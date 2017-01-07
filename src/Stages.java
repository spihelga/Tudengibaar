import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Sander on 12/29/2016.
 */
public class Stages {
    public static void addInv() {
        Stage window = new Stage();
        window.setTitle("Add Inventory");
        window.initModality(Modality.APPLICATION_MODAL);                //Uue aknaga peab enne tegelema
        GridPane pane = new GridPane();
        Scene adds = new Scene(pane);

        Label label = new Label("Beverages");
        pane.add(label, 3, 0);
        Label label2 = new Label("Minerals");
        pane.add(label2, 0, 0);
        Label label3 = new Label("Coca-Cola");
        pane.add(label3, 0, 1);
        Label label4 = new Label("Rum");
        pane.add(label4, 3, 1);
        Label label5 = new Label("Quantity");
        pane.add(label5, 1, 0);
        Label label6 = new Label("Quantity");
        pane.add(label6, 4, 0);

        Button submit = new Button("Submit");
        pane.add(submit, 4, 4);

        TextField cola = new TextField();
        pane.add(cola, 1, 1);
        cola.setPrefWidth(20);
        cola.setText("0");
        TextField rum = new TextField();
        pane.add(rum, 4, 1);
        rum.setPrefWidth(20);
        rum.setText("0");

        submit.setOnAction(event -> {
            Methods.addBev("Rum", Double.valueOf(rum.getText()));
            Methods.addMin("Cola", Double.valueOf(cola.getText()));
            window.close();
        });
        pane.setHgap(50);
        pane.setVgap(20);

        window.setScene(adds);
        window.show();
    }

    public static void viewInv() {

        Stage window = new Stage();
        window.setTitle("Viev Inventory");
        window.initModality(Modality.APPLICATION_MODAL);
        GridPane pane = new GridPane();
        Scene views = new Scene(pane);

        Label label = new Label("Beverages");
        pane.add(label, 3, 0);
        Label label2 = new Label("Minerals");
        pane.add(label2, 0, 0);
        Label label3 = new Label("Coca-Cola");
        pane.add(label3, 0, 1);
        Label label4 = new Label("Rum");
        pane.add(label4, 3, 1);
        Label label5 = new Label("Quantity");
        pane.add(label5, 1, 0);
        Label label6 = new Label("Quantity");
        pane.add(label6, 4, 0);
        Button exit = new Button("Exit");
        pane.add(exit, 4, 4);

        Label cola = new Label(String.valueOf(Methods.getMineral("Cola")));
        pane.add(cola, 1, 1);

        Label rum = new Label(String.valueOf(Methods.getBeverage("Rum")));
        pane.add(rum, 4, 1);

        exit.setOnAction(event -> {
            window.close();
        });

        pane.setHgap(50);
        pane.setVgap(20);

        window.setScene(views);
        window.show();
    }

    public static void addRec() {
        Stage window = new Stage();
        window.setTitle("Add Recipe");
        window.initModality(Modality.APPLICATION_MODAL);
        GridPane pane = new GridPane();
        Scene adds = new Scene(pane);

        Label label = new Label("Beverages");
        pane.add(label, 3, 0);
        Label label2 = new Label("Minerals");
        pane.add(label2, 0, 0);
        Label label3 = new Label("Coca-Cola");
        pane.add(label3, 0, 1);
        Label label4 = new Label("Rum");
        pane.add(label4, 3, 1);
        Label label5 = new Label("Quantity");
        pane.add(label5, 1, 0);
        Label label6 = new Label("Quantity");
        pane.add(label6, 4, 0);
        Label label7 = new Label("Recipe name");
        pane.add(label7, 0, 4);

        Button submit = new Button("Submit");
        pane.add(submit, 4, 4);

        TextField cola = new TextField();
        pane.add(cola, 1, 1);
        cola.setPrefWidth(20);
        cola.setText("0");

        TextField rum = new TextField();
        pane.add(rum, 4, 1);
        rum.setPrefWidth(20);
        rum.setText("0");

        TextField rename = new TextField();
        rename.setPromptText("Name");
        pane.add(rename, 1, 4);
        rename.setPrefWidth(35);

        submit.setOnAction(event -> {
            Methods.addRec(rename.getText(), Double.valueOf(rum.getText()), Double.valueOf(cola.getText()));
            window.close();
        });
        pane.setHgap(50);
        pane.setVgap(20);

        window.setScene(adds);
        window.show();
    }

    public static void viewRec() {
        Stage window = new Stage();
        window.setTitle("View Recipe");
        window.initModality(Modality.APPLICATION_MODAL);
        GridPane pane = new GridPane();
        //pane.setGridLinesVisible(true);
        Scene views = new Scene(pane);

        Label label = new Label("Name");
        pane.add(label, 0, 0);
        Label label2 = new Label("Ingredients");
        pane.add(label2, 1, 0);
        Label label3 = new Label("Vol %");
        pane.add(label3, 2, 0);
        Label label4 = new Label("x250 ml");
        pane.add(label4, 3, 0);
        Button exit = new Button("Exit");
        pane.add(exit, 3, Save.myRecipes.size() + 2);

        String[] name = new String[Save.myRecipes.size()];
        String[] ing = new String[Save.myRecipes.size()];
        Double[] vol = new Double[Save.myRecipes.size()];
        Double[] glass = new Double[Save.myRecipes.size()];

        for (int i = 0; i < Save.myRecipes.size(); i++) {
            name[i] = Save.myRecipes.get(i).getName();
            pane.add(new Label(name[i]), 0, i + 1);
                                                                                                                                    //Näitab koostisosade suhet
            ing[i] = Save.myRecipes.get(i).getBev1().getName() + " " + Save.myRecipes.get(i).getBev1().getQuantity()
                    + " Liters, " + Save.myRecipes.get(i).getMin1().getName() + " " + Save.myRecipes.get(i).getMin1().getQuantity() + " Liters ";
            pane.add(new Label(ing[i]), 1, i + 1);

            vol[i] = (Save.myRecipes.get(i).getBev1().getQuantity() * (Save.vol * 0.01)) /                                          //Arvutab kokteili kanguse
                    (Save.myRecipes.get(i).getMin1().getQuantity() + (Save.myRecipes.get(i).getBev1().getQuantity())) * 100;
            pane.add(new Label(String.valueOf((Math.round(vol[i])))), 2, i + 1);

            glass[i] = Methods.calc(Save.myRecipes.get(i));
            pane.add(new Label(String.valueOf((Math.round(glass[i])))), 3, i + 1);
        }
        exit.setOnAction(event -> {
            window.close();
        });
        pane.setHgap(50);
        pane.setVgap(20);
        window.setScene(views);
        window.show();
    }
}
