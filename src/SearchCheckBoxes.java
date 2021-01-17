import javax.swing.*;

public class SearchCheckBoxes extends JPanel {

    static final long serialVersionUID = 42L;
    private JCheckBox name = new JCheckBox("Name");
    private JCheckBox keyword = new JCheckBox("Keyword");
    private JCheckBox artist = new JCheckBox("Artist");

    public SearchCheckBoxes() {

        add(name);
        add(keyword);
        add(artist);
    }

    public boolean getNameState() {

        if (name.isSelected()) {
            return true;
        } else
            return false;
    }

    public boolean getKeyWordState() {

        if (keyword.isSelected()) {
            return true;
        } else
            return false;
    }

    public boolean getArtistStatus() {

        if (artist.isSelected()) {
            return true;
        } else
            return false;
    }
}

