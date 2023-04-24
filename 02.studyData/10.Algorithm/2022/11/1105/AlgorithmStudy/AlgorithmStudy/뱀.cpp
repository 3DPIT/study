

//몸길이 늘려서 머리 다음칸
//이동칸 사과. 있으면 사과 없고 꼬리 이동 안함
//이동칸 사과 없으면 몸길이 줄여서 꼬리가 위치한 칸 비움


#include<stdio.h>
#include<iostream>
#include<vector>
#include<string.h>
#include<algorithm>
#define NS 104

using namespace std;
int board[NS][NS];
int N,K,L;
int X;
char C;

void init() {
	cin >> N >> K;
	for (int k = 0; k < K; k++) {
		int y, x;
		cin >> y >> x;
		board[y][x] = -1;
	}
}
int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	return 0;
}