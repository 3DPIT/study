//#include<stdio.h>
//#include<iostream>
//#include<vector>
//using namespace std;
//
//int main(void) {
//	//char a = 10+55;
//	//cout << a << endl;
//	int N, B;
//	cin >> N >> B;
//	vector<char>result;
//	while (1) {
//		char nModB = N % B;
//		result.push_back(nModB);
//		N = N / B;
//		if (N == 0)break;
//	}
//
//	for (int i = result.size() - 1; i >= 0; i--) {
//		if (result[i] >= 10) printf("%c", result[i] + 55);
//		else printf("%d", result[i]);
//	}
//	return 0;
//}

#include<string>
#include<iostream>
#include<algorithm>
using namespace std;

int main(void) {
	int n, b;
	cin >> n >> b;
	string ans = "";
	while (n > 0) {
		int r = n % b;
		if (r < 10) ans += (char)(r + '0');
		else  ans += (char)(r-10 + 'A');
		n /= b;
	}
	reverse(ans.begin(), ans.end());
	cout << ans << '\n';

	return 0;
}