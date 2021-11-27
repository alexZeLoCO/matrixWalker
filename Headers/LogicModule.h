#include "Board.h"
#include "Point.h"

bool isOutOfBounds (Point p, Board b) {
    return b.getSize() < p.getX() || b.getSize() < p.getY() || p.getX() < 0 || p.getY() < 0;
}

bool validPosition (Point p, Board b) {

  if(isOutOfBounds(p, b)) return false;
  if (b.getBoard()[p.getX()][p.getY()].getTag() != '0') return false;

  return true;
  //return  ((p.getX() > getSize()) || (p.getY() > getSize()) || (getBoard()[p.getX()][p.getY()] != '0'));
}

bool validPosition (int x, int y, Board b) {
  Point p (x, y);
  return validPosition(p, b);
}
