import javax.swing.*;


public class SearchBtn extends JButton {
    static final long serialVersionUID = 42L;

    public void searchBtnImage(JButton searchButton){
        ImageIcon searchImgIcon = new ImageIcon(this.getClass().getResource("/images/maglass.png"));
        searchButton.setIcon(searchImgIcon);
    }
}
