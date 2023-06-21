#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
bool cmp(const string &u, const string &v) {
	if (u.size() == v.size()) {
		return u < v;
	}
	else {
		return u.size() < v.size();
	}
}
int main() {
	int N;
	cin >> N;
	vector<string> words(N);
	for (int i = 0; i < N; i++) {
		cin >> words[i];
	}
	sort(words.begin(), words.end(),cmp);
	//words.erase(unique(words.begin(), words.end()), words.end());

	for (int i = 0; i < words.size(); i++) {
		if(i==0 || words[i]!=words[i-1])
		cout << words[i]<<'\n';
	}
}