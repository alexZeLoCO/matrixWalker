#include "../Headers/Pathfinder.h"
//#include "LogicModule.h"
#include <string>

using namespace std;

Pathfinder :: Pathfinder (string name, Point position) : Entity (name, position) {

}

void Pathfinder :: north () {
  getPosition().setX(getPosition().getX()+1);
}

void Pathfinder :: south () {
  getPosition().setX(getPosition().getX()-1);
}

void Pathfinder :: east () {
  getPosition().setY(getPosition().getY()+1);
}

void Pathfinder :: west () {
  getPosition().setY(getPosition().getY()-1);
}
