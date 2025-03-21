public class Button
{
    private String icon;
    private int row;
    private int col;
    private boolean isClicked = false;

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

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
