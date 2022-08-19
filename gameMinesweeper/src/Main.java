import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to MineSweeper");
        System.out.println("Please write game size:");
        System.out.print("Row size:");
        int row = scanner.nextInt();
        System.out.print("Column size:");
        int column = scanner.nextInt();

        MineSweeper mineSweeper = new MineSweeper(row, column);
        mineSweeper.run();
    }

}
