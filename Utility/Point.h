#ifndef POINT_H
#define POINT_H

class Point {
private:
  int x;
  int y;

public:
 Point (int x, int y);
 Point ();

 int getX();
 int getY();

 void setX(int x);
 void setY(int y);

};

#endif // POINT_H
