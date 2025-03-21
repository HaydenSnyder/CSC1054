import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.geometry.*;
import javafx.stage.*;
import java.util.*;
import javafx.scene.paint.Color;

public class MouseLab extends Application 
{
   // Create the size of the Square
   private double squareX = (500 - 25) / 2;
   private double squareY = (500 - 25) / 2;
   
   // Create a boolean when you are dragging and the position of it
   private double offsetX, offsetY;
   private boolean isDragging = false;
    
   Canvas canvas = new Canvas(500, 500);


   public void start(Stage stage) 
   {
  
      GraphicsContext gc = canvas.getGraphicsContext2D();
      draw(gc);

      // Create the Listeners
      canvas.setOnMousePressed(new MousePressedHandler());
      canvas.setOnMouseDragged(new MouseDraggedHandler());
      canvas.setOnMouseReleased(new MouseReleasedHandler());

      FlowPane root = new FlowPane(canvas);
      Scene scene = new Scene(root, 500, 500);
      stage.setTitle("Drag Square");
      stage.setScene(scene);
      stage.show();
   }
   
   // Draw the background and the square
   private void draw(GraphicsContext gc) 
   {
      gc.setFill(Color.WHITE);
      gc.fillRect(0, 0, 500, 500);

      gc.setFill(Color.RED);
      gc.fillRect(squareX, squareY, 25, 25);
   }
   
   // Pressed down key handler
   private class MousePressedHandler implements EventHandler<MouseEvent> 
   {
      public void handle(MouseEvent event) 
      {
         // Set the mouseX and mouseY to where its currently
         double mouseX = event.getX();
         double mouseY = event.getY();

         // If the mouse and square are the same make the dragging true
         if (mouseX >= squareX && mouseX <= squareX + 25 &&
            mouseY >= squareY && mouseY <= squareY + 25) 
            {
               isDragging = true;
               offsetX = mouseX - squareX;
               offsetY = mouseY - squareY;
            }
      }
   }

   // Create the mouse dragging event handler
   private class MouseDraggedHandler implements EventHandler<MouseEvent> 
   {
      public void handle(MouseEvent event) 
      {
         // When the user clicks on the square position it will make it true
         if (isDragging) 
         {
            // This moves the square position
            squareX = event.getX() - offsetX;
            squareY = event.getY() - offsetY;

            // Prevent the square from going off-screen
            squareX = Math.max(0, Math.min(500 - 25, squareX));
            squareY = Math.max(0, Math.min(500 - 25, squareY));

            draw(canvas.getGraphicsContext2D());
         }
      }
   }

   // When the user is done clicking it sets the isDraggin to false
   private class MouseReleasedHandler implements EventHandler<MouseEvent> 
   {
      public void handle(MouseEvent event) 
      {
         isDragging = false;
      }
   }
   
    public static void main(String[] args) 
    {
        launch(args);
    }
}