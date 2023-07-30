import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Ex1 {
    public static void main(String[] args) {
        int x =  input();
        System.out.println(x);
    }
   public static int input(){
       int x;
       String str = "";
       while (!str.equals("q")) {
           Scanner scanner = new Scanner(System.in);
           System.out.println("Введите число или нажмите q для выхода");
           str = scanner.next().toLowerCase();
           if(!str.equals(null)){
           try {
               x = Integer.parseInt(str);
               System.out.println("все правильно ваше число "+ x + " принято");
               return x;

           } catch (Exception e) {
               System.out.println("это не число попробуйте еще раз");
           }

           }
       }
   return 0;
    }

}

