#include <iostream>

class Bird
{
    
public:
   
    virtual void  fly()
    {
        std::cout << "Am flying...\n" ;
    }
};

class Eagle : public Bird
{
public:
  
    void fly() override
    {
        std::cout << "Eagle: flying..\n";
    }
};

class Penguin : public Bird
{
};

static void flyBird(Bird& b)
{
    b.fly();
}

int main()
{
    Eagle theEagle;
    Penguin thePenguin;
    
    flyBird(theEagle);
    flyBird(thePenguin);
    
    return 0;
}

