import java.net.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import java.util.*;

public class CheckerboardClient extends Application
{
   public void start(Stage stage)
   {
      // Create the flowPane and set the size
      FlowPane flowPane = new FlowPane();
      flowPane.setPrefSize(700,600);

      // Create a for loop to create 42 squares
      for(int i=0;i<42;i++)
      {
         // Set the color of the square to be oppisite each time
         Color color = (i % 2 == 0) ? Color.GREEN : Color.YELLOW;
         Checkerboard myCheckerboard = new Checkerboard(color);
         
         // Add the checkerboard into the flowpane
         flowPane.getChildren().add(myCheckerboard);
      } 

      // Create the scene so we can see the checkerboard
      Scene scene = new Scene(flowPane, 700, 600);
      stage.setScene(scene);
      stage.setTitle("CheckerBoard");
      stage.show();
   }


   public static void main(String[] args)
   {
      launch(args);
   }
}


