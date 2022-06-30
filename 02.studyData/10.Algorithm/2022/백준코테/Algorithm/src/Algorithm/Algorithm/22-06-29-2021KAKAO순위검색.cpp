#include <vector>
#include <unordered_map>
#include <algorithm>
#include <sstream>
#include <iostream>

using namespace std;

const string ALL = "-";
unordered_map<string, vector<int>> map;

void insert(string* key, int point) {
	for (int mask = 0; mask < 16; mask++) {

		string s = "";
		for (int i = 0; i < 4; i++) {
			s += (mask & (1 << i)) ? ALL : key[i];
			map[s].push_back(point);
		}
	}
}

vector<int> solution(vector<string> info, vector<string> query) {
	vector<int> answer;
	string key[4], tmp;
	int point;

	for (auto& inf : info) {
		istringstream iss(inf);
		iss >> key[0] >> key[1] >> key[2] >> key[3] >> point;
		insert(key, point);
	}

	for (auto& m : map) sort(m.second.begin(), m.second.end());// Á¤·Ä

	for (auto& que : query) {
		istringstream iss(que);
		iss >> key[0] >> tmp >> key[1] >> tmp >> key[2] >> tmp >> key[3] >>
			point;
		string s = key[0] + key[1] + key[2] + key[3];
		vector<int>& v = map[s];
		answer.push_back(v.end() - lower_bound(v.begin(), v.end(), point));
	}

	return answer;
}
int main(void)
{
	string inf = "java and c++ and python and c#";
	string key[4], rm;

	istringstream iss(inf);
	iss >> key[0] >> rm >> key[1] >> rm >> key[2] >> rm >> key[3];
	cout << "key[0]" << " = " << key[0] << endl
		<< "key[1]" << " = " << key[1] << endl
		<< "key[2]" << " = " << key[2] << endl
		<< "key[3]" << " = " << key[3] << endl;


	vector<int> a = solution({ "java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50" },
		{ "java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150" });
	return 0;
}