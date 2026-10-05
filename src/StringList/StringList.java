package StringList;

import java.util.ArrayList;

public class StringList 
{
    private ArrayList<String> strings;//Instance variable

    public StringList(){//constructor
        this.strings =  new ArrayList<String>();//initialization
    }

    public void addWord(String add){//addword in the runner
        strings.add(add);
    }

    public String toString(){//We want to represent ALL the strings in the list, just like integer list
        String result = "";//make a box for our result
        for(int i=0; i<strings.size();i++){//make a for loop to go through each stinrg in the list
            result += strings.get(i) + ", ";//add (the) string (that we got) + ,
        }
        return result;
    }

    public String reverseOne(String arg){//Helper method to reverse ONE word
        String result = "";//Make a box for result
        String[] letters = new String[arg.length()];    //Make an array of length = word length
                                                        //We will make each index its own letter
        int index = 0; //We need a different index than i
        for(int i=arg.length()-1;i>=0;i--){//Go through the END of the word to the START of the word backwards
            letters[index] = arg.substring(i,i+1);//Start of our array will be the end of our argument string
            index++;
        }
        for(int i=0;i<arg.length();i++){
            result += letters[i];//Add to the result each letter that we have
        }
        return result;//Try testing this in the runner
    }

    public String reverse(){
        String result = "";//Make a box for result
        for(int i=0; i<strings.size();i++){//For each word in strings list
            result += reverseOne(strings.get(i)) + ", ";//reverse them and add it with a comma
        }
        return result;//test this in the runner too
    }

    public String largest(){
        //Compare to according to CollegeBoard:
        /*
            Returns a value < 0 if this is less than other; returns zero if
            this is equal to other; returns a value > 0 if this is greater than
            other. Strings are ordered based upon the alphabet.
        */
        String l = strings.get(0);//Let l be our first word for now-just like not letting first integer be 0, we want it RELATIVE
        for(int i=0;i<strings.size();i++){
            if(strings.get(i).compareTo(l)>0){//Look above for definition... we're comparing strings' ith word with the first one.
                l = strings.get(i);//If it's >0, then we set a new largest
            }
        }
        return l;
    }

    public String longest(){
        String l = strings.get(0);//Same deal with relative positioning, instead of 0 here
        for(int i=0;i<strings.size();i++){//Loop through every word
            if(strings.get(i).length()>l.length()){//Compare lengths
                l = strings.get(i);//Set new longest
            }
        }
        return l;
    }

    public boolean isAlphabetical() {
        //check if compare to keeps returning something above 0
        boolean result = false;//Assume false at first
        for(int i=0; i<strings.size();i++){
            if(i==0){//Ignore the first one
                continue;
            }
            else{
                if(strings.get(i-1).compareTo(strings.get(i))<=0){//Compare the alphabeticalness of them - test in runner
                    result = true;
                }
                else{
                    result = false;
                }
            }

        }
        return result;//There's definitely a more efficient way, I'll post that later as of 10/5
    }

    public boolean findReplace(String a, String b){
        //Iterate over array list, if ti contains a, replace a with b
        //Then STOP, do not keep going- so do a while loop probably
        boolean running = true;//this is for our while loop
        int index = 0;
        int width = a.length(); //Length of the TARGET string we're replacing
        int length = 0;
        String check = "";//Make a box for waht we're checking
        while(running){
            if(index==strings.size()){//If we're at the end of the word, STOP
                running = false;
                break; //break effecitvely stops the if statemnet
            }
            length = strings.get(index).length();//Let length be the length of our first index
            check = strings.get(index);//Then let it be our relative check
            for(int i=0;i<length-width;i++){
                if(check.substring(i,i+width).equals(a)){//If what we're checking in the window matches a,
                    strings.remove(index);//remove it
                    strings.add(index, b);//then add b at index
                    return true;
                }
            }
            index++;
        }
        return false;
    }
}
