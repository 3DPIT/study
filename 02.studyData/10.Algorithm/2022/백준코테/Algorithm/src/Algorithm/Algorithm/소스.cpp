#include <string>
#include <vector>

using namespace std;

int solution(vector<int> players) {
	int answer = -1;
	int zero = 0;
	int one = 0;
	for (int i = 0; i < players.size(); i++) {
		if (players[i] == 1)one++;
		else if (players[i] == 0) zero++;
	}
	if (one == zero || one == zero - 1) {
		answer = players.size() - 1;
	}
	else {
		one + 1 
	}
	return answer;
}
int main(void)
{
	return 0;
}