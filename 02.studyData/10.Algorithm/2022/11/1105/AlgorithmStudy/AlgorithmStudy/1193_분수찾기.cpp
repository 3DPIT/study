#include<stdio.h>
#include<iostream>
using namespace std;
int X;
int dy[] = { 0,1,1, - 1 };
int dx[] = { 1,-1,0,1 };
int main(void) {
	scanf("%d", &X);
	int y = 0;
	int x = 0;
	int dir = 0;
	for (int i = 1;; i++) {
		if (X - i <= 0) {
			if (i % 2 == 1) {
				y = i - X + 1;
				x = X;
			}
			else {
				y = X;
				x = i - X + 1;
			}
			break;
		}
		X-= i;
	}
	cout << y << '/' << x << endl;
	return 0;
}

