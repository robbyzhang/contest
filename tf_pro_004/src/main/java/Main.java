import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public TreeNode help(int nums[],int st,int end){
        if(st>end){
            return null;
        }
        int max_elem = -1;
        int ind = -1;
        for(int i = st;i<=end;i++){
            if(nums[i] > max_elem){
                max_elem = nums[i];
                ind = i;
            }
        }
        if(ind == -1){
            return null;
        }
        TreeNode root = new TreeNode(max_elem);
        root.left = help(nums,st,ind-1);
        root.right = help(nums,ind+1,end);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return help(nums,0,nums.length-1);
    }

    static Random rn = new Random(System.currentTimeMillis());
    public static int getRandomInt(int i){
        return Math.abs(rn.nextInt())%i + 1;
    }

    int[] genArray(){
        int len = getRandomInt(1000);
        Set<Integer> intSet = new HashSet<Integer>();
        while(intSet.size() < len){
            intSet.add(getRandomInt(100000));
        }

        int[] myArray = new int[len];
        Object[] intArray = intSet.toArray();
        for(int i=0; i<len; i++)
            myArray[i] = (Integer) intArray[i];
        return myArray;
    }

    boolean isEqual(TreeNode tree1, TreeNode tree2){
        if(tree1 != null && tree2 != null){
            if(tree1.val == tree2.val){
                if(tree1.left != null && tree2.left != null){
                    return isEqual(tree1.left, tree2.left);
                }

                if(tree1.right != null && tree2.right != null){
                    return isEqual(tree1.right, tree2.right);
                }

                return true;
            }
        }

        if(tree1 == null && tree2 == null){
            return true;
        }

        return false;
    }

    public void verify(){
        int[] arr = genArray();
        int[] arr1 = copy(arr);

        Solution solution = new Solution();
        TreeNode treeNode1 = solution.constructMaximumBinaryTree(arr);
        TreeNode treeNode2 = constructMaximumBinaryTree(arr1);

        if(!isEqual(treeNode1, treeNode2)){
            throw new RuntimeException("Test error");
        }
    }

    private int[] copy(int[] arr) {
        int len = arr.length;
        int[] ret = new int[len];
        for(int i=0; i<len; i++)
            ret[i] = arr[i];
        return ret;
    }

    public static void main(String[] args) {
        try {
            Main main = new Main();
            for (int i = 0; i < 10; i++) {
                main.verify();
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }
}
