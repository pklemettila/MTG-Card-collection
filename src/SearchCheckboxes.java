import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Image;

public class SearchCheckboxes extends JPanel {

    private JCheckBox name = new JCheckBox("Name");
    private JCheckBox keyword = new JCheckBox("Keyword");
    private JCheckBox artist = new JCheckBox("Artist");
    private JCheckBox common = new JCheckBox("Common");
    private JCheckBox uncommon = new JCheckBox("Uncommon");
    private JCheckBox rare = new JCheckBox("Rare");
    private JCheckBox mythic = new JCheckBox("Mythic Rare");



    public SearchCheckboxes(){

        this.add(name);
        this.add(keyword);
        this.add(artist);
        artist.setBorder(new EmptyBorder(0, 0, 0, 250));
        this.add(common);
        this.add(uncommon);
        this.add(rare);
        this.add(mythic);

    }

}
