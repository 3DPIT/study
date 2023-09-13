#include<stdio.h>
#include<vector>
#include<algorithm>
#include<string.h>
#include<string>
#include<vector>
using namespace std;

vector<int>D;
vector<int> num;


void dfs(int cnt, int idx) {
	if (cnt == 6) {
		for (int i = 0; i < 6; i++) {
			printf("%d ", D[i]);
		}
		printf("\n");
		return;
	}

	// 인덱스 범위 확인
	if (idx >= num.size()) {
		return;
	}

	// 현재 인덱스의 숫자 선택
	D.push_back(num[idx]);
	dfs(cnt + 1, idx + 1);
	D.pop_back(); // 선택 취소

	// 현재 인덱스의 숫자 선택하지 않음
	dfs(cnt, idx + 1);
}


using namespace std;
int main(void)
{
	int numberCount = -1;

	while (1) {
		scanf("%d", &numberCount);
		if (numberCount == 0) break;
		int lottoNumber;
		for (int i = 0; i < numberCount; i++) {
			scanf("%d", &lottoNumber);
			num.push_back(lottoNumber);
		}
		sort(num.begin(), num.end());
		dfs(0, 0);
		num.clear();
		D.clear();
		printf("\n");
	}

	return 0;
}