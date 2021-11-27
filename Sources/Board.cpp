#include "../Headers/Board.h"
#include "../Headers/Tag.h"
#include "../Headers/Pathfinder.h"
#include "../Headers/LogicModule.h"
#include <iostream>

Board :: Board (int size) {
  setSize(size);
  M = new Tag * [size];
  for (int i = 0; i < size; i++) {
    M[i] = new Tag [size];
  }
  fill();
}

Board :: Board (int size, Tag ** B) {
    setSize(size);
    M = new Tag * [size];
    for (int i = 0; i < size; i++) {
      M[i] = new Tag [size];
      for (int j = 0; j < size ; j++) {
        M[i][j] = B[i][j];
      }
    }

}

void Board :: setSize (int size) {
  this-> size = size;
}

int Board :: getSize () {
  return this-> size;
}

Tag** Board :: getBoard()  {
  return this-> M;
}

void Board :: fill () {
  for (int i = 0; i < getSize(); i++) {
    for (int j = 0; j < getSize(); j++) {
      getBoard()[i][j].setTag('0');
    }
  }
}

void Board :: show () {
  for (int i = 0; i < getSize(); i++) {
    for (int j = 0; j < getSize(); j++) {
      printf("%c ", getBoard()[i][j].getTag());
    }
    printf("\n");
  }
  printf("\n");
}

Point Board :: spawnNearby(Point p) {
  bool invalid = true;   //Sentinel

  Point test (p); //To be tested
/*
https://www.fluentcpp.com/2018/02/06/understanding-lvalues-rvalues-and-their-references/#:~:text=In%20C%2B%2B%2C%20every%20expression%20is%20either%20an%20lvalue,object%20names%20and%20are%20lvalues%29%2C%20but%20not%20only.
*/
  Point output;  //To be pasted when found a solution

  for (int i=1; i<getSize() && invalid ; i++) {
    //Checking right
    test.setY(p.getY() + i);
    if (validPosition(test, *this)) {
      invalid = false;
      output.setPosition(test);
      break;
    }

    //Checking left
    test.setY(p.getY() - i);
    if (validPosition(test, *this)) {
      invalid = false;
      output.setPosition(test);
      break;
    }

    test.setY(p.getY());  //Resetting Y
    //Checking below
    test.setX(p.getX() - i);
    if (validPosition(test, *this)) {
      invalid = false;
      output.setPosition(test);
      break;
    }

    //Checking above
    test.setX(p.getX() + i);
    if (validPosition(test, *this)) {
      invalid = true;
      output.setPosition(test);
      break;
    }

    //Checking bottom right
    test.setX(p.getX() - i);
    test.setY(p.getY() + i);
    if (validPosition(test, *this)) {
      invalid = true;
      output.setPosition(test);
      break;
    }

    //Checking top left
    test.setX(p.getX() + i);
    if (validPosition(test, *this)) {
      invalid = true;
      output.setPosition(test);
      break;
    }

    //Checking bottom left
    test.setY(p.getY() - i);
    if (validPosition(test, *this)) {
      invalid = true;
      output.setPosition(test);
      break;
    }

    //Checking bottom left
    test.setX(p.getX() - i);
    if (validPosition(test, *this)) {
      invalid = true;
      output.setPosition(test);
      break;
    }
  }
  return output;
}

Point Board :: spawnInBorder (Point p) {
    if (getSize() < p.getX()) {
      p.setX(getSize()-1);
    }
    if (getSize() < p.getY()) {
      p.setY(getSize()-1);
    }

    if (p.getX() < 0) {
      p.setX(0);
    }
    if (p.getY() < 0) {
      p.setY(0);
    }
    return p;
}

void Board :: spawn (Entity e) {
  if (!validPosition(e.getPosition(), *this)) {
    do {
      if (isOutOfBounds(e.getPosition(), *this)) {
        e.setPosition (spawnInBorder(e.getPosition()));
      } else {
        e.setPosition (spawnNearby(e.getPosition()));
      }
    } while (!validPosition(e.getPosition(), *this));
  }
    getBoard()[e.getPosition().getX()][e.getPosition().getY()].setTag(e.getTag());
}

/**
  Moves the pathfinder p in the dir direction. Possible directions according to a numpad:
  8 ==> North (Above)
  6 ==> East (Right)
  2 ==> South (Below)
  4 ==> West (Left)

  If the new position is not valid, the previous position is restored.
*/
void Board :: move (Pathfinder *p, int dir) {
  Point backup (p->getPosition());
  bool swapped = true;
  if (dir == 8) {
    p->north();
    if (!validPosition(p->getPosition(), *this)) {
      p->setPosition(backup);
      swapped = false;
    }
  }
  if (dir == 6) {
    p->east();
    if (!validPosition(p->getPosition(), *this)) {
      p->setPosition(backup);
      swapped = false;
    }
  }
  if (dir == 2) {
    p->south();
    if (!validPosition(p->getPosition(), *this)) {
      p->setPosition(backup);
      swapped = false;
    }
  }
  if (dir == 4) {
    p->west();
    if (!validPosition(p->getPosition(), *this)) {
      p->setPosition(backup);
      swapped = false;
    }
  }
  if (swapped) {
    cout << p->toString() << endl;
    getBoard()[p->getX()][p->getY()] = p->getTag();
    getBoard()[backup.getX()][backup.getY()] = '0';
  }
}
