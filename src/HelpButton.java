import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpButton extends JButton {


public HelpButton(JFrame f) {

    this.setIcon(new ImageIcon(this.getClass().getResource("/images/Help.png")));
    this.setBorder(BorderFactory.createEmptyBorder());
    this.setContentAreaFilled(false);
    this.addActionListener(new ActionListener() {  // Opening the help window with an action listener
        @Override
        public void actionPerformed(ActionEvent e) {

            new HelpWindow(f);
            ;


        }


    });



}

}
