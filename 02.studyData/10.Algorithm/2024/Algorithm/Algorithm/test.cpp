#include <iostream>
#include <cstring>
#include <vector>

using namespace std;
char str[1000004];

int main()
{
	int N;
	scanf("%d", &N);
	// N 5 10, 4 9 -> N * 2 -1
	for (int i = 0; i <=( N*2-1)/2; i++) {
		int count = i;
		for (int j = 0; j < N * 2 - 1-i; j++) {
			if (count > j) printf(" ");
			else printf("*");
		}
		printf("\n");
	}

	for (int i = 0; i < (N * 2 - 1) / 2; i++) {
		int count = N - 2 - i;
		for (int j = 0; j <=( (N * 2 ) / 2)+i; j++) {
			if (count > j) printf(" ");
			else
			printf("*");
		}
		printf("\n");
	}
}
