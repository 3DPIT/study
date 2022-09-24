#include <string>
#include <vector>
#include <iostream>
#include <sstream>

using namespace std;
string board[54][54];
int uniqueInt;
struct MergeData {
	int sy, sx, ey, ex;
	string content;
	int same_merge;
};
vector<MergeData>merges;

void update(int r, int c, string value) {
	int same = 0;
	int flag = 0;
	for (int i = 0; i < merges.size(); i++) {
		flag = 0;
		same = 0;
		for (int y = merges[i].sy; y <= merges[i].ey; y++) {
			for (int x = merges[i].sx; x <= merges[i].ex; x++) {
				if (r == y && c == x) {
					flag = 1;
					same = merges[i].same_merge;
					break;
				}
			}
			if (flag) break;
		}
		if (flag)break;
	}
	for (int i = 0; i < merges.size(); i++) {
		if (merges[i].same_merge == same) {

			for (int y = merges[i].sy; y <= merges[i].ey; y++) {
				for (int x = merges[i].sx; x <= merges[i].ex; x++) {
					board[y][x] = value;
				}
			}
			merges[i].content = value;
		}
	}
	if(flag==0)	board[r][c] = value;

	
}
void update1(string value1, string value2) {
	for (int i = 0; i < merges.size(); i++) {
		if (merges[i].content == value1) {
			merges[i].content = value2;
		}
	}
	for (int i = 0; i < 50; i++) {
		for (int j = 0; j < 50; j++) {
			if (board[i][j] == value1) {
				board[i][j] = value2;
			}
		}
	}
}
void merge(int r1, int c1, int r2, int c2) {
	int sy, sx, ey, ex;
	string content = board[r1][c1];
	if (r1 > r2) {
		sy = r2; sx = c2;
		ey = r1; ex = c1;
	}
	else if (r1 == r2) {
		if (c1 > c2) {
			sy = r2; sx = c2;
			ey = r1; ex = c1;
		}
		else {
			sy = r1; sx = c1;
			ey = r2; ex = c2;
		}
	}
	else {
		sy = r1; sx = c1;
		ey = r2; ex = c2;
	}


	int s_flag = 0;
	int size = merges.size();
	for (int r = sy; r <= ey; r++) {
		for (int c = sx; c <= ex; c++) {
			for (int i = 0; i < size; i++) {
				int flag = 0;
				for (int y = merges[i].sy; y <= merges[i].ey; y++) {
					for (int x = merges[i].ex; x <= merges[i].ex; x++) {
						if (r == y && c == x) {// 마지되어 있는 부분 확인
							s_flag = 1;
							flag = 1;
							break;
						}
					}
					if (flag) break;
				}
				if (flag == 1) {
					for (int ii = merges[i].sy; ii <= merges[i].ey; ii++) {
						for (int jj = merges[i].sx; jj <= merges[i].ex; jj++) {
							board[ii][jj] = content;
						}
					}
					for (int ii = sy; ii <= ey; ii++) {
						for (int jj = sx; jj <= ex; jj++) {
							board[ii][jj] = content;
						}
					}
					if (s_flag == 1) {
						s_flag = 2;
						++uniqueInt;
					}
					merges.push_back({ sy,sx,ey,ex,content,uniqueInt });
					merges[i].same_merge = uniqueInt;
				}
			}
		}
	}

	if (s_flag == 0) {
		for (int i = sy; i <= ey; i++) {
			for (int j = sx; j <= ex; j++) {
				board[i][j] = content;
			}
		}
		merges.push_back({ sy,sx,ey,ex,content,++uniqueInt });
	}
}
void unmerge(int r, int c) {
	int unique = 0;
	string content = board[r][c];
	for (int i = 0; i < merges.size(); i++) {
		int flag = 0;
		for (int y = merges[i].sy; y <= merges[i].ey; y++) {
			for (int x = merges[i].ex; x <= merges[i].ex; x++) {
				if (r == y && c == x) {// 마지되어 있는 부분 확인
					flag = 1;
					unique = merges[i].same_merge;
					break;
				}
			}
			if (flag)break;
		}
	}
	for (int i = 0; i < merges.size(); i++) {
		if (merges.size() == 0) break;
		if (merges[i].same_merge = unique) {
			for (int y = merges[i].sy; y <= merges[i].ey; y++) {
				for (int x = merges[i].sx; x <= merges[i].ex; x++) {
					board[y][x] = "";
				}
			}
			merges.erase(merges.begin() + i);
			i--;
		}
	}
	board[r][c] = content;
}
string print(int r, int c) {
	if (board[r][c] == "") return "EMPTY";
	else return board[r][c];
}
vector<string> solution(vector<string> commands) {
	vector<string> answer;
	
	for (auto& command : commands) {
		istringstream iss(command);
		string key[6];
		iss >> key[0] >> key[1] >> key[2] >> key[3] >> key[4] >> key[5];
		//cout << key[0] << " " << key[1] << " " << key[2] << " " << key[3] << " " << key[4] << " " << key[5] << endl;
		if (key[0] == "UPDATE"&&key[3] == "") {
			update1(key[1], key[2]);
		}
		else if (key[0] == "UPDATE"&&key[3] != "") {
			update(stoi(key[1]) - 1, stoi(key[2]) - 1, key[3]);
		}
		else if (key[0] == "MERGE") {
			merge(stoi(key[1]) - 1, stoi(key[2]) - 1, stoi(key[3])-1, stoi(key[4])-1);
		}
		else if (key[0] == "UNMERGE") {
			unmerge(stoi(key[1]) - 1, stoi(key[2]) - 1);
		}
		else if (key[0] == "PRINT") {
			answer.push_back(print(stoi(key[1]) - 1, stoi(key[2]) - 1));
		}
	}

	return answer;
}

int main(void)
{

	//vector<string> a = solution({ "UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4" });
	vector<string> a = solution({ "UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1","MERGE 2 1 1 1","PRINT 1 1","UNMERGE 2 2", "PRINT 1 1"});
	
	for (int i = 0; i < a.size(); i++) {
		cout << a[i] << " ";
	}
	return 0;
}