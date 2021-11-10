#ifndef BOARD_H
#define BOARD_H
#include "Point.h"
#include "Entity.h"

class Board {
private:
  int size;
  char **M;

public:
  Board (int size);

  void setSize(int size);
  int getSize();

  char** getBoard();

  void show ();
  void fill ();

  void place (Entity old, Point n);
  void spawn (Entity e);

  bool invalidPosition (Point&& p);
  Point spawnNearby(Point&& p);
};

#endif // BOARD_H
