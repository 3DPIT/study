#include <string>
#include <vector>
#include <algorithm>
using namespace std;
int lottoRank[7] = { 6,6,5,4,3,2,1};
int chkNum[46];
int removeNum;
int maxRet;
int minRet;
int D[6] = { 0, };

void dfs(int idx,int cnt,vector<int> &lottos, vector<int> &win_nums, vector<int> &number)
{
	if (idx == number.size()+1)return;
	if (cnt == removeNum) {
		vector<int> copy_lottos = lottos;
		int copy_idx = 0;
		for (int i = 0; i < copy_lottos.size(); i++) {
			if (copy_lottos[i] == 0) {
				copy_lottos[i] = D[copy_idx];
				copy_idx++;
			}
		}
		int lottoCnt = 0;
		for (int i = 0; i < win_nums.size(); i++) {
			for (int j = 0; j < copy_lottos.size(); j++) {
				if (win_nums[i] == copy_lottos[j]) {
					lottoCnt++;
				}
			}
		}
		minRet = min(minRet, lottoRank[lottoCnt]);
		return;
	}
	for (int i = idx; i < number.size(); i++) {
			D[idx] = number[i];
			dfs(idx + 1, cnt + 1, lottos, win_nums,number);
			D[cnt] = 0;
	}
	idx = 0;
}
vector<int> solution(vector<int> lottos, vector<int> win_nums) {
	vector<int> answer;
	removeNum = 0;
	maxRet = 0x80000000;// 최대가 6등
	minRet = 0x7fffffff;// 최소가 1등
	vector<int>number;
	memset(chkNum, 0, sizeof(chkNum));
	for (int i = 0; i < lottos.size(); i++) {
		if (lottos[i] == 0) {
			removeNum++;
		}
		else {
			for (int j = 0; j < win_nums.size(); j++) {
				if (lottos[i] == win_nums[j])
				{
					chkNum[j] = 1;
				}
			}
		}
	}
	
	for (int i = 0; i < 6; i++) {
		if (chkNum[i] == 0) {
			number.push_back(win_nums[i]);
		}
	}
	int num = 6 - number.size();
	maxRet = lottoRank[num];
	dfs(0,0,lottos, win_nums,number);
	answer.push_back(minRet);
	answer.push_back(maxRet);
	return answer;
}

int main(void) {
	vector<int>ret[4];
	ret[0] = solution({ 44, 1, 0, 0, 31, 25 }, { 31, 10, 45, 1, 6, 19 });
	ret[1] = solution({ 0, 0, 0, 0, 0, 0 }, { 38, 19, 20, 40, 15, 25 });
	ret[2] = solution({ 45, 4, 35, 20, 3, 9 }, { 20, 9, 3, 45, 4, 35 });
	return 0;
}