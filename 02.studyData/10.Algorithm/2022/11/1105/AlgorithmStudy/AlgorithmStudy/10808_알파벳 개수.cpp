#include<stdio.h>
#include<iostream>
#include<string>
using namespace std;

int main(void) {
	string s;
	cin >> s;
	int alphabet[28] = { 0 };
	for (int i = 0; i < s.size(); i++) {
		alphabet[ s[i]-'a']++;
	}

	for (int i = 0; i < 26; i++) {
		cout << alphabet[i] << " ";
	}
	return 0;
}