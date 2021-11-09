#ifndef BOARD_H
#define BOARD_H
#include "Point.h"
#include "Entity.h"

class Board {
private:
  int size;
  int **M;

public:
  Board (int size);

  void setSize(int size);
  int getSize();

  int** getBoard();

  void show ();
  void fill ();

  void place (Entity old, Point n);
  void spawn (Entity e);
};

#endif // BOARD_H
