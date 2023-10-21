#include<stdio.h>
#include<iostream>
#include<string>
#include<set>
#include<vector>
#include<algorithm>
using namespace std;

int main(void) {

	int N; int M;
	set<string>listenMan;
	vector<string>notListenMan;
	cin >> N >> M;

	string name;
	while (N--) {
		cin >> name;
		listenMan.insert(name);
	}


	while (M--) {
		cin >> name;
		if (listenMan.count(name)) {
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