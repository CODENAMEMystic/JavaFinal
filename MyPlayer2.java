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
        findPlayer(); //Ai System
        
    }  
    
    public void findPlayer()
    {
        //[NOTE] Will refine code later to remove unnecessary code.
        
        //getObjectsInRange(int range, object.class) returns a list of objects in range of AI
        myplayer1 = (MyPlayer1) getObjectsInRange(500, MyPlayer1.class).get(0); //returns first object in range (500) of AI
        p2x = getX(); //gets actors x position
        p2y = getY(); //gets actor y position
        
        distance2player1X = (myplayer1.getX() - getX()); //distance on x axis from player 1 to AI
        distance2player1Y = (myplayer1.getY() - getY()); //distance on y axis from player 1 to AI
        if(distance2player1X < 10) //if player 1 is to the left of AI
        {
            setLocation(getX() - speed, getY());
            setRotation(90);
        }
        else if(distance2player1X > 50) //if player 1 is to the right of AI
        {
            setLocation(getX() + speed, getY());
        }
        if(distance2player1Y < 50) //if player 1 is above AI
        {
            setLocation(getX(), getY() - speed);
            setRotation(0);
        }
        else if(distance2player1Y > 50) //if player 1 is below AI
        {
            setLocation(getX(), getY() + speed);
        }
         
        
        
        //setLocation(distance2player1X, distance2player1Y); //instantly moves AI to player location (Remove)
        
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

