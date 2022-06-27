#include <vector>
#include <string>
#include <algorithm>
#include <iostream>

using namespace std;
string ordering[6][3] = {
	//{"+-","*","."},
	//{"+*","-","."},
	//{"-*","+","."},
	//
	//{"*","+-","."},
	//{"-","+*","."},
	//{"+","-*","."},

	{"+","-","*"},
	{"+","*","-"},
	{"-","+","*"},
	{"-","*","+"},
	{"*","-","+"},
	{"*","+","-"}
};
long long solution(string expression) {
	long long answer = 0;
	vector<string>calNumber;
	string number;
	for (int i = 0; i < expression.size(); i++) {
		if ('0' <= expression[i] && expression[i] <= '9') {
			number += expression[i];
		}
		else {
			calNumber.push_back(number);
			number.clear();
			number += expression[i];
			calNumber.push_back(number);
			number.clear();
		}
		if(i== expression.size()-1)
			calNumber.push_back(number);
	}


	vector<string>copy_calNumber=calNumber;

	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 3; j++) {
			long long sum = 0;
			for (int e = 0; e < calNumber.size(); e++) {
				if (calNumber[e] == ordering[i][j]) {
					long long firstNum = stoll (calNumber[e - 1]);
					long long secondNum = stoll(calNumber[e + 1]);

					if (calNumber[e] == "+") {
						sum = firstNum + secondNum;
					}
					else if (calNumber[e] == "-") {
						sum = firstNum - secondNum;
					}
					else if (calNumber[e] == "*") {
						sum = firstNum * secondNum;
					}
					else break;
					calNumber.erase(calNumber.begin() + (e - 1), calNumber.begin() + (e - 1) + 3);
					e--;
					string number = to_string(sum);
					calNumber.insert(calNumber.begin() + e, number);
				}
			}
		} 
		answer = max(answer, abs(stoll(calNumber[0])));
		calNumber = copy_calNumber;

	}
	return answer;
}

int main(void)
{
	cout<<solution("50*6-3*2");
	return 0;
}