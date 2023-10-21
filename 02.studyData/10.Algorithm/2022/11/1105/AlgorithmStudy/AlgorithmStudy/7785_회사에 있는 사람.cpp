#include<stdio.h>
#include<iostream>
#include<vector>
#include<set>
#include<string>
using namespace std;

int main(void) {

	int N;
	cin >> N;

	set<string> map;

	for (int i = 0; i < N; i++) {
		string name;
		string status;
		cin >> name >> status;
		if (status == "enter") {
			map.insert(name);
		}
		else {
			map.erase(map.find(name));
		}
	}

	for (auto it = map.rbegin(); it != map.rend(); it++) {
		cout << *it << '\n';
	}

	return 0;
}