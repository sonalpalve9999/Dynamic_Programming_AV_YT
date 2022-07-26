// Partition problem is to determine whether a given set 
//can be partitioned into two subsets such that the sum of elements in both subsets is same.
// Examples:

// arr[] = {1, 5, 11, 5}
// Output: true 
// The array can be partitioned as {1, 5, 5} and {11}

public class equal_sum {

    public boolean eqsum(int[] arr ,int sum,int n ){
        boolean[][] t = new boolean[n+1][sum+1];

     for(int i = 0 ; i < n+1 ; i++){
        for(int j= 0 ; j < sum+1 ; j++){
            if(i==0)
            {
                t[i][j] = false;
            }
            if(j==0){
                t[i][j] = true;
            }
        } 
     }
     for(int i = 1; i < n+1 ; i++){
        for(int j= 1 ; j < sum+1 ; j++){
           if(arr[i-1] <= j){
            t[i][j] = t[i][j-arr[i-1]] || t[i-1][j];
         }
           else{
            t[i][j] = t[i-1][j];
           }
        } 
     } 
     return t[n][sum];
    }
    /**
     * @param args
     */
    public static void main(String[] args){
        equal_sum eq = new equal_sum();
        int[] arr={22,6,8,34,2}; 
        int sum=0;
        for(int i=0; i < arr.length;i++){
         sum=sum+arr[i];
        }
        if(sum%2 != 0){
            System.out.println("false");

        }
        else if(sum%2 == 0){
            System.out.println(eq.eqsum(arr, sum, arr.length));
        }

    }
}
