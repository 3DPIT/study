//#include <string>
//#include <vector>
//#include <iostream>
//using namespace std;
//
//int solution(string s) {
//	int ret = 0x7fffffff;
//	int answer = 0;
//
//	for (int c = 1; c <= s.size(); c++) {
//		int idx = 0;
//		string copyS[1001];
//		answer = 0;
//		for (int i = 0; i < s.size();) {
//			int C = c;
//			while (C--) {
//				if (i == (s.size()))break;
//				copyS[idx].push_back(s[i++]);
//			}
//			idx++;
//		}
//		for (int i = 0; i < idx;) {
//			int cnt = 1;
//			int ci = 0;
//			for (int j = i + 1; j < idx; j++) {
//				if (copyS[i] == copyS[j]) {//압축 가능한경우
//					cnt++;
//				}
//				else {
//					if (cnt != 1) {//개수 포함 저장
//						answer += to_string(cnt).size();
//						answer += copyS[i].size();
//					}
//					else if (cnt == 1) {//1은 제외 하고 저장
//						answer += copyS[i].size();
//					}
//					i = j;
//					if (i == idx - 1) {
//						answer += copyS[i].size();
//						i++;
//					}
//					break;
//				}
//				ci = j;
//			}
//			if (ci == idx - 1) {
//				i = idx;
//				if (cnt != 1) {//개수 포함 저장
//					answer += to_string(cnt).size();
//					answer += copyS[i - 1].size();
//				}
//				else if (cnt == 1) {//1은 제외 하고 저장
//					answer += copyS[i - 1].size();
//				}
//			}
//		}
//
//		ret = ret > answer ? answer : ret;
//	}
//	return ret;
//}
//int main(void) {
//	cout << solution("aaaaaaaaaa");
//	return 0;
//}



#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

vector<string> splitString(string s, int n) {
	vector<string> v;
	for (int i = 0; i < s.size(); i += n) {
		v.push_back(s.substr(i, n));
	}
	return v;
}

int solution(string s) {
	int answer = 0x7fffffff;
	vector<string> splitS;
	string beforeCmpS;
	int cnt = 1;
	for (int cmpCnt = 1; cmpCnt <= s.size() / 2; cmpCnt++) {
		splitS = splitString(s, cmpCnt);
		string zipS;
		beforeCmpS = splitS[0];
		cnt=1;
		for (int i = 1; i < splitS.size(); i++) {
			if (beforeCmpS == splitS[i]) cnt++;
			else{
				if (cnt != 1) zipS += to_string(cnt);
				zipS += beforeCmpS;
				beforeCmpS = splitS[i];
				cnt = 1;
			}
		}
		if (cnt != 1) zipS += to_string(cnt);
		zipS += beforeCmpS;
		answer = min(answer, (int)zipS.length());
		//cout << zipS << endl;
	}

	return answer==0x7fffffff?1:answer;
}

int main(void) {
	cout << solution("a");
	return 0;
}