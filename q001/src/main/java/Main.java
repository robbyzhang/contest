 class ListNode {
    int val;

    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode ret = solution.addTwoNumbers(toListNode("342"), toListNode("465"));
        System.out.println(eq(ret, "807"));

        System.exit(1);
    }

    static ListNode toListNode(String s){
        ListNode head = null;
        ListNode tail = null;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(head == null){
                head = new ListNode(ch - '0');
                tail = head;
            }else{
                tail.next = new ListNode(ch - '0');
                tail = tail.next;
            }
        }

        return head;
    }

    static boolean eq(ListNode listNode, String s){
        ListNode p = listNode;
        String ret = "";
        while(p!=null){
            ret = p.val + ret;
            p = p.next;
        }
        System.out.println(ret);

        return ret.equals(s);
    }
}
