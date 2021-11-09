#include <iostream>
#include "../Utility/testing.h"
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
  p.setX(6);
  p.setY(7);
  Entity target ("Target", p);
  cout << target.toString();

  p.setX(1);
  p.setY(1);
  Entity one ("1one", p);
  cout << one.toString();

  board.spawn(user);
  board.spawn(target);
  board.spawn(one);
  
  board.show();

  return 1;
}
