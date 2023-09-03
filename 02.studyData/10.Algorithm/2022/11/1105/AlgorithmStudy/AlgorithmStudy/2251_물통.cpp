#include<stdio.h>
#include<vector>
#include<queue>
#include<queue>
#include<map>
#include<algorithm>
#include<iostream>
using namespace std;

struct WaterBottle {
	int A, B, C;
};

int checkBottle[204][204][204];
int waterBottle[3];
int originWB[3];
WaterBottle WB , OriginWB;

int main(void) {
	map<int, int> m;
	scanf("%d %d %d", &originWB[0], &originWB[1], &originWB[2]);
	WB.C=originWB[2];
	
	vector<int> answerBottle;
	answerBottle.push_back(WB.C);
	checkBottle[WB.A][WB.B][WB.C] = 1;
	queue<WaterBottle>q;
	q.push(WB);

	while (!q.empty()) {
		WaterBottle c = q.front(); q.pop();
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) continue;
				WaterBottle n = c;
				int waterBottle[3] = { n.A,n.B,n.C };

				if (waterBottle[i]==0||waterBottle[j] == originWB[j])continue;
				int number = waterBottle[i] + waterBottle[j];
				if (number >= originWB[j]) {
					int num1 = originWB[j];
					int num2 = number - originWB[j];
					waterBottle[j] = num1;
					waterBottle[i] = num2;
				}
				else {
					waterBottle[j] = number;
					waterBottle[i] = 0;
				}
				
				if (checkBottle[waterBottle[0]][waterBottle[1]][waterBottle[2]] == 0) {
					checkBottle[waterBottle[0]][waterBottle[1]][waterBottle[2]] = 1;
					n.A = waterBottle[0];
					n.B = waterBottle[1];
					n.C = waterBottle[2];
					if (n.A == 0)
					{
						if (m.count(n.C) == 0) {
							m[n.C] = 1;
							answerBottle.push_back(n.C);
						}
					}
					q.push(n);
				}
			}
		}
	}

	sort(answerBottle.begin(), answerBottle.end());

	for(int i=0;i<answerBottle.size();i++)
	cout << answerBottle[i] << " ";
	return 0;
}