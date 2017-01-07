import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tudengibaar");
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        //pane.setGridLinesVisible(true);
        pane.setHgap(50);
        pane.setVgap(20);

        Button Exit = new Button("Exit");
        pane.add(Exit, 2, 2);
        Exit.setMaxWidth(500);

        Button Addi = new Button("Add Inventory");pane.add(Addi, 0, 0);             //Lisan esimesele aknale nupud
        Button Viewi = new Button("View Inventory");pane.add(Viewi, 0, 1);
        Button Addr = new Button("Add Recipe");pane.add(Addr, 2, 0);
        Button Viewr = new Button("View Recipe"); pane.add(Viewr, 2, 1);

        Addi.setOnAction(e -> Stages.addInv());                                     //Nupuvajutuse puhul tuleb uus aken
        Viewi.setOnAction(e -> Stages.viewInv());
        Addr.setOnAction(e -> Stages.addRec());
        Viewr.setOnAction(e -> Stages.viewRec());
        Exit.setOnAction(e -> Platform.exit());                                     //Exit

        Scene Start = new Scene(pane);

        primaryStage.setScene(Start);
        primaryStage.show();
    }


}
