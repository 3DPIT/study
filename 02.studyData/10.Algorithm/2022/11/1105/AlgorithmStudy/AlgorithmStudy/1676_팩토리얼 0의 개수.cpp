#include<stdio.h>
#include<iostream>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	int ret = 0;
	for (int i = 5; i <= n; i *= 5) {
		ret += n / i;
	}
	cout << ret << '\n';
	return 0;
}