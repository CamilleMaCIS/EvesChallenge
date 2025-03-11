
public class Main {
    public static void main(String[] args) {

        CircularLinkedList suitors = new CircularLinkedList();
        suitors.adjustSuitorListSize(5);
        CircularLinkedList suitors2 = new CircularLinkedList();
        suitors2.adjustSuitorListSize(7);
        CircularLinkedList suitors3 = new CircularLinkedList();
        suitors3.adjustSuitorListSize(6);
        CircularLinkedList suitors4 = new CircularLinkedList();
        suitors4.adjustSuitorListSize(9);
        CircularLinkedList suitors5 = new CircularLinkedList();
        suitors5.adjustSuitorListSize(8);

        System.out.println(suitors.print());
        System.out.println(suitors2.print());
        System.out.println(suitors3.print());
        System.out.println(suitors4.print());
        System.out.println(suitors5.print());

        System.out.println(suitors.determineWinner());
        System.out.println(suitors2.determineWinner());
        System.out.println(suitors3.determineWinner());
        System.out.println(suitors4.determineWinner());
        System.out.println(suitors5.determineWinner());

        /** ANSWERS!! */

//        12345	initial list of suitors, start counting from 1
//        1245	Suitor 3 eliminated; continue from 4
//        245	Suitor 1 eliminated; continue from 2
//        24	Suitor 5 eliminated; continue from 2
//        4 	Suitor 2 eliminated; the lucky winner is 4
//
//        1234567	initial list of suitors, start counting from 1
//        124567	Suitor 3 eliminated; continue from 4
//        12457		Suitor 6 eliminated; continue from 7
//        1457		Suitor 2 eliminated; continue from 4
//        145		Suitor 7 eliminated; continue from 1
//        14		Suitor 5 eliminated; continue from 1
//        4		    Suitor 1 eliminated; the lucky winner is 4
//
//        123456	initial list of suitors, start counting from 1
//        12456		Suitor 3 eliminated; continue from 4
//        1245		Suitor 6 eliminated; continue from 1
//        125		Suitor 4 eliminated; continue from 5
//        15		Suitor 2 eliminated; continue from 5
//        1		Suitor 5 eliminated; the lucky winner is 1
//
//        123456789	initial list of suitors, start counting from 1
//        12456789	Suitor 3 eliminated; continue from 4
//        1245789	Suitor 6 eliminated; continue from 7
//        124578	Suitor 9 eliminated; continue from 1
//        12578	    Suitor 4 eliminated; continue from 5
//        1257	    Suitor 8 eliminated; continue from 1
//        127	    Suitor 5 eliminated; continue from 7
//        17	    Suitor 2 eliminated; continue from 7
//        1	        Suitor 7 eliminated; the lucky winner is 1
//
//        12345678	initial list of suitors, start counting from 1
//        1245678	Suitor 3 eliminated; continue from 4
//        124578	Suitor 6 eliminated; continue from 7
//        24578 	Suitor 1 eliminated; continue from 2
//        2478  	Suitor 5 eliminated; continue from 7
//        478  `	Suitor 2 eliminated; continue from 4
//        47      `	Suitor 8 eliminated; continue from 4
//        7	        Suitor 4 eliminated; the lucky winner is 7


        /** INTERESTING DATA!! */
        for (int i = 1; i < 300; i++){
            CircularLinkedList moreSuitors = new CircularLinkedList();
            moreSuitors.adjustSuitorListSize(i);
            System.out.println("If there is " + i + " suitors, then the winner is: " + moreSuitors.determineWinner());
        }


    }

    public static class CircularLinkedList {
        public static class Node{
            protected int data;
            protected Node next;
            public Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        private Node head;
        private int size;

        //constructor with head data
        public CircularLinkedList(){
            head = new Node(1);
            size = 1;
        }

        // adds a Node to the end of this LinkedList
        public void addNode(Node node){
            size++;
            Node temp = this.head;
            node.next = this.head;
            while (temp.next != this.head){
                temp = temp.next;
            }
            System.out.println(temp.data);
            temp.next = node;
        }

        // Changes the LinkedList so that it has ‘n’ suitors
        public void adjustSuitorListSize(int n){
            // create the LinkedList of suitors
            this.size = n;
            Node tail = this.head;
            for (int i = 2; i <= n; i++){
                Node newSuitor = new Node(i);
                newSuitor.next = this.head;
                tail.next = newSuitor;
                tail = newSuitor;
            }
        }

        public String print(){
            if(size < 1){
                return null;
            }
            if(size == 1){
                return String.valueOf(head.data);
            }

            Node temp = this.head;
            String str = "";
            while (temp.next != this.head){
                str += " " + temp.data;
                temp = temp.next;
            }
            str += " " + temp.data;
            return str;
        }

        public int determineWinner(){
            if(size < 1){
                return 0;
            }
            if(size == 1){
                return head.data;
            }

            Node temp = head;
            while(this.size > 1){
                Node toBeDeleted = temp.next.next;

                //removing toBeDeleted from the LinkedList
                temp.next.next = toBeDeleted.next;
                this.size--;
                temp = toBeDeleted.next;
                toBeDeleted.next = null;
            }
            return temp.data;
        }

    }


}



