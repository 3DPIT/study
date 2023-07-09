#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(void) {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<int>soinsu;

	int n=0;
	cin >> n;

	for (int i = 2; i*i <= n; i++) {
		while (n%i == 0) {
			soinsu.push_back(i);
			n /= i;
		}
	}

	sort(soinsu.begin(), soinsu.end());

	for (int i = 0; i < soinsu.size(); i++) {
		cout << soinsu[i] << '\n';
	}

	if (n > 1)cout << n;
	return 0;
}