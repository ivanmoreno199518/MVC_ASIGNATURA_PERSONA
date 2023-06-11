package Controler.com.company;

import model.com.company.ModelPersonas;
import view.com.company.Persona.DialogoAddPersona;
import view.com.company.Persona.DialogoModifyPersona;
import view.com.company.Persona.ViewPanelPersona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControllerPersona implements MouseListener, WindowListener {
    private final ViewPanelPersona fr = new ViewPanelPersona("Persona");
    private final ModelPersonas model = new ModelPersonas();


    public ControllerPersona() {
        iniciarVentana();
        iniciarEventos();
        prepararBD();
    }

    private void prepararBD() {
        fr.getTable1().setModel(model.CargaDatos(null));
    }

    private void iniciarEventos() {
        fr.getAñadir().addActionListener(this::actionPerformed);
        fr.getEliminar().addActionListener(this::actionPerformed);
        fr.getModificar().addActionListener(this::actionPerformed);
        fr.getTable1().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_evt) {
                Point point = Mouse_evt.getPoint();
            }});
        fr.getPanel1().addMouseListener(this);
        fr.addWindowListener(this);
    }

    private void actionPerformed(ActionEvent actionEvent) {
        String entrada = actionEvent.getActionCommand();

        switch (entrada) {
            case "Añadir":
                new DialogoAddPersona(this.fr);
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
                    String [] array = new String[11];
                    for (int i = 0; i < 11; i++) {
                        if (fr.getTable1().getValueAt(fr.getTable1().getSelectedRow(),i) == null) {
                            array[i] = "";
                        } else {
                            array[i] = (String) fr.getTable1().getValueAt(fr.getTable1().getSelectedRow(), i);
                        }
                    }
                    new DialogoModifyPersona(this.fr,array);
                } else {
                    JOptionPane.showMessageDialog(this.fr,"DEBES SELECCIONAR ALGUNA FILA DE LA TABLA");
                }

                break;
        }
    }

    private void iniciarVentana() { fr.setVisible(true);}


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
