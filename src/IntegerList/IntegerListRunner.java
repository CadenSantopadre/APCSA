package IntegerList;

import java.util.Scanner;

public class IntegerListRunner {
    public static void main(String[] args){
        IntegerList il = new IntegerList();
        Scanner sc = new Scanner(System.in);

        boolean active = true;
        while(active){
            int add = sc.nextInt();
            il.add(add);
            if(add == 999){
                il.removeLast();

                active = false;

                sc.close();
            }
        }

        System.out.println(il);

        il.add(27);
        System.out.println(il);

        int lar = il.getLargest();
        System.out.println(lar);

        double avg = il.average();
        System.out.println(avg);

        boolean isInc = il.isIncreasing();
        System.out.println(isInc);

        int sLar = il.getSecondLargest();
        System.out.println(sLar);

        int removed = il.removeBelowThreshold(12);
        System.out.println(removed);
    }
}
