package IntegerList;

import java.util.ArrayList;

public class IntegerList {
    ArrayList<Integer> ints = new ArrayList<>();//Instance variable

    public IntegerList(){
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
        int sum = 0;
        for(int i=0; i<ints.size(); i++){
            sum += ints.get(i);
        }

        return (double) sum / ints.size();
    }

    public int getLargest(){
        int largest = ints.get(0);

        for(int i=0; i<ints.size(); i++){
            if(ints.get(i) > largest){
                largest = ints.get(i);
            }
        }
        return largest;
    }

    public int getSecondLargest(){
        int largest = ints.get(0);
        int sLargest = 0;
        for(int i=0; i<ints.size(); i++){
            if(ints.get(i) > largest){
                sLargest = largest;
                largest = ints.get(i);
            }
        }
        return sLargest;
    }

    public int countOdds() {
        int count = 0;
        for(int i=0; i<ints.size(); i++){
            if(ints.get(i) % 2 != 0){
                count++;
            }
        }
        return count;
    }

    public boolean isIncreasing() {
        boolean isInc = true;

        for(int i=0; i<ints.size()-1; i++){
            if(ints.get(i) - ints.get(i+1) > 0){
                isInc = false;
            }
        }
        return isInc;
    }

}
