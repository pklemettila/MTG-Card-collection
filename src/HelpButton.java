import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpButton extends JButton {

public HelpButton(JFrame f) {

    this.setIcon(new ImageIcon(this.getClass().getResource("/images/help-placeholder.jpg")));
    this.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            JLabel Filler = new JLabel("");
            JDialog d = new JDialog(f, ("HELP"));
            d.setLayout(new BoxLayout(d.getContentPane(), BoxLayout.PAGE_AXIS));

            JLabel l1 = new JLabel("Use the search bar to search for cards by name, keyword or artist. Type card name, artist name or keyword");
            ImageIcon magGlass = (new ImageIcon(this.getClass().getResource("/images/maglass.png")));
            JLabel l2 = new JLabel("into the text input field and press the search icon.", magGlass, SwingConstants.TRAILING);
            l2.setHorizontalTextPosition(SwingConstants.LEADING);

            d.add(l1);
            d.add(l2);
            d.setSize(700,500);
            d.setLocation(500,300);
            d.setVisible(true);

        }
    });


}

}
