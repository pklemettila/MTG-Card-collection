import javax.swing.*;

public class ManaSymbols extends JPanel {


    ImageIcon whiteS = new ImageIcon(this.getClass().getResource("/images/white_mana.png"));
    ImageIcon blackS = new ImageIcon(this.getClass().getResource("/images/black_mana.png"));
    ImageIcon greenS = new ImageIcon(this.getClass().getResource("/images/green_mana.png"));
    ImageIcon redS = new ImageIcon(this.getClass().getResource("/images/red_mana.png"));
    ImageIcon blueS = new ImageIcon(this.getClass().getResource("/images/blue_mana.png"));
    ImageIcon colourlessS = new ImageIcon(this.getClass().getResource("/images/Colorless-symbol.png"));
    ImageIcon multicolouredS = new ImageIcon(this.getClass().getResource("/images/multicolor_mana.png"));


    private JToggleButton blue = new JToggleButton(blueS);
    private JToggleButton black = new JToggleButton(blackS);
    private JToggleButton green = new JToggleButton(greenS);
    private JToggleButton red = new JToggleButton(redS);
    private JToggleButton white = new JToggleButton(whiteS);
    private JToggleButton multicoloured = new JToggleButton(multicolouredS);
    private JToggleButton colourless = new JToggleButton(colourlessS);

    public ManaSymbols() {

        this.add(blue);
        this.add(black);
        this.add(green);
        this.add(white);
        this.add(red);
        this.add(multicoloured);
        this.add(colourless);



    }
}
