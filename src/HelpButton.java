import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpButton extends JButton {


public HelpButton(JFrame f) {

    this.setIcon(new ImageIcon(this.getClass().getResource("/images/Help.png")));
    this.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            new HelpWindow(f);

        }


    });



}

}
