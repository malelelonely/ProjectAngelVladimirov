import java.util.*;
class Game {
    public static void main(String args[]) {
        Scanner in =new Scanner(System.in);
        System.out.println("Game Bulls and Cows :");
        System.out.println("______________________");
        System.out.print("\nEnter name for first player : ");
        String playerOne = in.next();
        System.out.print("\nEnter name for second player :");
        String playerTwo = in.next();
        String[]players = {playerOne,playerTwo};

        playGame(players);
    }

    public static String guessTheNumbers() {
        ArrayList<String> possible = new ArrayList<String>();
        for (int a = 0; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                if (b == a) continue;
                for (int c = 0; c <= 9; c++) {
                    if (c == b || c == a) continue;
                    for (int d = 0; d <= 9; d++) {
                        if (d == a || d == b || d == c) continue;
                        String numbersFound = ""+a+b+c+d;
                        possible.add(numbersFound);
                    }
                }
            }
        }
        String guess = possible.get((int)(Math.random() * possible.size()));
        return guess;
    }

    public static int feedback(String answer,String guess) {
        int bulls = 0, cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            int index = answer.indexOf(guess.charAt(i));
            if (index == i) bulls++;
            else if (index >= 0) cows++;
        }
        return bulls * 10 + cows;
    }
    public static void playGame(String[]players){
        Scanner in = new Scanner(System.in);
        final String target = guessTheNumbers();
        System.out.println("You started the game  \"Bulls and Cows\".");

        for (int i = 1; i <= 50; i++) {
            int player = i % 2;
            System.out.print(i+". ");
            System.out.println(players[player] + " is your turn :");
            String guess = in.next();
            int feedback = feedback(target, guess);
            System.out.println(guess+" - "+(feedback/10)+" bulls, "+(feedback%10)+" cows");
            if (feedback == 40) {System.out.println("CONGRATULATIONS YOU WIN " +players[player]); return;}
        }
        System.out.println("You have run out of moves. The number was - "+target);
    }
}
