import javax.swing.*;

public class Button extends JButton {
    private int row;
    private int col;
    private boolean clicked = false;
    private final ImageIcon X_Icon = new ImageIcon("path/to/x_icon.png");
    private final ImageIcon O_Icon = new ImageIcon("path/to/o_icon.png");
    private Game frame;

    public Button(int row, int col, Game frame) {
        this.row = row;
        this.col = col;
        this.frame = frame;
    }

    public void setXIcon() {
        setIcon(X_Icon);
    }

    public void setOIcon() {
        setIcon(O_Icon);
    }

    public void clearIcon() {
        setIcon((Icon) null);
    }

    public void turnOrder() {
        if (getIcon() == null) {
            if ("X".equals(frame.getCurrentPlayer())) {
                setXIcon();
            } else {
                setOIcon();
            }
            frame.handleMove(row, col);
        } else {
            JOptionPane.showMessageDialog(this, "Illegal Move", "Illegal Move", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JButton getButton() {
        return this;
    }
}