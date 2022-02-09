import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class GardenController {

    private Pane aimlessBeeBox = new VBox();
    private Pane searchingBeeBox = new VBox();
    @FXML
    private Pane theGarden;

    AimlessBee aimlessBee = new AimlessBee();
    SearchingBee searchingBee = new SearchingBee();

    public GardenController() {
    }

    @FXML
    public void initialize() {
        theGarden.setStyle("-fx-background-color: linear-gradient(to bottom right, derive(forestgreen, 20%), derive(forestgreen, -40%));");

        createBee(aimlessBeeBox,aimlessBee.image, aimlessBee.name);
        displayBee(aimlessBeeBox, aimlessBee.getxLocation(),aimlessBee.getyLocation());

        //createBee(searchingBeeBox,searchingBee.image, searchingBee.name);
        //displayBee(searchingBeeBox, aimlessBee.getxLocation(),aimlessBee.getyLocation());

        theGarden.setFocusTraversable(true); // ensure garden pane will receive keypresses
    }

    private void createBee(Pane beeBox, ImageView beeImage, String beeName){
        beeImage.setPreserveRatio(true);    // ensure ratio preserved when scaling the bee
        beeImage.setFitWidth(50.0);         // scale bee to be a reasonable size
        Label beeLabel = new Label();       // you might make this an attribute of another class so you can update it
        beeLabel.setText(beeName);
        beeLabel.setStyle("-fx-text-fill: white;");
        beeBox.getChildren().add(beeImage);
        beeBox.getChildren().add(beeLabel);
        theGarden.getChildren().add(beeBox); // place bee on the panel
    }

    // display the bee at the (beeXLocation, beeYLocation), ensuring the bee does not leave the garden
    private void displayBee(Pane beeBox, double beeXLocation, double beeYLocation) {

        if ( beeXLocation < 0 )
            beeXLocation = 0;
        else if (theGarden.getWidth() > 0 && beeXLocation > theGarden.getWidth() - 10)
            // note: getWidth() is 0 when first load the scene, so don't relocate the bee in that case
            beeXLocation = theGarden.getWidth() - 10;
        if (beeYLocation < 0)
            beeYLocation = 0;
        else if (theGarden.getHeight() > 0 && beeYLocation > theGarden.getHeight() - 10)
            beeYLocation = theGarden.getHeight() - 10;
        beeBox.setLayoutX(beeXLocation);
        beeBox.setLayoutY(beeYLocation);
    }

    @FXML
    public void onKeyPressed() {

        aimlessBee.move();
        if(aimlessBee.isAlive())
            displayBee(aimlessBeeBox, aimlessBee.getxLocation(),aimlessBee.getyLocation());
        else
            removeBee(aimlessBeeBox);

        //  searchingBee.move();
        /*
        if(searchingBee.isAlive())
             displayBee(searchingBeeBox, aimlessBee.getxLocation(),aimlessBee.getyLocation());
        else
            removeBee(searchingBeeBox);*/
    }

    private void removeBee(Pane beeBox){
        theGarden.getChildren().remove(beeBox);
    }
}
