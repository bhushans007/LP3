import java.util.PriorityQueue;
import java.util.Scanner;


class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.left = this.right = null;
    }

    Node(char ch, int freq, Node left, Node right) {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}


class NodeComparator implements java.util.Comparator<Node> {
    public int compare(Node a, Node b) {
        return a.freq - b.freq;
    }
}

public class HuffmanEncoding {

    
    public static void printCodes(Node root, String code) {
        if (root == null)
            return;

        
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());

        System.out.println("Enter character and frequency:");
        for (int i = 0; i < n; i++) {
            char ch = sc.next().charAt(0);
            int freq = sc.nextInt();
            pq.add(new Node(ch, freq));
        }

        
        while (pq.size() > 1) {
            Node left = pq.poll();   
            Node right = pq.poll();  

            int sum = left.freq + right.freq;
            pq.add(new Node('\0', sum, left, right));  
        }

        Node root = pq.peek();

        System.out.println("\nHuffman Codes:");
        printCodes(root, "");
        
        sc.close();
    }
}
