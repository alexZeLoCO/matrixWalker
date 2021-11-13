#ifndef LIVEVECTOR_H
#define LIVEVECTOR_H

#include "Entity.h"

class LiveVector {
private:
  int size;
  Entity *V;

public:
  LiveVector ();
  LiveVector (int size, Entity *entities);

  Entity * getEntities();
  Entity getEntity (int idx);
  
  int getSize();
  void setEntities (int size, Entity* entities);
  void setSize(int size);

  void add (Entity e);

  string toString();

};

#endif // LIVEVECTOR_H
