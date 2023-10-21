#include<iostream>
#include<string>
#include<queue>
#include<stdio.h>
using namespace std;

int main(void) {
	priority_queue<int>pq;

	int N;
	int x;
	cin >> N;

	while (N--) {
		scanf("%d", &x);
		if (x == 0) {
			if (pq.size() == 0)printf("0\n");
			else {
				printf("%d\n", pq.top());
				pq.pop();
			}
		}
		else {
			pq.push(x);
		}
	}
	return 0;
}