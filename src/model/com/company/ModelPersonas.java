package model.com.company;
import Connecion.ConectionBD;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
public class ModelPersonas {
    private Statement stmt;
    public ModelPersonas() {
        ConectionBD.openConn();
    }

    public DefaultTableModel CargaDatos(DefaultTableModel m) {
        String[] titulos = {"NIF", "Nombre", "Apellido1", "Apellido2", "Ciudad", "Dirección", "Teléfono", "Fecha Nacimiento", "Sexo", "Tipo", "ID"};
        m = new DefaultTableModel(null, titulos);

        try {
            stmt = ConectionBD.getStmt();
            ResultSet rs = stmt.executeQuery("select * from persona");
            String [] fields = {"nif","nombre","apellido1","apellido2","ciudad","direccion","telefono","fecha_nacimiento","sexo","tipo","id"};

            while (rs.next()) {
                String [] fila = new String[11];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getString(fields[i]);
                }
                m.addRow(fila);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return m;
    }
    public void deleteBD (String id) {
        try {
            stmt = ConectionBD.getStmt();
            String query = "DELETE FROM persona WHERE nif = '" + id + "';";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addBD (String [] array) {
        try {
            stmt = ConectionBD.getStmt();
            String query = "INSERT INTO Persona (nif, nombre, apellido1, apellido2, ciudad, direccion, telefono, fecha_nacimiento, sexo, tipo)" +
                        " VALUES ("
                        + "'" + array[0] +"',"
                        + "'" + array[1] +"',"
                        + "'" + array[2] +"',"
                        + "'" + array[3] +"',"
                        + "'" + array[4] +"',"
                        + "'" + array[5] +"',"
                        + "'" + array[6] +"',"
                        + "'" + array[7] +"',"
                        + "'" + array[8] +"',"
                        + "'" + array[9]
                        + "')";

            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void modifyBD(String[] data, String s) {
        try {
            stmt = ConectionBD.getStmt();
            String query = "UPDATE persona SET nif='" + data[0] + "', nombre='"
                    + data[1] + "', apellido1='" + data[2] + "', apellido2='" + data[3]
                    + "', ciudad='" + data[4] + "', direccion='" + data[5]
                    + "', telefono='" + data[6] + "', fecha_nacimiento='" + data[7] + "', sexo='" + data[8] +
                    "', tipo='" + data[9] + "' WHERE id=" + s;

            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
