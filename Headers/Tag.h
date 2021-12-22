#ifndef TAG_H
#define TAG_h

class Tag
{
private:
  char tag;

public:
  Tag();
  Tag(char c);

  char getNode();
  void setNode(char c);

  //void setup (Board b);
};

#endif // NodeS_H
