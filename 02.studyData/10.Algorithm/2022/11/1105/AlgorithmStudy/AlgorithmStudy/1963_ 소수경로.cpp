#include<stdio.h>
#include<iostream>
#include<queue>
#include<string>
#include<string.h>
using namespace std;

int prime[10004];
int visit[10004];

struct Data {
	int num , cnt;
};

int changeNum(int num, int index, int digit) {
	if (index == 0 && digit == 0) return 0;
	string s = to_string(num);

	s[index] = digit + '0';
	return stoi(s);
}

int main(void) {
	for (int i = 2; i <= 10000; i++) {
		if (prime[i] == false) {
			for (int j = i * i; j < 10000; j += i) {
				prime[j] = -1;
			}
		}
	}
	int N;
	scanf("%d", &N);
	while (N--) {
		memset(visit, 0, sizeof(visit));
		int startNum, endNum;
		scanf("%d %d", &startNum, &endNum);
		if (startNum == endNum) {
			cout << 0 << endl;
			continue;
		}
			queue<Data>q;
		q.push({ startNum,0 });
		visit[0]=visit[N] = 1;
		while (!q.empty()) {
			Data c = q.front(); q.pop();
			if (c.num == endNum) {
				printf("%d\n", c.cnt);
				break;
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j <= 9; j++) {
					Data n = c;
					n.num = changeNum(c.num, i, j);
					if (prime[n.num]==0 && visit[n.num]==0) {
						n.cnt+=1;
						visit[n.num] = n.cnt;
						q.push(n);
					}
				}
			}
		}
		if (visit[endNum] == 0) cout << "Impossible" << endl;
		while (!q.empty())q.pop();
	}
	return 0;

}