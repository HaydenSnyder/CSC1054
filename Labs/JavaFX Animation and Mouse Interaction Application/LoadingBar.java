import javafx.event.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.canvas.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.scene.paint.Color;
import javafx.stage.*;

public class LoadingBar extends Application 
{
   private boolean running = false;
   private boolean reverse = false;
   private int x = 202;
   private int barWidth = 0;
   private static int reverseCount = 0;
   private static int startCount = 0;

   private Canvas theCanvas = new Canvas(800, 200);
   private GraphicsContext gc = theCanvas.getGraphicsContext2D();
   private FlowPane flowPane = new FlowPane();

   public void start(Stage stage) 
   {
      flowPane.getChildren().add(theCanvas);
      Scene scene = new Scene(flowPane, 800, 200);
      stage.setScene(scene);
      stage.setTitle("Loading Bar");
      stage.show();

      draw(); 
      
      scene.setOnKeyPressed(new KeyListenerDown());

      AnimationHandler ah = new AnimationHandler();
      ah.start();
   }

   public void draw() 
   {
      gc.setFill(Color.BLACK);
      gc.fillRect(0, 0, 800, 200);

      gc.setFill(Color.WHITE);
      gc.fillRect(200, 75, 375, 45);

      gc.setFill(Color.BLUE);
      gc.fillRect(202, 77, 370, 40);
   }

   public class KeyListenerDown implements EventHandler<KeyEvent> 
   {
      public void handle(KeyEvent event) 
      {
         if (event.getCode() == KeyCode.S) 
         {
            running = true;
            
            if(reverse == false)
            {
               startCount = 0;
            }
            else if(reverse == true)
            {
               startCount = 1;
            }
         } 
         else if (event.getCode() == KeyCode.D) 
         {
            reverseCount++;
            
            if(reverseCount == 1)
            {
               reverse = true;
            }
            else if(reverseCount == 2)
            {
               reverseCount = 0;
               reverse = false;
            }
         } 
         else if (event.getCode() == KeyCode.A) 
         {
            if(running == true && reverse == true)
            {
               reverse = true;
               running = false;
            }
            else
            {
               running = false;
               reverse = false;
            }
         }
      }
   }

   public class AnimationHandler extends AnimationTimer 
   {
      @Override
      public void handle(long now) 
      {
         if (running && !reverse) 
         {
            if (barWidth < 370) 
            { 
                  barWidth++;  
            }
            else if(barWidth == 370)
            {
                  barWidth = 0;
            }
          } 
          else  if(running && startCount == 1)
          { 
            if (barWidth > 0) 
            { 
               barWidth--; 
            }
            else if(barWidth == 0)
            {
               barWidth = 370;
            }
          }
          else if(running && startCount == 0)
          {
            if (barWidth > 0) 
            { 
               barWidth--; 
            }  
          }

      

         gc.setFill(Color.BLACK);
         gc.fillRect(0, 0, 800, 200);

         gc.setFill(Color.WHITE);
         gc.fillRect(200, 75, 375, 45);

         gc.setFill(Color.BLUE);
         gc.fillRect(202, 77, 370, 40);

         gc.setFill(Color.PINK);
         gc.fillRect(202, 77, barWidth, 40);
     }
   }

   public static void main(String[] args) 
   {
      launch(args);
   }
}
