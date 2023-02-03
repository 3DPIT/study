#include<iostream>
#include<vector>
#include<stdio.h>

using namespace std;
int chkGear[4];

int main(int argc, char** argv)
{
	/*
	 -1 -1 -1 -1 -1 -1 -1 = -7 ascending

	 1 1 1 1 1 1 1 =7 decending

	 els mixed
	*/
	vector<int>gear;
	int currenGear = 0;
	scanf_s("%d", &currenGear);
	int gearSum = 0;
	for (int i = 1; i < 8; i++) {
		int nextGear;
		scanf_s("%d", &nextGear);
		if (currenGear - nextGear == -1) {
			chkGear[0]++;
		}
		else if (currenGear - nextGear == 1) {
			chkGear[1]++;
		}
		currenGear = nextGear;
	}
	if (chkGear[0] == 7) { printf("ascending\n"); }
	else if (chkGear[1] == 7) { printf("descending\n"); }
	else { printf("mixed\n"); }
	return 0;
}