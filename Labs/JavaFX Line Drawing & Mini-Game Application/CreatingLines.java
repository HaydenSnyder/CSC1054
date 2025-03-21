import java.util.*;
import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class CreatingLines extends Application 
{
   private FlowPane root = new FlowPane();
   private ComboBox<Integer> linePicker = new ComboBox<>();
   private Canvas canvas = new Canvas(400, 300);
   private GraphicsContext gc = canvas.getGraphicsContext2D();
   private CheckBox thickness = new CheckBox("Thick");
   private TextField textBox = new TextField("Enter an A or I");
   private RadioButton noSpaces = new RadioButton("No Spaces");
   private RadioButton spaces = new RadioButton("Spaces");
   private ToggleGroup group = new ToggleGroup();

   private boolean thickLines = false;
   private boolean oneSpace = false;

   public void start(Stage stage) 
   {
      // Adding line options
      linePicker.getItems().addAll(10, 50, 100);
      linePicker.setValue(10);

      // Event listeners
      linePicker.setOnAction(new ComboBoxListener());
      textBox.setOnAction(new TextFieldListener());
      thickness.setOnAction(new CheckBoxListener());
      noSpaces.setToggleGroup(group);
      spaces.setToggleGroup(group);
      noSpaces.setOnAction(new RadioButtonListener());
      spaces.setOnAction(new RadioButtonListener());

      // Layout setup
      root.getChildren().addAll(linePicker, thickness, noSpaces, spaces, textBox);
      VBox layout = new VBox(root, canvas);

      // Scene setup
      Scene scene = new Scene(layout, 400, 300);
      stage.setScene(scene);
      stage.setTitle("Creating Lines");
      stage.show();
      
      // Set the amount of lines to automatically 10
      drawLines(10);
   }

   private void drawLines(int count) 
   {
      gc.clearRect(0, 0, 400, 300);
      int spacing;
      int lineWidth = thickLines ? 2 : 1;
      
      // Set the spacing for each lines
      if(count == 10)
      {
         spacing = 10;
      }
      else if(count == 50)
      {
         spacing = 3;
      }
      else
      {
         spacing = 2;
      }
      
      // This for loop. goes through creating the spacing for the lines
      for (int i = 0; i < count; i++) 
      {
         int y = i * spacing;
         
         // If its one space make the size
         if (oneSpace) 
         {
            if (y < 150 || y > 152) 
            {
               gc.strokeLine(0, y, 40, y);
               gc.strokeLine(60, y, 100, y);
               
               // If the thickness is true, set the thickness
               if (thickLines) 
               {
                  gc.strokeLine(0, y + 1, 40, y);
                  gc.strokeLine(60, y + 1, 100, y);  
               }
            }
         } 
         else 
         {
            gc.strokeLine(0, y, 100, y);
            
            // Draw thicklines
            if (thickLines) 
            {
               gc.strokeLine(0, y + 1, 100, y + 1);
            }
         }
      }
   }
   
   
   // Create the Event Handler for the comboBox
   private class ComboBoxListener implements EventHandler<ActionEvent> 
   {
      public void handle(ActionEvent e) 
      {
         // when you select the number in the combo box draw those lines
         drawLines(linePicker.getValue());
      }
   }

   // Create the textField Event Handler
   private class TextFieldListener implements EventHandler<ActionEvent> 
   {
      public void handle(ActionEvent e) 
      {
         // If the user enters A set the one spec, thickness to true
         String input = textBox.getText().toUpperCase();
         if (input.equals("A")) 
         {
            linePicker.setValue(100);
            thickness.setSelected(true);
            spaces.setSelected(true);
            oneSpace = true;
            thickLines = true;
         } 
         // Else if A is entered 
         else if (input.equals("I")) 
         {
            linePicker.setValue(10);
            thickness.setSelected(false);
            noSpaces.setSelected(true);
            oneSpace = false;
            thickLines = false;
         }
                  
         drawLines(linePicker.getValue());
      }
   }
   
   // Create the Check Box Event Handler
   private class CheckBoxListener implements EventHandler<ActionEvent> 
   {
      public void handle(ActionEvent e) 
      {
         // If the thicklines is selected draw the thicklines
         thickLines = thickness.isSelected();
         drawLines(linePicker.getValue());
      }
   }
   
   // Create the Radio button event handler
   private class RadioButtonListener implements EventHandler<ActionEvent> 
   {
      public void handle(ActionEvent e) 
      {
         // If One space is selected seperate the lines
         oneSpace = spaces.isSelected();
         drawLines(linePicker.getValue());
      }
   }

   public static void main(String[] args) 
   {
      launch(args);
   }
}
