#include "../Utility/Board.h"
#include <iostream>

Board :: Board (int size) {
  setSize(size);
  M = new char * [size];
  for (int i = 0; i < size; i++) {
    M[i] = new char [size];
  }
  fill();
}

void Board :: setSize (int size) {
  this-> size = size;
}

int Board :: getSize () {
  return this-> size;
}

char** Board :: getBoard()  {
  return this-> M;
}

void Board :: fill () {
  for (int i = 0; i < getSize(); i++) {
    for (int j = 0; j < getSize(); j++) {
      getBoard()[i][j] = '0';
    }
  }
}

void Board :: show () {
  for (int i = 0; i < getSize(); i++) {
    for (int j = 0; j < getSize(); j++) {
      printf("%c ", getBoard()[i][j]);
    }
    printf("\n");
  }
  printf("\n");
}

void Board :: spawn (Entity e) {
  getBoard()[e.getPosition().getX()][e.getPosition().getY()] = e.getTag();
}
