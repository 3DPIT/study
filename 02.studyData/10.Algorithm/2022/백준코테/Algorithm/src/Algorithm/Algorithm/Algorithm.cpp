#include<stdio.h>
#include<iostream>
#include<vector>
#include<string.h>
#include<queue>
using namespace std;
void dfs(int idx)
{
	if (idx == 5)
	{
		return;
	}

	for (int i = 0; i < 4; i++)
	{
		int crr[5][5] = { 0, };
		copyArr(crr, arr);
		sumArr(arr);
		dfs(idx + 1);
		rotation(crr);
		copyArr(arr, crr);
	}
}

void dfs1(int y, int x, int sum, int idx)
{
	if (idx == 3)
	{
		return;
	}

	for (int dir = 0; dir < 4; dir++)
	{
		int ny = y + dy[dir]; int nx = x + dx[dir];
		if (safeZone(ny, nx) && board[ny][nx] == 0)
		{
			board[ny][nx] = 1;
			dfs(ny, nx, sum + input[ny][nx], idx + 1);
			board[ny][nx] = 0;
		}
	}
}

void dfs(int y, int x, int idx)
{
	if (idx == 3)
	{
		return;
	}

	for (int i = y; i < N; i++)
	{
		for (int j = x; j < N; j++)
		{
			if (board[i][j] == 0)
			{
				board[i][j] = 1;
				dfs(i, j + 1, idx + 1);
				board[i][j] = 0;
			}
		}
	}
}
int main(void)
{
	int N=5;
	int crr[5][5];
	int arr[5][5];
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			crr[i][j] = arr[N-j-1][i];
		}
	}//시계

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			crr[i][j] = arr[j][N-i-1];
		}
	}//반시계


	vector<int>q;
	int board[50][50];
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (board[i][j] != 0)
			{
				q.push_back(board[i][j]);
				board[i][j] = 0;
			}
		}

		for (int j = 0; j < q.size()-1; j++)
		{
			if (q.size() == 0) break;
			if (q[j] == q[j + 1])
			{
				q[j] += q[j + 1];
				q.erase(q.begin() + j + 1);
			}
		}

		for (int j = 0; q.size() != 0; j++)
		{
			board[i][j] = q.front();
			q.erase(q.begin());
		}
	}


	return 0;
}