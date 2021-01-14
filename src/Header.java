import javax.swing.*;
import java.awt.Image;



public class Header extends JLabel {
    static final long serialVersionUID = 42L;
    public Header()  {
        ImageIcon headImgIcon = new ImageIcon(this.getClass().getResource("/images/logo.png"));
        Image headImg = headImgIcon.getImage().getScaledInstance(1080, 119, Image.SCALE_SMOOTH);
        ImageIcon headIcon = new ImageIcon(headImg);

        this.setIcon(headIcon);
    }


}
