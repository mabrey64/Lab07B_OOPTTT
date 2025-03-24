public class Board
{
    private Button[][] buttons = new Button[3][3];
    private String XIcon = "X";
    private String OIcon = "O";

    public void CreateBoard()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                buttons[i][j] = new Button(i, j);
            }
        }
    }

    public void DisplayBoard()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                buttons[i][j].GetButton();
            }
        }
    }


    public boolean UpdateCell(int row, int col, String icon)
    {
        if(!buttons[row][col].isClicked())
        {
            buttons[row][col].setIcon(icon);
            buttons[row][col].Click();
            return true;
        }
        return false;
    }

    public boolean CheckWin()
    {
        for(int col=0; col < 3; col++)
        {
            //Check columns
            if (buttons[0][col].getIcon().equals(buttons[1][col].getIcon()) &&
            buttons[1][col].getIcon().equals(buttons[2][col].getIcon()) &&
            !buttons[0][col].getIcon().isEmpty()) {
                return true;
            }
        }
        for(int row=0; row < 3; row++) {
            //Check rows
            if (buttons[row][0].getIcon().equals(buttons[row][1].getIcon()) &&
            buttons[row][1].getIcon().equals(buttons[row][2].getIcon()) &&
            !buttons[row][0].getIcon().isEmpty()) {
                return true;
            }
        }
        //Check diagonals
        if (buttons[0][0].getIcon().equals(buttons[1][1].getIcon()) &&
            buttons[1][1].getIcon().equals(buttons[2][2].getIcon()) &&
            !buttons[0][0].getIcon().isEmpty()) {
                return true;
            }
        if (buttons[0][2].getIcon().equals(buttons[1][1].getIcon()) &&
            buttons[1][1].getIcon().equals(buttons[2][0].getIcon()) &&
            !buttons[0][2].getIcon().isEmpty()) {
                return true;
            }
            {
                return false;
            }
    }

    public boolean CheckTie()
    {
        boolean xFlag = false;
        boolean oFlag = false;

        //Check rows
        for (int row = 0; row < 3; row++)
        {
            if ("X".equals(buttons[row][0].getIcon()) ||
                "X".equals(buttons[row][1].getIcon()) ||
                "X".equals(buttons[row][2].getIcon())) {
                xFlag = true;
            }
            if ("O".equals(buttons[row][0].getIcon()) ||
                "O".equals(buttons[row][1].getIcon()) ||
                "O".equals(buttons[row][2].getIcon())) {
                oFlag = true;
            }
            if (!(xFlag && oFlag)) {
                return false;
            }
            xFlag = oFlag = false;
        }

        //Check columns
        for (int col = 0; col < 3; col++)
        {
            if ("X".equals(buttons[0][col].getIcon()) ||
                "X".equals(buttons[1][col].getIcon()) ||
                "X".equals(buttons[2][col].getIcon())) {
                xFlag = true;
            }
            if ("O".equals(buttons[0][col].getIcon()) ||
                "O".equals(buttons[1][col].getIcon()) ||
                "O".equals(buttons[2][col].getIcon())) {
                oFlag = true;
            }
        }
        if (!(xFlag && oFlag)) {
            return false;
        }
        xFlag = oFlag = false;

        //Check diagonals
        if ("X".equals(buttons[0][0].getIcon()) ||
            "X".equals(buttons[1][1].getIcon()) ||
            "X".equals(buttons[2][2].getIcon())) {
            xFlag = true;
        }
        if ("O".equals(buttons[0][0].getIcon()) ||
            "O".equals(buttons[1][1].getIcon()) ||
            "O".equals(buttons[2][2].getIcon())) {
            oFlag = true;
        }
        if (!(xFlag && oFlag)) {
            return false;
        }
        xFlag = oFlag = false;

        if ("X".equals(buttons[0][2].getIcon()) ||
            "X".equals(buttons[1][1].getIcon()) ||
            "X".equals(buttons[2][0].getIcon())) {
            xFlag = true;
        }
        if ("O".equals(buttons[0][2].getIcon()) ||
            "O".equals(buttons[1][1].getIcon()) ||
            "O".equals(buttons[2][0].getIcon())) {
            oFlag = true;
        }
        if (!(xFlag && oFlag)) {
            return false;
        }
        //If all the above conditions are false, then the game is a tie
        return true;
    }

    public void ResetBoard()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                buttons[i][j].ResetButton();
            }
        }
    }

    public void ClearBoard()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                buttons[i][j].setIcon("");
            }
        }
    }
}
