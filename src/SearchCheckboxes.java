import javax.swing.*;


public class SearchCheckBoxes extends JPanel {

    private JCheckBox name = new JCheckBox("Name");
    private JCheckBox keyword = new JCheckBox("Keyword");
    private JCheckBox artist = new JCheckBox("Artist");

    public SearchCheckBoxes() {

        this.add(name);
        this.add(keyword);
        this.add(artist);

    }

}
