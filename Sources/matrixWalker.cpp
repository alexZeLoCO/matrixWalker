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

  //cout << "Entity " << user.getName() << " (" << user.getTag() << ") , in (" << user.getPosition().getX() << ", " << user.getPosition().getY() << ")" << endl;
  cout << user.toString();
  p.setX(6);
  p.setY(7);
  Entity target ("Target", p);
  //cout << "Entity " << target.getName() << " (" << target.getTag() << ") , in (" << target.getPosition().getX() << ", " << target.getPosition().getY() << ")" << endl;
  cout << target.toString();
  board.show();

  board.spawn(user);
  board.spawn(target);
  board.show();

  return 1;
}
