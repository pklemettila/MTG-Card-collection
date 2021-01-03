import javax.swing.*;
import java.awt.*;

public class PriceRange extends JPanel {

    JLabel label;
    JTextField rangeField;
    JTextField rangeField2;


    public PriceRange() {

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        label = new JLabel("From:");
        this.add(label);
        rangeField = new JTextField(5);
        this.add(rangeField);
        JLabel toLabel = new JLabel("To:");
        this.add(toLabel);
        rangeField2 = new JTextField(5);
        this.add(rangeField2);

    }
}
