#include<stdio.h>
#include<iostream>
#include<string>
#include<string.h>
using namespace std;

int main(void) {

	char s[1000];
	scanf("%s",s);

	//printf("%d", 'A');//65
	//printf("%d", 'Z');//90
	for (int i = 0; i < (int)strlen(s); i++) {
		//if(s[i]-3<65) printf("%c", ((s[i]-3)+26));
		//else printf("%c", ((s[i] - 3) ));
		printf("%c", ((s[i] - 'A' - 3 + 26) % 26)+'A');
	}

	return 0;
}