import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import java.awt.Dimension;

public class MainInterface {

 
  static ManaSymbols manaSymbols = new ManaSymbols();
  static PriceRange fromTo = new PriceRange();
  static SearchCheckBoxes scBox = new SearchCheckBoxes();
  static RarityCheckBoxes rarityCheckBox = new RarityCheckBoxes();
  static DropdownMenu dropD = new DropdownMenu();
  static JCheckBox collected = new JCheckBox("Show only collected");
  static JFrame f = new JFrame();
  static HelpButton helpButton = new HelpButton(f);
  static JPanel scrollAreaPane = new JPanel();
  static JScrollPane scrollableArea = new JScrollPane(scrollAreaPane);
  static Database app = new Database();
  private static ArrayList<MtgCard> showedCards = new ArrayList<MtgCard>(Arrays.asList(new MtgCard(18149), new MtgCard(40817),
      new MtgCard(4730), new MtgCard(23019), new MtgCard(51395), new MtgCard(35710), new MtgCard(330), new MtgCard(9873), new MtgCard(18446), 
      new MtgCard(45939), new MtgCard(22931), new MtgCard(22934), new MtgCard(22698), new MtgCard(31131), new MtgCard(18724), new MtgCard(21084), 
      new MtgCard(10658), new MtgCard(35677)));;

  public static void headerArea(Container pane) {
    Header header = new Header();
    GridBagConstraints headerc = new GridBagConstraints();
    headerc.fill = GridBagConstraints.BOTH;
    headerc.gridx = 0;
    headerc.gridy = 0;
    headerc.gridwidth = 3;
    headerc.insets = new Insets(30, 30, 10, 30);
    pane.add(header, headerc);
  }

  public static void secondAndThirdRow(Container pane, JButton searchButton) {

    searchTextBox(pane, searchButton);
    GridBagConstraints searchc = new GridBagConstraints();
    searchc.fill = GridBagConstraints.HORIZONTAL;
    searchc.gridx = 1;
    searchc.gridy = 1;
    searchc.gridheight = 2;
    searchc.gridwidth = 1;
    searchc.weightx = 1.0;
    searchc.insets = new Insets(0, 10, 0, 50);
    pane.add(manaSymbols, searchc);

    JLabel price = new JLabel("Price");
    GridBagConstraints pricec = new GridBagConstraints();
    pricec.fill = GridBagConstraints.HORIZONTAL;
    pricec.gridx = 2;
    pricec.gridy = 1;
    pricec.gridheight = 1;
    pricec.gridwidth = 1;
    pricec.insets = new Insets(0, 0, 0, 10);
    pane.add(price, pricec);

    GridBagConstraints fromToc = new GridBagConstraints();
    fromToc.fill = GridBagConstraints.HORIZONTAL;
    fromToc.gridx = 2;
    fromToc.gridy = 2;
    fromToc.gridheight = 1;
    fromToc.gridwidth = 1;
    fromToc.insets = new Insets(0, -4, 0, 40);
    pane.add(fromTo, fromToc);
  }

  public static void fourthAndFifthRow(Container pane) {

    JLabel searchText = new JLabel("Search:");
    GridBagConstraints searchTextc = new GridBagConstraints();
    searchTextc.fill = GridBagConstraints.HORIZONTAL;
    searchTextc.gridx = 0;
    searchTextc.gridy = 3;
    searchTextc.gridwidth = 1;
    searchTextc.gridheight = 1;
    searchTextc.insets = new Insets(0, 70, 0, 0);
    pane.add(searchText, searchTextc);

    JLabel searchRarity = new JLabel("Rarity:");
    GridBagConstraints rarityc = new GridBagConstraints();
    rarityc.fill = GridBagConstraints.HORIZONTAL;
    rarityc.gridx = 1;
    rarityc.gridy = 3;
    rarityc.gridheight = 1;
    rarityc.gridwidth = 1;
    rarityc.insets = new Insets(0, 120, 0, 0);
    pane.add(searchRarity, rarityc);

    GridBagConstraints dropdc = new GridBagConstraints();
    dropdc.fill = GridBagConstraints.HORIZONTAL;
    dropdc.gridwidth = 1;
    dropdc.gridheight = 2;
    dropdc.gridx = 2;
    dropdc.gridy = 3;
    dropdc.insets = new Insets(0, 0, 0, 40);
    pane.add(dropD, dropdc);

    GridBagConstraints scBoxc = new GridBagConstraints();
    scBoxc.fill = GridBagConstraints.HORIZONTAL;
    scBoxc.gridy = 4;
    scBoxc.gridx = 0;
    scBoxc.gridwidth = 1;
    scBoxc.gridheight = 1;
    scBoxc.insets = new Insets(0, 40, 0, 0);
    pane.add(scBox, scBoxc);

    GridBagConstraints rarityCheckc = new GridBagConstraints();
    rarityCheckc.fill = GridBagConstraints.HORIZONTAL;
    rarityCheckc.gridy = 4;
    rarityCheckc.gridx = 1;
    rarityCheckc.gridwidth = 1;
    rarityCheckc.gridheight = 1;
    rarityCheckc.insets = new Insets(0, 0, 0, 0);
    pane.add(rarityCheckBox, rarityCheckc);
  }

  public static void collectedCheckBox(Container pane) {
    GridBagConstraints collectedc = new GridBagConstraints();
    collectedc.fill = GridBagConstraints.HORIZONTAL;
    Font collectedFont = new Font(collected.getFont().getName(), collected.getFont().getStyle(), 18);
    collected.setFont(collectedFont);
    collectedc.fill = GridBagConstraints.HORIZONTAL;
    collectedc.gridx = 1;
    collectedc.gridy = 5;
    collectedc.gridheight = 1;
    collectedc.gridwidth = 1;
    collectedc.insets = new Insets(0, 180, 0, 40);
    pane.add(collected, collectedc);

  }

  public static void cardArea(Container pane) {


    GridBagConstraints scrollableAreac = new GridBagConstraints();
    scrollableAreac.fill = GridBagConstraints.HORIZONTAL;
    scrollAreaPane.setLayout(new GridBagLayout());
    scrollableArea.setPreferredSize(new Dimension(300, 300));
    scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scrollableArea.setCorner(JScrollPane.LOWER_LEFT_CORNER, helpButton);
    scrollableAreac.fill = GridBagConstraints.BOTH;
    scrollableAreac.gridheight = 4;
    scrollableAreac.gridwidth = 3;
    scrollableAreac.insets = new Insets(0, 40, 5, 40);
    scrollableAreac.gridx = 0;
    scrollableAreac.gridy = 6;
    pane.add(scrollableArea, scrollableAreac);

    for (int i = 0; i < showedCards.size(); i++) {
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

  public static void help (Container pane) {

    GridBagConstraints helpc = new GridBagConstraints();
    helpc.fill = GridBagConstraints.HORIZONTAL;
    helpc.fill = GridBagConstraints.NONE;
    helpc.weightx = 0;
    helpc.gridheight = 1;
    helpc.gridwidth = 1;
    helpc.anchor = GridBagConstraints.LINE_START;
    helpc.gridx = 0;
    helpc.gridy = 10;
    helpc.insets = new Insets(0, 0, 0, 0);
    pane.add(helpButton, helpc);
  }

  public static void searchTextBox(Container pane, JButton searchButton) {

    JPanel search = new JPanel();
    search.setLayout(new BoxLayout(search, BoxLayout.LINE_AXIS));
    JTextField searchField = new JTextField();
    searchField.setBorder(BorderFactory.createEmptyBorder());
    Border lowbevelborder = BorderFactory.createLoweredBevelBorder();
    search.setBorder(lowbevelborder);
    searchButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        scrollAreaPane.removeAll();
        scrollAreaPane.revalidate();

        showedCards = searchFunction(manaSymbols.getWhiteState(), manaSymbols.getBlueState(),
            manaSymbols.getBlackState(), manaSymbols.getRedState(), manaSymbols.getGreenState(),
            manaSymbols.getColorlessState(), manaSymbols.getMulticolorState(), rarityCheckBox.getCommonState(),
            rarityCheckBox.getUncommonState(), rarityCheckBox.getRareState(), rarityCheckBox.getMythicState(),
            fromTo.fromHasText(), fromTo.getFromNumber(), fromTo.toHasText(), fromTo.getToNumber(),
            collected.isSelected(), dropD.isTypeSelected(), dropD.getSelected(), !searchField.toString().isEmpty(),
            scBox.getNameState(), scBox.getArtistStatus(), scBox.getKeyWordState(), searchField.getText());

        if (showedCards.size() == 0) {
          scrollAreaPane.add(new JLabel("No cards found"));
        }

        for (int i = 0; i < showedCards.size(); i++) {
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
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.BOTH;
    c.gridwidth = 1;
    c.gridheight = 2;
    c.gridx = 0;
    c.gridy = 1;
    c.weightx = 1;
    c.weighty = 0.5;
    c.insets = new Insets(5, 40, 5, 40);
    pane.add(search, c);

  }

  /*
   * this search method returns an ArrayList of MtgCards, created based on primary
   * 
   * keys acquired from the database.
   */
  private static ArrayList<MtgCard> searchFunction(boolean filterW, boolean filterU, boolean filterB, boolean filterR,
      boolean filterG, boolean filterC, boolean filterM, boolean filterCommon, boolean filterUncommon,
      boolean filterRare, boolean filterMythic, boolean priceLow, double priceMin, boolean priceHigh, double priceMax,
      boolean owned, boolean cardTypeSelected, String cardType, boolean searchField, boolean searchByName,
      boolean searchByArtist, boolean searchByKeyword, String search) {

    ArrayList<Integer> listedIDs = app.searchAll(filterW, filterU, filterB, filterR, filterG, filterC, filterM,
        filterCommon, filterUncommon, filterRare, filterMythic, priceLow, priceMin, priceHigh, priceMax, owned,
        cardTypeSelected, cardType, searchField, searchByName, searchByArtist, searchByKeyword, search);
    ArrayList<MtgCard> cardList = new ArrayList<>();

    for (int i = 0; i < listedIDs.size(); i++) {
      cardList.add(new MtgCard(listedIDs.get(i)));
    }

    return cardList;

  }

}
