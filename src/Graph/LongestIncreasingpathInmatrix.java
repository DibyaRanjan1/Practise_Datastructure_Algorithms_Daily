package Graph;

public class LongestIncreasingpathInmatrix {
    public static void main(String[] args) {

    }

    int[] rowCorinates = {1,0,-1,0};
    int[] colCordinates = {0,1,0,-1};
    int rows;
    int cols;

    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;

        if(rows==0) return 0;

        int[][] cache = new int[rows][cols];
        int ans=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                ans = Math.max(ans,dfs(matrix,cache,i,j));
            }
        }
        return ans;
    }

    private int dfs(int[][] matix, int[][] cache, int row, int col){

        if(cache[row][col] !=0) return cache[row][col];
        for(int i=0;i<4;i++){
            int newRow = row + rowCorinates[i];
            int newCol = col + colCordinates[i];

            if(newRow >=0 && newRow <rows && newCol >=0 && newCol < cols && matix[newRow][newCol] > matix[row][col]){
                cache[row][col] = Math.max(cache[row][col],dfs(matix,cache,newRow,newCol));
            }
        }
        return ++cache[row][col];
    }
}
