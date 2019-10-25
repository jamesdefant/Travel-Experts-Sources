package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//Olexiy Alex Tatarov +  Salah + James + Raman


//JDK option with 1.8_221 works

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


       Parent root = FXMLLoader.load(getClass().getResource("ExampleLayoutAlexOrigin.fxml"));
        primaryStage.setTitle("Hello Agent");
        primaryStage.setScene(new Scene(root));
      //  primaryStage.setResizable(false);
        primaryStage.show();

        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800);
        primaryStage.setMaxHeight(720);
        primaryStage.setMaxWidth(1800);


     //   primaryStage.setMinWidth(primaryStage.getWidth());
     //   primaryStage.setMinHeight(primaryStage.getHeight());

    }


    public static void main(String[] args) {
        launch(args);
    }
}
