import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBar extends JPanel {


    private JButton searchButton;
    private JTextField searchField;

     public SearchBar() {

        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        searchField = new JTextField();
        searchField.setBorder(BorderFactory.createEmptyBorder());
        searchButton = new JButton(new ImageIcon(this.getClass().getResource("images/maglass.png")));
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

    public void makeSearchClickable(ActionListener actionListener) {

    searchButton.addActionListener(actionListener);

    }

    public boolean hasText() {
         if (searchField.getText().isEmpty())
             return false;
         else return true;
    }
    public String getText() {
         return searchField.getText();
    }
}
