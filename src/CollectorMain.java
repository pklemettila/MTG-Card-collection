//on windows: java -classpath ".;sqlite-jdbc-3.32.3.2.jar" CollectorMain
//on linux: java -classpath ".:sqlite-jdbc-3.32.3.2.jar" CollectorMain

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CollectorMain {

    public static void main(String[] args) {

        Database DB = new Database();

        JFrame f = new JFrame();
        JButton b = new JButton("Click here");
        b.setBounds(50, 50, 200, 40);
        final JLabel tf = new JLabel();
        tf.setBounds(75, 150, 200, 30);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("Well clicked my friend!");
            }
        });


        f.add(b);
        f.add(tf);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
        
    }
}

