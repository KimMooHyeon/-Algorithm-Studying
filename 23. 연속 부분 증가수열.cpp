#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
using namespace std;

int main() {

	//freopen("input.txt", "rt", stdin);
	int N;
	int max = 0;
	int num = 1;
	scanf("%d", &N);
	vector<int> a(N);

	for (int i = 0; i<N; i++) {
		scanf("%d", &a[i]);
	}

	for (int i = 1; i<N; i++) {
		if (a[i - 1] <= a[i]) {
			//	printf("%d,%d\n",a[i],i);
			num++;
		}
		else {
			if (max<num) max = num;
			num = 1;
		}
	}

	printf("%d", max);
	return 0;
}

