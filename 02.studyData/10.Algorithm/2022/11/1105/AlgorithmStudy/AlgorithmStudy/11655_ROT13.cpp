#include<stdio.h>
#include<iostream>
#include<string>
using namespace std;
string s;
char Rot13(char word) {
	if ('A' <= word && word <= 'Z') {
		word = (((word - 'A') + 13) % 26) + 65;
	}
	else if ('a' <= word && word <= 'z') {
		word=(((word - 'a') + 13) % 26) + 97;
	}
	return word;
}
int main(void) {
	getline(cin,s);
	
	for (int i = 0; i<s.size(); i++) {
		s[i]=Rot13(s[i]);
	}

	cout << s << endl;
	return 0;
}