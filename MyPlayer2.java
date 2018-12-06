import greenfoot.*;

/**
 * Write a description of class MyPlayer2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyPlayer2 extends Tanks
{
    /**
     * Act - do whatever the MyPlayer2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 1;
    boolean fired = false;
    MyPlayer1 myplayer1;
    int distance2player1X;
    int distance2player1Y;
    int p2x;
    int p2y;

    
    public void act() 
    {
        moveAround();
        fire();
        getHit();
        findPlayer();
        
    }  
    
    public void findPlayer()
    {
        myplayer1 = (MyPlayer1) getObjectsInRange(500, MyPlayer1.class).get(0);
        p2x = getX();
        p2y = getY();
        
        distance2player1X = (myplayer1.getX() - getX());
        distance2player1Y = (myplayer1.getY() - getY());
        if(distance2player1X < 10)
        {
            setLocation(getX() - speed, getY());
            setRotation(90);
        }
        else if(distance2player1X > 50)
        {
            setLocation(getX() + speed, getY());
        }
        if(distance2player1Y < 50)
        {
            setLocation(getX(), getY() - speed);
            setRotation(0);
        }
        else if(distance2player1Y > 50)
        {
            setLocation(getX(), getY() + speed);
        }
         
        
        
        //setLocation(distance2player1X, distance2player1Y);
        
    }
    
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - speed , getY());
            setRotation(270);
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX() , getY() - speed);
            setRotation(0);
        }
        if(Greenfoot.isKeyDown("right"))
        {
           setLocation(getX() + speed, getY());
           setRotation(90);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + speed);
            setRotation(180);
        }
    }
    public void fire()
    {
        Projectile2 projectile2 = new Projectile2();
        if (Greenfoot.isKeyDown("0") && fired == false)
        {
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation());
            fired = true;
        }
        if (!Greenfoot.isKeyDown("0"))
        {
            fired = false;
        }
    }
    public void getHit()
    {
        if(isTouching(Projectile.class))
        {
            setImage("TankExplosion.png");
        }
    }
    }

