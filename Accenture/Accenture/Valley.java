package Accenture;
import java.util.Scanner;

//unstop :- Valley
// Question 2 :- https://unstop.com/courses/unstop-practice-interview-pep/accenture/accenture-coding-assessment-29619/question-29640

public class Valley {
    static  class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    /*
    public static Node buildLinkedList(int[] arr){
        int n=arr.length;
        if(n==0){
            return null;
        }
       Node head=new Node(arr[0]);
        Node current=head;
        for(int i=1;i<n;i++){
            current.next=new Node(arr[i]);
            current=current.next;
        }
        return head;
    }
     */

    public static Node buildLinkedList(int n, Scanner sc) {
        if (n == 0) {
            return null;
        }
        Node head = new Node(sc.nextInt());
        Node current = head;
        for (int i = 1; i < n; i++) {
            current.next = new Node(sc.nextInt());
            current = current.next;
        }
        return head;
    }
    public static int countvalley(Node head){
        if(head==null || head.next==null || head.next.next==null)return 0;
        int count=0;
        Node prev=head;
        Node curr=head.next;
        Node next=curr.next;
        while (curr.data>prev.data && curr.data>next.data){
            count++;
            prev=curr;
            curr=next;
            next=next.next;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
//        int[]arr= new int[n];
//        for(int i=0;i<n;i++){
//            arr[i]=sc.nextInt();
//        }
        Node head=buildLinkedList(n,sc);
        System.out.println(countvalley(head));
    }
}
