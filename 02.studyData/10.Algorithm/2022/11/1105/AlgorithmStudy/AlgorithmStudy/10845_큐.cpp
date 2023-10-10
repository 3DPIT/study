#include<stdio.h>
#include<iostream>
#include<string>
#include<deque>
using namespace std;

int main(void) {
	int N;
	string order;
	int X;
	deque<int>q;
	cin >> N;

	while (N--) {
		cin >> order;
		if (order == "push") {
			cin >> X;
			q.push_back(X);
		}
		else if (order == "pop") {
			if (q.size() != 0) {
				cout << q.front() << endl;
				q.pop_front();
			}
			else {
				cout << -1 << endl;
			}
		}
		else if (order == "size") {
			cout << q.size() << endl;
		}
		else if (order == "empty") {
			if (q.size() == 0) cout << 1 << endl;
			else cout << 0 << endl;
		}
		else if (order == "front") {
			if (q.size() != 0) {
				cout << q.front() << endl;
			}
			else {
				cout << -1 << endl;
			}
		}
		else if (order == "back") {
			if (q.size() != 0) {
				cout << q.back() << endl;
			}
			else {
				cout << -1 << endl;
			}
		}
	}
	return 0;
}