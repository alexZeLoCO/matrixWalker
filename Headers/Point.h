#ifndef POINT_H
#define POINT_H

using namespace std;

class Point {
private:
  int x;
  int y;

public:
 Point (int max);
 Point (int x, int y);
 Point (Point&& p);
 Point (Point &p);
 Point ();

 int getX();
 int getY();

 void setX(int x);
 void setY(int y);

 void setPosition (Point p);

 string toString();
};

#endif // POINT_H
