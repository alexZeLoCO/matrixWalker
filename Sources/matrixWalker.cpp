#include <iostream>
//#include "../Utility/testing.h"
#include "Point.cpp"
#include "Entity.cpp"
#include "Board.cpp"
#include <string>

#define SIZE 10

using namespace std;

int main () {

  Board board (SIZE);

  Point p (2,2);
  Entity user ("User", p);
  cout << user.toString();

  Entity target ("Target", p);
  cout << target.toString();

  board.spawn(user);
  board.spawn(target);

  board.show();

  return 1;
}
