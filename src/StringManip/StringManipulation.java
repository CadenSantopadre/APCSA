package StringManip;

public class StringManipulation 
{
	private String str; //INstance variable
    public StringManipulation(String str){//Constructor
        this.str = str;//Initailize instance variable
    }

    @Override
    public String toString(){
        return str;
    }

    public String iAfterE(){
        String result = "";//Make a "box" for our result string
        for(int i=0; i<str.length();i++){//Loop throuhg each letter in the string
            if(str.substring(i,i+1).equals("e") || str.substring(i,i+1).equals("E")){//If the letter we're looking at is e or E...
                result += str.substring(i,i+1);//...Add that letter
                result += "i";//AND add i
                i++; //This will skip the next letter for us... otherwise we get einveilopei
            }
            else{
                result += str.substring(i,i+1);//if not E or e, then just add it with no extra i
            }
        }
        return result;//Then return the box we had for result
    }

    public int firstVowel() {
        String character = "";//Make a box for looking at something for readability
        for(int i=0; i<str.length(); i++){//Loop through the word
            character = str.substring(i,i+1);//Set the character box as what letter we're looking at
            if(character.equals("a") || character.equals("A")){
                return i;//Return where we are in teh loop if we find a vowel
            }
            else if(character.equals("e") || character.equals("E")){
                return i;
            }
            
            else if(character.equals("i") || character.equals("I")){
                return i;
            }
            
            else if(character.equals("o") || character.equals("O")){
                return i;
            }
            
            else if(character.equals("u") || character.equals("U")){
                return i;
            }
        }
        return -1;//if no vowels, return -1, since we start at 0 
    }

    public String pigLatin() {
        String result = "";
        int i = firstVowel();//FirstVowel tells us where our first vowel will be so...
        String before = str.substring(0,i);//the part before the vowel will go up to i
        String after = str.substring(i,str.length());//Then the rest is from i to length
        result += after;//Flip it so after comes first
        result += before;
        result += "ay";//Then add ay
        return result;
    }

    public String merge(String add) {
        String result = "";
        String character = "";
        int least = 0;
        //int smallest = Math.min(add.length(), str.length()); is another way to assign length
        if(str.length() > add.length()){
            least = add.length();
        }
        else{
            least = str.length();
        }
        for(int i=0; i<least;i++){
            if(i % 2 == 0){
                character = str.substring(i,i+1);
                result += character;
            }
            else {
                character = add.substring(i,i+1);
                result += character;
            }
        }
        return result;
    }
}
