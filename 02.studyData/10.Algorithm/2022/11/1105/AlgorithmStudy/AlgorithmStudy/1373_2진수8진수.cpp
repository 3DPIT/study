#include<iostream>
#include<string>
#include<algorithm>
using namespace std;


int main(void) {
	string N;
	string ret;
	cin >> N;
	reverse(N.begin(), N.end());
	int threeCheck[] = { 0,1,2,4 };

	int sum = 0;
	for (int i = 0, cnt = 1; i < N.size(); i++,cnt++) {
		if (N[i] == '1')sum += threeCheck[cnt];

		if (cnt == 3) {
			ret += to_string(sum);
			cnt = 0;
			sum = 0;
		}
	}
	if (N.size() % 3 != 0) {
		ret += to_string(sum);
	}
	reverse(ret.begin(), ret.end());
	cout << ret << endl;
	return 0;
}