#ifndef ENTITY_H
#define ENTITY_H

#include "Point.h"

class Entity {
private:
  Point position;
  string name;
  char tag;

public:
  Entity (string name, Point position);

  Point getPosition();
  string getName();

  void setPosition(Point position);
  void setName(string name);

  void setTag(char tag);
  char getTag();

  string toString();
};

#endif // ENTITY_H
