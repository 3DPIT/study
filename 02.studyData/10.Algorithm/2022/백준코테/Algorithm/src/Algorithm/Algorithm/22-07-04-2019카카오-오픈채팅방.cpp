
#include <string>
#include <vector>
#include <sstream>
#include <unordered_map>

using namespace std;
struct Data {
	string actor;
	string uid;
};

vector<string> solution(vector<string> record) {
	vector<string> answer;
	unordered_map<string, string> map;
	vector<Data> sub_answer;
	for (auto& rec : record)
	{
		string key[3];
		istringstream iss(rec);
		iss >> key[0] >> key[1] >> key[2];
		if(key[0] != "Change")sub_answer.push_back({ key[0],key[1]});
		if(key[0]!="Leave")	map[key[1]] = key[2];
	}
	for (auto& sub_a : sub_answer) {
		if (sub_a.actor == "Enter") {
			string sumString;
			sumString += map[sub_a.uid] + "님이 들어왔습니다.";
			answer.push_back(sumString);
		}
		else  if (sub_a.actor == "Leave") {
			string sumString;
			sumString += map[sub_a.uid] + "님이 나갔습니다.";
			answer.push_back(sumString);
		}
	}
	return answer;
}

int main(void) {

	solution({ "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan" });
	return 0;
}
