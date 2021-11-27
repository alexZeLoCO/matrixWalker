#include "../Headers/Entity.h"
#include "../Headers/Node.h"

#include <iostream>
#include <string>
#include <sstream>

using namespace std;

Entity :: Entity (string name, Point position) {
  setName(name);
  setPosition(position);
  setNode(name[0]);
}

void Entity :: setName (string name) {
  this->name = name;
}

void Entity :: setPosition (Point position) {
  this->position.setX(position.getX());
  this->position.setY(position.getY());
}

void Entity :: setNode (char c) {
  this->Node.setNode(c);
}

string Entity :: getName () {
  return this-> name;
}

Point Entity :: getPosition () {
  return this-> position;
}

char Entity :: getNode () {
  return this->Node.getNode();
}

void Entity :: setX (int x) {
  this->position.setX(x);
}

void Entity :: setY (int y) {
  this->position.setY(y);
}

int Entity :: getY () {
  return this->position.getY();
}

int Entity :: getX () {
  return this->position.getX();
}

string Entity :: toString () {
  ostringstream buffer;
  buffer <<
  "Entity:\n" <<
  "\tName: " << getName() << " (" << getNode() << ")\n" <<
  "\tPosition: " << getPosition().toString() << "\n";

  return buffer.str();
}
