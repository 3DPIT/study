//#include <iostream>
//#include <string>
//#include <vector>
//
//using namespace std;
//
//
//int main()
//{
//	int maxLength = 0;
//	char a[5][15] = { 0, };
//	cin.ignore();
//	for (int i = 0; i < 5; i++)
//	{
//		cin.getline(a[i], 15);
//	}
//
//	
//
//	cout << endl;
//	for (int i = 0; i < 15; i++)
//	{
//		for (int j = 0; j < 5; j++)
//		{
//			if (a[j][i] == ' ')
//				continue;
//			cout << a[j][i];
//		}
//	}
//}

#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <string.h>
#include <algorithm>
#include <vector>

using namespace std;


int main()
{
	char board[5][16] = { 0, };
	int size = 0;
	for (int i = 0; i < 5; i++) {
		scanf("%s", board[i]);
		size = max(size, (int)strlen(board[i]));
	}


	for (int j = 0; j < size; j++) {
		for (int i = 0; i < 5; i ++) {
			
			if (board[i][j] != '\0')
				printf("%1c", board[i][j]);			
		}
	}
}
