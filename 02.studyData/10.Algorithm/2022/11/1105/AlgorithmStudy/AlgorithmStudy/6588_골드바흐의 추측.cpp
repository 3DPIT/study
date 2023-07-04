#include<stdio.h>
#include<iostream>
using namespace std;
const int MAX = 1000000;
bool check[MAX + 1];
int m, n;
int prime[MAX];
int pn;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	check[0] = check[1] = true;
	for (int i = 2; i*i <= MAX; i++) {
		if (check[i] == false) {
			prime[pn++] = i;
			for (int j = i + i; j <= MAX; j += i) {
				check[j] = true;
			}
		}
	}

	while (1) {
		cin >> n;
		if (n == 0)break;
	
		for(int i=1;i<pn;i++){
			if (check[n - prime[i]] == false) {
				cout << n << " = " << prime[i] << " + " << n - prime[i] << "\n";
				break;
			}
		}
	}
	return 0;
}