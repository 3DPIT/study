#include <string>
#include <vector>
#include <algorithm>
using namespace std;
struct File {
	string originFiles;
	string head;
	int number;
	string tail;
	int orderNumber;
};

bool cmp(File a, File b) {
	if (a.head == b.head&& a.number == b.number) {
		return a.orderNumber < b.orderNumber;
	}
	else if (a.head == b.head) {
		return a.number < b.number;
	}
	else return a.head < b.head;
}

vector<string> solution(vector<string> files) {
	vector<string> answer;
	vector<File> filesCollection;

	bool headFlag = 0;
	bool numberFlag = 0;

	int idx = 0;
	for (int i = 0; i < files.size(); i++) {
		string head;
		string number;
		string tail;
		for (int j = 0; j < files[i].size(); j++) {
			if (numberFlag==0&&'0' <= files[i][j] && files[i][j] <= '9') {//숫자인경우
				headFlag = 1;

				number += files[i][j];
			}
			else if (headFlag == 1 &&!('0' <= files[i][j] && files[i][j] <= '9')) {
				tail += files[i][j];
				numberFlag = 1;
			}
			if (headFlag == 0) head += files[i][j];
		}
		string originFiles = files[i];
		for (int j = 0; j < head.size(); j++) {
			head[j] = tolower(head[j]);
		}
		filesCollection.push_back({originFiles,head,stoi(number),tail,i });
		headFlag = 0;
		numberFlag = 0;
	}
	sort(filesCollection.begin(), filesCollection.end(), cmp);
	for (int i = 0; i < filesCollection.size(); i++) {
		answer.push_back(filesCollection[i].originFiles);
	}
	return answer;
}

int main(void)
{
	solution({ "O00321", "O49qcGPHuRLR5FEfoO00321" });
	//solution({ "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat" });
	//solution({ "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat" });

	return 0;
}