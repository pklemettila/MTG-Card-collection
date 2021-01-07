import javax.swing.*;
import java.awt.*;

public class ManaSymbols extends JPanel {

    private JToggleButton whiteManaButton;


    private JToggleButton blueManaButton;
    private JToggleButton blackManaButton;
    private JToggleButton redManaButton;
    private JToggleButton greenManaButton;
    private JToggleButton colorlessManaButton;
    private JToggleButton multicolorManaButton;


    public ManaSymbols() {

        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));


        this.whiteManaButton = createButton("/images/mana/white_mana.png");
        this.add(whiteManaButton);
        this.add(Box.createRigidArea(new Dimension(20,0)));

        this.blueManaButton = createButton("/images/mana/blue_mana.png");
        this.add(blueManaButton);
        this.add(Box.createRigidArea(new Dimension(20,0)));

        this.blackManaButton = createButton("/images/mana/black_mana.png");
        this.add(blackManaButton);
        this.add(Box.createRigidArea(new Dimension(20,0)));


        this.redManaButton = createButton("/images/mana/red_mana.png");
        this.add(redManaButton);
        this.add(Box.createRigidArea(new Dimension(20,0)));


        this.greenManaButton = createButton("/images/mana/green_mana.png");
        this.add(greenManaButton);
        this.add(Box.createRigidArea(new Dimension(20,0)));


        this.colorlessManaButton = createButton("/images/mana/colorless_mana.png");
        this.add(colorlessManaButton);
        this.add(Box.createRigidArea(new Dimension(20,0)));


        this.multicolorManaButton = createButton("/images/mana/multicolor_mana.png");
        this.add(multicolorManaButton);

    }


    private JToggleButton createButton(String colorSource) {

        JToggleButton returnButton = new JToggleButton();
        ImageIcon ManaIcon = new ImageIcon(this.getClass().getResource(colorSource));
        Image NewImg = ManaIcon.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        ImageIcon manaIcon = new ImageIcon(NewImg);
        returnButton.setPreferredSize(new Dimension(40, 40));
        returnButton.setIcon(manaIcon);
        returnButton.setBorder(BorderFactory.createEmptyBorder());
        returnButton.setContentAreaFilled(false);

        return returnButton;

    }



    public boolean getWhiteState() {
        return whiteManaButton.isSelected();
    }

    public boolean getBlueState() {
        return blueManaButton.isSelected();
    }

    public boolean getBlackState() {
        return blackManaButton.isSelected();
    }

    public boolean getRedState() {
        return redManaButton.isSelected();
    }

    public boolean getGreenState() {
        return greenManaButton.isSelected();
    }

    public boolean getColorlessState() {
        return colorlessManaButton.isSelected();
    }

    public boolean getMulticolorState() {
        return multicolorManaButton.isSelected();
    }

}
