import javax.swing.*;
import java.awt.*;

public class PriceRange extends JPanel {
    static final long serialVersionUID = 42L;
    JLabel label;
    JTextField fromField;
    JTextField toField;


    public PriceRange() {

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        label = new JLabel("From:");
        this.add(label);
        fromField = new JTextField(5);
        this.add(fromField);
        JLabel toLabel = new JLabel("To:");
        this.add(toLabel);
        toField = new JTextField(5);
        this.add(toField);

    }
    //Returns whether or not 'from' has text
    public boolean fromHasText() {
        if (fromField.getText().isEmpty())
            return false;
        else return true;
    }
    //Returns whether or not 'to' has text
    public boolean toHasText() {       //Returns whether or not 'to' has text
        if (toField.getText().isEmpty())
            return false;
        else return true;
    }
    
    public double getFromNumber() {
        try {
            return Double.parseDouble(fromField.getText());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }


    public double getToNumber() {
        try {
            return Double.parseDouble(toField.getText());
        } catch (NumberFormatException e) {
            return 9999;
        }
    }

}
