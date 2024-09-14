import java.util.Scanner;

public class Bai02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập a = ");
        int a = sc.nextInt();
        System.out.print("Nhập b = ");
        int b = sc.nextInt();
        System.out.printf("UCLN(%d, %d) = %d \n", a, b, UCLN(a,b));
        System.out.printf("BCNN(%d, %d) = %d", a, b, BCNN(a,b));
    }

    static int UCLN(int a, int b)
    {
        a = Math.abs(a);
        b = Math.abs(b);
        while (a*b != 0)
        {
            if (a>b) a = a%b;
            else b=b%a;
        }
        return a+b;
    }

    static int BCNN(int a, int b)
    {
        return (a*b)/UCLN(a,b);
    }
}
