#include "../Headers/Entity.h"
#include "../Headers/Tag.h"
#include <iostream>
#include <string>
#include <sstream>

using namespace std;

Entity :: Entity (string name, Point position) {
  setName(name);
  setPosition(position);
  setTag(name[0]);
}

void Entity :: setName (string name) {
  this->name = name;
}

void Entity :: setPosition (Point position) {
  this->position.setX(position.getX());
  this->position.setY(position.getY());
}

void Entity :: setTag (char c) {
  this->tag.setTag(c);
}

string Entity :: getName () {
  return this-> name;
}

Point Entity :: getPosition () {
  return this-> position;
}

char Entity :: getTag () {
  return this->tag.getTag();
}

string Entity :: toString () {
  ostringstream buffer;
  buffer <<
  "Entity:\n" <<
  "\tName: " << getName() << " (" << getTag() << ")\n" <<
  "\tPosition: " << getPosition().toString() << "\n";

  return buffer.str();
}
