#include<iostream>
#include<vector>
using namespace std;
int price[4];
int usingNumber[12];
int minPrice ;

vector<int> V;
vector<int> C;



void dfs(int month, int priceSum) {
	
	if (month>11) {
		if(minPrice > priceSum) minPrice = priceSum;
		return ;
	}
  	dfs(month+3, priceSum+price[2]);

	if (usingNumber[month] == 0) {
		dfs(month+1 , priceSum );
	}else if (price[1] < usingNumber[month] * price[0]) {
		dfs(month+1, priceSum + price[1]);	
	}
	else {
		dfs(month+1, priceSum + usingNumber[month] * price[0]);
	}

}
int main() {
	int T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		for (int j = 0; j < 4; j++) {
			cin >> price[j];
		}
		for (int k = 0; k < 12; k++) {
			cin >> usingNumber[k];
		}
		minPrice = price[3];
		dfs(0, 0);
		V.push_back(minPrice);
		//테스트케이스 끝
	}
	for (int i = 0; i < T; i++) {
		cout << "#" << i + 1 << " " << V[i]<<endl;
	}
}