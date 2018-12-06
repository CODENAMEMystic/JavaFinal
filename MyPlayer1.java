import greenfoot.*;

/**
 * Write a description of class MyPlayer1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyPlayer1 extends Tanks
{
    /**
     * Act - do whatever the MyPlayer1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 2;
    boolean fired = false;
    public void act() 
    {
       moveAround();
       fire();
       getHit();
       hitWalls();
    } 
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - speed , getY());
            setRotation(270);
        }
        if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX() , getY() - speed);
            setRotation(0);
        }
        if(Greenfoot.isKeyDown("d"))
        {
           setLocation(getX() + speed, getY());
           setRotation(90);
        }
        if(Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY() + speed);
            setRotation(180);
        }
    }
     public void fire()
    {
        Projectile projectile = new Projectile();
        if (Greenfoot.isKeyDown("f") && fired == false)
        {
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
            fired = true;
        }
        if (!Greenfoot.isKeyDown("f"))
        {
            fired = false;
        }
    }
    public void getHit()
    {
        if(isTouching(Projectile2.class))
        {
            setImage("TankExplosion.png");
        }
    }
    public void hitWalls()
    {
        if(isTouching(Wall.class))
        {
            speed = -speed;
        }
    }
}
