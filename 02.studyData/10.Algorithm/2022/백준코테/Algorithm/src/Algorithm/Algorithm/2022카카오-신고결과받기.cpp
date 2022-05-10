#include <string>
#include <vector>
#include <map>
#include<iostream>
using namespace std;
struct Data {
	string name;
	int report_out;
};
vector<int> solution(vector<string> id_list, vector<string> report, int k) {
	vector<int> answer;
	vector<int>friends[5000];
	map<string, int>friends_num;
	int check_out[5000] = { 0, };
	for (int i = 0; i < id_list.size(); i++)
	{
		friends_num[id_list[i]] = i;
	}
	for (int i = 0; i < report.size(); i++) {
		string s1;
		string s2;
		int flag = 0;
		for (int j = 0; j < report[i].size(); j++) {
			if (report[i][j] == ' ') {
				flag = 1;
				continue;
			}
			if(flag==0)s1 += report[i][j];
			if (flag == 1)s2 += report[i][j];
		}
		cout << s1 << endl;
		cout << s2 << endl;
		friends[friends_num[s1]].push_back(friends_num[s2]);
		check_out[friends_num[s2]]++;
	}

	for (int i = 0; i < id_list.size(); i++) {
		int count = 0;
		for (int j = 0; j < friends[i].size();j++){
			
			for (int ii= 0; ii < id_list.size(); ii++) {
				if (friends[i][j] == ii&& check_out[ii]>=k) {
					count++;
				}
			}
		}
		answer.push_back(count);
	}

	return answer;
}

int main(void)
{
	//solution({ "muzi", "frodo", "apeach", "neo" }, { "muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi" },2);
	solution({ "con", "ryan" }, { "ryan con", "ryan con", "ryan con", "ryan con" }, 3);

	return 0;
}