#include <iostream>
#include "Point.cpp"
#include "Entity.cpp"
#include "Board.cpp"
#include "Node.cpp"
#include "Pathfinder.cpp"
#include <string>
#include <list>

#define SIZE 4

using namespace std;

int main()
{

  list<int> l1 = {1, 2, 3};

  Node **M = new Node *[SIZE];
  for (int i = 0; i < SIZE; i++)
  {
    M[i] = new Node[SIZE];
  }
  /*
  Node V [SIZE*SIZE] = {'0','1','0','0','0','0','0','0','0','0',
                       '0','1','0','0','0','0','0','0','0','0',
                       '0','0','1','0','0','0','0','0','1','1',
                       '0','0','1','0','0','0','0','0','0','0',
                       '0','0','1','1','1','0','1','0','0','0',
                       '0','0','0','0','1','0','1','0','0','0',
                       '0','1','1','0','1','0','1','0','0','0',
                       '0','0','1','0','1','1','1','0','1','0',
                       '0','0','1','0','0','0','0','0','1','0',
                       '0','0','1','0','0','0','0','0','1','0'};
*/

  Node V[SIZE * SIZE] = {'0', '0', '0', '0',
                         '0', '1', '1', '0',
                         '0', '0', '1', '0',
                         '0', '0', '0', '0'};

  int idx = 0;
  for (int i = 0; i < SIZE; i++)
  {
    for (int j = 0; j < SIZE; j++)
    {
      M[i][j] = V[idx++];
    }
  }

  Board board(SIZE, M);

  Pathfinder user("User", *(new Point(SIZE - 1, 0)));
  Entity target("Target", *(new Point(0, SIZE - 1)));

  board.spawn(user);
  board.spawn(target);
  Node
          cout
      << user.toString();
  cout << target.toString();

  board.show();
}
