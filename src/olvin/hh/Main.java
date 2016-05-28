package olvin.hh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        /*
        - сохранять последнее положение и др. настройки
        - менять прозрачность по колесу
        */

        myJFrame myWindow = new myJFrame("Ruler");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setSize(400, 300);
        myWindow.setUndecorated(true);
        myWindow.setBackground(new Color(0, 0, 0, 100));
        myWindow.setLocation(200, 100);
        myWindow.setVisible(true);

        /*
        final JButton button1 = new JButton("Go!");
        myWindow.add(button1);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1.setText("!!!");
            }
        });
        */
    }
}
