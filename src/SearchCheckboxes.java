import javax.swing.*;

public class SearchCheckboxes extends JPanel {

    JCheckBox param1 = new JCheckBox("Name");
    JCheckBox param2 = new JCheckBox("Keyword");
    JCheckBox param3 = new JCheckBox("Artist");

    public SearchCheckboxes(){

        this.add(param1);
        this.add(param2);
        this.add(param3);

    }

}
