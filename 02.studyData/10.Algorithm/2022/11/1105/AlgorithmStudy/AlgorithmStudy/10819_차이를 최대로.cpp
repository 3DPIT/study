#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

vector<int>a;
int ans;
vector<int>d;
int checkd[104];

int calculate(vector<int> d)
{
	int sum = 0;
	for (int i = 0; i < a.size() - 1; i++) {
		sum += abs(a[d[i]-1] - a[d[i + 1]-1]);
	}
	return sum;
}
void dfs_next_permutation(int cnt, int N) {
	if (cnt == N) {
		int sum = 0;
		sum = calculate(d);
		ans = max(ans, sum);
		return;
	}
	
	for (int i = 1; i <= N; i++) {
		if (checkd[i] == 1)continue;
		checkd[i] = 1;
		d.push_back(i);
		dfs_next_permutation(cnt + 1, N);
		d.pop_back();
		checkd[i] = 0;
	}
}
int main(void) {
	int N = 0;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		int num = 0;
		scanf("%d", &num);
		a.push_back(num);
	}
	/*sort(a.begin(), a.end());
	do {
		int temp = calculate(a);
		ans = max(ans, temp);
	} while (next_permutation(a.begin(), a.end()));
*/
	dfs_next_permutation(0, N);
	printf("%d", ans);
}