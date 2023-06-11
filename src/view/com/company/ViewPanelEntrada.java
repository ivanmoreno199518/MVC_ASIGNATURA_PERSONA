package view.com.company;

import javax.swing.*;

public class ViewPanelEntrada extends JFrame {

    private JPanel panelEntrada;
    private JButton Asignaturas;
    private JButton Personas;


    public ViewPanelEntrada() {

        super("Panel de entrada");
        setContentPane(panelEntrada);
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        setSize(ancho, alto);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public JPanel getPanelEntrada() {
        return panelEntrada;
    }

    public void setPanelEntrada(JPanel panelEntrada) {
        this.panelEntrada = panelEntrada;
    }

    public JButton getAsignaturasButton() {
        return Asignaturas;
    }

    public void setAsignaturasButton(JButton asignaturasButton) {
        this.Asignaturas = asignaturasButton;
    }

    public JButton getPersonasButton() {
        return Personas;
    }

    public void setPersonasButton(JButton personasButton) {
        this.Personas = personasButton;
    }


}
