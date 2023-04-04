package Heap_Priority_Queues;
import java.util.*;
public class Sliding_Window {
    static class pair implements Comparable<pair> {
        int number;
        int idx;
        public pair(int number, int idx){
            this.number = number;
            this.idx = idx;
        }
        @Override
        public int compareTo(pair p2){
            return  p2.number- this.number;
        }
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int k =3;
        int result []= new int [arr.length-k+1];
        PriorityQueue<pair> pq = new PriorityQueue<>();

        for(int i= 0; i<k; i++){
            pq.add(new pair(arr[i],i));

        }
        result[0] = pq.peek().number;
        for(int i = k; i<arr.length; i++){
            while(pq.size()> 0 && pq.peek().idx <=(i-k)){
                pq.remove();
            }
            pq.add(new pair(arr[i],i));
            result[i-k+1] = pq.peek().number;
        }
        for(int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }

    }
}
