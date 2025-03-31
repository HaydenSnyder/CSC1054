import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class ToDoClient extends Application
{
   ComboBox<String> dayPicker = new ComboBox<>();
   BorderPane root = new BorderPane();
   ListView<HBox> taskList = new ListView<>();
   TextField taskInput = new TextField();

   // Create the day ArrayLists of Task objects
   ArrayList<Task> mondayTasks = new ArrayList<>();
   ArrayList<Task> tuesdayTasks = new ArrayList<>();
   ArrayList<Task> wednesdayTasks = new ArrayList<>();
   ArrayList<Task> thursdayTasks = new ArrayList<>();
   ArrayList<Task> fridayTasks = new ArrayList<>();
   ArrayList<Task> saturdayTasks = new ArrayList<>();
   ArrayList<Task> sundayTasks = new ArrayList<>();

   public void start(Stage stage)
   {
      // Create the ComboBox for the choices
      dayPicker.getItems().addAll("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
      dayPicker.setValue("Monday");
      dayPicker.setOnAction(new ComboBoxListener());

      // Create an HBox to hold the dayPicker and align it to the top left
      HBox topLeftBox = new HBox(dayPicker);
      topLeftBox.setAlignment(Pos.TOP_LEFT);
      topLeftBox.setPadding(new Insets(10));

      // Create the Add Task Button and TextField
      taskInput.setPromptText("Enter your task here");
      taskInput.setPrefWidth(300);
      
      Button addTaskButton = new Button("Add Task");
      addTaskButton.setOnAction(new ButtonListener());

      // Layout for input and button
      HBox inputLayout = new HBox(10, taskInput, addTaskButton);
      inputLayout.setAlignment(Pos.CENTER);
      inputLayout.setPadding(new Insets(20));
      
      // Set up the root layout
      root.setTop(topLeftBox);       // Set dayPicker at the top left
      root.setCenter(taskList);      // Set task list at the center
      root.setBottom(inputLayout);   // Set input and button at the bottom

      // Create the scene and show the stage
      Scene scene = new Scene(root, 600, 400);
      stage.setScene(scene);
      stage.setTitle("To Do List");
      stage.show();
   } 
 
   
   // Create the EventHandler for button listener
   public class ButtonListener implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         addTask();
      }
   }

   // Create the EventHandler for ComboBox listener
   public class ComboBoxListener implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         String selectedDay = dayPicker.getValue();
         loadTasks(selectedDay);
      }
   }

   // Create a method to add Tasks
   private void addTask()
   {
      String task = taskInput.getText();
      if(!task.isEmpty())
      {
         Task newTask = new Task(task); // Create new Task object
         String selectedDay = dayPicker.getValue();

         // Add task to the corresponding day's list
         switch(selectedDay)
         {
            case "Monday":
               mondayTasks.add(newTask);
               break;
            
            case "Tuesday":
               tuesdayTasks.add(newTask);
               break;
            
            case "Wednesday":
               wednesdayTasks.add(newTask);
               break;
            
            case "Thursday":
               thursdayTasks.add(newTask);
               break;
            
            case "Friday":
               fridayTasks.add(newTask);
               break;
            
            case "Saturday":
               saturdayTasks.add(newTask);
               break;
            case "Sunday":
               sundayTasks.add(newTask);
         }

         // Create HBox to display task
         HBox taskHBox = new HBox();
         Label taskLabel = new Label(task);
         
         // Create ComboBox to mark task as completed
         ComboBox<String> colorComboBox = new ComboBox<>();
         colorComboBox.getItems().addAll("Not Completed", "Completed");
         colorComboBox.setValue("Not Completed");
         
         // Listen to ComboBox changes
         colorComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
         
         if (newValue.equals("Completed")) 
         {
            taskLabel.setTextFill(Color.GREEN);
            newTask.setCompleted(true); // Mark task as completed
         } 
         else 
         {
            taskLabel.setTextFill(Color.BLACK);
            newTask.setCompleted(false); // Reset task completion
         }
      });

      taskHBox.getChildren().addAll(taskLabel, colorComboBox);
      taskHBox.setSpacing(10);

      // Add task to the task list display
      taskList.getItems().add(taskHBox);
      taskInput.clear();
      }
   }

   // Load tasks for the selected day
   private void loadTasks(String day)
   {
      ArrayList<Task> tasksToLoad = new ArrayList<>();
      
      switch(day)
      {
         case "Monday":
            tasksToLoad = mondayTasks;
            break;
            
         case "Tuesday":
            tasksToLoad = tuesdayTasks;
            break;
            
         case "Wednesday":
            tasksToLoad = wednesdayTasks;
            break;
            
         case "Thursday":
             tasksToLoad = thursdayTasks;
             break;
             
         case "Friday":
             tasksToLoad = fridayTasks;
             break;
             
         case "Saturday":
             tasksToLoad = saturdayTasks;
             break;
             
         case "Sunday":
            tasksToLoad = sundayTasks;
            break;
     }
   
     taskList.getItems().clear(); // Clear previous tasks
     
     for (Task task : tasksToLoad)
     {
         HBox taskHBox = new HBox();
         Label taskLabel = new Label(task.getDescription());
   
         // Set the color based on completion status
         if (task.isCompleted()) 
         {
            taskLabel.setTextFill(Color.GREEN);
         } 
         else 
         {
            taskLabel.setTextFill(Color.BLACK);
         }

         // Create ComboBox for changing completion status
         ComboBox<String> colorComboBox = new ComboBox<>();
         colorComboBox.getItems().addAll("Not Completed", "Completed");
         colorComboBox.setValue(task.isCompleted() ? "Completed" : "Not Completed");

         // Listen to ComboBox changes
         colorComboBox.valueProperty().addListener((observable, oldValue, newValue) -> 
         {
            if (newValue.equals("Completed")) 
            {  
               taskLabel.setTextFill(Color.GREEN);
               task.setCompleted(true); // Mark task as completed
             } 
             else 
             {
               taskLabel.setTextFill(Color.BLACK);
               task.setCompleted(false); // Reset task completion
             }
         });

         taskHBox.getChildren().addAll(taskLabel, colorComboBox);
         taskHBox.setSpacing(10);

         taskList.getItems().add(taskHBox);
      }
   }

   // Launch the GUI
   public static void main(String[] args)
   {
      launch(args);
   }
}
