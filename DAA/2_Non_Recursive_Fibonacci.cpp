#include <iostream>
using namespace std;

int fibonacci(int n) {
    if (n <= 1)
        return n;

    int a = 0;   
    int b = 1;   
    int c; 
    cout<<"Fibonacci Series : "<<a<<" "<<b<<" ";

    for (int i = 2; i <= n; i++) {
        c = b + a;
        a = b;
        b = c;
        cout << c << " ";
    }

    return c;
}

int main() {
    int n,ans=0;
    cout << "Enter n: ";
    cin >> n;
    ans=fibonacci(n);
    cout << endl<<"Fibonacci(" << n << ") = " << ans << endl;

    return 0;
}
