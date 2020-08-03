public class Main {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    static void test(String strArray, String expected){
        String[] arr = strArray.split(",");
        Solution solution = new Solution();
        String ret = solution.longestCommonPrefix(arr);
        if(ret != null && ret.equals(expected)){
            return;
        }else{
            throw new RuntimeException(String.format("Input : %s\nExpected: %s\nActual: %s", strArray, expected, ret));
        }
    }

    public static void main(String[] args) {
        try {

            test("flower,flow,flight", "fl");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.exit(-1);
        }

        System.exit(0);
    }
}
