#include<iostream>
using namespace std;

bool broken[10];

int possible(int n) {
	if (n == 0) return broken[0] ? 0 : 1;// 0버튼이 깨져있으면 0임, 아니면 1개 누를수 있음
	int len = 0;
	while (n > 0) {
		if (broken[n % 10]) return 0;// 고장난 버튼인 경우
		len += 1;
		n /= 10;
	}
	return len;
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int x;
		cin >> x;
		broken[x] = true;
	}
	
	int ans = n - 100;
	if (ans < 0) ans = -ans;

	for (int i = 0; i <= 1000000; i++) {
		int channel = i;
		int len = possible(channel);
		if (len > 0) {
			int press = channel - n;
			if (press < 0) press = -press; //양수 처리
			if (ans > len + press) ans = len + press; //최소처리
		}
	}

	cout << ans << endl;
	return 0;
}