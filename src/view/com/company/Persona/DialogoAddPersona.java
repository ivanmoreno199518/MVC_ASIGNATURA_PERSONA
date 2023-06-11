package view.com.company.Persona;

import model.com.company.ModelPersonas;
import view.com.company.DialogoPersona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoAddPersona extends DialogoPersona {
    ModelPersonas m = new ModelPersonas();
    public DialogoAddPersona (ViewPanelPersona fr) {


        super.getButtonOK().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] array = rellenaCamposOk();

                if (compruebaNulos(array)) {
                    m.addBD(array);
                    fr.getTable1().setModel(m.CargaDatos(null));
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(DialogoAddPersona.super.getButtonOK(), "Todos los campos deben estar rellenos");
                }
            }
        });
    }
}
