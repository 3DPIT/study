#include <string>
#include <vector>
#include <iostream>
#include <string.h>

using namespace std;
int locks[64][64];
int cc[64][64];

void rotation(vector<vector<int>> &arr) {
	vector<vector<int>>crr = arr;
	for (int i = 0; i < arr.size(); i++) {
		for (int j = 0; j < arr.size(); j++) {
			cc[i][j] = crr[i][j] = arr[j][arr.size() - i - 1];
		}
	}

	arr = crr;
}

void copyArr(vector<vector<int>> &lock) {
	memset(locks, 0, sizeof(locks));
	for (int i = 0; i < lock.size(); i++) {
		for (int j = 0; j < lock.size(); j++) {
			locks[i][j] = lock[i][j];
		}
	}
}
bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
	bool answer = true;

	vector<vector<int>> copy_lock = lock;
	for (int k = 0; k < 4; k++) {
		for (int i = 0; i <= 4; i++) {

			for (int y = 0; y < lock.size(); y++) {
				for (int x = 0; x < lock.size(); x++) {
					int chk[44][44] = { 0, };

					copyArr(lock);
					int flag = 0;
					for (int yy = 0; yy < key.size(); yy++) {
						for (int xx = 0; xx < key.size(); xx++) {
							chk[y + yy][x + xx] = 1;
							if (key[yy][xx] == 1) {
								locks[y + yy][x + xx]++;
								if (locks[y + yy][x + xx] == 2) {
									flag = 1;
									break;
								}
							}
						}
						if (flag)break;
					}
					if (flag)continue;

					int result = (lock.size())* (lock.size());
					int count = 0;
					for (int y = 0; y < lock.size(); y++) {
						for (int x = 0; x < lock.size(); x++) {
							if (locks[y][x] == 1)
								count++;
						}
					}
					if (result == count) return true;
				}
			}
			rotation(key);
		}
		rotation(lock);
	}
	return false;
}
int main(void)
{
	cout << solution({ {0, 0, 0}, {1, 0, 0}, {0, 1, 1} }, { {1, 1, 1} ,{1, 1, 0}, {1, 0,1} });
	return 0;
}