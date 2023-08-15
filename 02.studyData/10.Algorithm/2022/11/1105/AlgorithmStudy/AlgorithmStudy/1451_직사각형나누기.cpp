#include<iostream>
#include<cstdio>
using namespace std;
int a[55][55] = { 0, };
int s[55][55] = { 0, };
long long sum(int a, int b, int c, int d) {
	return s[c][d] - s[c][b - 1] - s[a - 1][d] + s[a - 1][b - 1];
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	int N, M;
	long long ans=0;
	cin >> N >> M;
	//scanf("%d %d", &N, &M);

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			scanf("%1d", &a[i][j]);
		}
	}

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + (long long)a[i][j];
		}
	}

	//1
	for (int i = 1; i <= M - 2; i++) {
		for (int j = i + 1; j <= M- 1; j++) {
			long long r1 = sum(1, 1, N, i);
			long long r2 = sum(1, i + 1, N, j);
			long long r3 = sum(1, j + 1, N, M);
			if (ans < r1*r2*r3) ans = r1 * r2*r3;
		}
	}
	//2
	for (int i = 1; i <= N - 2; i++) {
		for (int j = i + 1; j <= N - 1; j++) {
			long long r1 = sum(1, 1, i, M);
			long long r2 = sum(i + 1, 1, j, M);
			long long r3 = sum(j + 1, 1, N, M);
			if (ans < r1*r2*r3) ans = r1 * r2*r3;
		}
	}
	//3
	for (int i = 1; i <= N - 1; i++) {
		for (int j = 1; j <= M - 1; j++) {
			long long r1 = sum(1, 1, N, j);
			long long r2 = sum(1, j + 1, i, M);
			long long r3 = sum(i + 1, j + 1, N, M);
			if (ans < r1*r2*r3) ans = r1 * r2*r3;
		}
	}
	//4
	for (int i = 1; i <= N - 1; i++) {
		for (int j = 1; j <= M - 1; j++) {
			long long r1 = sum(1, 1, i, j);
			long long r2 = sum(i + 1, 1, N, j);
			long long r3 = sum(1, j + 1, N, M);
			if (ans < r1*r2*r3) ans = r1 * r2*r3;
		}
	}
	//5
	for (int i = 1; i <= N - 1; i++) {
		for (int j = 1; j <= M - 1; j++) {
			long long r1 = sum(1, 1, i, M);
			long long r2 = sum(i + 1, 1, N, j);
			long long r3 = sum(i + 1, j + 1, N, M);
			if (ans < r1*r2*r3) ans = r1 * r2*r3;
		}
	}
	//6
	for (int i = 1; i <= N - 1; i++) {
		for (int j = 1; j <= M - 1; j++) {
			long long r1 = sum(1, 1, i, j);
			long long r2 = sum(1, j + 1, i, M);
			long long r3 = sum(i + 1, 1, N, M);
			if (ans < r1*r2*r3) ans = r1 * r2*r3;
		}
	}

	cout << ans << endl;
	return 0;
}