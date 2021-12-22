#include "../Headers/Node.h"
#include "../Headers/Tag.h"

Node ::Node()
{
    this->tag = ('0');
}

Node ::Node(Tag t)
{
    this->tag = t;
}

void Node ::setNode(char c)
{
    this->tag = (Tag)c;
}

char Node ::getNode()
{
    return this->tag.getNode();
}
