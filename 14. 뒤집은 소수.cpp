#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

float pow(int a, int b) {
	float sum = 1.0;
	if (0 <= b) {
		for (int i = 0; i<b; i++) {
			sum = sum * a;
		}
	}
	else if (b<0) {
		for (int i = 0; b<i; i--) {
			sum = sum / a;
		}
	}
	return sum;
}
int reverse(int x) {
	int sum = 0;
	int num = 1;
	int temp = x;
	if (x<10) num = 1;
	else {
		while (1) {
			temp = temp / 10;
			num++;
			if (temp<10) break;
		}
	}
	temp = x;
	int a = num - 1;
	int c = num - 1;
	int d = num - 1;
	int b = 0;
	for (num; 0<num; num--) {

		sum += (x / (int)pow(10, a--))*(int)pow(10, b++);
		x = x - (x / (int)pow(10, d--))*(int)pow(10, c--);
	}
	return sum;
}

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

	int size;
	int number;
	//	freopen("input.txt", "rt", stdin);
	scanf("%d", &size);


	for (int i = 0; i<size; i++) {
		scanf("%d", &number);
		if (isPrime(reverse(number))) printf("%d ", reverse(number));
	}

	return 0;
}

