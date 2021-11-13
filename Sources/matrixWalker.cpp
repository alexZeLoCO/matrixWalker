#include <iostream>
#include "Point.cpp"
#include "Entity.cpp"
#include "Board.cpp"
#include "Tag.cpp"
#include "LiveVector.cpp"
#include <string>

#define SIZE 10

using namespace std;

int main () {
  LiveVector lv ();
  Entity user ("User", SIZE);
  lv.add(user);
  lv.toString();
/*
  Tag ** M = new Tag * [SIZE];
  for (int i = 0; i < SIZE; i++) {
    M[i] = new Tag [SIZE];
  }
  Tag V [SIZE*SIZE] = {'0','1','0','0','0','0','0','0','0','0',
                       '0','1','0','0','0','0','0','0','0','0',
                       '0','0','1','0','0','0','0','0','1','1',
                       '0','0','1','0','0','0','0','0','0','0',
                       '0','0','1','1','1','0','1','0','0','0',
                       '0','0','0','0','1','0','1','0','0','0',
                       '0','1','1','0','1','0','1','0','0','0',
                       '0','0','1','0','1','1','1','0','1','0',
                       '0','0','1','0','0','0','0','0','1','0',
                       '0','0','1','0','0','0','0','0','1','0'};
  int idx = 0;
  for (int i = 0; i < SIZE ; i++) {
    for (int j = 0; j < SIZE ; j++) {
      M[i][j] = V[idx++];
    }
  }

  Entity user ("User", SIZE);
  Entity target ("Target", SIZE);
  Entity Ve [2];
  Ve[0] = user;
  Ve[1] = target;

  Board board (SIZE, M, Ve, 2);
  //board.spawn(user);
  //board.spawn(target);

  //cout << user.toString();
  //cout << target.toString();

  board.show();
*/
}
