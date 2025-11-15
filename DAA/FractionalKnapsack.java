import java.util.*;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    public static double fractionalKnapsack(int W, List<Item> items) {
        Collections.sort(items, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                double r1 = (double) a.value / a.weight;
                double r2 = (double) b.value / b.weight;
                return Double.compare(r2, r1);
            }
        });

        double totalValue = 0.0;

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);

            if (item.weight <= W) {
                totalValue += item.value;
                W -= item.weight;
            } else {
                double fraction = (double) W / item.weight;
                totalValue += item.value * fraction;
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        List<Item> items = new ArrayList<>();

        System.out.println("Enter value and weight of each item:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            int weight = sc.nextInt();
            items.add(new Item(value, weight));
        }

        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        double maxValue = fractionalKnapsack(W, items);

        System.out.println("\nMaximum value in Knapsack = " + maxValue);
        sc.close();
    }
}
