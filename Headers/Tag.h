#ifndef NodeS_H
#define NodeS_H

class Node {
private:
  char Node;
  int gCost;
  int hCost;

public:
  Node ();
  Node (char c);

  char getNode();
  void setNode(char c);

  void setup (Board b);

  
};

#endif // NodeS_H
