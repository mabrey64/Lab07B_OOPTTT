import javax.swing.*;

public class Button
{
    private String icon;
    private int row;
    private int col;
    private boolean isClicked = false;
    JButton button = new JButton();

    public Button(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void Click() {
        isClicked = true;
    }

    public void GetButton() {
        button.setText(icon);
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void addActionListener() {
        button.addActionListener(e -> {
            if (!isClicked) {
                setIcon("X");
                Click();
                GetButton();
            }
        });
    }

    public void ResetButton() {
    }
}
