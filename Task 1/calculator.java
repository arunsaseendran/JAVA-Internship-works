import java.util.Scanner;

public class calculator
{
    public static  double add(double num1,double num2)
    {
        return num1+num2;

    }
    public static double substract(double num1,double num2)
    {
        return num1-num2;
    }

    public static double multiplication(double num1,double num2)
    {
        return num1*num2;
    }

    public static double division(double num1,double num2)
    {
        return num1/num2;
    }



public static void main(String[] args)
{
    Scanner scanner=new Scanner(System.in);
    System.out.println("=================== Simple Java Calculator ===================");

    boolean contin =true;
    double result=0;

    while (contin) {
        System.out.println("Enter First Number : ");
        double  num1=scanner.nextInt();
        System.out.println("\n Enter Operation to be Performed '+','-','*','/' : ");
        char op=scanner.next().charAt(0);
        System.out.println("\nEnter Second Number : ");
        double num2=scanner.nextInt();

        switch (op) {
            case '+':
                result = add(num1,num2);
                break;
            case '-':
                result = substract(num1,num2);
                break;
            case '*':
                result = multiplication(num1, num2);
                break;
            case '/':
                result = division(num1, num2);
                break;
        
            default:
                System.out.println("Not A Valid Operator");
                break;
        }

        System.out.println(num1+" "+op+" "+num2+" = "+result);

        


        
    }
    scanner.close();
    
}
}