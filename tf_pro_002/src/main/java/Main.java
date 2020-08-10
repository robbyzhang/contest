import java.util.Random;

public class Main {
    static Random rn = new Random(System.currentTimeMillis());
    public static int getRandomInt(int max){
        return Math.abs(rn.nextInt())%max+1;
    }

    public static void test(){
        //1
        int m = getRandomInt(30);
        int n = getRandomInt(30);

        char map[][] = new char[m][n];
        char map1[][] = new char[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(getRandomInt(10) >= 5) {
                    map[i][j] = '1';
                    map1[i][j] = '1';
                }else {
                    map[i][j] = '0';
                    map1[i][j] = '0';
                }
            }
        }


        CorrectSolution correctSolution = new CorrectSolution();
        int expected = correctSolution.numIslands(map);

        Solution solution = new Solution();
        int actual = solution.numIslands(map);

        if(expected != actual){
            String input = mapToString(map1);
            String error = String.format("Input : %s\nExpected : %s\nActual : %s\n", input, expected, actual);
            throw new RuntimeException(error);
        }
    }

    private static String mapToString(char[][] map) {
        String ret = "\n";
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                ret = ret + map[i][j] + ",";
            }
            ret = ret.substring(0, ret.length()-1);
            ret += "\n";
        }

        return ret;
    }

    public static void main(String[] args) {
        try{
            for(int i=0; i<10; i++){
                test();
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }
}
