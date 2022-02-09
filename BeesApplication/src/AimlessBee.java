import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AimlessBee implements Bee {
    public ImageView image;
    public String name;
    public double xLocation = 300;
    public double yLocation = 300;
    public int health = 100;
    public boolean isAlive = true;

    //This variable is used to scale movement
    static final int MOVEMENTSIZE = 4;

    public AimlessBee(){
        name = "Aimless Bee";
        Image i = new Image("file:aimless_bee.png");
        image = new ImageView();
        image.setImage(i);
    }

    @Override
    public void move() {

        xLocation = xLocation + (int) (Math.random() * (20 * MOVEMENTSIZE));
        xLocation = xLocation - (int) (Math.random() * (20 * MOVEMENTSIZE));
        yLocation = yLocation + (int) (Math.random() * (20 * MOVEMENTSIZE));
        yLocation = yLocation - (int) (Math.random() * (20 * MOVEMENTSIZE));

        //Keep the bee inbounds
        if(xLocation < 50)
            xLocation = xLocation + (int) (Math.random() * (20 * MOVEMENTSIZE));
        if(yLocation < 50)
            yLocation = yLocation + (int) (Math.random() * (20 * MOVEMENTSIZE));
        if(xLocation > 500)
            xLocation = xLocation - (int) (Math.random() * (20 * MOVEMENTSIZE));
        if(yLocation > 500)
            yLocation = yLocation - (int) (Math.random() * (20 * MOVEMENTSIZE));


        takeDamage();
    }

    @Override
    public void takeDamage() {

        health--;

        if(health <= 0)
            isAlive = false;
    }


    public double getyLocation() {
        return yLocation;
    }

    public double getxLocation() {
        return xLocation;
    }

    public boolean isAlive(){
        return isAlive;
    }

}
