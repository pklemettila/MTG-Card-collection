import javax.swing.*;

public class DropdownMenu extends JPanel {

    private JComboBox dropDown;

    public DropdownMenu(String[] s) {


        dropDown = new JComboBox(s);
        this.add(dropDown);

    }



}
