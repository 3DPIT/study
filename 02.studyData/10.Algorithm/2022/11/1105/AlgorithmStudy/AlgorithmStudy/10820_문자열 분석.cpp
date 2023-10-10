#include<stdio.h>
#include<iostream>
#include<string>
using namespace std;
int main(void) {
	string s;
	
	while (getline(cin, s)) {
		int lower = 0;
		int upper = 0;
		int number = 0;
		int blank = 0;
		for (int i = 0; i < s.size(); i++) {
			if ('a' <= s[i] && s[i] <= 'z') lower++;
			else if ('A' <= s[i] && s[i] <= 'Z') upper++;
			else if (s[i] == ' ')blank++;
			else number++;
		}
		cout << lower << " " << upper << " " << number << " " << blank << endl;
		s.clear();
	}
	return 0;
}