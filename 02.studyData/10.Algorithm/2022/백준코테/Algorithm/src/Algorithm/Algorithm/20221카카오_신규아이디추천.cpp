#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string new_id) {
	string answer = "";

	//1
	for (int i = 0; i< new_id.size(); i++) {//대문자를 소문자로 변경
		if('A'<=new_id[i]&&new_id[i]<='Z')
		new_id[i] += 32;
	}

	//2
	for (int i = 0; i < new_id.size(); i++) {
		if (('0' <= new_id[i] && new_id[i] <= '9')||('a' <= new_id[i] && new_id[i] <= 'z')
			||new_id[i] == '.'||new_id[i] == '-'||new_id[i] == '_') {

		}
		else {
			if (new_id.size() == 0)break;
			new_id.erase(new_id.begin() + i);
			i--;
		}	
	}

	//3
	for (int i = 0; i < new_id.size()-1; i++) {
		if (new_id.size() == 1)break;
		if (new_id.size()&&new_id[i] == '.'&& new_id[i+1]=='.') {
			for (int j = i+1; j < new_id.size(); j++)
			{
				if (new_id.size() == 1)break;
				if (new_id.size() == 0)break;
				if(new_id[j]=='.') new_id.erase(new_id.begin() + j);
				else break;
				j--;
				i = j;
			}
		}
	}

	//4
	if(new_id.size()!=0&&new_id[0]=='.') new_id.erase(new_id.begin());//4단계

	int size = 0;
	if (new_id.size() != 0 && new_id[size] == '.') {
		new_id.erase(new_id.end()-1);
	}

	//5
	if (new_id.size() == 0) new_id.push_back('a');

	//6
	while (new_id.size()>= 16) {

		new_id.pop_back();
	}

	if (new_id.size()&&new_id[new_id.size() - 1] == '.')new_id.pop_back();

	//7
	if (new_id.size()&&new_id.size() <= 2) {
		char c = new_id[new_id.size() - 1];
		while (new_id.size()!=3) {
			new_id.push_back(c);
		}
	}

	answer = new_id;
	return answer;
}

int main(void)
{
	//cout << solution("ssssssssssssssssssssssssadasdafafafaliehaklsfhjk3@34jiuo23h48972rn au3r98f2a3lruj2389ry239rynq2789gr?@#rq23rq#@RQ@#*(rq2893nryq2389yr98sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss") << endl;
	//cout<<solution("...!@BaT#*..y.abcdefghijklm")<<endl;
	//cout << solution("z-+.^.") << endl;
	//cout << solution("aaa") << endl;
	//cout << solution("123_.def") << endl;
	cout << solution("abcdefghijklmn.p") << endl;
	return 0;
}