#include<stdio.h>
#include<algorithm>
#include<queue>
#include<iostream>
#include<vector>
using namespace std;
vector <int> a[1010];
int dfsCh[1001];
int bfsCh[1001];
int N, M, V;

void dfs(int start) {
	 if (dfsCh[start] == 0) {
	
		dfsCh[start] = 1;
		cout << start << " ";
		for (int i = 0; i < a[start].size(); i++) {
			sort(a[start].begin(), a[start].end());
			if (dfsCh[a[start][i]] != 1) {
					dfs(a[start][i]);
			}
		
		}

	}
}
void bfs(int start) {
	queue<int> Q;
	Q.push(start);

	while (!Q.empty())
	{
		int temp;
		temp = Q.front();
		Q.pop();
		

		if (bfsCh[temp] == 0) {
			cout << temp << " ";
			bfsCh[temp] = 1;
			//cout << "bfsCh[temp] = " << bfsCh[temp] << endl;;
			sort(a[temp].begin(), a[temp].end());
			for (int i = 0; i < a[temp].size(); i++) {
				if (bfsCh[a[temp][i]] == 0)
				{
					Q.push(a[temp][i]);
				//	cout << "	Q.push(a[temp][i])" << " " << a[temp][i] << endl;
				}
			
			}
		}
	}

}
int main() {
	
	int b, c;
	cin >> N >> M >> V;

	for (int i = 0; i < M; i++) {
		cin >> b >> c;
		a[b].push_back(c);
		a[c].push_back(b);
	}
	dfs(V);
	cout << endl;
	bfs(V);
	return 0;
}