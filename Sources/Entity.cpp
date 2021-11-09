#include "../Utility/Entity.h"
#include <iostream>
#include <string>

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
  this->position = position;
}

void Entity :: setTag (char tag) {
  this-> tag = tag;
}

string Entity :: getName () {
  return this-> name;
}

Point Entity :: getPosition () {
  return this-> position;
}

char Entity :: getTag () {
  return this-> tag;
}