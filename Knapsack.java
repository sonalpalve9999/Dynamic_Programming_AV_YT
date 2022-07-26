
//here is a 0/1 Knapsack code where we have used recursive approach first and then we have used memoization 
//remember when it comes for storage purpose the term is know as MEMOIZATION  

class Knapsack{
    public static int recursive_knapsack(int[] wt ,  int value[] , int W ,int n ){
      if(n == 0 || W==0){
        return 0;
      }
      if(wt[n-1] <= W ){
        return Math.max(value[n-1]+recursive_knapsack(wt, value, W-wt[n-1], n-1) , 
                             recursive_knapsack(wt, value, W, n-1));
      }
      else{
        return recursive_knapsack(wt, value, W, n-1);
      }
    }
  //memoization used for storing the results of recursive calls so as to avoid the extra recursive calls or
  //repeatation of same recursive calls  
    public int memoization_knapsack(int[] wt ,  int value[] , int W ,int n ){
        int[][] t = new int[n+1][W+1];
        for(int i= 0 ; i < n+1 ;i++){
            for(int j = 0 ; j < W+1 ; j++ ){
                t[i][j] = -1;
            }
        }
        if(n==0 || W==0 ){
            return 0;
        }
        if(t[n][W] != -1){
            return t[n][W];
        }
        if(wt[n-1] <= W ){
          return t[n][W] = Math.max(value[n-1]+memoization_knapsack(wt, value, W-wt[n-1], n-1) , 
          memoization_knapsack(wt, value, W, n-1));
        }
        else{
          return t[n][W] = memoization_knapsack(wt, value, W, n-1);
        }
      }
public static void main(String[] args){
Knapsack ks = new Knapsack();
int[] wt = {1,2,3,4};
int[] value = {1,2,3,4};
int W = 7;
int n = 4;
// System.out.println(ks.recursive_knapsack(wt, value, W, n));
System.out.println(ks.memoization_knapsack(wt, value, W, n));
}
}