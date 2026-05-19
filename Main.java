import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Random random = new Random();

        int target = random.nextInt(100) + 1;

        int guess = 0;
        int attempts=0;
        int score=0;

        while (guess != target && attempts<=5) {

            System.out.print("Enter your guess: ");

            guess = sc.nextInt();

            if (guess == target) {
                System.out.println("Correct Guess! yahooo");
                score+=5;
                System.out.println("Present score: "+score);
            }

            else if (guess > target) {
                System.out.println("Too High!");
                score-=1;
                System.out.println("Present score: "+score);
            }

            else {
                System.out.println("Too Low!");
                score=-1;
                System.out.println("Present score: "+score);
            }
            attempts++;
        }
        if(attempts>5){
            System.out.println("Chances over!");
        }
        System.out.println("Correct Guess is: 25"+target);
        System.out.println("Total score: "+score);
        if(score>=5){
            System.out.println("your score is eligible for next round ...You can play again");
            attempts=0;
        }
    }
}