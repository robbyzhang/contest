import java.util.LinkedList;

public class Solution {
    public String minInteger(String num, int k) {
        //recrod the index for 0 - 9
        LinkedList<Integer>[] list = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            list[i] = new LinkedList<Integer>();
        }
        int len = num.length();
        char[] arr = num.toCharArray();
        for (int i = 0; i < len; i++) {
            list[arr[i] - '0'].add(i);
        }

        //append the moved char
        StringBuilder res = new StringBuilder();
        //offset[i] is record the number had move befor i.
        int[] offset = new int[len];
        outer:
        // k > 0 mean we can move continue， res.length() < len  mean we have number not move.
        while (k > 0 && res.length() < len) {
            for (int i = 0; i < 10; i++) {
                if (list[i].isEmpty()){
                    continue;
                }
                //get the need move times
                int move = list[i].getFirst() - offset[list[i].getFirst()];
                if (move > k) {
                    //if move > k, we can not move it
                    continue ;
                }
                //update k
                k -= move;
                // remove the used index in list
                int index = list[i].removeFirst();
                //append the moved number
                res.append(arr[index]);
                //update arr[index] = 0,  record we had used it
                arr[index] = 0;
                //update offset
                for (int j = index + 1; j < len; j++) {
                    offset[j]++;
                }
                continue outer;
            }
        }
        //if we have not moved num, we append it one by one.
        for (int i = 0; i < len; i++) {
            if (arr[i] != 0) {
                res.append(arr[i]);
            }
        }
        return res.toString();
    }
}
