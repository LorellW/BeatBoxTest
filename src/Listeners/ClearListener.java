package Listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClearListener implements ActionListener {
    private ArrayList<JCheckBox> checkBoxList;

    public ClearListener(ArrayList<JCheckBox> checkBoxList) {
        this.checkBoxList = checkBoxList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JCheckBox checkBox: checkBoxList) {
            checkBox.setSelected(false);
        }
    }
}
