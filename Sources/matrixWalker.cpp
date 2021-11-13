#include <iostream>
#include "Point.cpp"
#include "Entity.cpp"
#include "Board.cpp"
#include "Tag.cpp"
#include <string>

#define SIZE 10

using namespace std;

int main () {

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

  Board board (SIZE, M);

  Entity user ("User", SIZE);
  Entity target ("Target", SIZE);

  board.spawn(user);
  board.spawn(target);

  cout << user.toString();
  cout << target.toString();

  board.show();

}
