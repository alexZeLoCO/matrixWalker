#include "../Headers/Node.h"

Node :: Node () {
  setNode(0);
}

Node :: Node (char c) {
  setNode(c);
}

char Node :: getNode () {
  return this->Node;
}

void Node :: setNode (char c) {
  this->Node = c;
}
