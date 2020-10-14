import java.util.*;
import java.lang.*;

public class Calculator {

    private static String negativeNumbersString = "";
    private static Boolean isNegative = false;

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println(add(obj.nextLine()));
    }

    private static int add(String numbers){
        int sum = 0;
        if(!numbers.equals("")){
            int[] num = getNumbers(numbers);
            for(int i=0; i<num.length; i++){
                if(isNegative){
                    throw new IllegalArgumentException("negatives not allowed" + negativeNumbersString);
                }
                if(num[i]<=1000){
                    sum = sum+num[i];
                }
            }
        }
        return sum;
    }

    private static int[] getNumbers(String numbers){
        char delimiter = ' ';
        String[] delimiterRemoved;
        if(numbers.startsWith("//")){
            if(numbers.charAt(2)=='['){
                int indexValue = getIndex(numbers);
                if(hasMultipleDelimiter(numbers)){
                    String delimiterString = getMultiDelimiter(numbers);
                    delimiterRemoved = delimiterRemoved1(numbers.substring(indexValue+1), delimiterString);
                } else {
                    String delimiterString = numbers.substring(3, indexValue - 1);
                    delimiterRemoved = delimiterRemoved1(numbers.substring(indexValue + 1), delimiterString);
                }
            } else{
                delimiter = numbers.charAt(2);
                delimiterRemoved = delimiterRemoved1(numbers.substring(4), Character.toString(delimiter));
            }

        } else {
            delimiterRemoved = delimiterRemoved1(numbers, ",|\n");
        }
        int[] num = new int[delimiterRemoved.length];
        for(int i=0; i< num.length; i++){
            num[i] = Integer.parseInt(delimiterRemoved[i]);
            if(num[i]<0){
                isNegative=true;
                negativeNumbersString = negativeNumbersString +" "+num[i];
            }
        }
        return num;
    }

    private static String getMultiDelimiter(String numbers){
        String delimeter = "";
        String delimiterString = numbers.substring(2,getIndex(numbers));
        String[] multiDelimeter = delimiterString.split("]");
        for(int i=0; i<multiDelimeter.length; i++){
            delimeter =delimeter+multiDelimeter[i].substring(1)+"|";
        }
        return delimeter.substring(0,delimeter.length()-1);
    }

    private static Boolean hasMultipleDelimiter(String numbers){
        String delimiterString = numbers.substring(2,getIndex(numbers));
        String[] multiDilimeter = delimiterString.split("]");
        if(multiDilimeter.length>1){
            return true;
        }
        return false;
    }

    private static int getIndex(String numbers){
        char[] obj = numbers.toCharArray();
        for(int i=0; i<numbers.length(); i++){
            if(obj[i]=='\n'){
                return i;
            }
        }
        return 0;
    }

    private static String[] delimiterRemoved1(String numbers, String regix){
        return numbers.split(regix);
    }

}
