#include <string>
#include <vector>
#include <algorithm>
using namespace std;
char numberChar[] = { '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F' };

string nChange(int changeNumber, int number)
{
	string nString;
	while (changeNumber / number != 0) {
		nString += numberChar[changeNumber%number];
		changeNumber /= number;
	}
	nString += numberChar[changeNumber%number];
	changeNumber /= number;
	reverse(nString.begin(), nString.end());
	return nString;
}

string solution(int n, int t, int m, int p) {
	string answer = "";
	string s;
	int Cnt = 0;
	for (int i = 0; i < t*m; i++) s += nChange(i, n);
	for (int i = p - 1, cnt = 0; i < s.length(), cnt<t; i += m) {
		answer += s[i];
		cnt++;
	}

	return answer;
}

int main(void) {
	string a = solution(16, 16, 2, 1);
}