#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
char numberChar[] = { '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F' };

bool checkPrimeNumber(long long n) {
	if (n == 0 || n == 1) return false;
	for (int i = 2; i <= sqrt(n); i++) {
		if (n%i == 0) return false;
	}

	return true;
}
bool checkPrimeNumber1(long long n) {
	if (n == 0 || n == 1) return false;
	for (int i = 2; i*i <=  n; i++) {
		if (n%i == 0) return false;
	}
	return true;
}
int solution(int n, int k) {
	int answer = 0;

	string numberC;
	while (n / k != 0) {
		numberC += numberChar[n%k];
		n /= k;
	}
	numberC += numberChar[n%k];
	reverse(numberC.begin(), numberC.end());

	string num;
	for (int i = 0; i < numberC.size(); i++) {
		if (numberC[i] == '0') {
			if (num.size() == 0 ) {
				continue;
			}
			if (checkPrimeNumber(stol(num))) answer++;
			num.clear();
		}
		else if(numberC[i]!='0')num += numberC[i];
	}
	if (num.size()!=0&&checkPrimeNumber(stol(num))) answer++;
	//cout << num << endl;
	return answer;
}

int main(void) {

	cout<<solution(110011, 10);
	return 0;
}