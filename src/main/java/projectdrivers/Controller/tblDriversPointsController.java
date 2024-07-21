package projectdrivers.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import projectdrivers.Model.Drivers;
import projectdrivers.Repository.RepositoryDriverPoints;

public class tblDriversPointsController implements Initializable {

    @FXML
    private TableColumn<Drivers, String> clmConductores;

    @FXML
    private TableColumn<Drivers, Float> clmPoints; // Usa Float en lugar de float

    @FXML
    private TableView<Drivers> tblDrivers;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Configurar el cellValueFactory para las columnas
        clmConductores.setCellValueFactory(new PropertyValueFactory<>("NameDriver")); // Asegúrate de que el nombre coincida con el getter en Drivers
        clmPoints.setCellValueFactory(new PropertyValueFactory<>("PointsDriver")); // Asegúrate de que el nombre coincida con el getter en Drivers
        cargarDriversPoints();

    }

    private void cargarDriversPoints() {
        RepositoryDriverPoints objDriverPoints = new RepositoryDriverPoints();
		List<Drivers> ls_d = objDriverPoints.getDriversPoints();
        tblDrivers.getItems().addAll(ls_d);
    }
}
