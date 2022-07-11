#include <string>
#include <vector>
#include <algorithm>
#include <sstream>
using namespace std;
int chk[1000004];
vector<string> vectorSS[1000004];

bool cmp(string a, string b) {
	
	return a.size() < b.size();
}
vector<int> solution(string s) {
	vector<int> answer;
	vector<string> vectorS;
	string s1[4];
	for (int i = 1; i < s.size() - 1; i++ ) {
		string copyS;
		if (s[i] == '{') {
			i++;
			while (1) {
				if (s[i] == '}')break;
				copyS += s[i];
				i++;
			}
			vectorS.push_back(copyS);
		}
	}
	sort(vectorS.begin(), vectorS.end(), cmp);

	for (int i = 0; i < vectorS.size(); i++) {
		string vs;
		int flag = 0;
		vector<string> s1;
		for (int j = 0; j < vectorS[i].size(); j++) {
			if (vectorS[i][j] != ',') {
				vs += vectorS[i][j];
			}
			else {
				s1.push_back(vs);
				vs.clear();
			}
		}
		s1.push_back(vs);

		for (int k = 0; k < s1.size(); k++) {
			vectorSS[s1.size()].push_back(s1[k]);
		}
	}

	for (int j = 0; j <= 1000000; j++) {
		for (int i = 0; i < vectorSS[j].size(); i++) {
			if (chk[stoi(vectorSS[j][i])] == 0) {
				answer.push_back(stoi(vectorSS[j][i]));
				chk[stoi(vectorSS[j][i])] = 1;
			}
		}
	}
	
	return answer;
}

int main(void)
{
	vector<int>a;
	a = solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");

	return 0;
}