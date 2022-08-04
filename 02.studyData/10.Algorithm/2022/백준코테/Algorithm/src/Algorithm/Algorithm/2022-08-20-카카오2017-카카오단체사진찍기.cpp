#include <string>
#include <vector>
#include <map>
#include <iostream>
#include <algorithm>

using namespace std;
int D[8];
int num[9];
map<char, int> m;
int ret;
void dfs(int idx, int cnt, vector<string> &data,int n) {
	if (idx == 9) return;
	if (cnt == 8) {
		int flag = 0;


		for (int i = 0; i < data.size(); i++) {
			int firstFriend = m[data[i][0]];
			int secondFriend = m[data[i][2]];
			char bigSameSmall = data[i][3];
			int number =stoi(to_string(data[i][4]))-48;

			int one = 0, two = 0;
			for (int j = 0;j<8; j++) {
				if (D[j] == firstFriend) {
					one = j;
				}
				if (D[j] == secondFriend) {
					two = j;
				}
			}
			if (bigSameSmall == '=') {
				int absnum = abs(one - two)-1;
				if (absnum == number) flag++;
				else return;
			}
			else if (bigSameSmall == '<') {
				int absnum = abs(one - two)-1;
				if (absnum < number) flag++;
				else return;


			}
			else if (bigSameSmall == '>') {
				int absnum = abs(one - two)-1;
				if (absnum >number) flag++;
				else return;


			}
		}
		if (flag == n)ret++;
		return;
	}
	for (int i = 1; i <= 8; i++) {
		if (D[idx] == 0&& num[i]==0) {
			num[i] = 1;
			D[idx] = i;
			dfs(idx+1, cnt+1, data,n);
			D[idx] = 0;
			num[i] = 0;
		}
			
	}
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int n, vector<string> data) {
	ret = 0;
	m.clear();
	for (int i = 0; i < 8; i++) {
		D[i] = 0;
	}	
	for (int i = 0; i < 9; i++) {
		num[i] = 0;
	}

	m['A'] = 1;
	m['C'] = 2;
	m['F'] = 3;
	m['J'] = 4;
	m['M'] = 5;
	m['N'] = 6;
	m['R'] = 7;
	m['T'] = 8;

	dfs(0, 0, data,n);
	return ret;
}

int main(void) {
	solution(2, { "N~F=0", "R~T>2" });
	return 0;
}