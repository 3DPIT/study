#include<string>
#include<iostream>
#include<string.h>
#include<algorithm>
#include<vector>

using namespace std;

int main(void) {
	string s = "1 -1 -2 3";
	string answer;
	int min1 = numeric_limits<int>::max();
	int max1 = numeric_limits<int>::min();

	int flag = 1;
	for (char c : s) {
		int num = 0;
		if (flag == 0) {
			num = (c - '0') *-1;
			flag = 1;
		}
		else if (c == '-') {
			flag = 0;
			continue;
		}
		else if (c == ' ')
		{
			continue;
		}
		else {
			 num = c - '0';
		}
		min1 = min(min1, num);
		max1 = max(max1, num);
	}
	if (min1 < 0) {
		answer += '-';
		answer += (min1*-1) + '0';
	}
	else if (min1 >= 0) {
		answer += (min1) + '0';
	}
	answer += " ";
	if (max1 < 0) {
		answer += '-';
		answer += (max1*-1) + '0';
	}
	else if (max1 >= 0) {
		answer += (max1)+'0';
	}
	cout << answer << endl;
}