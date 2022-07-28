#include <string>
#include <vector>
#include <unordered_map>
#include <regex>
using namespace std;

struct Data {
	int time;
	string title;
	string music;
};
string solution(string m, vector<string> musicinfos) {
	string answer = "";
	string a;
	int idx = 0;
	m = regex_replace(m, regex("C#"), "c");
	m = regex_replace(m, regex("D#"), "d");
	m = regex_replace(m, regex("F#"), "f");
	m = regex_replace(m, regex("G#"), "g");
	m = regex_replace(m, regex("A#"), "a");
	vector<string> v[104];
	vector<Data> musicV;
	for (int i = 0; i < musicinfos.size(); i++) {
		for (int j = 0; j < musicinfos[i].size(); j++) {
			a += musicinfos[i][j];
			if (musicinfos[i][j] == ',') {
				v[i].push_back(a);
				a.clear();
			}
		}
		v[i].push_back(a);
		a.clear();
	}
	for (int i = 0; i < musicinfos.size(); i++) {
		string time2;
		string time1;
		int time = 0;
		int timeInt2 = 0;
		int timeInt1 = 0;
		timeInt2 = (v[i][1][0]-48)*10 + (v[i][1][1]-48);
		time1 = v[i][0][0] + v[i][0][1];
		timeInt1 = (v[i][0][0] - 48) * 10 + (v[i][0][1] - 48);
		time += timeInt2 - timeInt1;

		timeInt2 = (v[i][1][3] - 48) * 10 + (v[i][1][4] - 48);
		time1 = v[i][0][0] + v[i][0][1];
		timeInt1 = (v[i][0][3] - 48) * 10 + (v[i][0][4] - 48);
		time += timeInt2 - timeInt1;


		int remainTime = time;
		int idx = 0;
		int size = v[i][3].size();
		string music;
		while (remainTime--) {
			music += v[i][3][idx++];
			if (idx == size)idx = 0;
		}
		music = regex_replace(music, regex("C#"), "c");
		music = regex_replace(music, regex("D#"), "d");
		music = regex_replace(music, regex("F#"), "f");
		music = regex_replace(music, regex("G#"), "g");
		music = regex_replace(music, regex("A#"), "a");

		
		musicV.push_back({ time,v[i][2],music });
	}
	int max = 0x80000000;
	string title;
	for (int i = 0; i < musicV.size(); i++ ) {
		if (musicV[i].music.find(m) != string::npos) {
			if (max < musicV[i].time) {
				max = musicV[i].time;
				title = musicV[i].title;
			}
		}
	}
	title.pop_back();
	return title;
}
int main(void) {
	solution("ABC#DEC#G", { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" });
}