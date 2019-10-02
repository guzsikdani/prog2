interface Bird
{
    
}

interface IFlyingBird extends Bird
{
    public void  fly();
}
interface INotFlyingBird extends Bird
{
}
class Eagle implements IFlyingBird
{
    public void fly()
    {
        System.out.println("Eagle: flying..\n");
    }
}
class Penguin implements INotFlyingBird
{
}

class LiskovSub
{

    public static void flyBird(IFlyingBird b)
    {
        b.fly();
    }

    public static void main(String[] args)
    {
        Eagle theEagle = new Eagle();
        Penguin  thePenguin = new Penguin();
        
        flyBird(theEagle);
        //flyBird(thePenguin); //Fordítási hiba!!
        
        
    }

} 

