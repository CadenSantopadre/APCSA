package simpleLoops;

public class SimpleLoops 
{
    private int result;
    public SimpleLoops(){
        this.result = -1;
    }

    public int getResult(){
        return result;
    }

    @Override
    public String toString(){
       return ("" + result);
    }

    public void divide(int num, int denom){
        int count = 0;
        while(num >= denom){
            num -= denom;
            count++;
        }
        result = count;
    } 
    public void remainder(int num, int denom){
        while(num >= denom){
            num -= denom;
        }
        result = num;
    } 

    public void countMultiples(int start, int end){
        int count = 0;
        for(int i=start; i<end; i++){
            if(i % 4 == 0){
                count++;
            }
            if(i % 5 == 0){
                count++;
            }
            if(i % 5 == 0 && i % 4 == 0){
                count -=2;
            }
        }
        result = count;
    } 

    public void sumDigits(int num){
        int addedThing = 0;
        if(num < 0){
            num *= -1;
        }
        while(num > 0){
            int digit = num % 10;
            addedThing += digit;
            num /= 10;
        }
        result = addedThing;
    }

    public void randomSum(){
        int a = 10 + (int)(91*Math.random());
        int b = 10 + (int)(91*Math.random());
        int end = 0;
        int start = 0;

        if(b>a){ 
            end = b;
            start=a;
        }
        else{
            start=b;
            end=a;
        }

        int total = 0;
        for(int i=start; i<end; i++){
            if(i % 2 != 0){
                total += i;
            }
        }
        result = total;
    }
}
