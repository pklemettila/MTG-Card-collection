import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBar extends JPanel {



    public SearchBar() {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        JTextField searchField = new JTextField();
        searchField.setBorder(BorderFactory.createEmptyBorder());
        JButton searchButton = new JButton(new ImageIcon(this.getClass().getResource("images/maglass.png")));
        Border lowbevelborder = BorderFactory.createLoweredBevelBorder();
        this.setBorder(lowbevelborder);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // nothing happens
            }
        });


        this.add(searchField);
        this.add(searchButton);

    }


}
