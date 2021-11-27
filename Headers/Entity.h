#ifndef ENTITY_H
#define ENTITY_H

#include "Point.h"
#include "Tag.h"

class Entity {
private:
  Point position;
  string name;
  Tag tag;

public:
  Entity (string name, Point position);

  Point getPosition();
  string getName();

  void setPosition(Point position);
  void setName(string name);

  void setTag(char tag);
  char getTag();

  void setX (int x);
  void setY (int y);
  int getX();
  int getY();

  string toString();
};

#endif // ENTITY_H
