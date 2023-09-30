import java.util.*;

//This class holds the declaration of board and display function.
class chessboard {
    Scanner sc = new Scanner(System.in);
    int i,j;
    String board[][] = {
        {"$", "h", "g", "f", "e", "d", "c", "b", "a"},
        {"1", "R", "N", "B", "K", "Q", "B", "N", "R"},
        {"2", "P", "P", "P", "P", "P", "P", "P", "P"},
        {"3", " ", " ", " ", " ", " ", " ", " ", " "},
        {"4", " ", " ", " ", " ", " ", " ", " ", " "},
        {"5", " ", " ", " ", " ", " ", " ", " ", " "},
        {"6", " ", " ", " ", " ", " ", " ", " ", " "},
        {"7", "p", "p", "p", "p", "p", "p", "p", "p"},
        {"8", "r", "n", "b", "k", "q", "b", "n", "r"}
    };

    //This function is executed everytime after the updation of the movements.
    void display() {
        for (i = 0; i <= 8; i++) {
            for (j = 0; j <= 8; j++) {
                System.out.print("|" + board[i][j] + "|\t");
            }
            System.out.println("\n");
        }
    }
}

//This is a player class which extends chessboard class in order to access the board.
class player extends chessboard{
    public static String f1, t1;
    public static int f2, t2;
    private String board[][];
    public player(String[][] board){
        this.board=board;
    }

    //This function accepts the input from user in the form of rows and columns.
    void accept() {
        System.out.println("Enter column from:");
        f1 = sc.next();
        if("cm".equals(f1))
        System.exit(0);
        System.out.println("Enter row from:");
        f2 = sc.nextInt();
        System.out.println("Enter column to:");
        t1 = sc.next();
        System.out.println("Enter row to:");
        t2 = sc.nextInt();
        System.out.println(f1 + f2 + t1 + t2);
        updatemovement(f1, f2, t1, t2);
    }

    //This function updates the movement according to accepted input.
    void updatemovement(String f1, int f2, String t1, int t2) {
        int x1 = val(f1);
        int x2 = f2;
        int y1 = val(t1);
        int y2 = t2;
        board[y2][y1] = board[x2][x1];
        board[x2][x1] = " ";
    }
    
    //This function returns the (int)index converting it from String.
    int val(String z) {
        int t;
        switch (z) {
            case "a": t = 8; break;
            case "b": t = 7; break;
            case "c": t = 6; break;
            case "d": t = 5; break;
            case "e": t = 4; break;
            case "f": t = 3; break;
            case "g": t = 2; break;
            case "h": t = 1; break;
            case "1": t = 1; break;
            case "2": t = 2; break;
            case "3": t = 3; break;
            case "4": t = 4; break;
            case "5": t = 5; break;
            case "6": t = 6; break;
            case "7": t = 7; break;
            case "8": t = 8; break;
            default: t = 0; break;
        }
        return t;
    }
}

//Main class handling 
class chess{
    public static void main(String[] args) {
        chessboard board = new chessboard();
        player p = new player(board.board);
        System.out.println("\t\t C H E S S   G A M E ");
        board.display();
        while (true) {
            p.accept();
            board.display();
        }
    }
}
