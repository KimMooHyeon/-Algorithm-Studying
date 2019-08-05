#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
using namespace std;

int main() {

	//	freopen("input.txt", "rt", stdin);
	int n, k, i, sum = 0, max;
	scanf("%d %d", &n, &k);
	vector<int> a(n);

	for (int i = 0; i<n; i++) {
		scanf("%d", &a[i]);
	}
	for (i = 0; i<k; i++) {
		sum += a[i];
	}
	max = sum;
	for (i = k; i<n; i++) {
		sum = sum + (a[i] - a[i - k]);
		if (sum>max) max = sum;
	}
	printf("%d", max);
	return 0;
}
