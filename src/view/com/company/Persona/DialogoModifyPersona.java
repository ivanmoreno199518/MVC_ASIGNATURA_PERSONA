package view.com.company.Persona;

import model.com.company.ModelPersonas;
import view.com.company.DialogoPersona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoModifyPersona extends DialogoPersona {
    ModelPersonas model = new ModelPersonas();

    public DialogoModifyPersona(ViewPanelPersona fr, String [] array) {

        rellenaCamposDialogo(array);

        super.getButtonOK().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String [] data = rellenaCamposOk();

                if (compruebaNulos(data)) {
                    model.modifyBD(data,array[10]);
                    fr.getTable1().setModel(model.CargaDatos(null));
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(getButtonOK(),"Debes rellenar todos los campos.");
                }
            }
        });
    }
}
