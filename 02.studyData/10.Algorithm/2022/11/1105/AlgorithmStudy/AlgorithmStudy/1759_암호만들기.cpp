#include<stdio.h>
#include<vector>
#include<algorithm>
#include<iostream>
#include<string>

using namespace std;
int L, C;
int D[19];
vector<char>alphabet;
char mo[5] = {'a','e','i','o','u' };

void dfs(int cnt,int idx, string alpha) {

	if (cnt == L) {
		int count1 = 0;
		int count2 = 0;
	
		for (int i = 0; i < alpha.size(); i++) {
			if (alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u') {
				count1++;
			}
			else {
				count2++;
			}
		}
		if (count1 >= 1 && count2 >= 2) {
			cout << alpha << endl;
		}
		return;
	}
	if (idx >= alphabet.size())return;

	alpha.push_back(alphabet[idx]);
	dfs(cnt + 1, idx + 1, alpha);
	alpha.pop_back();
	dfs(cnt, idx + 1, alpha);

	//for(int i= idx;i<C;i++){
	//	if (D[i] == 0) {
	//		D[i] = 1;
	//		alpha.push_back(alphabet[i]);
	//		dfs(cnt + 1, i ,alpha);
	//		alpha.pop_back();
	//		D[i] = 0;
	//	}
	//}
}

int main(void) {

	scanf("%d %d", &L, &C);
	for (int i = 0; i < C; i++) {
		char c;
		scanf(" %c", &c);
		alphabet.push_back(c);
	}


	sort(alphabet.begin(), alphabet.end());
	dfs(0,0,"");



	return 0;
}