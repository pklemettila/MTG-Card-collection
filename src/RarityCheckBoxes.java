import javax.swing.*;


public class RarityCheckBoxes extends JPanel {
    static final long serialVersionUID = 42L;
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

    public boolean getCommonState() {
        return (common.isSelected());
    }
    public boolean getUncommonState() {
        return (uncommon.isSelected());
    }
    public boolean getRareState() {
        return (rare.isSelected());
    }
    public boolean getMythicState() {
        return (mythic.isSelected());
    }

}
