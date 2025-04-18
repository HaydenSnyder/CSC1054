import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class ThePlayer extends DrawableObject
{
    private int score;
    private double speedX;
    private double speedY;
    private double forceX;
    private double forceY;

     
	//takes in its position
   public ThePlayer(float x, float y)
   {
      super(x,y);
   }
   //draws itself at the passed in x and y.
   public void drawMe(float x, float y, GraphicsContext gc)
   {
      gc.setFill(Color.BLACK);
      gc.fillOval(x-14,y-14,27,27);
      gc.setFill(Color.GRAY);
      gc.fillOval(x-13,y-13,25,25);

   }
   
   public void act(boolean left, boolean right, boolean up, boolean down)
   {
      // Add at force when the user clicks a button
      if (left) 
      {
         forceX -= 0.1;
      }
      else if (right) 
      {
         forceX += 0.1;
      }
      if (up) 
      {
          forceY -= 0.1;
      } 
      else if (down) 
      {
          forceY += 0.1;
      }

      // Limit force
      forceX = Math.max(-5, Math.min(5, forceX));
      forceY = Math.max(-5, Math.min(5, forceY));
   
      // Apply acceleration
      speedX += forceX;
      speedY += forceY;
   
      // Apply Force
      speedX *= 0.975;
      speedY *= 0.975;
        
      // Check if a key is not pressed and force is within (-0.25, 0.25) range, then set force to 0
      if (!left && !right && -0.25 < forceX && forceX < 0.25) 
      {
         forceX = 0;
      }
      if (!up && !down && -0.25 < forceY && forceY < 0.25) 
      {
         forceY = 0;
      }
   
      // Update position
      x += speedX;
      y += speedY;
   }
      
   // Return the score
   public int getScore() 
   {
      return score;
    }

   // Add 1 to score each time
   public void incrementScore() 
   {
      score++;
   }

   // When you move left set the X to current X - 1
   public void moveLeft() 
   {
      setX(getX() - 1);
   }

   // When user moves right set X to current X + 1
   public void moveRight() 
   {
      setX(getX() + 1);
   }

   // When user moves up set Y to current Y - 1
   public void moveUp() 
   {
      setY(getY() - 1);
   }

   // When the user moves down set the Y to current Y + 1
   public void moveDown() 
   {
      setY(getY() + 1);
   }
 
   // Set Force in the X direction
   public void setForceX(double forceX) 
   {
      this.forceX = forceX;
   }
 
   // Set force in the Y direction
   public void setForceY(double forceY) 
   {
      this.forceY = forceY;
   }
    
   // Get the speed of the x direction
   public double getSpeedX() 
   {
     return speedX;
   }
   
   // Get the speed of the Y direction
   public double getSpeedY() 
   {
      return speedY;
   }
}