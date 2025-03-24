import javax.swing.JFrame;

public class Game
{
    private int MoveCount = 0;
    private String CurrentPlayer = "X";
    private JFrame frame;
    private Player player;
    private ComputerPlayer AIPlayer;
    private Board board;

    public Game() {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board = new Board();
        board.CreateBoard();
        frame.add(board);
        frame.setVisible(true);
    }

    public void StartGame()
    {

    }

    public String GetCurrentPlayer() {
        return CurrentPlayer;
    }

    public void SwitchPlayer()
    {
        CurrentPlayer = CurrentPlayer.equals("X") ? "O" : "X";
    }

    public boolean IsWin() {
        return board.CheckWin();
    }

    public boolean IsTie() {
        return board.CheckTie();
    }
}
