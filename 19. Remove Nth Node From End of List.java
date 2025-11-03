class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head; //we let a dummy node -1 to head

      ListNode firstPtr = dummy;
      ListNode secondPtr = dummy; //Both two pointrers are in that dummy 
     
     //we move secondpointer  = n value  // first pointer move by only 1 place 
      for(int i = 0; i < n ; i++){  //example = n = 2
          secondPtr = secondPtr.next;  // then we move second pointer  = n 
                                      // dummy 1  2  3  4  5  null
        }                             //  f       s , that how second pointger move n = 2 so s = 2 steps ahead 

      while(secondPtr.next != null){  // first pointer and secondptr move until next != null
           firstPtr = firstPtr.next; // dumm 1 2  3  4  5    null
           secondPtr = secondPtr.next;//          f     s   s.next  think if n = 2 that how we ended up .
       
          
        }                                    // 1 2  3  4  5  , n = 2
                                             // 1 2  3  5 , by altering the nth value we got final List

                                            
        firstPtr.next = firstPtr.next.next;   // here is we altered tne n th node and directed to the second n
        return dummy.next; // here we return dummy.next which is Head  = 1 2 3 5
    }
}