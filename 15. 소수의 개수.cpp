#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;


bool isPrime(int x) {
	int cnt = 0;
	if (x == 1) return false;
	for (int i = 1; i*i <= x; i++) {
		if (i*i == x) cnt++;
		else if (x%i == 0) cnt += 2;
	}
	if (cnt == 2) return true;
	else return false;
}
int main() {

	int number;
	int cnt = 0;
	scanf("%d", &number);

	for (int i = 2; i <= number; i++) {
		if (isPrime(i)) cnt++;
	}
	printf("%d", cnt);
	return 0;
}

