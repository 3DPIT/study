#include<iostream>
#include<stdio.h>
#include<map>
#include<string>
using namespace std;
int main(void) {
	map<string,int> res;
	res["black"] = 1;
	res["brown"] = 10;
	res["red"] = 100;
	res["orange"] = 1000;
	res["yellow"] = 10000;
	res["green"] = 100000;
	res["blue"] = 1000000;
	res["violet"] = 10000000;
	res["grey"] = 100000000;
	res["white"] = 1000000000;
	map<string, int> res = {
	{"black",0},
	{"brown",1},
	{"red",2},
	{"orange",3},
	{"yellow",4},
	{"green",5},
	{"blue",6},
	{"violet",7},
	{"grey",8},
	{"white",9},
	};

	string s1, s2, s3;
	long long ret=0;
	int tenNumber = 10;
	cin >> s1 >> s2 >> s3;

	ret = res[s1] * 10 + res[s2];

	int tenRet = 0;
	for (int index = 0; index < res[s3]; index++) {
		ret *= 10;
	}	
	cout << ret << endl;
	return 0;
}