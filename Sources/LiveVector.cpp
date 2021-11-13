#include "../Headers/LiveVector.h"
#include "../Headers/Entity.h"
#include <string>
#include <sstream>

using namespace std;

LiveVector :: LiveVector () {
  Entity E [0];
  setEntities(0, E);
}

LiveVector :: LiveVector (int size, Entity *entities) {
  setEntities (size, entities);
}

Entity* LiveVector :: getEntities () {
  return this->V;
}

Entity LiveVector :: getEntity (int idx) {
    return this->getEntities()[idx];
}

int LiveVector :: getSize() {
  return this->size;
}

void LiveVector :: setEntities (int size, Entity* entities) {
  this->setSize(size);
  for (int i = 0; i < size ; i++) {
    this->V[i] = entities[i];
  }
}

void LiveVector :: setSize (int size) {
  this->size = size;
}

//REALLY NOT SURE
void LiveVector :: add (Entity e) {
    this->setSize(this->getSize()+1);
    Entity es [this->getSize()];
    for (int i = 0; i < this->getSize()-1 ; i++) {
      es[i] = this->getEntity(i);
    }
    es[this->getSize()] = e;
    this->V=es;
}

string LiveVector :: toString () {
  ostringstream buffer;
  buffer << "Entities:\n";
  for (int i = 0; i<this->getSize() ; i++) {
    buffer << this->getEntity(i).toString();
  }
  buffer << endl;
  return buffer.str();
}
