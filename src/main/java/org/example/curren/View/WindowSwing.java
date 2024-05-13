package org.example.curren.View;

import org.example.curren.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.io.StringWriter;
import java.util.Scanner;

public class WindowSwing {
    private final JDialog jDialog;
    public WindowSwing(Controller controller) {
        JLabel textNumber = new JLabel();
        var am = controller.getCurrencies();
        var result = String.valueOf(Double.parseDouble(am.getEdWallet()) * Double.parseDouble(am.getWallet()));
        textNumber.setText(am.getEdWallet() + " = " + result + "rub");
        jDialog = new JDialog();
        jDialog.add(textNumber);

        jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jDialog.setSize(317,157);
        jDialog.setLocationRelativeTo(null);
    }
    public void showConsole(){
        jDialog.setVisible(true);
    }
}
