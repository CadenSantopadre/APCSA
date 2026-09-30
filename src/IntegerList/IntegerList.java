package IntegerList;

import java.util.ArrayList;

public class IntegerList {
    ArrayList<Integer> ints;//Instance variable

    public IntegerList(){
        ints = new ArrayList<>();
        //Constructor
    }

    //Helper methods
    public void add(int add){
        ints.add(add);
    }

    public void clear(){
        //We need to get rid of all things in the arraylist...
        while(ints.size()!=0){
            ints.remove(0);
        }
    }

    public void removeLast() {
        ints.remove(ints.size() - 1);
    }

    @Override
    public String toString(){
        //We want something that returns val + , over and over again
        String comma = ",";
        String result = "";
        for(int i=0; i<ints.size(); i++){
            result += ints.get(i) + comma;
        }
        return result;
    }

    //End of helper methods


    public double average(){
        int sum = 0; //Add up all items, then divide by how many there were(size)
        for(int i=0; i<ints.size(); i++){
            sum += ints.get(i);
        }

        //Make sure to cast
        return (double) sum / ints.size();
    }

    public int getLargest(){
        //Start with a relative number, NOT 0 or some arbitrary number
        int largest = ints.get(0);

        //Look through each integer with a for loop
        for(int i=0; i<ints.size(); i++){
            //If something is GREATER THAN largest...
            if(ints.get(i) > largest){
                //...set the new largest to whatever is largest in the int
                largest = ints.get(i);
            }
        }
        return largest;
    }

    public int getSecondLargest(){
        int largest = ints.get(0);
        int sLargest = 0;
        //Same logic as before
        for(int i=0; i<ints.size(); i++){
            if(ints.get(i) > largest){
                //Make sure to set sLargest first
                sLargest = largest;
                //Then set the new largest
                largest = ints.get(i);
            }
        }
        return sLargest;
    }

    public int countOdds() {
        int count = 0;
        for(int i=0; i<ints.size(); i++){
            //If NOT divisible by 2...
            if(ints.get(i) % 2 != 0){
                //...then add to count
                count++;
            }
        }
        return count;
    }

    public boolean isIncreasing() {
        //Assume it's increasing for now, when we prove it wrong ONCE, then it's false
        //That's why at the end we have return true

        //ints.size()-1 becuase we do a phase shift of 1
        for(int i=0; i<ints.size()-1; i++){
            //There's probably a way to do this by just doing ints.get(i) > ints.get(i+1) or something
            if(ints.get(i) - ints.get(i+1) > 0){
                //once it's proven false, it's false no matter what
                return false;
            }
        }
        return true;
    }

    //Not needed for integerlist but is very helpful to know
    public int removeBelowThreshold(int threshold){
        //Make a local variable to represent a box for count
        int count = 0;
        //For loop to look at each number
        for(int i=0; i<ints.size();i++){
            //If something is LOWER THAN the threshold...
            if(ints.get(i) < threshold){
                //...then remove it
                ints.remove(i);
                //Make sure to shift the index
                i--;
                //Then add to the count
                count++;
            }
        }
        return count;
    }
}
