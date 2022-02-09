import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SearchingBee implements Bee{
    public ImageView image;
    public String name;
    public double xLocation = 100;
    public double yLocation = 200;
    public int health = 100;
    public boolean isAlive = true;



    public SearchingBee(){
        name = "Searching Bee";
        Image i = new Image("file:searching_bee.png");
        image = new ImageView();
        image.setImage(i);
    }


    @Override
    public void move() {
        //Flower directed movement here

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

    public int getHealth(){
        return health;
    }

    public boolean isAlive(){
        return isAlive;
    }

}
