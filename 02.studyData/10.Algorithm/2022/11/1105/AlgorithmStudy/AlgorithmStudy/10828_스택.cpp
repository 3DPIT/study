#include<stdio.h>
#include<iostream>
#include<stack>
#include<string>
using namespace std;
stack<int>s;

void push(int X) {
	s.push(X);
}

void pop() {
	if (s.empty()) {
		cout << -1 << endl;
	}
	else {
		cout << s.top() << endl;
		s.pop();
	}
}

void size() {
	cout << s.size() << endl;
}

void empty() {
	if (s.empty()) cout << 1 << endl;
	else cout << 0 << endl;
}

void top() {
	if (s.empty()) cout << -1 << endl;
	else cout << s.top() << endl;
}

int main(void) {
	int N;
	string order; int X;
	cin >> N;
	while (N--) {
		cin>>order;
		if (order == "push") {
			cin >> X;
			push(X);
		}
		else if (order == "pop") {
			pop();
		}
		else if (order == "size") {
			size();
		}
		else if (order == "empty") {
			empty();
		}
		else if (order == "top") {
			top();
		}
	}
		//push X : 정수 X를 스택에 넣는 연산이다.
		//pop : 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다.만약 스택에 들어있는 정수가 없는 경우에는 - 1을 출력한다.
		//size : 스택에 들어있는 정수의 개수를 출력한다.
		//empty : 스택이 비어있으면 1, 아니면 0을 출력한다.
		//top : 스택의 가장 위에 있는 정수를 출력한다.만약 스택에 들어있는 정수가 없는 경우에는 - 1을 출력한다.
	return 0;
}