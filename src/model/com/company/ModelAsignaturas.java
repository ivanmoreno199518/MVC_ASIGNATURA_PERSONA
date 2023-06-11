package model.com.company;

import Connecion.ConectionBD;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelAsignaturas {

    private Statement stmt;

    public DefaultTableModel CargaDatos(DefaultTableModel m) {

        String[] titulos = {"ID", "Nombre", "Créditos", "Tipo", "Curso", "Cuatrimestre", "Id Profesor", "Id Grado"};
        m = new DefaultTableModel(null, titulos);

        try {
            stmt = ConectionBD.getStmt();

            ResultSet rs = stmt.executeQuery("select * from asignatura");
            String [] fields = {"id","nombre","creditos","tipo","curso","cuatrimestre","id_profesor","id_grado"};

            while (rs.next()) {
                String [] data = new String[8];
                for (int i = 0; i < data.length; i++) {
                    data[i] = rs.getString(fields[i]);
                }
                m.addRow(data);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return m;
    }

    public void addBD (String [] array) {
        try {
            stmt = ConectionBD.getStmt();
            String query = "INSERT INTO Asignatura (nombre, creditos, tipo, curso, cuatrimestre, id_profesor, id_grado)" +
                        " VALUES ("
                        + "'" + array[0] +"',"
                        + "'" + array[1] +"',"
                        + "'" + array[2] +"',"
                        + "'" + array[3] +"',"
                        + "'" + array[4] +"',"
                        + "'" + array[5] +"',"
                        + "'" + array[6]
                        + "')";

                stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void deleteBD (String id) {
        try {
            stmt = ConectionBD.getStmt();
            String query = "DELETE FROM asignatura WHERE id = " + id + ";";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void modifyBD (String [] data, String id) {
        try {
            stmt = ConectionBD.getStmt();
            String query = "UPDATE asignatura SET nombre='" + data[0] + "', creditos="
                    + data[1] + ", tipo='" + data[2] + "', curso=" + data[3]
                    + ", cuatrimestre=" + data[4] + ", id_profesor=" + data[5]
                    + ", id_grado=" + data[6] + " WHERE id=" + id;
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
