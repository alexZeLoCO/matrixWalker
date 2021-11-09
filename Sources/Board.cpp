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

bool Board :: invalidPosition (Point p) {
  return  ((p.getX() >= getSize()) || (p.getY() >= getSize()) || (getBoard()[p.getX()][p.getY()] != '0'));
}

Point Board :: spawnNearby(Point p) {
  bool invalid = true;   //Sentinel

  Point test (p); //To be tested
  Point output;  //To be pasted when found a solution

  for (int i=1; i<getSize() && invalid ; i++) {
    //Checking above
    test.setY(p.getY() + i);
    if (!invalidPosition(test)) {
      invalid = false;
      output.setPosition(test);
    }

    //Checking below
    test.setY(p.getY() - i);
    if (!invalidPosition(test)) {
      invalid = false;
      output.setPosition(test);
    }

    test.setY(p.getY());  //Resetting Y
    //Checking left
    test.setX(p.getX() - i);
    if (!invalidPosition(test)) {
      invalid = false;
      output.setPosition(test);
    }

    //Checking right
    test.setX(p.getX() + i);
    if (!invalidPosition(test)) {
      invalid = true;
      output.setPosition(test);
    }

    //Checking top left
    test.setX(p.getX() - i);
    test.setY(p.getY() + i);
    if (!invalidPosition(test)) {
      invalid = true;
      output.setPosition(test);
    }

    //Checking top right
    test.setX(p.getX() + i);
    if (!invalidPosition(test)) {
      invalid = true;
      output.setPosition(test);
    }

    //Checking bottom rigth
    test.setY(p.getY() - i);
    if (!invalidPosition(test)) {
      invalid = true;
      output.setPosition(test);
    }

    //Checking bottom left
    test.setX(p.getX() - i);
    if (!invalidPosition(test)) {
      invalid = true;
      output.setPosition(test);
    }
  }
  return output;
}

void Board :: spawn (Entity e) {
  if (invalidPosition(e.getPosition())) {
        //Invalid spawn position. Check adyacent spots.
        Point spawn = spawnNearby(e.getPosition());
        if (!invalidPosition(spawn)) {
          getBoard()[spawn.getX()][spawn.getY()] = e.getTag();
        }
  } else {
        getBoard()[e.getPosition().getX()][e.getPosition().getY()] = e.getTag();
  }
}
