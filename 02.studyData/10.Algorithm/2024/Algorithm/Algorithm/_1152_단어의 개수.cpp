#include <iostream>
#include <cstring>
#include <vector>

using namespace std;
char str[1000004];

int main()
{

	scanf("%[^\n]s", str);

	int length = strlen(str);
	int count = 0;
	bool flag = false;

	for (int i = 0; i < length; i++)
	{
		if (str[i] != ' ') {
			if (!flag) {
				count++;
				flag = true;
			}
		}
		else {
			flag = false;
		}
	}


	printf("%d\n", count);
	return 0;
}
