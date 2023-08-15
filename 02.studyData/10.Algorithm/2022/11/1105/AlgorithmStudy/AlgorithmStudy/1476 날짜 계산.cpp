#include<iostream>
#include<vector>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int E, S, M;
	cin >> E >> S >> M;

	int e=0, s=0, m=0;
	int ret = 0;
	while (1) {
	if (e == E && s == S && m == M)break;

	e += 1; 
	s += 1;
	m += 1;
	if (e == 16)e = 1;
	if (s == 29) s = 1;
	if (m == 20) m = 1;

		ret++;
	}
	
	cout << ret;
	return 0;
}