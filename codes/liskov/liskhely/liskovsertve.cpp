#include <iostream>

class Bird
{
    
};

class IFlyingBird : public Bird
{
public:
    virtual void fly() = 0;
};
class INotFlyingBird : public Bird
{
};

class Eagle : public IFlyingBird
{
public:
  
    void fly() override
    {
        std::cout << "Eagle: flying..\n";
    }
};

class Penguin : public INotFlyingBird
{
};

static void flyBird(IFlyingBird& b)
{
    b.fly();
}

int main()
{
    Eagle theEagle;
    Penguin thePenguin;
    
    flyBird(theEagle);
    //flyBird(thePenguin); //Ez az utasításmár nem fog lefordulni...
    //A programtulajdonságai épek maradnak.
    
    return 0;
}

