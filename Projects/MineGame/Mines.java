import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;
import java.util.ArrayList;


public class Mines extends DrawableObject
{
   private double colorValue;
   private double colorIncrement = 0.01; 
   private int way = 1; 
   private ArrayList<Mines> mines = new ArrayList<>();
   
   public Mines(float x, float y)
   {
      super(x,y); 
      
      Random rand = new Random();
      colorValue = rand.nextDouble(); 
   }
   
   public void drawMe(float x, float y, GraphicsContext gc)
   {
      // ColorValue is random Double that is adding the colorIncrement * way
      colorValue += colorIncrement * way;
      
      // If the colorvalue is greater than 1 it sets the colorvalue to 1 and way to -1
      if (colorValue >= 1) 
      {
         colorValue = 1;
         way = -1;
      }
      
      // If color value is less than 0 it sets colorValue to 0 and way to 1
      if (colorValue <= 0) 
      {
         colorValue = 0;
         way = 1;
      }
      
      // Draw the mine with oscillating color
      Color color = Color.RED.interpolate(Color.WHITE, colorValue);
      gc.setFill(color);
      gc.fillOval(getX() - x + 300 - 5, getY() - y + 300 - 5, 10, 10);
   }
}