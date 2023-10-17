#include<stdio.h>
#include<iostream>
#include<string>
#include<map>
#include<vector>
#include<algorithm>
using namespace std;

int main(void) {

	int N; int M;
	map<string, int>listenMan;
	vector<string>notListenMan;
	cin >> N >> M;

	string name;
	while (N--) {
		cin >> name;
		listenMan[name] = 1;
	}


	while (M--) {
		cin >> name;
		if (listenMan[name]!=0) {
			notListenMan.push_back(name);
		}
	}
	cout << notListenMan.size() << endl;
	sort(notListenMan.begin(), notListenMan.end());

	for (int i = 0; i < notListenMan.size(); i++) {
		cout << notListenMan[i] << '\n';
	}

	return 0;
}