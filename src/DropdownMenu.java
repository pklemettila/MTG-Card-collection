import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropdownMenu extends JPanel {

    private String[] s = {"All Card Types", "Artifact", "Conspiracy", "Creature", "Enchantment", "Instant", "Land", "Planeswalker", "Sorcery"};
    private JComboBox dropDown = new JComboBox(s);
    private Boolean wasClicked = false;

    public DropdownMenu() {


        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(dropDown);



    }

    public Boolean isTypeSelected() {
        if (String.valueOf(dropDown.getSelectedItem()) != "All Card Types")
            return true;
        else  return false;
    }

    public String getSelected() {

        return String.valueOf(dropDown.getSelectedItem());
    }

}
