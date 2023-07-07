#include<iostream>
#include<string>
#include<algorithm>
#include<map>
using namespace std;

int main(void) {
	map<char, string> twoRule;
	twoRule['0'] = "000";
	twoRule['1'] = "001";
	twoRule['2'] = "010";
	twoRule['3'] = "011";
	twoRule['4'] = "100";
	twoRule['5'] = "101";
	twoRule['6'] = "110";
	twoRule['7'] = "111";

	string N;
	cin >> N;
	string ret;
	for (int i = 0; i < N.size(); i++) {
		ret += twoRule[N[i]];
	}
	//reverse(ret.begin(), ret.end());

	if (ret[0] == '0') ret.erase(ret.begin(), ret.begin() + 1);
	if (ret[0] == '0') ret.erase(ret.begin(), ret.begin() + 1);

	cout << ret << '\n';
	return 0;
}
