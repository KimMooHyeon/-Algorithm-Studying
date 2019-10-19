#include<stdio.h>
#include<algorithm>
#include<queue>
#include<iostream>
#include<vector>
using namespace std;
int N, M; 
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
int minChicken = 0;
int solution = 10000;
int map[51][51];
vector <pair<int, int>> home;
vector <pair<int, int>> chicken;
vector <pair<int, int>> PickChicken;

void search() {
	minChicken = 0;
	for (int i = 0; i < home.size(); i++) {
		int min = 100000;
		for (int j = 0; j < PickChicken.size(); j++) {
		int cnt=abs(home[i].first - PickChicken[j].first) + abs(home[i].second - PickChicken[j].second);
		if (min > cnt) min = cnt;

		}
		minChicken += min;
	}

}

void dfs(int level) {
	if (PickChicken.size() == M) {
		//치킨집 다뽑음
		//TODO
		search();
		if (minChicken < solution) solution = minChicken;
		return ;
	}
	for (int i = level; i < chicken.size(); i++) {
		PickChicken.push_back({ chicken[i].first,chicken[i].second });
		dfs(i + 1);
		PickChicken.pop_back();
	}

}


int main() {

	cin >> N >> M;
	for (int y = 0; y < N; y++) {
		for (int x = 0; x < N; x++) {
			cin >> map[y][x];
			if (map[y][x] == 2) { //치킨집
				chicken.push_back({ y, x });
			}
			if (map[y][x] == 1) { //집 
				home.push_back({ y,x });
			}
		}
	}
	dfs(0);
	cout << solution << endl;
	return 0;
}