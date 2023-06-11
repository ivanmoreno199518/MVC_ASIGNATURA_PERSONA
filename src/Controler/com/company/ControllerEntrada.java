package Controler.com.company;

import Connecion.ConectionBD;
import view.com.company.*;
import javax.swing.*;
import java.awt.event.*;

public class ControllerEntrada implements ActionListener, WindowListener {
    private final ViewPanelEntrada frEntrada = new ViewPanelEntrada();

    public ControllerEntrada() {
        iniciarVentana();
        iniciarEventos();
    }

    public void iniciarVentana() {
        frEntrada.setVisible(true);
    }

    public void iniciarEventos() {
        frEntrada.getAsignaturasButton().addActionListener(this::actionPerformed);
        frEntrada.getPersonasButton().addActionListener(this::actionPerformed);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String entrada = e.getActionCommand();

        switch (entrada) {
            case "Asignaturas":
               new ControllerAsignatura();
               break;
            case "Personas":
                new ControllerPersona();
                break;
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        frEntrada.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ConectionBD.closeConn();
    }

    @Override
    public void windowOpened(WindowEvent e) {

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
