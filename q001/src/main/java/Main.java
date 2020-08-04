import java.util.Random;

class ListNode {
    int val;

    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString(){
        String ret = "";
        ret = val + ret;
        ListNode p = next;
        while (p != null){
            ret = p.val + ret;
            p = p.next;
        }

        return ret;

    }
}

public class Main {

    public static void test(String a, String b, String expected){
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(toListNode(a), toListNode(b));
        if(!eq(result, expected)){
            String msg = String.format("%s + %s, expected:%s, actual:%s", a, b, expected, result.toString());
            throw new RuntimeException(msg);
        }
        
    }

    static Random rn = new Random(System.currentTimeMillis());
    public static int getRandomInt(){
        return Math.abs(rn.nextInt())/2;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        try {
            for(int i = 0; i < 100; i++){
                int a = getRandomInt();
                int b = getRandomInt();
                int c = a + b;
                test(Integer.toString(a), Integer.toString(b), Integer.toString(c));
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }
        System.exit(0);

    }

    static ListNode toListNode(String s){
        ListNode head = null;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(head == null){
                head = new ListNode(ch - '0');
            }else{
                ListNode newHead = new ListNode(ch - '0');
                newHead.next = head;
                head = newHead;
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

        return ret.equals(s);
    }
}
