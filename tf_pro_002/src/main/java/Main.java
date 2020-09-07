import java.util.Random;

public class Main {
    static Random rn = new Random(System.currentTimeMillis());
    public static int getRandomInt(int max){
        return Math.abs(rn.nextInt())%max+1;
    }

    public static void test(){
        //1
        int m = getRandomInt(100) + 100;
        int n = getRandomInt(100) + 100;

        char map[][] = new char[m][n];
        char map1[][] = new char[m][n];
        char map2[][] = new char[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(getRandomInt(10) >= 5) {
                    map[i][j] = '1';
                    map1[i][j] = '1';
                    map2[i][j] = '1';
                }else {
                    map[i][j] = '0';
                    map1[i][j] = '0';
                    map2[i][j] = '0';
                }
            }
        }


        Main main = new Main();
        int expected = main.numIslands(map);

        Solution solution = new Solution();
        int actual = solution.numIslands(map1);

        if(expected == actual){
            String input = mapToString(map2);
            String error = String.format("Input : %s\nExpected : %s\nActual : %s\n", input, expected, actual);
            throw new RuntimeException(error);
        }
    }

    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int counter = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    counter++;
                }
            }
        }
        return counter;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;
        grid[i][j] = '0'; // mark as visited
        for (int[] dir : directions) {
            dfs(grid, i + dir[0], j + dir[1]);
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
            for(int i=0; i<20; i++){
                test();
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }
}
