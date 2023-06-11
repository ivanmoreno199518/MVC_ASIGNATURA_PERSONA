package view.com.company.Asignatura;

import model.com.company.ModelAsignaturas;
import view.com.company.DialogoAsignatura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoAddAsignatura extends DialogoAsignatura {
    ModelAsignaturas m = new ModelAsignaturas();

    public DialogoAddAsignatura(ViewPanelAsignatura fr) {

        super.getButtonOK().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] array = rellenaCamposOk();

                if (compruebaNulos(array)) {
                    m.addBD(array);
                    fr.getTable1().setModel(m.CargaDatos(null));
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(getButtonOK(),"Todos los campos deben estar rellenos.");
                }
            }
        });
    }
}
