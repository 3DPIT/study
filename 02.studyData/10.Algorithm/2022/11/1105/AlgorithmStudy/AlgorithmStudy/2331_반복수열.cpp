#include<stdio.h>
#include<iostream>
#include<queue>
#include<string>
#include<math.h>
#include<string.h>
using namespace std;
long long N;
int P;
int cnt = 0;
int visit[1000000];
int ret;

int next(int a, int p) {
	int sum = 0;
	while (a > 0) {
		sum += pow(a % 10, p);
		a /= 10;
	}

	return sum;
}

int length(int a, int p, int cnt) {
	if (visit[a] != 0) {
		return visit[a] - 1;
	}
	visit[a] = cnt;
	int b = next(a, p);

	return length(b, p, cnt + 1);
}

int dfs(int a, int p, int cnt) {
	if (visit[a] == 0) {
		visit[a] = cnt;

		int b = next(a, p);
		return dfs(b, p, cnt + 1);
	}
	else {
		return visit[a]-1;
	}
}

long long squrtNumber(long long number) {
	string numbers = to_string(number);
	long long sum = 0;

	for (int i = 0; i < numbers.size(); i++) {
		int powNumber = pow(numbers[i]-'0', P);
		sum += powNumber;
	}

	return sum;
}

void repeatNumberCheck(long long N) {
	while (1) {
		if (visit[N] == 0) {
			visit[N] = ++cnt;
			long long sum = squrtNumber(N);
			N = sum;
		}
		else {
			int retNumber = N;
			ret = visit[retNumber] - 1;
			break;
		}
	}
}

int main(void) {
	cin >> N >> P;
	//repeatNumberCheck(N);
	cout << dfs(N, P, 1) << endl;
	//cout << ret << endl;

	return 0;
}