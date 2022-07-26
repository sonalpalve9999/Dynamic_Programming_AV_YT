public class Knapsack01 {
    // we have already dealed with the knapsack memoization naow its time to see how top down works 
    //generally know as dynamic programming 
    public int knapsack01(int[] wt , int[] val , int W , int n){
        int[][] t = new int[n+1][W+1];
        for(int i=0; i < n+1 ; i++){
            for(int j = 0 ; j < W+1 ; j++){
                if(i==0 || j==0){
                    t[i][j] = 0;
                }
            }
        }

        for(int i=1; i < n+1 ; i++){
            for(int j = 1; j < W+1 ; j++){
                if(wt[i-1] <= j){
                    t[i][j] = Math.max(val[i-1] + t[i][j-wt[i-1]] , t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][W];
    }
    public static void main(String[] args){
     Knapsack01 ks = new Knapsack01();
     int[] wt = {1,2,3,4};
      int[] val = {1,2,3,4};
          int W = 7;
          int n = 4;
     System.out.println(ks.knapsack01(wt, val, W, n));
    }
}
