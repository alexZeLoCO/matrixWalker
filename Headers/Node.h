#ifndef NODE_H
#define NODE_H

#include "Tag.h"

class Node
{
private:
    Tag tag;
    int gCost;
    int hCost;
    int distanceToPathfinder;

public:
    Node();
    Node(Tag);

    void setNode(char c);
    char getNode();
};

#endif // Node