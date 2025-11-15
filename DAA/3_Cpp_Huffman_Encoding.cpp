#include <iostream>
#include <queue>
#include <unordered_map>
using namespace std;

struct Node {
    char ch;
    int freq;
    Node *left, *right;
};


struct Compare {
    bool operator()(Node* a, Node* b) {
        return a->freq > b->freq; 
    }
};


Node* getNode(char ch, int freq, Node* left, Node* right) {
    Node* node = new Node();
    node->ch = ch;
    node->freq = freq;
    node->left = left;
    node->right = right;
    return node;
}


void printCodes(Node* root, string code) {
    if (!root)
        return;

    
    if (!root->left && !root->right) {
        cout << root->ch << " : " << code << endl;
    }

    printCodes(root->left, code + "0");
    printCodes(root->right, code + "1");
}

int main() {
    int n;
    cout << "Enter number of characters: ";
    cin >> n;

    char ch;
    int freq;

    priority_queue<Node*, vector<Node*>, Compare> pq;

    
    cout << "Enter character and its frequency:\n";
    for (int i = 0; i < n; i++) {
        cin >> ch >> freq;
        pq.push(getNode(ch, freq, nullptr, nullptr));
    }

    
    while (pq.size() > 1) {
        Node* left = pq.top(); 
        pq.pop();

        Node* right = pq.top(); 
        pq.pop();

        
        int sum = left->freq + right->freq;
        pq.push(getNode('\0', sum, left, right));
    }

    Node* root = pq.top();

    cout << "\nHuffman Codes:\n";
    printCodes(root, "");

    return 0;
}
