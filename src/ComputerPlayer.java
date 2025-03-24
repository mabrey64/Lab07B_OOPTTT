import java.util.Random;

public class ComputerPlayer {
    private String icon;
    private Board board;
    private Random random;

    public ComputerPlayer(Board board, String icon) {
        this.board = board;
        this.icon = icon;
        this.random = new Random();
    }

    public void makeMove() {
        int row, col;
        Button[][] buttons = board.getButtons();
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!buttons[row][col].getText().isEmpty());
        buttons[row][col].setText(icon);
    }
}