#include "../Utility/Point.h"
#include <iostream>
#include <string>
#include <sstream>

using namespace std;

Point :: Point (int x, int y) {
  setX(x);
  setY(y);
}

Point :: Point () {
  setX(0);
  setY(0);
}

void Point :: setX (int x) {
  this->x=x;
}

void Point :: setY (int y) {
  this->y=y;
}

int Point :: getX () {
  return this->x;
}

int Point :: getY () {
  return this->y;
}

string Point :: toString () {

  ostringstream buffer;
  buffer << "(" << getX() << ", " << getY() << ")\n";

  return buffer.str();

}
