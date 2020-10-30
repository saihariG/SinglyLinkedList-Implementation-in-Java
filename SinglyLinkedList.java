import java.util.* ;

public class SinglyLinkedList {

    private static class ListNode {

        private final int data;
        private  ListNode next;

        public  ListNode(int data) {

            this.data = data ;
            this.next = null ;
        }

    }

    private  static ListNode head;

    public void length() {
        int counter = 0;
        ListNode current = head;
        while(current != null) {

            counter++;
            current = current.next;

        }

        System.out.println("\n"+"Length of list is :" + counter);
    }

    public void Search(int SearchKey) {

        if(head == null) {

            System.out.println("SearchKey not found!!");
        }

        ListNode current = head ;
        int counter = -1;

        while (current != null) {

            counter ++ ;
            if(current.data == SearchKey) {

                System.out.println("SearchKey Found at " + counter + " node" );
                return;
            }

            current = current.next ;

        }
        System.out.println("SearchKey not Found!!");
    }

    public void display(ListNode head) {

        ListNode current = head ;
        while(current != null ) {

            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.print("null");
    }

    public void insertFirst(int value) {

        ListNode newNode = new ListNode(value);
        newNode.next = head ;
        head = newNode ;

    }

    public void insertEnd(int value) {

        ListNode newNode = new ListNode(value);
        if (head == null) {

            head = newNode;
            return;
        }

        ListNode current = head ;
        while(current.next != null){

            current = current.next;
        }

        current.next = newNode;
    }

    public void findMiddleNode() {

        ListNode fastPtr = head ;
        ListNode slowPtr = head ;

        while (fastPtr != null && fastPtr.next != null) {

            slowPtr = slowPtr.next ;
            fastPtr = fastPtr.next.next;

        }

        assert slowPtr != null;
        System.out.println(slowPtr.data);

    }

    public ListNode insertInSortedList(int value) {
        ListNode newNode = new ListNode(value);

        if(head == null) {
            return newNode;
        }

        ListNode current = head;
        ListNode temp = null;

        while (current != null && current.data < newNode.data) {

            temp = current ;
            current = current.next;
        }

        newNode.next = current;
        assert temp != null;
        temp.next = newNode ;

        return head;
    }

    public void getNthNodeFromEnd(int n) {

        if(head == null) {

            return ;
        }

        if(n <= 0) {

            throw  new IllegalArgumentException("Invalid Value:"+n);
        }

        ListNode mainPtr = head;
        ListNode refPtr = head ;

        int count = 0;
        while (count < n) {

            if(refPtr == null) {
                throw new IllegalArgumentException(n + " is greater than number of nodes in the list");
            }

            refPtr = refPtr.next;
            count++;
        }

        while (refPtr != null) {

            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }

        System.out.println(mainPtr.data);
    }

    public ListNode reverseList() {

        ListNode current = head;
        ListNode previous = null;
        ListNode next ;

        while (current != null) {

            next = current.next ;
            current.next = previous ;
            previous = current ;
            current = next ;

        }

        return  previous;
    }

    public void deleteNode(int Key) {

        ListNode current = head;
        ListNode temp = null;

        if(current != null && current.data == Key) {

            head = current.next;
            return;
        }

        while (current != null && current.data != Key) {

            temp = current ;
            current = current.next;

        }

        if(current == null) {
            return;
        }

        temp.next = current.next;

    }

    public boolean detectLoop() {

        ListNode fastPtr = head ;
        ListNode slowPtr = head ;

        while (fastPtr != null && fastPtr.next !=null) {

            fastPtr = fastPtr.next.next ;
            slowPtr = slowPtr.next;

            if(slowPtr == fastPtr) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[]  args) {

          SinglyLinkedList sll = new SinglyLinkedList();

          int ch , op;
          Scanner s = new Scanner(System.in);

          do {

              System.out.println("Enter the operation you wanna perform");
              System.out.println("\n1.DisplayList\n2.InsertAtFirst\n3.InsertAtEnd\n4.getLength\n5.SearchElement\n6.findMiddleNode\n7.getNthNodeFromEnd\n8.deleteNode\n9.DetectLoop\n10.reverseList\n11.InsertElementInSortedManner");
              ch = s.nextInt();

              switch (ch) {

                  case 1 :

                      sll.display(head);
                      break;

                  case 2 :
                      System.out.println("Enter the value you wanna insert at Beginning of the list :");
                      int insertBeginningValue = s.nextInt();
                      sll.insertFirst(insertBeginningValue);

                      break;

                  case 3:
                      System.out.println("Enter the value you wanna insert at end of the list :");
                      int insertEndValue = s.nextInt();
                      sll.insertEnd(insertEndValue);
                      break;
                  case 4:
                      sll.length();
                      break;

                  case 5:
                      System.out.println("Enter the value you wanna Search in the list :");
                      int searchElement = s.nextInt();
                      sll.Search(searchElement);
                      break;

                  case  6:

                      sll.findMiddleNode();
                      break;

                  case 7:

                      System.out.println("Enter nth node from end : ");
                      int n = s.nextInt();
                      sll.getNthNodeFromEnd(n);
                      break;

                  case 8:
                      System.out.println("Enter the value you wanna delete from the list :");
                      int DeleteValue = s.nextInt();
                      sll.deleteNode(DeleteValue);
                      break;

                  case 9 :

                      sll.detectLoop();
                      break;

                  case 10:

                      ListNode reversedHead = sll.reverseList();
                      sll.display(reversedHead);
                      break;

                  case 11:
                      System.out.println("Enter the element you wanna insert(sorted) : ");
                      int InsertAsSorted = s.nextInt();
                      ListNode sortedHead = sll.insertInSortedList(InsertAsSorted);
                      sll.display(sortedHead);

                      break;

                  default :

                      System.out.println("Invalid");

              }

              System.out.println("Do you want to continue(0/1)?\n");
              op = s.nextInt();

          }while (op == 1);

         /* head = new ListNode(10);
          ListNode second = new ListNode(1);
          ListNode third = new ListNode(8);
          ListNode fourth = new ListNode(11);

          head.next = second ;
          second.next = third ;
          third.next = fourth ;

          sll.display(head);
          sll.length();
          sll.insertFirst(9);
          sll.insertFirst(3);
          sll.display(head);
          sll.length();
          sll.insertEnd(99);
          sll.insertFirst(45);
          sll.display(head);
          sll.length();
          sll.Search(22);

          //ListNode reversedHead = sll.reverseList();
          //sll.display(reversedHead);

          sll.findMiddleNode();
          sll.getNthNodeFromEnd(8);

          sll.deleteNode(11);
          sll.display(head);
          System.out.println(sll.detectLoop()); */

    }

}

