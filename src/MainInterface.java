import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    JLabel price = new JLabel("Price");
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



    /* SearchBar search = new SearchBar();

    search.setLayout(new BoxLayout(search, BoxLayout.LINE_AXIS));
    JTextField searchField = new JTextField();
    searchField.setBorder(BorderFactory.createEmptyBorder());
    JButton searchButton = new JButton(new ImageIcon(this.getClass().getResource("images/maglass.png")));
    Border lowbevelborder = BorderFactory.createLoweredBevelBorder();
    search.setBorder(lowbevelborder);
    search.add(searchField);
    search.add(searchButton);
    c.fill = GridBagConstraints.BOTH;
    c.weightx = 1;
    c.gridwidth = 1;
    c.gridheight = 2;
    c.gridx = 0;
    c.gridy = 1;
    c.insets = new Insets(5, 50, 5, 10);
    pane.add(search, c); */

    ManaSymbols manaSymbols = new ManaSymbols();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridheight = 2;
    c.gridwidth = 7;
    c.gridx = 1;
    c.gridy = 1;
    c.insets = new Insets(5, 40, 5, 40);
    pane.add(manaSymbols, c);



    PriceRange from = new PriceRange();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridx = 8;
    c.gridy = 2;
    c.anchor = GridBagConstraints.LINE_START;
    c.insets = new Insets(0, 0, 0, 35);
    c.gridheight = 1;
    pane.add(from, c);


    // Fourth row.

    JLabel searchText = new JLabel("Search:");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridwidth = 1;
    c.gridx = 0;
    c.gridy = 3;
    c.insets = new Insets(5, 72, 0, 10);
    pane.add(searchText, c);

    JLabel searchRarity = new JLabel("Rarity:");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridwidth = 7;
    c.insets = new Insets(5, 48, 0, 10);
    c.anchor = GridBagConstraints.LINE_START;
    c.gridx = 1;
    c.gridy = 3;
    pane.add(searchRarity, c);

    // Card Type Dropdown

    DropdownMenu dropD = new DropdownMenu();
    c.fill = GridBagConstraints.BOTH;
    c.weightx = 0;
    c.gridwidth = 1;
    c.gridheight = 2;
    c.gridx = 8;
    c.gridy = 3;
    c.insets = new Insets(10, 5, 10, 125);
    pane.add(dropD, c);

    // Fifth row. Notice that CardType button starts in row 3 and spans to row 4

    SearchCheckBoxes scBox = new SearchCheckBoxes();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 0;
    c.weighty = 0;
    c.gridx = 0;
    c.insets = new Insets(-5, 25, 5, 10);
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
    c.insets = new Insets(-5, 0, 5, 20);
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
      erkinc.gridx = ((erkinNum % 4) * 2);
      erkinc.gridy = ((erkinNum / 4) * 2);
      erkinc.insets = new Insets(20, 10, 10, 10);
      scrollAreaPane.add(erkki, erkinc);

      button = new JButton("+");
      erkinc.fill = GridBagConstraints.HORIZONTAL;
      erkinc.weightx = 0;
      erkinc.gridwidth = 1;
      erkinc.gridheight = 1;
      erkinc.gridx = (((erkinNum % 4) * 2) + 1);
      erkinc.gridy = ((erkinNum / 4) * 2);
      erkinc.insets = new Insets(20, 0, 0, 0);
      scrollAreaPane.add(button, erkinc);

      button = new JButton("-");
      erkinc.fill = GridBagConstraints.HORIZONTAL;
      erkinc.weightx = 0;
      erkinc.gridwidth = 1;
      erkinc.gridheight = 1;
      erkinc.gridx = (((erkinNum % 4) * 2) + 1);
      erkinc.gridy = (((erkinNum / 4) * 2) + 1);
      erkinc.insets = new Insets(20, 0, 0, 0);
      scrollAreaPane.add(button, erkinc);


      scrollAreaPane.revalidate();

      erkinNum++;
    }

    HelpButton helpButton = new HelpButton(frame);
    c.fill = GridBagConstraints.NONE;
    c.weightx = 0;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.LINE_START;
    c.gridx = 0;
    c.gridy = 11;
    c.insets = new Insets(0, 0, 0, 0);
    pane.add(helpButton, c);


    SearchBar search = new SearchBar();

    search.setLayout(new BoxLayout(search, BoxLayout.LINE_AXIS));
    JTextField searchField = new JTextField();
    searchField.setBorder(BorderFactory.createEmptyBorder());
    JButton searchButton = new JButton(new ImageIcon(this.getClass().getResource("images/maglass.png")));
    Border lowbevelborder = BorderFactory.createLoweredBevelBorder();
    search.setBorder(lowbevelborder);

    searchButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(scBox.getNameState() == true)
          searchField.setText("Thor!!!");
      }
    });

    search.add(searchField);
    search.add(searchButton);
    c.fill = GridBagConstraints.BOTH;
    c.weightx = 1;
    c.gridwidth = 1;
    c.gridheight = 2;
    c.gridx = 0;
    c.gridy = 1;
    c.insets = new Insets(5, 50, 5, 10);
    pane.add(search, c);

    frame.pack();
    frame.setMinimumSize(new Dimension(950, 600));
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);

  }




}
