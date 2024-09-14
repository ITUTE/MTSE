import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input = ");
        String input = sc.nextLine();
        int result = solve(input);
        System.out.println("Result = " + result);
    }

    static int solve(String s)
    {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum+= Integer.valueOf(s.charAt(i)) - 48;
        }
        return  sum;
    }
}
