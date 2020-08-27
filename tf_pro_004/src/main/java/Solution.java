class Solution {
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
}
