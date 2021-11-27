#ifndef ENTITY_H
#define ENTITY_H

#include "Point.h"
#include "Node.h"

class Entity {
private:
  Point position;
  string name;
  Node Node;

public:
  Entity (string name, Point position);

  Point getPosition();
  string getName();

  void setPosition(Point position);
  void setName(string name);

  void setNode(char Node);
  char getNode();

  void setX (int x);
  void setY (int y);
  int getX();
  int getY();

  string toString();
};

#endif // ENTITY_H
