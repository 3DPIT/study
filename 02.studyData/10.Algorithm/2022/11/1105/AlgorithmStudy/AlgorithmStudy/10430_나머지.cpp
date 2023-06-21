#include <stdio.h>
#include <vector>
#include<iostream>
using namespace std;
int A, B, C;
int main(void) {
	cin >> A >> B >> C;
	cout << (A + B) % C << '\n';
	cout << ((A%C) + (B%C)) % C << "\n";
	cout << (A*B) % C << "\n";
	cout << ((A%C) *(B%C)) % C << "\n";
	return 0;
}