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
  Entity ();
  Entity (string name, Point position);

  Point getPosition();
  string getName();

  void setPosition(Point position);
  void setPosition();
  void setName(string name);


  void setTag(char tag);
  char getTag();

  string toString();
};

#endif // ENTITY_H
