#include<stdio.h>
#include<iostream>
#include<string>
using namespace std;

int main(void) {
	//add |
	//check &
	//remove &~
	//toggle ^
	//all << N -1
	//empty 0
	int N;
	string order;
	cin >> N;
	int number = 0;
	int x;
	while (N--) {
		cin >> order;
		if (order == "add") {
			cin >> x;
				number = number | (1 << x);
			
		}
		if (order == "check") {
			cin >> x;
			x = number &( 1 << x);
			if (x == 0) cout << 0 << endl;
			else cout << 1 << endl;
		}
		if (order == "remove") {
			cin >> x;
				number = number & ~(1 << x);
		
		}
		if (order == "toggle") {
			cin >> x;
			number = number ^ (1 << x);

		}
		if (order == "all") {
			number = (1 << number) - 1;
		}
		if (order == "empty") {
			number = 0;
		}
	}
	return 0;
}