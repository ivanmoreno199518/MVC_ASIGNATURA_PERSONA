package Controler.com.company;

import model.com.company.ModelAsignaturas;
import view.com.company.Asignatura.DialogoAddAsignatura;
import view.com.company.Asignatura.DialogoModifyAsignatura;
import view.com.company.Asignatura.ViewPanelAsignatura;

import javax.swing.*;
import java.awt.event.*;

public class ControllerAsignatura implements ActionListener, MouseListener, WindowListener, KeyListener{
    private final ViewPanelAsignatura fr = new ViewPanelAsignatura("Asignatura");
    private final ModelAsignaturas model = new ModelAsignaturas();

    public ControllerAsignatura() {
        iniciarVentana();
        iniciarEventos();
        prepararBD();
    }

    private void iniciarVentana() {
        fr.setVisible(true);
    }

    private void prepararBD() {
        fr.getTable1().setModel(model.CargaDatos(null));
    }

    private void iniciarEventos() {
        fr.getAñadir().addActionListener(this::actionPerformed);
        fr.getEliminar().addActionListener(this::actionPerformed);
        fr.getModificar().addActionListener(this::actionPerformed);
        fr.getTable1().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_evt) {}});
        fr.getPanel1().addMouseListener(this);
        fr.addWindowListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String entrada = e.getActionCommand();

        switch (entrada) {
            case "Añadir":
                new DialogoAddAsignatura(this.fr);
                break;
            case "Eliminar":
                if (fr.getTable1().getSelectedRow() != -1) {
                    String id = (String) fr.getTable1().getValueAt(fr.getTable1().getSelectedRow(), 0);
                    model.deleteBD(id);
                    prepararBD();
                } else {
                    JOptionPane.showMessageDialog(this.fr,"DEBES SELECCIONAR ALGUNA FILA DE LA TABLA");
                }
                break;
            case "Modificar":
                if (fr.getTable1().getSelectedRow() != -1) {
                    String [] array = rellenaDialogo();
                    new DialogoModifyAsignatura(this.fr, array);
                } else {
                    JOptionPane.showMessageDialog(this.fr,"DEBES SELECCIONAR ALGUNA FILA DE LA TABLA");
                }
                break;
        }
    }

    private String[] rellenaDialogo() {
        String [] array = new String[8];
        for (int i = 0; i < 8; i++) {
            if (fr.getTable1().getValueAt(fr.getTable1().getSelectedRow(), i) == null) {
                array[i] = "";
            } else {
                array[i] = (String) fr.getTable1().getValueAt(fr.getTable1().getSelectedRow(), i);
            }
        }
        return array;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        fr.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }


}
