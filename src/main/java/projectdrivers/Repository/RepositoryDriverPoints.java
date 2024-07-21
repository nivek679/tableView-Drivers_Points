package projectdrivers.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import projectdrivers.Model.ConnectionDB;
import projectdrivers.Model.Drivers;

public class RepositoryDriverPoints {

    public List<Drivers> getDriversPoints() {
        List<Drivers> listaDriversLocal = new ArrayList<>();
        ConnectionDB connDB = new ConnectionDB();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = connDB.establecerConexion();
            String sql = "SELECT " +
                         "    CONCAT(d.forename, ' ', d.surname) AS driver_name, " +
                         "    SUM(r.points) AS total_points " +
                         "FROM " +
                         "    results r " +
                         "JOIN " +
                         "    drivers d ON r.driver_id = d.driver_id " +
                         "GROUP BY " +
                         "    d.forename, d.surname " +
                         "ORDER BY " +
                         "    total_points DESC " +
                         "LIMIT 50;";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("driver_name");
                float points = rs.getFloat("total_points");
                Drivers driver = new Drivers(name,points);
                listaDriversLocal.add(driver);
            }

        } catch (Exception e) {
            System.out.println("No se completó la carga de los datos.");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return listaDriversLocal;
    }

    public static void main(String[] args) {
        RepositoryDriverPoints repo = new RepositoryDriverPoints();
        List<Drivers> driversList = repo.getDriversPoints();

        // Imprimir encabezado de la tabla
        System.out.printf("%-30s %10s%n", "Driver Name", "Total Points");

        // Imprimir cada registro con formato
        for (Drivers driver : driversList) {
            System.out.printf("%-30s %10.2f%n",
                    driver.getNameDriver(),
                    driver.getPointsDriver());
        }
    }
}
