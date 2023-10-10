#include<stdio.h>
#include<iostream>
#include<stack>
#include<string>
using namespace std;


string valid(string s) {
	int cnt = 0;
	for (int i = 0; i < s.size(); i++) {
		if (s[i] == '(') {
			cnt += 1;
		}
		else {
			cnt -= 1;
		}
		if (cnt < 0) {
			return "NO";
		}
	}
	if (cnt == 0) {
		return "YES";
	}
	else {
		return "NO";
	}
}

int main(void) {
	int N;
	cin >> N;
	while(N--) {
	string squarBrackets;
	//	stack<char>s;
		cin >> squarBrackets;
	//	int flag = 0;
	//	for (int i = 0; i < squarBrackets.size(); i++) {
	//		if (squarBrackets[i] == ')') {
	//			if (s.size() != 0 && s.top() != ')') {
	//				s.pop();
	//			}
	//			else {
	//				cout << "NO" << endl;
	//				flag = 1;
	//				break;
	//			}
	//		}
	//		else if(squarBrackets[i]=='(') {
	//			s.push('(');
	//		}
	//		else if (s.size() == 0&&i<squarBrackets.size()) {
	//			cout << "NO" << endl;
	//			flag = 1;
	//			break;
	//		}
	//	}
	//	if (s.size() != 0) cout << "NO" << endl;
	//	else if (flag == 0)cout << "YES" << endl;
		cout << valid(squarBrackets) << endl;
	}
	
	return 0;
}