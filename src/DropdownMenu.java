import javax.swing.*;


public class DropdownMenu extends JPanel {

   
static final long serialVersionUID = 42L;

    private String[] s = {"Select Card Type", "Artifact", "Conspiracy", "Creature", "Enchantment", "Instant", "Land", "Planeswalker", "Sorcery"};
    private JComboBox dropDown = new JComboBox(s);


    public DropdownMenu() {


        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(dropDown);

    }
    // checks if a card type is selected
    public Boolean isTypeSelected() {
        if (String.valueOf(dropDown.getSelectedItem()) != "Select Card Type")
            return true;
        else  return false;
    }

    public String getSelected() {

        return String.valueOf(dropDown.getSelectedItem());
    }

}
