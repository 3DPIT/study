#include<iostream>
#include<algorithm>
using namespace std;

long long cntHandler(int n, int m,int findNumber) {
	long long Cnt = 0;

	for (int i = findNumber; i <= n; i *= findNumber) {
		Cnt += n / i;
	}
	for (int i = findNumber; i <= m; i *= findNumber) {
		Cnt -= m / i;
	}
	for (int i = findNumber; i <= (n - m); i *= findNumber) {
		Cnt -= (n - m) / i;
	}
	return Cnt;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	int result = 0;
	cin >> n >> m;

	result = min(cntHandler(n, m, 2), cntHandler(n, m, 5));

	cout << result << endl;

	return 0;
}