import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SearchingBee implements Bee{
    public ImageView image;
    public String name;
    public double xLocation = 10;
    public double yLocation = 10;
    public int health = 1000;
    public boolean isAlive = true;



    public SearchingBee(){
        name = "Searching Bee";
        Image i = new Image("file:searching_bee.jpg");
        image = new ImageView();
        image.setImage(i);
    }


    @Override
    public void move() {
        //Flower directed movement here

       double x2 = 0;
       double y2 = 0;

       if(xLocation < 20 && yLocation < 20){
        x2 = 600;
        y2 = 0;
           xLocation += Math.sqrt(Math.pow((x2 - xLocation),2)+Math.pow((y2-yLocation),2))/20;
           yLocation +=  Math.sqrt(Math.pow((x2 - xLocation),2)+Math.pow((y2-yLocation),2))/20;
        }
       else if(yLocation > 450 && xLocation > 450){
            x2 = 0;
            y2 = 0;
           xLocation += Math.sqrt(Math.pow((x2 - xLocation),2)+Math.pow((y2-yLocation),2))/20;
           yLocation -=  Math.sqrt(Math.pow((x2 - xLocation),2)+Math.pow((y2-yLocation),2))/20;

        }else{
           xLocation += Math.sqrt(Math.pow((x2 - xLocation),2)+Math.pow((y2-yLocation),2))/100;
           yLocation +=  Math.sqrt(Math.pow((x2 - xLocation),2)+Math.pow((y2-yLocation),2))/100;
       }


        takeDamage();
    }

    @Override
    public void takeDamage() {
    if(health > 0)
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
