#include "Board.h"
#include "Point.h"

bool invalidPosition (Point p, Board b) {

  if(isOutOfBounds(p, b)) return true;
  if (b.getBoard()[p.getX()][p.getY()].getTag() != '0') return true;

  return false;
  //return  ((p.getX() > getSize()) || (p.getY() > getSize()) || (getBoard()[p.getX()][p.getY()] != '0'));
}

bool invalidPosition (int x, int y, Board b) {
  Point p (x, y);
  return invalidPosition(p, b);
}

bool isOutOfBounds (Point p, Board b) {
    return b.getSize() < p.getX() || b.getSize() < p.getY() || p.getX() < 0 || p.getY() < 0;
}
