import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.Image;
import java.awt.Dimension;

public class MainInterface {
  final static boolean shouldFill = true;
  final static boolean shouldWeightX = true;

  public MainInterface() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container pane = frame.getContentPane();
    pane.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;
    if (shouldFill) {
      c.fill = GridBagConstraints.HORIZONTAL;
    }

    JButton button;

    // First row. Only has one column that spans all 10 columns (c.gridwidth = 10).
    // All rows have ten columns.

    Header header = new Header();
    c.fill = GridBagConstraints.BOTH;
    c.weightx = 1.0;
    c.gridwidth = 10;
    c.gridx = 0;
    c.gridy = 0;
    c.anchor = GridBagConstraints.CENTER;
    c.insets = new Insets(30, 30, 30, 0);
    pane.add(header, c);

    // Second row. Has text "Price:". Shares half of search box and manasymbols with
    // third row.

    JLabel price = new JLabel("Price:");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 1;
    c.gridwidth = 1;
    c.gridx = 8;
    c.gridy = 1;
    c.ipadx = 0;
    c.anchor = GridBagConstraints.LINE_START;
    c.insets = new Insets(0, 5, 0, 30);
    pane.add(price, c);

    // Third row. Most elements start from row 1 (row 1 = second row). Has
    // searchBar, 7 manabuttons and two price range columns.

    SearchBar search = new SearchBar("");
    c.fill = GridBagConstraints.BOTH;
    c.weightx = 1;
    c.gridwidth = 1;
    c.gridheight = 2;
    c.gridx = 0;
    c.gridy = 1;
    c.insets = new Insets(5, 50, 5, 10);
    pane.add(search, c);

    // Seven manabuttons. gridheight is 2, so these are in the second and third row
    // (gridy = 1. Start from row 1 aka second row).

    ImageIcon whiteManaIcon = new ImageIcon(this.getClass().getResource("/images/mana/white_mana.png"));
    Image whiteNewImg = whiteManaIcon.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon manaIconW = new ImageIcon(whiteNewImg);
    JToggleButton whiteManaButton = new JToggleButton();
    whiteManaButton.setPreferredSize(new Dimension(40, 40));
    whiteManaButton.setIcon(manaIconW);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridheight = 2;
    c.gridx = 1;
    c.gridy = 1;
    c.insets = new Insets(5, 80, 5, 10);
    pane.add(whiteManaButton, c);

    ImageIcon blueManaIcon = new ImageIcon(this.getClass().getResource("/images/mana/blue_mana.png"));
    Image newimg = blueManaIcon.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon manaIconBlu = new ImageIcon(newimg);
    JToggleButton blueManaButton = new JToggleButton();
    blueManaButton.setPreferredSize(new Dimension(40, 40));
    blueManaButton.setIcon(manaIconBlu);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 2;
    c.gridheight = 2;
    c.gridy = 1;
    c.insets = new Insets(5, 20, 5, 20);
    pane.add(blueManaButton, c);

    ImageIcon blackManaIcon = new ImageIcon(this.getClass().getResource("/images/mana/black_mana.png"));
    Image blackNewImg = blackManaIcon.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon manaIconBla = new ImageIcon(blackNewImg);
    JToggleButton blackManaButton = new JToggleButton();
    blackManaButton.setPreferredSize(new Dimension(40, 40));
    blackManaButton.setIcon(manaIconBla);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 3;
    c.gridheight = 2;
    c.gridy = 1;
    pane.add(blackManaButton, c);

    ImageIcon redManaIcon = new ImageIcon(this.getClass().getResource("/images/mana/red_mana.png"));
    Image redNewImg = redManaIcon.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon manaIconR = new ImageIcon(redNewImg);
    JToggleButton redManaButton = new JToggleButton();
    redManaButton.setPreferredSize(new Dimension(40, 40));
    redManaButton.setIcon(manaIconR);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 4;
    c.gridy = 1;
    c.gridheight = 2;
    pane.add(redManaButton, c);

    ImageIcon greenManaIcon = new ImageIcon(this.getClass().getResource("/images/mana/green_mana.png"));
    Image greenNewImg = greenManaIcon.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon manaIconG = new ImageIcon(greenNewImg);
    JToggleButton greenManaButton = new JToggleButton();
    greenManaButton.setPreferredSize(new Dimension(40, 40));
    greenManaButton.setIcon(manaIconG);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 5;
    c.gridy = 1;
    c.gridheight = 2;
    pane.add(greenManaButton, c);

    ImageIcon colorlessManaIcon = new ImageIcon(this.getClass().getResource("/images/mana/colorless_mana.png"));
    Image colorlessNewImg = colorlessManaIcon.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon manaIcon = new ImageIcon(colorlessNewImg);
    JToggleButton colorlessManaButton = new JToggleButton();
    colorlessManaButton.setPreferredSize(new Dimension(40, 40));
    colorlessManaButton.setIcon(manaIcon);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 6;
    c.gridy = 1;
    c.gridheight = 2;
    pane.add(colorlessManaButton, c);

    ImageIcon multicolorManaIcon = new ImageIcon(this.getClass().getResource("/images/mana/multicolor_mana.png"));
    Image multicolorNewImg = multicolorManaIcon.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon manaIconM = new ImageIcon(multicolorNewImg);
    JToggleButton multicolorManaButton = new JToggleButton();
    multicolorManaButton.setPreferredSize(new Dimension(40, 40));
    multicolorManaButton.setIcon(manaIconM);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 7;
    c.gridy = 1;
    c.gridheight = 2;
    c.insets = new Insets(5, 20, 0, 50);
    pane.add(multicolorManaButton, c);

    // Two PriceRange text boxes. These do not start from row 1 but from row 2.
    // gridheight = 1 so they are only on third row.

    PriceRange from = new PriceRange("From: ");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridx = 8;
    c.gridy = 2;
    c.anchor = GridBagConstraints.LINE_START;
    c.insets = new Insets(0, 0, 0, 0);
    c.gridheight = 1;
    pane.add(from, c);

    PriceRange to = new PriceRange("to: ");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridx = 9;
    c.gridy = 2;
    c.insets = new Insets(0, 0, 0, 30);
    pane.add(to, c);

    // Fourth row.

    JLabel searchText = new JLabel("Search:");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridwidth = 1;
    c.gridx = 0;
    c.gridy = 3;
    c.insets = new Insets(5, 70, 0, 10);
    pane.add(searchText, c);

    JLabel searchRarity = new JLabel("Rarity:");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridwidth = 7;
    c.insets = new Insets(5, 150, 0, 10);
    c.anchor = GridBagConstraints.LINE_START;
    c.gridx = 1;
    c.gridy = 3;
    pane.add(searchRarity, c);

    // Placeholder for Card Type Dropdown

    String cardTypes[] = {"Card type", "Artifact", "Conspiracy", "Creature", "Enchantment", "Instant", "Land", "Planeswalker", "Sorcery"};
    DropdownMenu dropD = new DropdownMenu(cardTypes);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridwidth = 2;
    c.gridheight = 2;
    c.gridx = 8;
    c.gridy = 3;
    c.insets = new Insets(0, 30, 0, 30);
    pane.add(dropD, c);

    // Fifth row. Notice that CardType button starts in row 3 and spans to row 4

    SearchCheckBoxes scBox = new SearchCheckBoxes();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 0;
    c.weighty = 0;
    c.gridx = 0;
    c.insets = new Insets(-5, 60, 5, 10);
    c.anchor = GridBagConstraints.LINE_START;
    c.gridwidth = 1;
    c.gridheight = 1;
    c.gridy = 4;
    pane.add(scBox, c);

    RarityCheckBoxes rarityCheckBox = new RarityCheckBoxes();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weighty = 0;
    c.gridx = 1;
    c.gridwidth = 7;
    c.insets = new Insets(-5, 20, 5, 0);
    c.gridy = 4;
    pane.add(rarityCheckBox, c);

    // Sixth row.

    JCheckBox collected = new JCheckBox("Show only collected");
    Font collectedFont=new Font(collected.getFont().getName(),collected.getFont().getStyle(),18);  
    collected.setFont(collectedFont);
    c.fill = GridBagConstraints.NONE;
    c.weightx = 1;
    c.gridheight = 1;
    c.gridwidth = 9;
    c.gridx = 3;
    c.gridy = 5;
    c.insets = new Insets(5, 0, 0, 0);
    pane.add(collected, c);

    HelpButton helpButton = new HelpButton(frame);
    c.fill = GridBagConstraints.NONE;
    c.weightx = 0;
    c.gridheight = 1;
    c.gridwidth = 9;
    c.gridx = 0;
    c.gridy = 15;
    c.insets = new Insets(0, 0, 0, 0);
    pane.add(helpButton, c);

    // Scroller

    JPanel scrollAreaPane = new JPanel();
    scrollAreaPane.setLayout(new GridBagLayout());
    JScrollPane scrollableArea = new JScrollPane(scrollAreaPane);
    scrollableArea.setPreferredSize(new Dimension(300, 300));
    scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    c.fill = GridBagConstraints.BOTH;
    c.anchor = GridBagConstraints.CENTER;
    c.weightx = 1;
    c.gridheight = 4;
    c.gridwidth = 10;
    c.insets = new Insets(0, 30, 5, 30);
    c.gridx = 0;
    c.gridy = 6;
    pane.add(scrollableArea, c);

    ArrayList<String> erkit = new ArrayList<String>(
        Arrays.asList("/images/Cards/black_card.jpg", "/images/Cards/white_card.jpg", "/images/Cards/aether.png",
            "/images/Cards/crystallineGiantCard.png", "/images/Cards/white_card.jpg", "/images/Cards/white_card.jpg", "/images/Cards/white_card.jpg",
            "/images/Cards/white_card.jpg"
        ));
    int erkinNum = 0;

    for (String pathToErkki : erkit) {
      GridBagConstraints erkinc = new GridBagConstraints();
      ImageIcon raakaErkki = new ImageIcon(this.getClass().getResource(pathToErkki));
      Image erkinKuva = raakaErkki.getImage().getScaledInstance(172, 240, Image.SCALE_SMOOTH);
      ImageIcon valmisErkki = new ImageIcon(erkinKuva);
      JLabel erkki = new JLabel();
      erkki.setIcon(valmisErkki);
      erkinc.fill = GridBagConstraints.HORIZONTAL;
      erkinc.weightx = 0;
      erkinc.gridwidth = 1;
      erkinc.gridheight = 2;
      erkinc.gridx = ((erkinNum % 4) + (erkinNum % 4));
      erkinc.gridy = ((erkinNum / 4) + (erkinNum / 4));
      erkinc.insets = new Insets(20, 10, 10, 10);
      scrollAreaPane.add(erkki, erkinc);

      button = new JButton("+");
      erkinc.fill = GridBagConstraints.HORIZONTAL;
      erkinc.weightx = 0;
      erkinc.gridwidth = 1;
      erkinc.gridheight = 1;
      erkinc.gridx = (((erkinNum % 4) + (erkinNum % 4)) + 1);
      erkinc.gridy = ((erkinNum / 4) + (erkinNum / 4));
      erkinc.insets = new Insets(20, 0, 0, 0);
      scrollAreaPane.add(button, erkinc);

      button = new JButton("-");
      erkinc.fill = GridBagConstraints.HORIZONTAL;
      erkinc.weightx = 0;
      erkinc.gridwidth = 1;
      erkinc.gridheight = 1;
      erkinc.gridx = (((erkinNum % 4) + (erkinNum % 4)) + 1);
      erkinc.gridy = (((erkinNum / 4) + (erkinNum / 4)) + 1);
      erkinc.insets = new Insets(20, 0, 0, 0);
      scrollAreaPane.add(button, erkinc);


      scrollAreaPane.revalidate();

      erkinNum++;
    }

    frame.pack();
    frame.setMinimumSize(new Dimension(950, 600));
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);

  }

}
