import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        System.out.println(input());
    }
    public static String input(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equals("")){
            throw new RuntimeException("Ввод пустых строк запрещен");
        }
        return str;
    }
}
