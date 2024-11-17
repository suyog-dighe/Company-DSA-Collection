package Juspay.juspay;

import java.time.Duration;
import java.time.Instant;

public class Threading {

    static long  oddsum=0;
    static long evensum=0;
     public static void addeven(long start,long end){
         for (long i=start;i<=end;i++){
             if ((i & 1)==0){
                evensum+=i;
             }
         }
     }
     public static void oddsum(long start,long end){
         for (long i=start;i<=end;i++){
             if ((i &1)!=0){
                 oddsum+=i;
             }
         }
     }
    public static void main(String[] args) {
        long start=0;
        long end=1900000000;

        Instant starttime=Instant.now();

        addeven(start,end);
        oddsum(start,end);

        Instant stoptime=Instant.now();

        Duration duration=Duration.between(starttime,stoptime);
        System.out.println(evensum);
        System.out.println(oddsum);
        System.out.println("Sec: " + (duration.toMillis() / 1000.0));

    }
}
