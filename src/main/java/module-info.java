module projectdrivers {
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;

    //PONER CLASE APP MAIN
    opens projectdrivers.App to javafx.fxml;
    //AGREGAR MODULOS Q SE USARAN
    opens projectdrivers.Model;
    opens projectdrivers.Controller;
    opens projectdrivers.Repository;


    //EXPORT MAIN CLASS
    exports projectdrivers.App;
}
