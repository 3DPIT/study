#include <iostream>
#include <sstream>
#include <vector>
using namespace std;
int main(void)
{
	vector<string> record = {{"abc ¿¡ÀÌºñ¾¾ aºñc"},{"aºñc ¿¡ÀÌºñ¾¾ abc"}};
	string key[3];

	for (auto& rec : record) {
		istringstream iss(rec);
		iss >> key[0] >> key[1] >> key[2] ;
		cout << key[0] << key[1] << endl;
	}
	return 0;
}