#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

void replaceAll(string &m, string from, string to) {
	int pos = 0;
	while ((pos = m.find(from)) != -1) {
		m.replace(pos, from.length(), to);
	}
}

struct Data {
	int time;
	string title;
};
string solution(string m, vector<string> musicinfos) {
	string answer = "";
	pair<int, string> ans = { 0,"" };
	replaceAll(m, "C#", "c");
	replaceAll(m, "D#", "d");
	replaceAll(m, "F#", "f");
	replaceAll(m, "G#", "g");
	replaceAll(m, "A#", "a");
	
	for (int i = 0; i < musicinfos.size(); i++) {

		int t = 0,idx = 0, pos = 0;
		string h1, h2, m1, m2, title, runningMusic;
		h1 = musicinfos[i].substr(0, 2);
		m1 = musicinfos[i].substr(3, 2);
		h2 = musicinfos[i].substr(6, 2);
		m2 = musicinfos[i].substr(9, 2);

		t = abs(stoi(h1) - stoi(h2))*60;
		if (m1 > m2) {
			t -= 60;
			t += (stoi(m2) - stoi(m1)) + 60;
		}
		else t += stoi(m2) - stoi(m1);
		idx = 12;
		for (int j = 12; musicinfos[i][j] != ','; j++,idx++) {
			title += musicinfos[i][j];
		}
		for (int j = idx+1; j < musicinfos[i].size(); j++) runningMusic += musicinfos[i][j];
		replaceAll(runningMusic, "C#", "c");
		replaceAll(runningMusic, "D#", "d");
		replaceAll(runningMusic, "F#", "f");
		replaceAll(runningMusic, "G#", "g");
		replaceAll(runningMusic, "A#", "a");

		int remainTime = t;
		idx = 0;
		int size = runningMusic.size();
		string music;
		while (remainTime--) {
			music += runningMusic[idx++];
			if (idx == size)idx = 0;
		}
		idx = 0;
		idx = music.find(m);
		if (idx != -1 && ans.first < t) {
			ans.first = t;
			ans.second = title;
		}

	}
	answer = ans.second;
	if (answer == "") answer = "(None)";

	return answer;
}
int main(void) {
	solution("ABC#DEC#G", { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" });
}

