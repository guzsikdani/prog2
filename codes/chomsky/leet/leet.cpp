#include <iostream>
#include <string>

using namespace std;

int main()
{
	string bemenet;
	cin >>bemenet;

	cout<<bemenet;

	return 0;
}

 void leeter(string bemenet)
 {
 	count vector<char> charvect(bemenet.begin(), kimenet.end());
	vector<string> temp;
	cout << " ";
	vector<char> angol;
	angol{’ ’,’a’,’b’,’c’,’d’,’e’,’f’,’g’,’h’,’j’,’k’,’l’,’m’,’n’,’o’,’p’,’q’,’r’,’s’,’t’,’u’ ←-
	,’v’,’w’,’z’,’0’,’1’,’2’,’3’,’4’,’5’,’6’,’7’,’8’,’9’};
	vector<string> leet;
	leet={" ","4","8","(","|)","3","|=","6","|-|","1","_/","|<","|_","|v|","/v","0","|o","O_" ←-
	,"|2","5","-|-","|/","VV","><","’/","2","O","I","Z","E","A","S","G","T","X","J"};
	 for(int i = 0; i < bemenet.size(); i++) {
	for(int z = 0; z < 35; z++) {
	if (angol[z] == bemenet[i]) {
	temp.push_back(leet[z]);
  }
 }
}

 for(int i =0; i<bemenet.size();i++)
 {
 	cout<<temp[i];
 }

 bemenet.clear();
 temp.clear();