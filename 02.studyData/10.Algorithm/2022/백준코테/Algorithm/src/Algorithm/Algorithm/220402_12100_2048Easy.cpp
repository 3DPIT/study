#include<stdio.h>
#include<iostream>
#include<string.h>
#include<vector>
using namespace std;
#define N_SIZE 21
int N;
int board[N_SIZE][N_SIZE];
void initValue();
void sumRight();
void sumBlock2();
void sumBlock3();
void sumBlock4();
void rotation(int arr[N_SIZE][N_SIZE]);
void printBlock();
void copyBoard(int crr[N_SIZE][N_SIZE], int arr[N_SIZE][N_SIZE]);
void dfs(int index);
int ret = 0x80000000;

int main()
{
	initValue();
	dfs(0);
	cout << ret << endl;
	return 0;
}

void dfs(int idx)
{
	if (idx == 5) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ret = ret < board[i][j] ? board[i][j] : ret;
			}
		}
		return;
	}
	for (int i = 0; i < 4; i++) {
		int crr[N_SIZE][N_SIZE] = { 0, };
		copyBoard(crr, board);
		sumRight();
		dfs(idx + 1);
		rotation(crr);
		copyBoard(board, crr);
	}
}

void initValue()
{
	scanf("%d", &N);
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			scanf("%d", &board[i][j]);
		}
	}
}

void copyBoard(int crr[N_SIZE][N_SIZE], int arr[N_SIZE][N_SIZE]) {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			crr[i][j] = arr[i][j];
		}
	}
}

void rotation(int arr[N_SIZE][N_SIZE])
{
	int copy[N_SIZE][N_SIZE] = { 0, };
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			copy[j][N - i - 1] = arr[i][j];
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			arr[i][j] = copy[i][j];
		}
	}
}


void sumRight()
{
	vector<int>q;
	for (int j = 0; j < N; j++) {
		for (int i = N - 1; i >= 0; i--) {
			if (board[i][j] != 0)q.push_back(board[i][j]);//일단 저장
			board[i][j] = 0;//초기화 시키기
		}
		for (int i = 0; i < q.size() - 1; i++) {
			if (q.size() == 0)break;
			if (q[i] == q[i + 1] && q[i] != 0) {
				q[i] += q[i + 1];
				q.erase(q.begin() + i + 1);
			}
		}
		for (int i = N - 1; q.size(); i--) {
			board[i][j] = q.front();
			q.erase(q.begin());
		}
	}
}

void printBlock()
{
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++) {
			cout << board[i][j] << " ";
		}
		cout << endl;
	}
}