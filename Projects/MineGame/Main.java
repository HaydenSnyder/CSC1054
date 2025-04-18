import java.net.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import java.io.*;
import javafx.event.*;
import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.animation.*;

public class Main extends Application 
{
   // Create the Canvas
   FlowPane fp;
   Canvas theCanvas = new Canvas(600, 600);
   GraphicsContext gc;

   // Create the Player at center of the screen
   ThePlayer thePlayer = new ThePlayer(300, 300);
   
   // Create the Mines in a arrayList where it stores all of them
   Mines m = new Mines(300, 300);
   ArrayList<Mines> allMines = new ArrayList<>();
   ArrayList<String> generatedGrids = new ArrayList<>();
   
   // Create a grid 
   int lastCGridX = Integer.MIN_VALUE;
   int lastCGridY = Integer.MIN_VALUE;

   // Keys for moving 
   boolean right = false, left = false, up = false, down = false;
   
   // Intitate Score
   private double score = 0;
   private int newHighScore = 0;
   Label highScoreText = new Label("0");

   // Create the background Image
   Image background = new Image("stars.png");
   Image overlay = new Image("starsoverlay.png");
   
   // Create a boolean where game is running
   private boolean gameRunning = true;

   public void start(Stage stage) 
   {
      // Create the canvas
      fp = new FlowPane();
      fp.getChildren().add(theCanvas);
      gc = theCanvas.getGraphicsContext2D();
      drawBackground(300, 300, gc);

      // Allows the canvwas to use the key listeners
      theCanvas.setOnKeyPressed(new KeyListenerDown());
      theCanvas.setOnKeyReleased(new KeyListenerUp());

      // Runs the animation handler
      AnimationHandler animationHandler = new AnimationHandler();
      animationHandler.start();

      // Draws the player in the center of the creen
      thePlayer.drawMe(300, 300, gc);

      Scene scene = new Scene(fp, 600, 600);
      stage.setScene(scene);
      stage.setTitle("Project :)");
      stage.show();

      theCanvas.requestFocus();
   }

   public class AnimationHandler extends AnimationTimer 
   {
      public void handle(long now) 
      {
         // Draw the backgorund
         gc.clearRect(0, 0, 600, 600);
         drawBackground(thePlayer.getX(), thePlayer.getY(), gc);

         // Draw the mines as well as check for collision
         checkForMineGeneration();
         removeFarMines();
         drawMines(gc);
         checkMineCollisions();

         // If the game is running allow the user to move
         if (gameRunning) 
         {
            // Draw the mine in the middle
            thePlayer.draw(300, 300, gc, true);
            
            if (left) 
            {
               thePlayer.moveLeft();
               thePlayer.incrementScore();
               thePlayer.setForceX(-0.1);
             }
             
             if (right) 
             {
               thePlayer.moveRight();
               thePlayer.incrementScore();
               thePlayer.setForceX(0.1);
              }
                
              if (down) 
              {
                  thePlayer.moveDown();
                  thePlayer.incrementScore();
                  thePlayer.setForceY(0.1);
              }
                
               if (up) 
               {
                  thePlayer.moveUp();
                  thePlayer.incrementScore();
                  thePlayer.setForceY(-0.1);
               }

                thePlayer.act(left, right, up, down);

         }
         
         // Draw the score and High score, as well as update it
          drawScore();
          updateScore();
          saveHighScore();
          loadHighScore();
      }
   }

   // Method to draw the background
   public void drawBackground(float playerx, float playery, GraphicsContext gc) 
   {
      playerx *= .1;
      playery *= .1;

      float x = playerx / 400;
      float y = playery / 400;

      int xi = (int) x;
      int yi = (int) y;

      for (int i = xi - 3; i < xi + 3; i++) 
      {
         for (int j = yi - 3; j < yi + 3; j++) 
         {
            gc.drawImage(background, -playerx + i * 400, -playery + j * 400);
         }
      }

      playerx *= 2f;
      playery *= 2f;
      x = playerx / 400;
      y = playery / 400;

      xi = (int) x;
      yi = (int) y;

      for (int i = xi - 3; i < xi + 3; i++) 
      {
         for (int j = yi - 3; j < yi + 3; j++) 
         {
            gc.drawImage(overlay, -playerx + i * 400, -playery + j * 400);
         }
      }
   }

   // Create a key listener when we press a button down
   public class KeyListenerDown implements EventHandler<KeyEvent> 
   {
      public void handle(KeyEvent event) 
      {
         // If the user clicks W set Up to true
         if (event.getCode() == KeyCode.W) 
         {
            up = true;
         }
         // If the user ckicks A set left to true
         else if (event.getCode() == KeyCode.A) 
         {
            left = true;
         }
         // If the user clicks S set down to true
         else if (event.getCode() == KeyCode.S) 
         {
            down = true;
         }
         // If user clicks D set right to true
         else if (event.getCode() == KeyCode.D) 
         {
            right = true;
         }
      }
   }
   
   // Create a keylistener for when we unlcick a button
   public class KeyListenerUp implements EventHandler<KeyEvent> 
   {
      public void handle(KeyEvent event) 
      {
         // If the user moves hand off W set up to false
         if (event.getCode() == KeyCode.W) 
         {
            up = false;
         }
         // If the user moves hand off A set left to false
         else if (event.getCode() == KeyCode.A) 
         {
            left = false;
         }
         // If the user moves hand off S set down to false
         else if (event.getCode() == KeyCode.S) 
         {
            down = false;
         }
         // If the user moves hand off D set right to false
         else if (event.getCode() == KeyCode.D) 
         {
            right = false;
         }
      }
   }

   // Create a method that draws the score
   public void drawScore() 
   {
      gc.setFill(Color.WHITE);
      gc.setFont(Font.font("Arial", FontWeight.BOLD, 20));
      gc.fillText("Score: " + (int) score, 15, 25);
    }

   // Create a method that updates the current game high score if its larger than the file high score
   private void updateScore() 
   {
      double distance = Math.sqrt(Math.pow(thePlayer.getX() - 300, 2) + Math.pow(thePlayer.getY() - 300, 2));
      score = distance;
        
      if (score > newHighScore) 
      {
         newHighScore = (int) score;
      }
   }

   // Create a method that loads in the high score saved in the file
   private void loadHighScore() 
   {
      try 
      {
         // Create a file
         File file = new File("HighScore.txt");
         
         // If the file exists scan it and draw the high score
         if (file.exists()) 
         {
            Scanner scan = new Scanner(file);
            
            if (scan.hasNextInt()) 
            {
               int highScore = scan.nextInt();
               gc.setFill(Color.WHITE);
               gc.setFont(Font.font("Arial", 15));
               gc.fillText("High Score: " + highScore, 15, 42);
            }
         
            scan.close();
         }
      } 
      catch (IOException e) 
      {
         e.printStackTrace();
      }
   }

   // Create a method to save the high score in a file
   public void saveHighScore() 
   {
      try 
      {
         // Read in the HighScore File
         int oldHighScore = 0;
         File highScoreFile = new File("HighScore.txt");
         
         // If the file exists scan in the int
         if (highScoreFile.exists()) 
         {
            Scanner fileScan = new Scanner(highScoreFile);
            
            // If the file int is an int set oldhighscore to the int
            if (fileScan.hasNextInt()) 
            {
               oldHighScore = fileScan.nextInt();
               fileScan.close();
            }

            // If the newhighscore is greater than old high score, over write the new highscore
            if (newHighScore > oldHighScore) 
            {
               PrintWriter pw = new PrintWriter("HighScore.txt");
               pw.println(newHighScore);
               pw.close();
            }
         }
      } 
      catch (FileNotFoundException fnfe) 
      {
         System.out.println("File Not Found!");
      }
   }

   // Create a method that generates mines in a area
   public void checkForMineGeneration() 
   {
      // Get the players current grid
      int cgridx = ((int) thePlayer.getX()) / 100;
      int cgridy = ((int) thePlayer.getY()) / 100;
      
      // If the player hasnt moved to a new grid dont do anything
      if (cgridx == lastCGridX && cgridy == lastCGridY) 
      {
         return;
      }
      
      // Update the last known grid cordinate
      lastCGridX = cgridx;
      lastCGridY = cgridy;

      // Loop over a 9x9 grid area around te player
      for (int i = -4; i <= 4; i++) 
      {
         for (int j = -4; j <= 4; j++) 
         {
            // Skip the center grid
            if (i == 0 && j == 0) 
            {
               continue;
            }
            
            // Only consider grids at distance 3 or 4
            int dist = Math.max(Math.abs(i), Math.abs(j));
            
            if (dist != 3 && dist != 4) 
            {
               continue;
            }

            // Calculate Grid coordinates
            int gridX = cgridx + i;
            int gridY = cgridy + j;
            
            //Generate a way to track the grid
            String key = gridX + "," + gridY;
            boolean alreadyGenerated = false;


            // check to see if mines already generated for the grid
            for (String s : generatedGrids) 
            {
                if (s.equals(key)) 
                {
                  alreadyGenerated = true;
                  break;
                }
            }
            
            // skip the grid if its already generated
            if (alreadyGenerated) 
            {
               continue;
            }
            
            // Make the grid generated
            generatedGrids.add(key);
            
            // Calculate the distance from the middle to determine amount of mines
            double distToOrigin = Math.sqrt((gridX * 100) * (gridX * 100) + (gridY * 100) * (gridY * 100));
            int N = (int) (distToOrigin / 1000);
            
            // Generate up to N mines i the grid with a 30% chance per attempt
            for (int k = 0; k < N; k++) 
            {
               if (Math.random() < 0.3) 
               {
                  // Randomize mine location within the current 100x100
                  float mineX = gridX * 100 + (float) (Math.random() * 100);
                  float mineY = gridY * 100 + (float) (Math.random() * 100);
                  
                  // Add the mine to the list
                  allMines.add(new Mines(mineX, mineY));
               }
            }
         }
      }
   }


   // Create a method that draws the mines
   public void drawMines(GraphicsContext gc) 
   {
      for (Mines mine : allMines) 
      {
         mine.drawMe(thePlayer.getX(), thePlayer.getY(), gc);
      }
   }

   // Create a method to remove mines when out of range
   public void removeFarMines() 
   {
      for (int i = allMines.size() - 1; i >= 0; i--) 
      {
         Mines mine = allMines.get(i);
         double d = Math.sqrt(Math.pow(mine.getX() - thePlayer.getX(), 2) + Math.pow(mine.getY() - thePlayer.getY(), 2));
         
         if (d > 800) 
         {
            allMines.remove(i);
         }
      }
   }
   
   // Method to check if the player and the mines collide
   public void checkMineCollisions() 
   {
      for (Mines mine : allMines) 
      {
         double distance = Math.sqrt(Math.pow(thePlayer.getX() - mine.getX(), 2) + Math.pow(thePlayer.getY() - mine.getY(), 2));
         if (distance < 15) 
         {    
            score = 0;
            newHighScore = 0;
            gameRunning = false;
         }
         
      }
   }

   
   public static void main(String[] args) 
   {
      launch(args);
   }
}