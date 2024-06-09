//41
#include<stdio.h>
#include<iostream>
#include<vector>
#include<string>
using namespace std;

int main(void) {
	string input;
	cin >> input;

	int end = input.size() - 1;
	int mid = end / 2;
	int i = 0;

	for (i = 0; i <= mid; i++) {
		if (input[i] != input[end - i]) {
			mid = 0;
			cout << 0 << endl;
			break;
		}
	}

	if (mid || input.size() == 1) cout << 1 << endl;


	return 0;
}