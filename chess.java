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
        if(isValid(x2,x1,y2,y1))
        {
            board[y2][y1] = board[x2][x1];
            board[x2][x1] = " ";
        }
        else
            System.out.println("Invalid move");
    }
    
    //Conditions for pieces
    boolean isValid(int x2,int x1,int y2,int y1)
    {
        switch(board[x2][x1])
        {
            case "R" :
            case "r" : if(x2!=y2 && x1!=y1)
                        return false;
                        else
                        {
                            if(Rook(x2,x1,y2,y1)) {
                                return true;
                            }else {
                                return false;
                            }
                        }
            case "B" : 
            case "b" : if(x2==y2 && x1==y1)
                        return false;
                        else
                        {
                            if(Bishop(x2,x1,y2,y1)) {
                                return true;
                            }else {
                                return false;
                            }
                        }
            case "N" : 
            case "n" : if(x2==y2 && x1==y1)
                        return false;
                        else
                        {
                            if(Knight(x2,x1,y2,y1)) {
                                return true;
                            }else {
                                return false;
                            }
                        } 
            case "Q" :  
            case "q" : if(x2!=y2 && x1!=y1)
                        {
                            if(Bishop(x2,x1,y2,y1)) {
                                return true;
                            }else {
                                return false;
                            }
                        }
                        else if(x2==y2 || x1==y1)
                        {
                            if(Rook(x2,x1,y2,y1)) {
                                return true;
                            }else {
                                return false;
                            }
                        }
                        else
                        return false;
            case "K" :
            case "k" : if(Math.abs(y2-x2)==1 || Math.abs(y1-x1)==1)
                        return true;
                        else
                        return false;
        }
        return true;
    }

    //Knight condition
    boolean Knight(int x1, int y1, int x2, int y2) {
    int dx = Math.abs(x2 - x1);
    int dy = Math.abs(y2 - y1);

    if((dx == 2 && dy == 1) || (dx == 1 && dy == 2))
    return true;
    else 
    return false;
    }

    //Bishop condition
    boolean Bishop(int x1, int y1, int x2, int y2) {
    if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
        int minX = Math.min(x1, x2);
        int minY = Math.min(y1, y2);
        int maxX = Math.max(x1, x2);
        int maxY = Math.max(y1, y2);

        for (int i = 1; i < Math.abs(x1 - x2); i++) {
            int checkX = minX + i;
            int checkY = minY + i;
            if (!board[checkX][checkY].equals(" ")) {
                return false;
            }
        }
        return true; 
    }
    return false;
}


    //Rook condition
    boolean Rook(int x2,int x1,int y2,int y1)
    {
        if(x2==y2)
        {
            int max=Math.max(y1,x1);
            int min=Math.min(y1,x1);
            for(int i=min+1;i<max;i++)
            {
                if(!board[x2][i].equals(" ")) {
                    return false;
                }
            }
            return true;
        }
        else if(x1==y1)
        {
            int max=Math.max(y2,x2);
            int min=Math.min(y2,x2);
            for(int i=min+1;i<max;i++)
            {
                if(!board[i][x1].equals(" ")) {
                    return false;
                }
            }
            return true;
        }
        return true;
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
