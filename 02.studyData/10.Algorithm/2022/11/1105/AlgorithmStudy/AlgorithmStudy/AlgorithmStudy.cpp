#include <string>
#include <iostream>
#include <math.h>
using namespace std;

string numberC;
char numberChar[] = {
	'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'
};

bool checkPrimeNumber(long long number) {
	if (number == 0 || number == 1) return false;
	for (int i = 2; i <= number*number; i++) {
		if (number % i == 0) return false;
	}
	return true;
}

bool checkPrimeNumber_test(long long number) {
	if (number == 0 || number == 1) return false;
	for (int i = 2; i <= sqrt(number); i++) {
		if (number % i == 0)return false;
	}
	return true;
}


int main(void) {

	cout << checkPrimeNumber(4);
	return 0;
}