#include<iostream>
#include<stdio.h>
#include<vector>
#include<string.h>
#define NS 100
using namespace std;

int main(void)
{
	int N;
	int board[NS][NS];
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%d", &board[i][j]);
		}
	}

	vector<int>q;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (board[i][j] != 0) {
				q.push_back(board[i][j]);
				board[i][j] = 0;
			}
		}

		for (int j = 0; j < q.size()-1; j++) {
			if (q.size() == 0)break;
			if (q[j] != 0 && q[j] == q[j + 1])
			{
				q[j] += q[j + 1];
				q.erase(q.begin() + j + 1);
			}
		}
		for (int j = 0;q.size()!=0; j++) {
			board[i][j] = q.front();
			q.erase(q.begin());
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			printf("%d", board[i][j]);
		}
		printf("\n");
	}
	return 0;
}
/*
5
2 0 2 0 2
2 2 2 2 2
2 2 0 2 2
2 0 4 0 2
4 0 2 2 0
*/

/*
4 2 0 0 0
4 4 2 0 0
4 4 0 0 0
2 4 2 0 0
4 4 0 0 0
*/