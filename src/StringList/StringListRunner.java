package StringList;

import java.util.Scanner;

public class StringListRunner 
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        boolean running = true;
        StringList sl = new StringList();
        String input = "";//MUST do input instead of sc.nextLine() since for some reason having it in 
        //an if check will consume it, then it's a different word for the else part
        while(running){
            input = sc.nextLine();
            if(input.equals("quit")){
                running = false;
            }
            else{
                sl.addWord(input);
            }
        }
        sc.close();
        String result = sl.toString();
        System.out.println(result);
        
        result = sl.reverse();
        System.out.println(result);
        
        result = sl.largest();
        System.out.println(result);
        
        result = sl.longest();
        System.out.println(result);
        
        
        boolean result2 = sl.isAlphabetical();
        System.out.println(result2);

        result2 = sl.findReplace("an", "cat");
        result = sl.toString();
        System.out.println(result2 + result);
    }
}

