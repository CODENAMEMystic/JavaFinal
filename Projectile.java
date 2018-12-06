import greenfoot.*;

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends MyPlayer1
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 15;
    public void act() 
    {
       getDirection();
       remove();
    } 
    public void getDirection()
    {
        if(getRotation() == (0) && fired == false)
        {
            setLocation(getX(), getY() - speed);
        }
        if(getRotation() == (270) && fired == false)
        {
            setLocation(getX() - speed, getY());
        }
        if(getRotation() == (90) && fired == false)
        {
            setLocation(getX() + speed, getY());
        }
        if(getRotation() == (180) && fired == false)
        {
            setLocation(getX(), getY() + speed);
        }
        
    }
    public void remove()
    {
        if (getX() == 0)
        {
            getWorld().removeObject(this);
        }
        else
        
        if (getY() == 0)
        {
            getWorld().removeObject(this);
        }
        else
        if (getX() == 1199)
        {
            getWorld().removeObject(this);
        }
        else
        if (getY() == 799)
        {
            getWorld().removeObject(this);
        }
    }
}
