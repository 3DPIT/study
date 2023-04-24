#include<stdio.h>
#include<iostream>
#include<vector>
#define NS 1004
using namespace std;
int dy[] = { 0,1,0,-1 };
int dx[] = { -1,0,1,0 };

int board[NS][NS];
int temp[NS][NS];
int N = 5;


void snailArr() {


	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			temp[i][j] = board[j][N-1-i];
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++){
			board[i][j] = temp[i][j];
			cout << temp[i][j] << " ";
			temp[i][j];
	}
		cout << endl;
	}
}
int main() {

	int cnt = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			board[i][j] = ++cnt;
		}
	}
	for(int i=0;i<4;i++)
	snailArr();
	return 0;
}