#include<stdio.h>
#include<iostream>
#include<string>
#include<vector>
#include<algorithm>

using namespace std;



int main(void) {
	//string s;
	//cin >> s;
	//int n = s.size();
	//vector<int> a;
	//for (int i = 0; i < n; i++) a.push_back(i);
	//sort(a.begin(), a.end(), [&s](int u, int v) {
	//	return strcmp(s.c_str() + u, s.c_str() + v) < 0;
	//});
	//for (auto &x : a) {
	//	cout << s.substr(x) << '\n';
	//}



	string S;
	cin >> S;
	vector<string> tailArr;

	string tailS;
	for (int i =S.size() - 1; i >= 0; i--) {
		tailS += S[i];
		tailArr.push_back(tailS);
	}

	for (int i = 0; i < tailArr.size(); i++) {
		reverse(tailArr[i].begin(), tailArr[i].end());
	}
	

	sort(tailArr.begin(), tailArr.end());

	for (int i = 0; i < tailArr.size(); i++) {
		//reverse(tailArr[i].begin(), tailArr[i].end());
		cout<<tailArr[i]<<endl;
	}

	return 0;
}