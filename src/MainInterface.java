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
  private static  ArrayList<MtgCard> showedCards = new ArrayList<MtgCard>(Arrays.asList(new MtgCard(1), new MtgCard(2), new MtgCard(3), new MtgCard(4)
          , new MtgCard(5), new MtgCard(6), new MtgCard(7), new MtgCard(8)));; // initializing showed cards with 8 different cards


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

    // In the Third row most elements start from row 1 (row 1 = second row). Has
    // searchbar, 7 manabuttons and two price range columns.




    ManaSymbols manaSymbols = new ManaSymbols();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridheight = 2;
    c.gridwidth = 7;
    c.gridx = 1;
    c.gridy = 1;
    c.insets = new Insets(5, 40, 5, 40);
    pane.add(manaSymbols, c);



    PriceRange fromTo = new PriceRange();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridx = 8;
    c.gridy = 2;
    c.anchor = GridBagConstraints.LINE_START;
    c.insets = new Insets(0, 0, 0, 35);
    c.gridheight = 1;
    pane.add(fromTo, c);


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


    for (int i = 0; i< showedCards.size(); i++) {
      GridBagConstraints cardC = new GridBagConstraints();
      cardC.fill = GridBagConstraints.HORIZONTAL;
      cardC.weightx = 0;
      cardC.gridwidth = 1;
      cardC.gridheight = 1;
      cardC.gridx = i % 4;
      cardC.gridy = i / 4;
      cardC.insets = new Insets(20, 10, 10, 10);
      scrollAreaPane.add(showedCards.get(i), cardC);
      scrollAreaPane.revalidate();

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


    JPanel search = new JPanel();
    search.setLayout(new BoxLayout(search, BoxLayout.LINE_AXIS));
    JTextField searchField = new JTextField();
    searchField.setBorder(BorderFactory.createEmptyBorder());
    JButton searchButton = new JButton(new ImageIcon(this.getClass().getResource("images/maglass.png")));
    Border lowbevelborder = BorderFactory.createLoweredBevelBorder();
    search.setBorder(lowbevelborder);

    searchButton.addActionListener(new ActionListener() {     // Using the searchfunction and filling the grid with the found cards. Displays an error msg if no cards are found
      @Override
      public void actionPerformed(ActionEvent e) {

        scrollAreaPane.removeAll();
        scrollAreaPane.revalidate();

        showedCards = searchFunction(manaSymbols.getWhiteState(), manaSymbols.getBlueState(), manaSymbols.getBlackState(), manaSymbols.getRedState(), manaSymbols.getGreenState(), manaSymbols.getColorlessState(),
                manaSymbols.getMulticolorState(), rarityCheckBox.getCommonState(), rarityCheckBox.getUncommonState(), rarityCheckBox.getRareState(), rarityCheckBox.getMythicState(),
                fromTo.fromHasText(), fromTo.getFromNumber(), fromTo.toHasText(), fromTo.getToNumber(), collected.isSelected(), dropD.isTypeSelected(), dropD.getSelected(),
                !searchField.toString().isEmpty(), scBox.getNameState(), scBox.getArtistStatus(), scBox.getKeyWordState(), searchField.getText());



        if(showedCards.size() == 0) {
          scrollAreaPane.add(new JLabel("No cards found"));
        }

        for (int i = 0; i< showedCards.size(); i++) {
          GridBagConstraints cardC = new GridBagConstraints();
          cardC.fill = GridBagConstraints.HORIZONTAL;
          cardC.weightx = 0;
          cardC.gridwidth = 1;
          cardC.gridheight = 1;
          cardC.gridx = i % 4;
          cardC.gridy = i / 4;
          cardC.insets = new Insets(20, 10, 10, 10);
          scrollAreaPane.add(showedCards.get(i), cardC);
          scrollAreaPane.revalidate();

        }



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

  // this searchfunction returns an ArrayList of MtgCards, created based on primary keys acquired from the database.
    private ArrayList<MtgCard> searchFunction(boolean filterW, boolean filterU, boolean filterB, boolean filterR,
                                            boolean filterG, boolean filterC, boolean filterM, boolean filterCommon, boolean filterUncommon,
                                            boolean filterRare, boolean filterMythic, boolean priceLow, double priceMin, boolean priceHigh,
                                            double priceMax, boolean owned, boolean cardTypeSelected, String cardType, boolean searchField,
                                            boolean searchByName, boolean searchByArtist, boolean searchByKeyword, String search) {

    Database app = new Database();
    ArrayList<Integer> listedIDs  = app.searchAll(filterW, filterU, filterB, filterR, filterG, filterC, filterM, filterCommon, filterUncommon, filterRare, filterMythic, priceLow, priceMin, priceHigh,
                                    priceMax, owned, cardTypeSelected, cardType, searchField, searchByName, searchByArtist, searchByKeyword, search);
    ArrayList<MtgCard> cardList = new ArrayList<>();

    for(int i=0; i < listedIDs.size(); i++) {
      cardList.add(new MtgCard(listedIDs.get(i)));
    }



    return cardList;

  }




}
