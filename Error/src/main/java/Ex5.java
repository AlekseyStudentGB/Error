import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) throws ParseException, NullPointerException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные пользователя в соответствующем формате ");
        String str = scanner.nextLine();
        String[] mass = str.split(" ");
        System.out.println(mass.length);
        if (mass.length<6 || mass.length > 6) {
            throw new RuntimeException("Произошла ошибка!\nВозможно вы указали лишние данные или данные не корректно разделены пробелом");
        }
        checkDateValid(mass[3]);
        checkNumber(mass[4]);
        checkGender(mass[5]);
        try {
            File file = new File(mass[0]+".txt");
            if (file.createNewFile()) {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bf = new BufferedWriter(fw);
                bf.write(str);
                bf.close();
                fw.close();
            }else {

                Scanner scanner1 = new Scanner(file);
                String s = "";
                while (scanner1.hasNext()){
                    s += scanner1.nextLine()+"\n";
                }
                System.out.println(s);
                FileWriter fw = new FileWriter(file);
                BufferedWriter bf = new BufferedWriter(fw);
                bf.write(s + str+"\n");
                bf.close();
                fw.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void checkDateValid(String date)  {
        final String DATE_FORMAT = "dd.MM.yyyy";

        try {
            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            format.setLenient(false);
            format.parse(date);

        } catch (ParseException e) {
            throw new RuntimeException("Сохранение данных не возможно по причине не соответствия формата даты образцу ");
        }


    }
    public static void checkNumber(String num){
        try {
            int n = Integer.parseInt(num);
        }catch (NumberFormatException e){
           throw new NumberFormatException("Телефонный номер содержит не допустимые числа");
        }
    }
    public static void checkGender(String gender){
        if (!gender.equals("m") || !gender.equals("f")){
            throw new RuntimeException("Пол указан не верно");
        }

    }
}
