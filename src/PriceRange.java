import javax.swing.*;

public class PriceRange extends JPanel {

    JLabel label;
    JTextField rangeField;



    public PriceRange(String s) {
        label = new JLabel(s);
        this.add(label);
        rangeField = new JTextField(5);
        this.add(rangeField);
    }
}
