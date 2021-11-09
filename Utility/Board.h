#ifndef BOARD_H
#define BOARD_H
#include "Point.h"
#include "Entity.h"

class Board {
private:
  int size;
  int M[][];

public:
  Board (int size);

  void show ();
  void place (Entity old, Point new);
};

#endif // BOARD_H
