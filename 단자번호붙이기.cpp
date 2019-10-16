#include<stdio.h>
#include<algorithm>
#include<queue>
#include<iostream>
#include<vector>
using namespace std;
int virusNumber = 0;
int computerCh[103];
vector <int> A[103];
void bfs(int start) {
	queue <int> Q;
	
	int temp;
	Q.push(start);
	while (!Q.empty())
	{
		temp = Q.front();
		Q.pop();
	
		if (computerCh[temp] == 0) {
			computerCh[temp] = 1;
			virusNumber++;
			for (int i = 0; i < A[temp].size(); i++) {
				if (computerCh[A[temp][i]] == 0) {
			
					Q.push(A[temp][i]);
				}
					
			}
		}

	}

}
int main() {
	int a, b;
	int computerNumber;
	int networkComputerNumber;

	cin >> computerNumber >> networkComputerNumber;
	for (int i = 0; i < networkComputerNumber; i++) {
		cin >> a >> b;
		A[a].push_back(b);
		A[b].push_back(a);
	}
	bfs(1);
	cout << virusNumber-1 << endl;
	return 0;
}