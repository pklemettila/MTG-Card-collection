import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropdownMenu extends JPanel {

    private String[] s = {"Card Type", "Artifact", "Conspiracy", "Creature", "Enchantment", "Instant", "Land", "Planeswalker", "Sorcery"};
    private JComboBox dropDown = new JComboBox(s);
    private Boolean wasClicked = false;

    public DropdownMenu() {


        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        dropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if (wasClicked == false && dropDown.getSelectedIndex() != 0) {
                     dropDown.removeItemAt(0);
                     wasClicked = true;
                }
            }
        });


        this.add(dropDown);



    }

    public Boolean isTypeSelected() {
        if (String.valueOf(dropDown.getSelectedItem())!= "Card Type")
            return true;
        else  return false;
    }

    public String getSelected() {

        return String.valueOf(dropDown.getSelectedItem());
    }

}
