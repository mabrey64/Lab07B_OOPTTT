import javax.swing.*;
import java.awt.*;

public class Game {
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private String currentPlayer = "X";
    private Board board;
    private int moveCount = 0;
    private static final int MovesForTie = 9;
    private ComputerPlayer AI;

    public Game() {
        // Initialize the components
        buttonPanel = new JPanel();
        mainPanel = new JPanel(new BorderLayout());

        // Set the layout for the main panel
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Set the title of the frame
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the game board panel
        board = new Board(this);
        mainPanel.add(board.getGameBoardPanel(), BorderLayout.CENTER);

        // Initialize the computer player
        AI = new ComputerPlayer(board, "O");

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        mainPanel.add(exitButton, BorderLayout.NORTH);

        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);

        frame.add(mainPanel);
        startGame();
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void startGame() {
        Button[][] buttons = board.getButtons();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                final int r = row;
                final int c = col;
                buttons[row][col].addActionListener(e -> handleMove(r, c));
            }
        }
    }

    public void handleMove(int row, int col) {
        Button[][] buttons = board.getButtons();
        if (!buttons[row][col].isEnabled() || !buttons[row][col].getText().isEmpty()) {
            return;
        }

        buttons[row][col].setText(currentPlayer);
        moveCount++;

        if (board.isWin(currentPlayer)) {
            int response = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Player " + currentPlayer + " wins!", JOptionPane.YES_NO_OPTION);
            SwingUtilities.invokeLater(() -> {
                disableAllButtons();
                newGame();
            });

            if (response == JOptionPane.YES_OPTION) {
                startGame();
            } else {
                JOptionPane.showMessageDialog(null, "The user has exited the game", "Exit", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        } else if (moveCount >= MovesForTie && board.isTie()) {
            int response = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "The game is a tie!", JOptionPane.YES_NO_OPTION);
            SwingUtilities.invokeLater(() -> {
                disableAllButtons();
                newGame();
            });

            if (response == JOptionPane.YES_OPTION) {
                startGame();
            } else {
                JOptionPane.showMessageDialog(null, "The user has exited the game", "Exit", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        } else {
            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
            if (currentPlayer.equals("O")) {
                AI.makeMove();
                moveCount++;
                if (board.isWin(currentPlayer)) {
                    int response = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Player " + currentPlayer + " wins!", JOptionPane.YES_NO_OPTION);
                    SwingUtilities.invokeLater(() -> {
                        disableAllButtons();
                        newGame();
                    });

                    if (response == JOptionPane.YES_OPTION) {
                        startGame();
                    } else {
                        JOptionPane.showMessageDialog(null, "The user has exited the game", "Exit", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                } else if (moveCount >= MovesForTie && board.isTie()) {
                    int response = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "The game is a tie!", JOptionPane.YES_NO_OPTION);
                    SwingUtilities.invokeLater(() -> {
                        disableAllButtons();
                        newGame();
                    });

                    if (response == JOptionPane.YES_OPTION) {
                        startGame();
                    } else {
                        JOptionPane.showMessageDialog(null, "The user has exited the game", "Exit", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                }
                currentPlayer = "X";
            }
        }
    }

    private void disableAllButtons() {
        Button[][] buttons = board.getButtons();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setEnabled(false);
            }
        }
    }

    private void newGame() {
        Button[][] buttons = board.getButtons();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
                buttons[row][col].setEnabled(true);
            }
        }
        moveCount = 0;
        currentPlayer = "X";
    }
}