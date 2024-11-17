package Accenture_Ques_Paid;

public class CoconutSweet {
    public static int coconut(int n,int e,int d){
        if (n==0) return -1;
        if(e==0||d==0)return 0;
        if (n*6<e*7)return -1;
        if (d<7){
            if ((d*e)%n==0){
                return (d*e)/n;
            }else{
                return (d*e)/n + 1;
            }
        }
        int ans=0;
        int week=d/7;
        if ((week*e*7)%n==0){
            ans+=(week*e*7)/n;
        }else{
            ans+= (week*e*7)/n +1;
        }
        int left=ans*n -week*e*7;
        int days=d*7;
        int req=(days*e-left);

        ans+=(req%n==0)?(req/n):(req/n)+1;
        return ans;
    }

    public static int calculate(int s, int e, int t) {
        if (s == 0 || e == 0 || t == 0) return -1;
        if (s * 6 < e * 7) return -1;

        int total = e * t;

        int boxes = total / s; // Calculate the base number of boxes
        if (total % s != 0) {
            boxes += 1; // Add one more box if there's a remainder
        }
        return boxes;
    }

    public static void main(String[] args) {
        //no of sweet per box
        int n=5;
        //eat per day
        int e=2;
        //total days given
        int d=10;
        System.out.println(calculate(n,e,d));
//        System.out.println(coconut(n,e,d));


    }
}
