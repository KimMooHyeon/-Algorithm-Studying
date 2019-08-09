#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;



int main() {

	//	freopen("input.txt", "rt", stdin);
	int N;
	scanf("%d", &N);
	vector <int> a(N + 1);
	int temp;
	for (int i = 2; i <= N; i++) {
		int j = 2;
		temp = i;
		while (1) {

			if (temp%j == 0) {
				a[j]++;

				if (temp == j) break;

				temp = temp / j;
			}
			else {
				j++;
			}
		}

	}
	printf("%d! = ", N);
	for (int i = 0; i <= N; i++) {
		if (a[i] != 0) printf("%d ", a[i]);
	}

	return 0;
}

