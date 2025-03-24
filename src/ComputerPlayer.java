import java.util.Random;

public class ComputerPlayer {
    private String currentPlayer;
    private String icon;
    private Board board;

    public ComputerPlayer(Board board, String icon) {
        this.board = board;
        this.icon = icon;
    }

    public void makeMove() {
        // Simple AI: find the first empty cell and make a move
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.updateCell(i, j, icon)) {
                    return;
                }
            }
        }
    }
}