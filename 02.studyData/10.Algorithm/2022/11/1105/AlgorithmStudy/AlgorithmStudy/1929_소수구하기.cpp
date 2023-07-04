#include<stdio.h>
#include<iostream>
using namespace std;
const int MAX = 1000000;
bool check[MAX + 1];//ture: 지워짐, false : 지워지지 않음
int m, n;

int main() {
	check[0] = check[1] = true;
	for (int i = 2; i*i <= MAX; i++) {
		if (check[i] == false) {
			for (int j = i + i; j <= MAX; j += i) {
				check[j] = true;
			}
		}
	}

	 cin >> m>> n;
	for (int i = m; i <= n; i++) {
		if (check[i] == false) {
			cout << i << '\n';
		}
	}
	return 0;
}