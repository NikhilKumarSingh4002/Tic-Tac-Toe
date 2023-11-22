
import java.util.*;
public class TicTacToe {
    static Scanner s=new Scanner(System.in);
    static int x=0;
    public static void main(String[] args) {
        System.out.println("Let's play Tic-Tac-Toe");
        char[][]board={
            {'_','_','_'},
            {'_','_','_'},
            {'_','_','_'}
        };
        printBoard(board);
        for(int i=0;i<9;i++){
            playTurn(board);
            printBoard(board);
          if(checkWin(board)==3){
                System.out.println("Player 1 wins");
                break;
            }
            else if(checkWin(board)==-3){
                System.out.println("Player 2 wins");
                break;
            }
            else if(i==8){
                System.out.println("Tie game");
                break;
            }
        }
    }
    public static void printBoard(char[][]board){
        System.out.println();
        for(int i=0;i<board.length;i++){
            System.out.print("\t");
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println("\n");
        }
    }
    public static char turnAlternately(){
        x=x%2;
        if(x==0){
            x++;
            return 'X';
        }
        else{
            x++;
            return 'O';
        }
    }
    public static void playTurn(char[][]board){
        int b=0;
        char a=turnAlternately();
        System.out.println("Turn :"+a);
        while(b!=1){
        System.out.println("Pick a row and column number: ");
        int row=s.nextInt();
        int column=s.nextInt();
        if(board[row][column]=='_'){
            b=1;
            board[row][column]=a;
            return;
        }
        System.out.println("Spot taken, try again ");
        }
    }
    public static int WinCond(int count){
        if(Math.abs(count)==3){
            return count;
        }
        return 0;
    }
    public static int checkWin(char[][]board){
        int count=0,count1=0,count2=0,count3=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='X'){
                    count=count+1;
                }
                if(WinCond(count)==3){
                    return count;
                }
                if(board[i][j]=='O'){
                    count=count-1;
                }
                if(WinCond(count)==3){
                    return count;
                }
            }
            count=0;
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[j][i]=='X'){
                    count3=count3+1;
                }
                if(WinCond(count3)==3){
                    return count3;
                }
                if(board[j][i]=='O'){
                    count3=count3-1;
                }
                if(WinCond(count3)==3){
                    return count3;
                }
            }
            count3=0;
        }
        if(Math.abs(count3)==3){
            return count3;
        }
        for(int i=0;i<board.length;i++){
            if(board[i][i]=='X'){
                count1=count1+1;;
            }
            if(board[i][i]=='O'){
                count1=count1-1;
            }
        }
        if(Math.abs(count1)==3){
            return count1;
        }
        for(int i=0;i<board.length;i++){
            if(board[2-i][i]=='X'){
                count2=count2+1;
            }
            if(board[2-i][i]=='O'){
                count2=count2-1;
            }
        }
        if(Math.abs(count2)==3){
            return count2;
        }
        return 0;
    }
}
