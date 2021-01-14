import javax.swing.*;


public class SearchBtn extends JButton {
    static final long serialVersionUID = 42L;

    public  SearchBtn(){
        ImageIcon searchImgIcon = new ImageIcon(this.getClass().getResource("/images/maglass.png"));
        this.setIcon(searchImgIcon);
    }
}
