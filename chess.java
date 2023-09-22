import java.util.*;

class chessboard {
    Scanner sc = new Scanner(System.in);
    int i, j;
    String board[][] = {
        {"$", "a", "b", "c", "d", "e", "f", "g", "h"},
        {"1", "LR", "LN", "LB", "Q", "K", "RB", "RN", "RR"},
        {"2", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8"},
        {"3", " ", " ", " ", " ", " ", " ", " ", " "},
        {"4", " ", " ", " ", " ", " ", " ", " ", " "},
        {"5", " ", " ", " ", " ", " ", " ", " ", " "},
        {"6", " ", " ", " ", " ", " ", " ", " ", " "},
        {"7", "p8", "p7", "p6", "p5", "p4", "p3", "p2", "p1"},
        {"8", "rr", "rn", "rb", "q", "k", "lb", "ln", "lr"}
    };

    void display() {
        for (i = 0; i <= 8; i++) {
            for (j = 0; j <= 8; j++) {
                System.out.print("|" + board[i][j] + "|\t");
            }
            System.out.println("\n");
        }
    }
}

class player extends chessboard{
    public static String f1, t1;
    public static int f2, t2;
    private String board[][];
    public player(String[][] board){
        this.board=board;
    }

    void accept() {
        System.out.println("Enter column from:");
        f1 = sc.next();
        System.out.println("Enter row from:");
        f2 = sc.nextInt();
        System.out.println("Enter column to:");
        t1 = sc.next();
        System.out.println("Enter row to:");
        t2 = sc.nextInt();
        System.out.println(f1 + f2 + t1 + t2);
        updatemovement(f1, f2, t1, t2);
    }

    void updatemovement(String f1, int f2, String t1, int t2) {
        int x1 = val(f1);
        int x2 = f2;
        int y1 = val(t1);
        int y2 = t2;
        //System.out.println(x1 + x2 + y1 + y2);
        String temp = board[x2][x1];
        //System.out.println(temp);
        board[x2][x1] = board[y2][y1];
        //System.out.println(board[x2][x1]);
        board[y2][y1] = temp;
        //System.out.println(board[y2][y1]);
    }
    
    int val(String z) {
        int t;
        switch (z) {
            case "a": t = 1; break;
            case "b": t = 2; break;
            case "c": t = 3; break;
            case "d": t = 4; break;
            case "e": t = 5; break;
            case "f": t = 6; break;
            case "g": t = 7; break;
            case "h": t = 8; break;
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
