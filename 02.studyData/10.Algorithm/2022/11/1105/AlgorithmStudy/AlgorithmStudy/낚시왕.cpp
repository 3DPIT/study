#include<stdio.h>
#include<iostream>
#include<vector>
#include<string.h>
#include<algorithm>
#define SS 1004
using namespace std;
int N, M, S;//격자 y x , 상어수
int ret;
int dy[] = { -1,1,0,0 };
int dx[] = { 0,0,1,-1 };
struct Data {
	int y, x, s, d, z;
};
vector<Data>Shark;
bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < M;
}
bool cmp(Data a, Data b) {
	if (a.y == b.y)return a.x < b.x;
	return a.y < b.y;
}
void init() {
	scanf("%d %d %d", &N, &M, &S);
	for (int s = 0; s < S; s++) {
		Data c;
		scanf("%d %d %d %d %d", &c.y, &c.x, &c.s, &c.d, &c.z);
		c.y--; c.x--; c.d--;
		if (c.d == 0 || c.d == 1) c.s = c.s % ((N - 1)*2);
		else  c.s = c.s % ((M - 1)*2);
		Shark.push_back(c);
	}
}
void sharkFishing() {
	for (int j = 0; j < M; j++) {//낚시 가능 횟수
		if (Shark.size() == 0)break;
		sort(Shark.begin(), Shark.end(), cmp);
		for (int i = 0; i < Shark.size(); i++) {
			if (Shark[i].x == j) {
				ret += Shark[i].z;
				Shark.erase(Shark.begin() + i);
				break;
			}
		}


		for (int s = 0; s < Shark.size(); s++) {//상어 이동
			if (Shark.size() == 0) break;
			Data n = Shark[s];
			for (int speed = 0; speed < Shark[s].s; speed++) {
				n.y = n.y + dy[n.d];
				n.x = n.x + dx[n.d];
				if (n.y < 0 || n.y == N || n.x < 0 || n.x == M) {
					n.y = n.y - dy[n.d];
					n.x = n.x - dx[n.d];
					if (n.d == 0) n.d = 1;
					else if (n.d == 1) n.d = 0;
					else if (n.d == 2) n.d = 3;
					else if (n.d == 3) n.d = 2;
					speed--;
				}
			}
			Shark[s] = n;
		}

		for (int i = 0; i < Shark.size(); i++) {
			Data n = Shark[i];
			for (int s = 0; s < Shark[i].s; s++) {
				n.y = n.y + dy[n.d]; n.x = n.x + dx[n.d];
				if (n.y < 0 || n.y == N || n.x < 0 || n.x == M) {
					n.y = n.y - dy[n.d]; n.x = n.x - dx[n.d];
					if (n.d == 0) n.d = 1;
					else if (n.d == 1) n.d = 0;
					else if (n.d == 2)n.d = 3;
					else if (n.d == 3) n.d = 2;
					s--;
				}
			}
		}

		if (Shark.size() == 0)break;
		sort(Shark.begin(), Shark.end(), cmp);
		for (int i = 0; i < Shark.size() - 1; i++) {
			if (Shark.size() == 1) break;
			if (Shark[i].y == Shark[i + 1].y&&
				Shark[i].x == Shark[i + 1].x) {
				if (Shark[i].z > Shark[i + 1].z) {
					Shark.erase(Shark.begin() + i + 1);
					i--;
				}
				else if (Shark[i].z < Shark[i + 1].z) {
					Shark.erase(Shark.begin() + i);
					i--;
				}
			}
		}
	}
}
int main(void)
{
	init();
	sharkFishing();
	printf("%d\n", ret);
	return 0;
}