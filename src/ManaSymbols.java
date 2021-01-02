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
        this.add(Box.createRigidArea(new Dimension(10,0)));

        this.blueManaButton = createButton("/images/mana/blue_mana.png");
        this.add(blueManaButton);
        this.add(Box.createRigidArea(new Dimension(10,0)));

        this.blackManaButton = createButton("/images/mana/black_mana.png");
        this.add(blackManaButton);
        this.add(Box.createRigidArea(new Dimension(10,0)));


        this.redManaButton = createButton("/images/mana/red_mana.png");
        this.add(redManaButton);
        this.add(Box.createRigidArea(new Dimension(10,0)));


        this.greenManaButton = createButton("/images/mana/green_mana.png");
        this.add(greenManaButton);
        this.add(Box.createRigidArea(new Dimension(10,0)));


        this.colorlessManaButton = createButton("/images/mana/colorless_mana.png");
        this.add(colorlessManaButton);
        this.add(Box.createRigidArea(new Dimension(10,0)));


        this.multicolorManaButton = createButton("/images/mana/multicolor_mana.png");
        this.add(multicolorManaButton);
        this.add(Box.createRigidArea(new Dimension(10,0)));



    }

    private JToggleButton createButton(String colorSource) {

        JToggleButton ReturnButton = new JToggleButton();
        ImageIcon ManaIcon = new ImageIcon(this.getClass().getResource(colorSource));
        Image NewImg = ManaIcon.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        ImageIcon manaIconW = new ImageIcon(NewImg);
        ReturnButton.setPreferredSize(new Dimension(40, 40));
        ReturnButton.setIcon(manaIconW);

        return ReturnButton;

    }

}
