import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;


public class Checkerboard extends Canvas
{
   public Checkerboard(Color color)
   {
      // Create canvas size
      setWidth(100);
      setHeight(100);
      draw(color);
   }
   
   
   public void draw(Color color)
   {
      GraphicsContext gc = getGraphicsContext2D();
      gc.setFill(color);
      gc.fillRect(0,0,100,100);
   }
}
