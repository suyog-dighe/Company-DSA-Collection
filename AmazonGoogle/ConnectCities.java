package Graph;
import java.util.PriorityQueue;
public class ConnectCities {
    public static  class edge implements Comparable<edge>{
        int dest;
        int cost;
        public edge(int s,int c){
            this.dest=s;
            this.cost=c;
        }
        public int compareTo(edge e2){
            return this.cost-e2.cost;
        }
    }
    public static int connect_cities(int[][] cities){
        PriorityQueue<edge> pq= new PriorityQueue<>();
        boolean[] visit= new boolean[cities.length];
        pq.add(new edge(0,0));
        int finalcost=0;
        while (!pq.isEmpty()){
            edge curr= pq.remove();
            if(!visit[curr.dest]){
                visit[curr.dest]=true;
                finalcost +=curr.cost;
                for(int i=0;i<cities[curr.dest].length;i++){
                    if (cities[curr.dest][i] !=0){
                        pq.add(new edge(i,cities[curr.dest][i]));
                    }
                }
            }
        }
        return  finalcost;
    }
    public static void main(String[] args) {
        int[][] cities={{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};
        System.out.println(connect_cities(cities));
    }
}
