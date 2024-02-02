import java.util.ArrayList;
import java.util.Hashtable;
public class NumberConverter {
    int[] digits;
    int base;


    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int convertToDecimal(int base) {
        int exp = 0;
        int number = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            number += (int) (digits[i] * Math.pow(base, exp));
            exp++;
        }
        return number;
    }

    public String convertToBinary() {
        int number = Integer.parseInt(displayOriginalNumber());
        ArrayList<Integer> binary = new ArrayList<Integer>();
        while (number > 0){
            binary.add(number % 2);
            number /= 2;
        }
        String binStr = "";
        for (int i = binary.size() - 1; i >= 0; i--) {
            binStr += binary.get(i);
        }
        return binStr;
    }

    public String convertToOctal() {
        int number = Integer.parseInt(displayOriginalNumber());
        if (!(base == 10)){
            number = convertToDecimal(2);
        }
        ArrayList<Integer> octal = new ArrayList<Integer>();
        while (number > 0){
            octal.add(number % 8);
            number /= 8;
        }
        String octalStr = "";
        for (int i = octal.size() - 1; i >= 0; i--) {
            octalStr += octal.get(i);
        }
        return octalStr;
    }

    public String convertToHexadecimal(){
        int number = Integer.parseInt(displayOriginalNumber());
        if (!(base == 10)){
            number = convertToDecimal(base);
        }
        ArrayList<Integer> hexa = new ArrayList<Integer>();
        while (number > 0){
            hexa.add(number % 16);
            number /= 16;
        }

        ArrayList<String> hexaStrArrLst = new ArrayList<String>();
        for (int i = 0; i < hexa.size(); i++) {
            hexaStrArrLst.add(Integer.toString(hexa.get(i)));
        }

        for (int i = 0; i < hexaStrArrLst.size(); i++) {
            hexaStrArrLst.set(i, getCharacter(hexaStrArrLst.get(i)));
        }

        String hexaStr = "";
        for (int i = hexaStrArrLst.size() - 1; i >= 0; i--) {
            hexaStr += hexaStrArrLst.get(i);
        }
        return hexaStr;
    }

    private String getCharacter(String key){
        String base64 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
        Hashtable<String, String> hash64 = new Hashtable<String, String>();
        for (int i = 0; i < base64.length(); i++) {
            hash64.put(String.valueOf(i), base64.substring(i, i + 1));
        }
        return hash64.get(key);
    }

    public String convert10ToAnyBase(int customBase){
        int number = Integer.parseInt(displayOriginalNumber());
        ArrayList<Integer> custom = new ArrayList<Integer>();
        while (number > 0){
            custom.add(number % customBase);
            number /= customBase;
        }

        ArrayList<String> customStrArrLst = new ArrayList<String>();
        for (int i = 0; i < custom.size(); i++) {
            customStrArrLst.add(Integer.toString(custom.get(i)));
        }

        for (int i = 0; i < customStrArrLst.size(); i++) {
            customStrArrLst.set(i, getCharacter(customStrArrLst.get(i)));
        }

        String customStr = "";
        for (int i = customStrArrLst.size() - 1; i >= 0; i--) {
            customStr += customStrArrLst.get(i);
        }
        return customStr;
    }
}