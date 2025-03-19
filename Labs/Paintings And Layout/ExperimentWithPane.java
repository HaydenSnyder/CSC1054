import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;

public class ExperimentWithPane extends Application {
    public void start(Stage stage) {
        BorderPane outerPane = new BorderPane();
        outerPane.setPrefSize(600, 500);

        // Outer Top Flowpane
        FlowPane top = new FlowPane();
        top.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        top.setPrefSize(50, 50);
        top.setAlignment(Pos.CENTER);
        top.getChildren().add(new Label("Top"));
        
        // Outer Bottom Flowpane
        FlowPane bottom = new FlowPane();
        bottom.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        bottom.setPrefSize(50, 50);
        bottom.setAlignment(Pos.CENTER);
        bottom.getChildren().add(new Label("Bottom"));

        // Outer Left Flowpane
        FlowPane left = new FlowPane();
        left.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, CornerRadii.EMPTY, Insets.EMPTY)));
        left.setPrefSize(50, 50);
        left.setAlignment(Pos.CENTER);
        left.getChildren().add(new Label("Left"));

        // Outer Right Flowpane
        FlowPane right = new FlowPane();
        right.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, CornerRadii.EMPTY, Insets.EMPTY)));
        right.setPrefSize(50, 50);
        right.setAlignment(Pos.CENTER);
        right.getChildren().add(new Label("Right"));

        // Center Flowpane
        FlowPane center = new FlowPane();
        center.setPrefSize(50, 50);
        center.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        center.setAlignment(Pos.CENTER);
        
 

        // Add outer BorderPane sections
        outerPane.setRight(right);
        outerPane.setLeft(left);
        outerPane.setCenter(center);
        outerPane.setTop(top);
        outerPane.setBottom(bottom);

        // Inner BorderPane inside the center
        BorderPane innerPane = new BorderPane();
        innerPane.setPrefWidth(300); 
        innerPane.setPrefHeight(300);
        
        // Inner top FlowPane
        FlowPane topInner = new FlowPane();
        topInner.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, CornerRadii.EMPTY, Insets.EMPTY)));
        topInner.setPrefSize(50, 50);
        topInner.setAlignment(Pos.CENTER);
        topInner.getChildren().add(new Label("Inner Top"));

        // Inner Bottom FlowPane
        FlowPane bottomInner = new FlowPane();
        bottomInner.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, CornerRadii.EMPTY, Insets.EMPTY)));
        bottomInner.setPrefSize(50, 50);
        bottomInner.setAlignment(Pos.CENTER);
        bottomInner.getChildren().add(new Label("Inner Bottom"));

        // Inner Left FlowPane
        FlowPane leftInner = new FlowPane();
        leftInner.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        leftInner.setPrefSize(50, 50);
        leftInner.setAlignment(Pos.CENTER);
        leftInner.getChildren().add(new Label("Inner Left"));

        // Inner Right FlowPane
        FlowPane rightInner = new FlowPane();
        rightInner.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        rightInner.setPrefSize(50, 50);
        rightInner.setAlignment(Pos.CENTER);
        rightInner.getChildren().add(new Label("Inner Right"));

        // Center of the inner BorderPane
        FlowPane centerInner = new FlowPane();
        centerInner.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        centerInner.setPrefSize(50, 50);
        centerInner.setAlignment(Pos.CENTER);
        centerInner.getChildren().add(new Label("Inner Center"));

        // Add inner sections to innerPane
        innerPane.setTop(topInner);
        innerPane.setBottom(bottomInner);
        innerPane.setLeft(leftInner);
        innerPane.setRight(rightInner);
        innerPane.setCenter(centerInner);

        // Add inner BorderPane inside the center FlowPane
        center.getChildren().add(innerPane);

        // Create first VBox with clean colors
        VBox vbox1 = new VBox();
        vbox1.setBackground(new Background(new BackgroundFill(Color.MINTCREAM, CornerRadii.EMPTY, Insets.EMPTY)));
        vbox1.setPrefSize(50, 50);
        vbox1.setSpacing(10);
        vbox1.getChildren().add(new Label("Vbox 1"));

        // Create second VBox with clean colors
        VBox vbox2 = new VBox();
        vbox2.setBackground(new Background(new BackgroundFill(Color.LAVENDERBLUSH, CornerRadii.EMPTY, Insets.EMPTY)));
        vbox2.setPrefSize(50, 50);
        vbox2.setSpacing(10);
        vbox2.getChildren().add(new Label("Vbox 2"));

        // Create first HBox with clean colors
        HBox hbox1 = new HBox();
        hbox1.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));
        hbox1.setPrefSize(200, 100);
        hbox1.setSpacing(10);
        hbox1.getChildren().add(new Label("Hbox 1"));

        // Create second HBox with clean colors
        HBox hbox2 = new HBox();
        hbox2.setBackground(new Background(new BackgroundFill(Color.PALETURQUOISE, CornerRadii.EMPTY, Insets.EMPTY)));
        hbox2.setPrefSize(200, 100);
        hbox2.setSpacing(20);
        hbox2.getChildren().add(new Label("Hbox 2"));

        // Add HBoxes and VBoxes inside the centerInner FlowPane
        centerInner.getChildren().addAll(hbox1, hbox2, vbox1, vbox2);

        // Scene setup
        Scene scene = new Scene(outerPane, 600, 500);
        stage.setScene(scene);
        stage.setTitle("Cleaner Layouts");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
