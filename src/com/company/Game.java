import java.util.*;
class Game {
    public static void main(String args[]) {
        Scanner in =new Scanner(System.in);
        System.out.println("Game Bull and Cows :");
        System.out.println("______________________");
        System.out.print("\nEnter name for first player : ");
        String playerOne = in.next();
        System.out.print("\nEnter name for second player :");
        String playerTwo = in.next();
        String[]players = {playerOne,playerTwo};

        playGame(players);
    }

    public static String getNumber() {
        ArrayList<String> possib = new ArrayList<String>();
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                if (b == a) continue;
                for (int c = 1; c <= 9; c++) {
                    if (c == b || c == a) continue;
                    for (int d = 1; d <= 9; d++) {
                        if (d == a || d == b || d == c) continue;
                        String cnt = ""+a+b+c+d;
                        possib.add(cnt);
                    }
                }
            }
        }
        String guess = possib.get((int)(Math.random() * possib.size()));
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
        final String target = getNumber();
        System.out.println("You started the game  \"Bull and Cows\".");

        for (int i = 1; i <= 30; i++) {
            int player = i % 2;
            System.out.print(i+". ");
            System.out.println(players[player] + " is your turn");
            boolean currentPlayerMove = true;
            String guess = in.next();
            int feedback = feedback(target, guess);
            System.out.println(guess+" - "+(feedback/10)+" bulls, "+(feedback%10)+" cows");
            if (feedback == 40) {System.out.println("CONGRATULATIONS! YOU WIN! "+player); return;}
        }
        System.out.println("You have run out of moves. The number was - "+target);
    }
}