#include<iostream>
#include<vector>
using namespace std;
int num;
int Array[100];

int Check[100];
vector<int> Sol;
void dfs(vector<int> V) {
	if (V.size() == 3) {
		for (int i = 0; i < num; i++) {
			cout << V[i] << " ";
		}
		cout << endl;
		return ;
	}
	for (int i = 0; i < num; i++) {
		if (Check[i] == 0) {
			V.push_back(Array[i]);
			Check[i] = 1;
			dfs(V);
			Check[i] = 0;
			V.pop_back();
		}
	}

}

int main() {
	cin >> num;
	for (int i = 0; i < num; i++) {
		cin >> Array[i];
	}
	dfs(Sol);


}