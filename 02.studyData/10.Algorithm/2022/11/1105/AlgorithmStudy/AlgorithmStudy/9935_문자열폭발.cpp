#include <iostream>
#include <vector>
#include <string>
#include <stack>
#include<algorithm>
using namespace std;
char a[1000001];
bool erased[1000001];
char b[100];

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0), cout.tie(0);
	cin >> a;
	cin >> b;
	int n = strlen(a);
	int m = strlen(b);

	if (m == 1) {
		for (int i = 0; i < n; i++) {
			if (a[i] == b[0]) {
				erased[i] = true;
			}
		}
	}
	else {
		stack<pair<int, int>> s;
		for (int i = 0; i < n; i++) {
			if (a[i] == b[0]) {
				s.push(make_pair(i, 0));
			}
			else {
				if (!s.empty()) {
					auto p = s.top();
					if (a[i] == b[p.second + 1]) {
						s.push(make_pair(i, p.second + 1));
						if (p.second + 1 == m - 1) {
							for (int k = 0; k < m; k++) {
								auto p = s.top();
								erased[p.first] = true;
								s.pop();
							}
						}
					}
					else {
						while (!s.empty()) {
							s.pop();
						}
					}
				}
			}
		}
	}
	bool printed = false;
	for (int i = 0; i < n; i++) {
		if (erased[i]) continue;
		cout << a[i];
		printed = true;
	}
	if (!printed) {
		cout << "FRULA" << '\n';
	}

}
