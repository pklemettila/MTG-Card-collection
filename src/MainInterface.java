import javax.swing.*;

public class MainInterface {

    public MainInterface() {
        JFrame frame = new JFrame();
        SearchBar Search = new SearchBar("Search terms go here...");
        Search.setLocation(40, 200);
        ImageIcon headImg = new ImageIcon(this.getClass().getResource("/images/logo.png"));
        JLabel header = new JLabel();
        header.setIcon(headImg);
        header.setBounds(10, 10 , 1250, 200);
        header.setVisible(true);

        SearchCheckboxes scBox = new SearchCheckboxes();
        scBox.setBounds(-20, 250, 950, 30);

        frame.add(scBox);
        frame.add(Search);
        frame.add(header);
        frame.setSize(1260, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

    }


}
