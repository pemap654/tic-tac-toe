import java.util.*;
public class TicTacToe {
    public static final String[][] BOXS = new String[3][3];

    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        String play = "yes";
        while (play.equals("yes")){
            String[] playerNames = Intro(console);
            String winner = eachTurn(console, playerNames);
            if (winner.equals("tie")){
                endGame(playerNames);
            }
            else {
                System.out.println(winner + " win!!!");
            }
            System.out.println();
            System.out.print("Do you want to play again? ");
            play = console.next();
        }
    }

    public static String[] Intro (Scanner console){
        System.out.println("Welcome to tic tac tok game");
        String[] names = new String[2];
        for (int i = 0; i < 2; i++){
            System.out.print("player " + (i + 1) + ": ");
            String input = console.next();
            names[i] = input;
        }
        return names;
    }

    public static String eachTurn(Scanner console, String[] names){
        String[][] frameGame = new String[3][3];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 2; j++){
                System.out.println(names[j] + "'s turn:");
                System.out.print("Enter row number: ");
                int rowNum = console.nextInt();
                System.out.print("Enter collumn number: ");
                int collumnNum = console.nextInt();
                String[] XO = {"X", "O"};
                frameGame[rowNum][collumnNum] = XO[j];
                for (int k = 0; k < frameGame.length; k++){
                    System.out.println(Arrays.toString(frameGame[k]));
                }
                System.out.println();
                if (frameGame[0][0] == XO[j] && frameGame[1][1] == XO[j] && frameGame[2][2] == XO[j]){
                    return names[j];
                }
                else if (frameGame[0][0] == XO[j] && frameGame[0][1] == XO[j] && frameGame[0][2] == XO[j]){
                    return names[j];
                }
                else if (frameGame[1][0] == XO[j] && frameGame[1][1] == XO[j] && frameGame[1][2] == XO[j]){
                    return names[j];
                }
                else if (frameGame[2][0] == XO[j] && frameGame[2][1] == XO[j] && frameGame[2][2] == XO[j]){
                    return names[j];
                }
            }
        }
        return "tie";
    }

    public static void endGame(String[] names){
        System.out.println(names[0] + " and " + names[1] + " are ties");
    }
}
