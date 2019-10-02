class Bird
{
        
    public void  fly()
    {
            System.out.println("Am flying...\n");
    }
}

class Eagle extends  Bird
{
    public void fly()
        {
        System.out.println("Eagle: flying..\n");
        }
}
class Penguin extends  Bird
{
}

class Liskov
{

    public static void flyBird(Bird b)
    {
        b.fly();
    }

    public static void main(String[] args)
    {
        Bird theEagle = new Eagle();
        Bird thePenguin = new Penguin();
        
        flyBird(theEagle);
        flyBird(thePenguin);
        
        
    }

}

