#include "../Headers/Board.h"
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

bool Board :: invalidPosition (Point&& p) {

  if(getSize() > p.getX() || getSize() > p.getY()) return false;
  if (getBoard()[p.getX()][p.getY()] != '0') return false;
  
  return true;
  //return  ((p.getX() > getSize()) || (p.getY() > getSize()) || (getBoard()[p.getX()][p.getY()] != '0'));
}

Point Board :: spawnNearby(Point&& p) {
  bool invalid = true;   //Sentinel

  Point test (p); //To be tested
/*
https://www.fluentcpp.com/2018/02/06/understanding-lvalues-rvalues-and-their-references/#:~:text=In%20C%2B%2B%2C%20every%20expression%20is%20either%20an%20lvalue,object%20names%20and%20are%20lvalues%29%2C%20but%20not%20only.
*/
  Point output;  //To be pasted when found a solution

  for (int i=1; i<getSize() && invalid ; i++) {
    //Checking above
    test.setY(p.getY() + i);
    if (!invalidPosition(std::move(test))) {
      invalid = false;
      output.setPosition(test);
    }

    //Checking below
    test.setY(p.getY() - i);
    if (!invalidPosition(std::move(test))) {
      invalid = false;
      output.setPosition(test);
    }

    test.setY(p.getY());  //Resetting Y
    //Checking left
    test.setX(p.getX() - i);
    if (!invalidPosition(std::move(test))) {
      invalid = false;
      output.setPosition(test);
    }

    //Checking right
    test.setX(p.getX() + i);
    if (!invalidPosition(std::move(test))) {
      invalid = true;
      output.setPosition(test);
    }

    //Checking top left
    test.setX(p.getX() - i);
    test.setY(p.getY() + i);
    if (!invalidPosition(std::move(test))) {
      invalid = true;
      output.setPosition(test);
    }

    //Checking top right
    test.setX(p.getX() + i);
    if (!invalidPosition(std::move(test))) {
      invalid = true;
      output.setPosition(test);
    }

    //Checking bottom rigth
    test.setY(p.getY() - i);
    if (!invalidPosition(std::move(test))) {
      invalid = true;
      output.setPosition(test);
    }

    //Checking bottom left
    test.setX(p.getX() - i);
    if (!invalidPosition(std::move(test))) {
      invalid = true;
      output.setPosition(test);
    }
  }
  return output;
}

void Board :: spawn (Entity e) {
  if (invalidPosition(std::move(e.getPosition()))) {
        //Invalid spawn position. Check adyacent spots.
        Point spawn (std::move(spawnNearby(e.getPosition())));
        if (!invalidPosition(std::move(spawn))) {
          getBoard()[spawn.getX()][spawn.getY()] = e.getTag();
        }
  } else {
        getBoard()[e.getPosition().getX()][e.getPosition().getY()] = e.getTag();
  }
}
