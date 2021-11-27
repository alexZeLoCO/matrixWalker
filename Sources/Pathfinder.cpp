#include "../Headers/Pathfinder.h"
#include <string>

using namespace std;

Pathfinder :: Pathfinder (string name, Point position) : Entity (name, position) {

}

void Pathfinder :: north () {
  setX(getX()-1);
}

void Pathfinder :: south () {
  setX(getX()+1);
}

void Pathfinder :: east () {
  setY(getY()+1);
}

void Pathfinder :: west () {
  setY(getY()-1);
}
