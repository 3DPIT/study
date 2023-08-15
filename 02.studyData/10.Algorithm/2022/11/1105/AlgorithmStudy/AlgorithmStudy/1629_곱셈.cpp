#include<iostream>
using namespace std;

long long calc(long long a, long long b, long long c) {
	if (b == 0) return 1;
	else if (b == 1)return a;
	else if (b % 2 == 0) {
		long long temp = calc(a, b / 2,c);
		return temp * temp %c;
	}
	else if (b % 2 == 1) {
		return a * calc(a, b - 1,c) %c;
	}
}

long long calc2(long long a, long long b, long long c) {
	long long  ans = 1LL;
	while (b > 0) {
		if (b % 2 == 1) {
			ans *= a;
			ans %= c;
		}
		a = a * a ;
		a %= c;
		b /= 2;
	}
	return ans;
}

long long calc21(long long a, long long b, long long c) {
	long long ans = 1LL;
	while (b > 0) {
		if (b % 2 == 1) {
			ans *= a;
			ans %= c;
		}
		a = a * a;
		a %= c;
		b /= 2;
	}
	return ans;
}


int main(void) {
	
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	long long A, B, C;
	cin >> A >> B >> C;
	int result = calc21(A, B,C);
	cout << result % C << '\n';
	return 0;
}