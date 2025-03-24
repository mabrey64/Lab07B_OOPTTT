import javax.swing.*;
import java.awt.*;

public class Board {
    private JPanel gameBoardPanel;
    private Button[][] buttons;

    public Board(Game game) {
        gameBoardPanel = new JPanel(new GridLayout(3, 3));
        buttons = new Button[3][3];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new Button(row, col, game);
                gameBoardPanel.add(buttons[row][col]);
            }
        }
    }

    public JPanel getGameBoardPanel() {
        return gameBoardPanel;
    }

    public Button[][] getButtons() {
        return buttons;
    }

    public boolean isColWin(int col, String currentPlayer) {
        for (int row = 0; row < 3; row++) {
            if (buttons[row][col] == null || !buttons[row][col].getText().equals(currentPlayer)) {
                return false;
            }
        }
        return true;
    }

    public boolean isRowWin(int row, String currentPlayer) {
        for (int col = 0; col < 3; col++) {
            if (buttons[row][col] == null || !buttons[row][col].getText().equals(currentPlayer)) {
                return false;
            }
        }
        return true;
    }

    public boolean isDiagonalWin(String currentPlayer) {
        boolean diagonal1 = true;
        boolean diagonal2 = true;
        for (int i = 0; i < 3; i++) {
            if (buttons[i][i] == null || !buttons[i][i].getText().equals(currentPlayer)) {
                diagonal1 = false;
            }
            if (buttons[i][2 - i] == null || !buttons[i][2 - i].getText().equals(currentPlayer)) {
                diagonal2 = false;
            }
        }
        return diagonal1 || diagonal2;
    }

    public boolean isWin(String currentPlayer) {
        for (int i = 0; i < 3; i++) {
            if (isRowWin(i, currentPlayer) || isColWin(i, currentPlayer)) {
                return true;
            }
        }
        return isDiagonalWin(currentPlayer);
    }

    public boolean isTie() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean updateCell(int row, int col, String icon) {
        if (buttons[row][col].getText().isEmpty()) {
            buttons[row][col].setText(icon);
            return true;
        }
        return false;
    }
}