#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
	int answer = 0;

	vector<int>box;
	vector<int>lineDoll[31];

	for (int j = 0; j < board.size(); j++) {//뽑아내기
		for (int i = 0; i < board.size(); i++) {
			if (board[i][j] != 0) {
				lineDoll[j].push_back(board[i][j]);
			}
		}
	}

	for (int m = 0; m < moves.size(); m++) {
		if (lineDoll[moves[m]-1].size() != 0) {
			box.push_back(lineDoll[moves[m]-1][0]);
			lineDoll[moves[m]-1].erase(lineDoll[moves[m]-1].begin());
		}

		//인형 두개 이상인지 확인하고 같은 종류 두개인지 확인후 제거 점수 추가
		if (box.size() >= 2) {
			for (int i = 0; i < box.size() - 1; i++) {
				if (box.size()==0||box.size() == 1)break;
				if (box[i] == box[i + 1]) {
					box.erase(box.begin() + i, box.begin() + i+2);
					i--;
					answer += 2;
				}
			}
		}
	}
	return answer;
}

int main(void)
{
	cout << solution({ {0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1} }, { 1, 5, 3, 5, 1, 2, 1, 4});
	return 0;
}