#include <iostream>
#include <vector>
using namespace std;

int knapsack(int W, vector<int> &value, vector<int> &weight, int n) {
    vector<vector<int>> dp(n + 1, vector<int>(W + 1));

    for (int i = 1; i <= n; i++) {
        for (int w = 1; w <= W; w++) {
            if (weight[i - 1] <= w)
                dp[i][w] = max(value[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w]);
            else
                dp[i][w] = dp[i - 1][w];
        }
    }
    return dp[n][W];
}

int main() {
    int n, W;
    cout << "Enter number of items: ";
    cin >> n;

    vector<int> value(n), weight(n);
    cout << "Enter value and weight of each item:\n";
    for (int i = 0; i < n; i++)
        cin >> value[i] >> weight[i];

    cout << "Enter knapsack capacity: ";
    cin >> W;

    int maxValue = knapsack(W, value, weight, n);
    cout << "\nMaximum value in Knapsack = " << maxValue << endl;

    return 0;
}
