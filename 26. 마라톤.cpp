#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;



int main() {

	//freopen("input.txt", "rt", stdin);
	int N;
	int cnt = 0;
	scanf("%d", &N);
	vector<int> a(N);
	vector<int> b(N);
	for (int i = 0; i<N; i++) {
		scanf("%d", &a[i]);
		b[i]++;
	}
	for (int i = 0; i<N; i++) {
		cnt = i + 1;
		for (int j = 0; j<i; j++) {
			if (a[i]>a[j]) {
				cnt--;
			}
			else {

			}
		}
		b[i] = cnt;
	}
	for (int i = 0; i<N; i++) {
		printf("%d ", b[i]);
	}
	return 0;
}

