#include <string>
#include <vector>
#include <map>
using namespace std;

vector<int> solution(vector<int> fees, vector<string> records) {
	vector<int> answer;
	map<string, vector<pair<int, string>>>cars;

	for (int i = 0; i < records.size(); i++) {
		string number;
		int minute;
		string IO;
		int hour = stoi(records[i].substr(0, 2))*60;
		minute = stoi(records[i].substr(3, 2)) + hour;
		number = records[i].substr(6, 4);
		IO = records[i].substr(11, 1);
		cars[number].push_back({ minute,IO });
	}

	//OUT Ãß°¡
	for (auto car : cars) {
	
		if (car.second.size() %2 != 0) {
			cars[car.first].push_back({ 1439,"O" });
		}
	}

	for (auto car : cars) {
		int minuteS=0;
		for (int i = 0; i < car.second.size(); i += 2) {
			minuteS+=(car.second[i + 1].first - car.second[i].first);
		}
		if (fees[0] < minuteS) {
			int a = 0;
			if (((minuteS - fees[0]) % fees[2]) != 0) {
				a = ((minuteS - fees[0]) / fees[2])+1;
			}
			else a = ((minuteS - fees[0]) / fees[2]);
			answer.push_back(fees[1] + a *fees[3]);
		}
		else answer.push_back(fees[1]);
	}
	
	return answer;
}
int main(void)
{
	solution({ 180, 5000, 10, 600 }, { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" });
	return 0;
}
