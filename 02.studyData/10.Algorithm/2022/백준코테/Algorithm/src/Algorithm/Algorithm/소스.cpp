#include <iostream>
#include <sstream>
#include <vector>
using namespace std;
int main(void)
{
	int rr[] = { 1,2,3,4,5,6,7,8,9,10 };
	int ii[] = { 1,2,4,4,5,6,7,8,9,10};
	int idx = 0;
	while (rr[idx++] >0);
	string s;
	int driLen = idx-1;

	vector<string>vs;

	for (int i = 0; i < driLen; i++) {
		if (rr[i] == ii[i]) {
			for (int j = 0; j < driLen; j++) {
				if (j+1 == rr[i]) s += "1,";
				else s += "0,";
			}
		}
		else if (rr[i] != ii[i]) {
			for (int j = 0; j < driLen; j++) {
				if (j+1 == rr[i]) s += "2,";
				else if (j == rr[i]) s += "1,";
				else s += "0,";
			}
		}
		vs.push_back(s);
		s.clear();
	}

	for (int i = 0; i < driLen; i++) {
			cout << vs[i]<<endl;
	}
	
	return 0;
}