#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>
#include <map>
using namespace std;

vector<int> solution(string msg) {
	vector<int> answer;
	unordered_map<string, int> m;
	int index;
	string temp = "";

	for (index = 1; index < 27; index++) {
		temp += 'A' + index - 1;
		m.emplace(temp, index);
		temp = "";
	}
	for (int i = 0; i < msg.size(); i++) {
		string s = "";
		s += msg[i];
		int idx = i;
		while (m.find(s) != m.end()) {
			s += msg[++idx];
		}
		i = idx - 1;
		m[s] = index++; //m.emplace(s, index++);
		s.pop_back();
		answer.push_back(m[s]);//answer.emplace_back(m[temp]);

	}
	return answer;
}
int main(void) {
	solution("TOBEORNOTTOBEORTOBEORNOT");
	return 0;
}