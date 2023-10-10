#include<stdio.h>
#include<iostream>
#include<string>
#include<stack>
using namespace std;
int main(void) {

	string ironStick;
	stack<int>s;
	int ret=0;
	cin >> ironStick;

	for (int i = 0; i < ironStick.size(); i++) {
		if (ironStick[i] == '(') {
			s.push(i);
		}
		else if (ironStick[i] == ')') {
			if (i - s.top() == 1) {//·¹ÀÌÀú
				s.pop();
					ret += s.size();
			}
			else {
				s.pop();
				ret += 1;
			}
		}
	}

	cout << ret << endl;
	return 0;

}