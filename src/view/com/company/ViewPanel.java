package view.com.company;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public abstract class ViewPanel extends JFrame {

    private JPanel panel1;
    private JButton Añadir;
    private JButton Eliminar;
    private JButton Modificar;
    private JTable table1;

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public void setModificar(JButton modificar) {
        Modificar = modificar;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public void setAñadir(JButton añadir) {
        Añadir = añadir;
    }

    public void setEliminar(JButton eliminar) {
        Eliminar = eliminar;
    }

    public JButton getAñadir() {
        return Añadir;
    }

    public JButton getEliminar() {
        return Eliminar;
    }

    public JButton getModificar() {
        return Modificar;
    }

    public JTable getTable1() {
        return table1;
    }

    public ViewPanel(String titulo) {
        super(titulo);
        setContentPane(panel1);
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        setSize(ancho, alto);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table1.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                table1.scrollRectToVisible(table1.getCellRect(table1.getRowCount()-1, 0, true));
            }
        });
    }



}
