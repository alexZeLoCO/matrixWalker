#ifndef BOARD_H
#define BOARD_H
#include "Point.h"
#include "Entity.h"
#include "Node.h"
#include "Pathfinder.h"

class Board {
private:
  int size;
  Node **M;

public:
  Board (int size);
  Board (int size, Node **B);

  void setSize(int size);
  int getSize();

  Node** getBoard();

  void show ();
  void fill ();

  void move (Pathfinder *p, int dir);
  void spawn (Entity e);

  Point spawnNearby(Point p);
  Point spawnInBorder (Point p);
};

#endif // BOARD_H
