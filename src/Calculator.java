import java.util.*;
import java.lang.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println(add(obj.nextLine()));
    }

    private static int add(String numbers){
        int sum = 0;
        if(!numbers.equals("")){
            int[] num = getNumbers(numbers);
            for(int i=0; i<num.length; i++){
                sum = sum+num[i];
            }
        }
        return sum;
    }

    private static int[] getNumbers(String numbers){
        char delimiter = ' ';
        String[] delimiterRemoved;
        if(numbers.startsWith("//")){
            delimiter = numbers.charAt(2);
            delimiterRemoved = delimiterRemoved1(numbers.substring(4), Character.toString(delimiter));
        } else {
            delimiterRemoved = delimiterRemoved1(numbers, ",|\n");
        }
        int[] num = new int[delimiterRemoved.length];
        for(int i=0; i< num.length; i++){
            num[i] = Integer.parseInt(delimiterRemoved[i]);
        }
        return num;
    }

    private static String[] delimiterRemoved1(String numbers, String regix){
        String[] delimiterRemoved = numbers.split(regix);
        return delimiterRemoved;
    }

}
