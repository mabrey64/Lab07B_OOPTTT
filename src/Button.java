import javax.swing.*;
import java.awt.*;


public class Button extends JButton {
    private int row;
    private int col;
    private boolean clicked = false;
    private static final ImageIcon X_Icon = resizeIcon(new ImageIcon("x.png"), 100, 100);
    private static final ImageIcon O_Icon = resizeIcon(new ImageIcon("o.png"), 100, 100);
    private Game frame;

    public Button(int row, int col, Game frame) {
        this.row = row;
        this.col = col;
        this.frame = frame;
        setFont(new Font("Arial", Font.PLAIN, 40));
    }

    public JButton getButton() {
        return this;
    }

    //This method wasn't included in the CRC cards, but it is used to resize the icons
    private static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
}