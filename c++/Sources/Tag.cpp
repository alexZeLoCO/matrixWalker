#include "../Headers/Tag.h"

Tag :: Tag () {
  setTag(0);
}

Tag :: Tag (char c) {
  setTag(c);
}

char Tag :: getTag () {
  return this->tag;
}

void Tag :: setTag (char c) {
  this->tag = c;
}
