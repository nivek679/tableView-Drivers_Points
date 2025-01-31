package projectdrivers.App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage arg0) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/projectdrivers/View/resources/fxml/DriversPointsView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        arg0.setTitle("DRIVER POINTS");
        arg0.setScene(scene);
        arg0.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
