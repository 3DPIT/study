#include<iostream>
#include<string>
#include<vector>
#include<algorithm>

using namespace std;
struct Data {
	string name;
	int time[19] = { 0, };
};
bool cmp(Data a, Data b) {
	return a.name < b.name;
}
int main(int argc, char** argv)
{
	int N, M;
	vector<Data>room;
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		Data roomN;
		cin >> roomN.name;
		room.push_back({ roomN });
	}
	sort(room.begin(), room.end(),cmp);
	for (int i = 0; i < M; i++) {
		string name, int start, int end;
		cin >> name >> start >> end;
		for (int i = 0; i < room.size(); i++) {
			if (name == room[i].name) {
				for (int t = start; t <= end; t++) {
					room[i].time[t] = 1;
				}
				room[i].time[start] = 2;
				room[i].time[end] = 2;
			}
		}
	}
	return 0;
}