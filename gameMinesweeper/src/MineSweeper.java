import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNumber;
    int colNumber;
    int size;
    int mine;
    boolean game=true;
    String[][] map;
    String[][] board;

    Random random=new Random();
    Scanner scanner=new Scanner(System.in);
    MineSweeper(int rowNumber,int colNumber){
        this.rowNumber=rowNumber;
        this.colNumber=colNumber;
        this.map=new String[rowNumber][colNumber];
        this.board=new String[rowNumber][colNumber];
        this.size=rowNumber*colNumber;
        mine=this.size/4;
    }

    public void run() {
        int success=0;
        prepareGame();
        mineMap();
        print(map);
        System.out.println("Game Start");
        while(game){
            print(board);
            System.out.print("Row:");
            int row=scanner.nextInt();
            System.out.print("Column:");
            int column=scanner.nextInt();
            if(row<0 ||row>=rowNumber){
                System.out.println("invalid coordinate");
                continue;
            }
            if(column<0 ||column>=colNumber){
                System.out.println("invalid coordinate");
                continue;
            }
            if(map[row][column]!="*"){
                check(row,column);
                success++;
                if(success==(size-mine)){
                    System.out.println("Congratulations:)");
                }
            }else{
                game=false;
                System.out.println("Game Over:(");
            }
        }
    }
    public  void check(int r,int c){
        if(map[r][c]=="-"){
            if((c<colNumber-1) &&(map[r][c]=="-")){
                board[r][c]="1";
            }
            if((r<rowNumber-3) &&(map[r+1][c]=="-")){
                board[r][c]="1";
            }
            if((r>0) &&(map[r-1][c]=="-")){
                board[r][c]="1";
            }
            if((c>0) &&(map[r][c-1]=="-")){
                board[r][c]="1";
            }

        }
    }
    public  void prepareGame() {

        for (int i = 0; i < this.rowNumber; i++) {
            for (int j = 0; j < this.colNumber; j++) {
                map[i][j] = "-";
                board[i][j] = "-";
            }
        }
    }
    public void mineMap(){
        int randRow;
        int randColumn;
        int count = 0;
        while(count!=mine){
            randRow=random.nextInt(rowNumber);
            randColumn=random.nextInt(colNumber);
            if(map[randRow][randColumn]!="*") {
                map[randRow][randColumn] = "*";
                count++;
            }
            }
    }


    public  void print(String[][] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){

                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }


}