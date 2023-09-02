#include<stdio.h>
#include<string.h>
#include<string>
#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>
#include<stack>
using namespace std;

int N;
int visit[10004];


struct Data {
	int num;
	string road;
};

int main(void) {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		memset(visit, 0, sizeof(visit));

		int startNum;
		int endNum;
		scanf("%d %d", &startNum, &endNum);
		queue<Data>q;
		q.push({startNum});
		visit[startNum] = 1;
		while (!q.empty()) {
			Data c = q.front(); q.pop();

			if (c.num == endNum) {
				cout << c.road << "\n";
				break;
			}
			//D
			int number = (c.num * 2) % 10000;
			if (visit[number] == 0) {
				Data n = c;
				n.num = number;
				visit[number] = 1;
				n.road += 'D';
				q.push(n);
			}
			
			//S
			 number = c.num-1;
			if (number==-1) number = 9999;
				if (visit[number] == 0) {
					Data n = c;
					n.num = number;
					visit[number] = 1;
					n.road += 'S';
					q.push(n);
			}
		
			//L
			number = (c.num % 1000) * 10 + (c.num / 1000);
			if (visit[number] == 0) {
				Data n = c;
				n.num = number;
				visit[number] = 1;
				n.road += 'L';
				q.push(n);
			}

			//R
			number = (c.num / 10) + (c.num % 10) * 1000;
			if (visit[number] == 0) {
				Data n = c;
				n.num = number;
				visit[number] = 1;
				n.road += 'R';
				q.push(n);
			}
		}	
	}
	return 0;
}