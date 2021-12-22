#ifndef PATHFINDER_H
#define PATHFINDER_H
#include "Entity.h"
#include <string>

using namespace std;

class Pathfinder : public Entity
{
private:
public:
  Pathfinder(string name, Point position);

  void north();
  void south();
  void east();
  void west();
  void northWest();
  void northEast();
  void southWest();
  void southEast();
};

#endif // PATHFINDER_H
