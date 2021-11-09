#include <iostream>

Board :: Board (int size) {
  setSize(size);
  M = new int * [size];
  for (int i = 0; i < size; i++) {
    M[i] = new int [size];
  }
}

void Board :: setSize (int size) {
  this-> size = size;
}

int Board :: getSize () {
  return this-> size;
}

void Board :: fill () {

}
