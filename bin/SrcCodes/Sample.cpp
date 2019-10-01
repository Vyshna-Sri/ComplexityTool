
#include<stdio.h>
#include <iostream>
using namespace std;

int main(){
 /* This is a comment */
  int number;
  int min,max;
  long sum =0;
 
  cout << "Enter the minimum range: ";
  cin >> min;
 
  cout << "Enter the maximum range: ";
  cin >> max;
 
  for(number = min;number <= max; number++)
    if(number % 2 !=0)
      sum = sum + number;
 
  cout << "Sum of odd numbers in given range is: " << sum;
 
  return 0;
 
}
