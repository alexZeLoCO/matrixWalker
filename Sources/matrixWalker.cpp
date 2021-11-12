#include <iostream>
//#include "../Utility/testing.h"
#include "Point.cpp"
#include "Entity.cpp"
#include "Board.cpp"
#include "Tag.cpp"
#include <string>

#define SIZE 10

using namespace std;

int main () {

  Board board (SIZE);

  Point p (2,12);
  Entity user ("User", p);
  cout << user.toString();

  Point pp (2,9);
  Entity target ("Target", pp);
  cout << target.toString();

  board.spawn(user);
  board.spawn(target);

  board.show();
}
