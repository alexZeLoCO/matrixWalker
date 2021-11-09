#include <iostream>
#include "../Utility/testing.h"
#include "Point.cpp"
#include "Entity.cpp"
#include <string>

#define SIZE 10

using namespace std;

int main () {

  int **M;
  M = new int * [SIZE];
  for (int i = 0; i < SIZE; i++) {
    M[i] = new int [SIZE];
  }

  fill(M, SIZE, 0);

  Point p (2,2);
  Entity user ("User", p);
  //printf("Entity %s, in (%d, %d)\n", user.getName(), user.getPosition().getX(), user.getPosition().getY());
  cout << "Entity " << user.getName() << " (" << user.getTag() << ") , in (" << user.getPosition().getX() << ", " << user.getPosition().getY() << ")" << endl;
  show(M, SIZE);
  
  return 1;
}
