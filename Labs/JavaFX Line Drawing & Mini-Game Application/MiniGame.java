import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.event.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;

public class MiniGame extends Application 
{
   // Create the Array of buttons
   Button[][] buttons = new Button[4][4];
   
   Label title = new Label("Welcome to the Game!");

   public void start(Stage stage) 
   {
      title.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(10), Insets.EMPTY)));
      GridPane theGridPane = new GridPane();


      // Creating a 4x4 grid of buttons
      for (int i = 0; i < 4; i++) 
      {
         for (int j = 0; j < 4; j++) 
         {
            Button b = new Button();
            buttons[i][j] = b;

            b.setPrefSize(100, 100);
            b.setOnAction(new ButtonListener(i, j)); 
            
            theGridPane.setAlignment(Pos.CENTER);
            theGridPane.add(b, i, j);
         }
      }
      
      
      VBox vbox = new VBox(10, title, theGridPane);
      
      
      Scene scene = new Scene(vbox, 500, 500);
      stage.setScene(scene);
      stage.setTitle("MiniGame");
      stage.show();
   }

   // Inner class to handle button clicks
   public class ButtonListener implements EventHandler<ActionEvent> 
   {
      int row, col;

      public ButtonListener(int row, int col) 
      {
         this.row = row;
         this.col = col;
      }
      
      // Create action event for when the buttons are click it will check win
      public void handle(ActionEvent e) 
      {
         toggleVisibility(row, col);
         checkWin();
      }
   }

   // Toggle visibility of button and its neighbors
   private void toggleVisibility(int row, int col) 
   {
      // Toggle itself
      buttons[row][col].setVisible(!buttons[row][col].isVisible()); 

      // Check and toggle visibility of neighbors
      if (row > 0)
      {
         // UP
         buttons[row - 1][col].setVisible(!buttons[row - 1][col].isVisible()); 
      }
      if (row < 3) 
      {
         // Down
         buttons[row + 1][col].setVisible(!buttons[row + 1][col].isVisible()); 
      }
      if (col > 0) 
      {
         // Left
         buttons[row][col - 1].setVisible(!buttons[row][col - 1].isVisible()); 
      }
      if (col < 3) 
      {
         // Right
         buttons[row][col + 1].setVisible(!buttons[row][col + 1].isVisible()); 
      }
   }
   
   // Check to see if the user Wins
   private void checkWin()
   {
      boolean allHidden = true;
      
      // Create a for loop where if all the blocks are gone it will set it to true, if some are there set to false
      for(int i = 0; i < 4; i++)
      {
         for(int j = 0; j < 4; j++)
         {
            if(buttons[i][j].isVisible())
            {
               allHidden = false;
               break;
            }
         }
         if (!allHidden)
         {
            break;
         }
      }
      
      // End the game
      if(allHidden)
      {
         title.setText("Game Over!");
      }
   }
   
   public static void main(String[] args) 
   {
      launch(args);
   }
}
