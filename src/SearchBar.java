import javax.swing.*;

public class SearchBar extends JTextField {


    JPanel paramPanel = new JPanel();
    JCheckBox param1 = new JCheckBox("Name");
    JCheckBox param2 = new JCheckBox("Keyword");
    JCheckBox param3 = new JCheckBox("Artist");



    public SearchBar(String s) {
        super(s);
        this.setBounds(50,200,200,30);
        this.paramPanel.add(param1);
        this.paramPanel.add(param2);
        this.paramPanel.add(param3);

    }


}
