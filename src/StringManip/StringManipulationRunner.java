package StringManip;

public class StringManipulationRunner {
    public static void main(String[] args){
        StringManipulation sm = new StringManipulation("crayon");
        String result = sm.iAfterE();
        System.out.println(result);
        int result2 = sm.firstVowel();
        System.out.println(result2);
        result = sm.pigLatin();
        System.out.println(result);
        result = sm.merge("flabbergasted");
        System.out.println(result);
    }
}
