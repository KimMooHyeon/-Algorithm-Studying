#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
using namespace std;

int absulute(int a, int b) {
	if (a - b >= 0) return a - b;
	else return b - a;
}

int main() {

	//freopen("input.txt", "rt", stdin);
	int N;
	scanf("%d", &N);
	vector<int> a(N);
	vector<int> b(N - 1);

	for (int i = 0; i<N; i++) {
		scanf("%d", &a[i]);
	}
	for (int i = 0; i<N; i++) {
		//	printf("a[%d]=%d\n",i,a[i]);

	}
	for (int i = 1; i<N; i++) {
		//	printf("absulte = %d \n",absulute(a[i],a[i-1])) ; 
		if (1 <= absulute(a[i], a[i - 1]) && absulute(a[i], a[i - 1]) <= 100) {
			//	printf("IN absulte = %d \n",absulute(a[i],a[i-1])) ; 
			b[absulute(a[i], a[i - 1])]++;
		}
	}
	b[0] = 1;
	for (int i = 0; i<N - 1; i++) {
		if (b[i] == 0) {
			printf("NO");
			return 0;
		}

	}
	printf("YES");

	return 0;
}

