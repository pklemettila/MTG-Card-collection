import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManaSymbols extends JPanel {
    static final long serialVersionUID = 42L;
    private JToggleButton whiteManaButton;


    private JToggleButton blueManaButton;
    private JToggleButton blackManaButton;
    private JToggleButton redManaButton;
    private JToggleButton greenManaButton;
    private JToggleButton colorlessManaButton;
    private JToggleButton multicolorManaButton;


    public ManaSymbols() {

        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        this.add(Box.createRigidArea(new Dimension(30,0)));
        this.whiteManaButton = createButton("/images/mana/white_mana");
        this.add(whiteManaButton);
        this.add(Box.createRigidArea(new Dimension(30,0)));


        this.blueManaButton = createButton("/images/mana/blue_mana");
        this.add(blueManaButton);
        this.add(Box.createRigidArea(new Dimension(30,0)));

        this.blackManaButton = createButton("/images/mana/black_mana");
        this.add(blackManaButton);
        this.add(Box.createRigidArea(new Dimension(30,0)));


        this.redManaButton = createButton("/images/mana/red_mana");
        this.add(redManaButton);
        this.add(Box.createRigidArea(new Dimension(30,0)));


        this.greenManaButton = createButton("/images/mana/green_mana");
        this.add(greenManaButton);
        this.add(Box.createRigidArea(new Dimension(30,0)));


        this.colorlessManaButton = createButton("/images/mana/colorless_mana");
        this.add(colorlessManaButton);
        this.add(Box.createRigidArea(new Dimension(30,0)));


        this.multicolorManaButton = createButton("/images/mana/multicolor_mana");
        this.add(multicolorManaButton);
        this.add(Box.createRigidArea(new Dimension(10,0)));


    }

    // Creating a new mana symbol toggle button with an action listener that changes the icon upon mouse click
    private JToggleButton createButton(String colorSource) {

        JToggleButton returnButton = new JToggleButton();
        ImageIcon ManaIcon = new ImageIcon(this.getClass().getResource(colorSource + ".png"));
        Image NewImg = ManaIcon.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        ImageIcon manaIcon = new ImageIcon(NewImg);
        returnButton.setPreferredSize(new Dimension(40, 40));
        returnButton.setIcon(manaIcon);
        returnButton.setBorder(BorderFactory.createEmptyBorder());
        returnButton.setContentAreaFilled(false);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (returnButton.isSelected()) {
                    ImageIcon toggleManaIcon = new ImageIcon(this.getClass().getResource(colorSource + "_p.png"));
                    Image NewImg = toggleManaIcon.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon togglemanaIcon = new ImageIcon(NewImg);
                    returnButton.setIcon(togglemanaIcon);

                }
                if (!returnButton.isSelected()) {
                    returnButton.setIcon(manaIcon);
                }
            }
        });

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
