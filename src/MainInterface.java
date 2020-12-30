import javax.swing.*;

public class MainInterface {

    public MainInterface() {
        JFrame frame = new JFrame();
        SearchBar Search = new SearchBar("Search terms go here...");
        Header header = new Header();
        header.setVisible(true);
        SearchCheckboxes scBox = new SearchCheckboxes();
        ManaSymbols symbols = new ManaSymbols();

        frame.add(scBox);
        frame.add(symbols);
        frame.add(Search);
        frame.add(header);
        frame.setSize(1260, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

    }


}
