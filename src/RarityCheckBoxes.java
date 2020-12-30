import javax.swing.*;


public class RarityCheckBoxes extends JPanel {

    private JCheckBox common = new JCheckBox("Common     ");
    private JCheckBox uncommon = new JCheckBox("Uncommon   ");
    private JCheckBox rare = new JCheckBox("Rare       ");
    private JCheckBox mythic = new JCheckBox("Mythic Rare");

    public RarityCheckBoxes() {
        this.add(common);
        this.add(uncommon);
        this.add(rare);
        this.add(mythic);

    }
}
