#include<iostream>
#include<string>
using namespace std;

int main(void) {
	string N;
	int B;
	cin >> N >> B;

	int ret = 0;

	for (int i = 0; i < N.size(); i++) {
		if (N[i] >= 'A') ret = ret * B + (N[i] - 'A' + 10);
		else ret = ret * B + (N[i] - '0');
	}
	cout << ret << '\n';
	return 0;
}