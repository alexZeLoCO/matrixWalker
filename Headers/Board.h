#ifndef BOARD_H
#define BOARD_H
#include "Point.h"
#include "Entity.h"
#include "Tag.h"

class Board {
private:
  int size;
  Tag **M;

public:
  Board (int size);

  void setSize(int size);
  int getSize();

  Tag** getBoard();

  void show ();
  void fill ();

  void move (Entity old, Point n);
  void spawn (Entity e);

  bool invalidPosition (Point p);
  bool isOutOfBounds (Point p);
  Point spawnNearby(Point p);
  Point spawnInBorder (Point p);
};

#endif // BOARD_H
