import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class HelpButton extends JButton {

    static final long serialVersionUID = 42L;

    public HelpButton(JFrame f) {

        this.setIcon(
                new ImageIcon(this.getClass().getResource(File.separator + "images" + File.separator + "Help.png")));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);

        // Opening the help window with an action listener
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HelpWindow(f);

            }
        });
    }

}
