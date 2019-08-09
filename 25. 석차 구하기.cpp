#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;


int main() {

	//	freopen("input.txt", "rt", stdin);
	int N;
	int num = 0;
	scanf("%d", &N);
	vector<int> a(N);
	vector<int> b(N);
	for (int i = 0; i<N; i++) {
		scanf("%d", &a[i]);
		b[i]++;
	}
	for (int i = 0; i<N; i++) {
		for (int j = 0; j<N; j++) {
			if (a[i]>a[j]) b[j]++;
		}
	}
	for (int i = 0; i<N; i++) {
		printf("%d ", b[i]);
	}
	return 0;
}

