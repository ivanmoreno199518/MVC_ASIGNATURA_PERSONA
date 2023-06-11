package view.com.company.Asignatura;

import model.com.company.ModelAsignaturas;
import view.com.company.DialogoAsignatura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoModifyAsignatura extends DialogoAsignatura {
    ModelAsignaturas model = new ModelAsignaturas();
    public DialogoModifyAsignatura(ViewPanelAsignatura fr, String [] array) {

        rellenaCamposDialogo(array);

        super.getButtonOK().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String [] data = rellenaCamposOk();

                if (compruebaNulos(data)) {
                    model.modifyBD(data,array[0]);
                    fr.getTable1().setModel(model.CargaDatos(null));
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(getButtonOK(),"Todos los campos deben estar rellenos.");
                }
            }
        });
    }

}
