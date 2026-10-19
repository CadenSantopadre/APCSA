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

    //EXTRA STUFF BELOW


    public int countEs(){
        int count = 0; //Make a box for count
        for(int i=0; i<str.length(); i++){ //make a loop over each letter in the string
            String ch = str.substring(i,i+1); //Make the character we're looking at be called ch
            if(ch.equals("e") || ch.equals("E")){//If ch is e, then 
                count++;//add 1 to count
            }
        }
        return count;//after the loop, return count
    }

    public int countEs2(){ //this one uses indexOf
        int count = 0;
        int index = 0;
        while(str.substring(index).indexOf("e") != -1){
            index += str.substring(index).indexOf("e") + 1;//Mr. Morton did it a weird way with temp... I like this more
            count++;
        }

        return count;
    }

    public String removeEs(){
        String result = "";
        for(int i=0; i<str.length(); i++){
            String ch = str.substring(i,i+1);
            if(!ch.equals("e")){
                result += ch;
            }
        }
        return result;
    }

    public String removeEs2(){
        String noEs = str;
        while(noEs.indexOf("e") != -1){
            int index = noEs.indexOf("e");
            noEs = noEs.substring(0,index) + noEs.substring(index+1);
        }
        return noEs;
    }

    public String removeStr(String remove){
        String removed = str;

        while(removed.indexOf(remove) != -1){
            int index = removed.indexOf(remove);
            removed = removed.substring(0, index) + removed.substring(index+remove.length());
        }
        return removed;
    }

    public String replaceEs(String replace){
        String result = "";

        for(int i=0;i<str.length();i++){
            String ch = str.substring(i,i+1);
            if(ch.equals("e")){
                result += replace;
            }
            else {
                result += ch;
            }
        }
        return result;
    }

    public int countDoubleLetters(){
        int count = 0;
        for(int i=0; i<str.length()-1; i++){
            String cset = str.substring(i,i+2);
            if(cset.substring(0,1).equals(cset.substring(1))){
                count++;
            }
        }
        return count;
    }

    public String largestLetter(){
        String lar = str.substring(0,1);
        for(int i=0; i<str.length(); i++){
            String ch = str.substring(i,i+1);
            if(ch.compareTo(lar) > 0){
                lar = ch;
            }
        }
        return lar;
    }

    public String removeBelowThreshold(String threshold){
        String result = "";
        for(int i=0; i<str.length(); i++){
            String ch = str.substring(i,i+1);
            if(ch.compareTo(threshold) >= 0){
                result += ch;
            }
        }
        return result;
    }
}
