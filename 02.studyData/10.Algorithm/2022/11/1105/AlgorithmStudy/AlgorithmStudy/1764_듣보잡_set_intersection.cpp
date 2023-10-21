#include<stdio.h>
#include<iostream>
#include<string>
#include<set>
#include<vector>
#include<algorithm>
using namespace std;

int main(void) {

	int N; int M;
	vector<string>listenMan;
	vector<string>notListenMan;
	vector<string>ans;
	cin >> N >> M;

	string name;
	while (N--) {
		cin >> name;
		listenMan.push_back(name);
	}


	while (M--) {
		cin >> name;
			notListenMan.push_back(name);
	}

	sort(listenMan.begin(), listenMan.end());
	sort(notListenMan.begin(), notListenMan.end());

	set_intersection(listenMan.begin(), listenMan.end(), notListenMan.begin(), notListenMan.end(), back_inserter(ans));

	cout << ans.size() << endl;

	//for (int i = 0; i < ans.size(); i++) {
	//	cout << ans[i] << '\n';
	//}

	for (auto &name : ans) {
		cout << name << "\n";
	}

	return 0;
}