import javax.swing.*;

public class DropdownMenu extends JPanel {

    private JComboBox dropDown;

    public DropdownMenu(String[] s) {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        dropDown = new JComboBox(s);
        this.add(dropDown);

    }



}
