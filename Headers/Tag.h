#ifndef TAGS_H
#define TAGS_H

class Tag {
private:
  char tag;

public:
  Tag ();
  Tag (char c);

  char getTag();
  void setTag(char c);

};

#endif // TAGS_H
