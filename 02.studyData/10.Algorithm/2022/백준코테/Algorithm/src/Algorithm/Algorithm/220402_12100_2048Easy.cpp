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
void rotation();
void printBlock();
void copyBoard(int crr[N_SIZE][N_SIZE],int arr[N_SIZE][N_SIZE]);
int ret = 0x80000000;
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
		rotation();
		copyBoard(board, crr);
	}
}

void rotation();

int main()
{
	initValue();
	dfs(0);
	cout << ret << endl;
	return 0;
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
void rotation()
{
	int crr[N_SIZE][N_SIZE] = { 0, };
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			crr[j][N - i -1] = board[i][j];
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			board[i][j] = crr[i][j];
		}
	}
	//printBlock();
}


void sumRight()
{
	for (int i = 0; i < N; i++)
	{
		vector<int>v1;
		vector<int>v2;
		for (int j = N - 1; j >= 0; j--)
		{
			if(board[i][j]!=0)
			v1.push_back(board[i][j]);
			board[i][j] = 0;
		}

		int k = 0;
		for (k = 0; k < v1.size()-1; k++)
		{
			if (v1.size() ==0)break;
			if (v1[k]!=0&&v1[k] == v1[k+1]) {
				v2.push_back(v1[k]*2);
				k++;
			}
			else 
				v2.push_back(v1[k]);
		}
		if (k == v1.size() - 1) v2.push_back(v1[k]);
		
		int index = N - 1;
		for (k = 0; k < v2.size(); k++)
		{
			board[i][index--] = v2[k];
		}
	}
}

void sumBlock2()
{
	for (int j = 0; j < N; j++)
	{
		vector<int>v1;
		vector<int>v2;
		for (int i = N - 1; i >= 0; i--)
		{
			if (board[i][j] != 0)
				v1.push_back(board[i][j]);
			board[i][j] = 0;
		}

		int k = 0;
		for (k = 0; k < v1.size() - 1; k++)
		{
			if (v1[k] != 0 && v1[k] == v1[k + 1]) {
				v2.push_back(v1[k] * 2);
				k++;
			}
			else
				v2.push_back(v1[k]);
		}
		if (k == v1.size() - 1) v2.push_back(v1[k]);

		int index = 0;
		for (k = 0; k < v2.size(); k++)
		{
			board[index++][j] = v2[k];
		}
	}
}

void sumBlock3()
{
	for (int i = N - 1; i >= 0; i--)
	{
		vector<int>v1;
		vector<int>v2;
		for (int j = N-1; j >=0; j--)
		{
			if (board[i][j] != 0)
				v1.push_back(board[i][j]);
			board[i][j] = 0;
		}

		int k = 0;
		for (k = 0; k < v1.size() - 1; k++)
		{
			if (v1[k] != 0 && v1[k] == v1[k + 1]) {
				v2.push_back(v1[k] * 2);
				k++;
			}
			else
				v2.push_back(v1[k]);
		}
		if (k == v1.size() - 1) v2.push_back(v1[k]);

		int index = 0;
		for (k = 0; k < v2.size(); k++)
		{
			board[i][index++] = v2[k];
		}
	}
}

void sumBlock4()
{
	for (int i = 0; i< N; i++)
	{
		vector<int>v1;
		vector<int>v2;
		for (int j = N - 1; j >= 0; j--)
		{
			if (board[i][j] != 0)
				v1.push_back(board[i][j]);
			board[i][j] = 0;
		}

		int k = 0;
		for (k = 0; k < v1.size() - 1; k++)
		{
			if (v1[k] != 0 && v1[k] == v1[k + 1]) {
				v2.push_back(v1[k] * 2);
				k++;
			}
			else
				v2.push_back(v1[k]);
		}
		if (k == v1.size() - 1) v2.push_back(v1[k]);

		int index = 0;
		for (k = 0; k < v2.size(); k++)
		{
			board[i][index++] = v2[k];
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