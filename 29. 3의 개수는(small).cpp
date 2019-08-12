#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;
using namespace std;

char b[10];
int main() {

	//	freopen("input.txt", "rt", stdin);
	int N;
	int cnt = 0;
	scanf("%d", &N);
	for (int i = 3; i <= N; i++) {
		sprintf(b, "%d", i);
		for (int j = 0; b[j] != '\0'; j++)
			if (b[j] == '3') cnt++;
	}

	printf("%d", cnt);

	return 0;
}
