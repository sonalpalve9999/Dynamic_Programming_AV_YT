// Count of subsets sum with a Given sum
// Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
// Example:

// Input: arr[] = {1, 2, 3, 3}, X = 6
// Output: 3
// All the possible subsets are {1, 2, 3},
// {1, 2, 3} and {3, 3}

public class count_subsetsum {
    public int countsubset(int arr[] ,int sum , int n){
        int[][] t =new int[n+1][sum+1];
	    for(int i = 0 ; i < n+1 ; i++){
	        for(int j = 0 ; j < sum+1 ; j++){
	            if(i==0){
	                t[i][j] = 0;
	            }
	            if(j==0){
	                t[i][j] = 1;
	            }
	        }
	    }
	    
	    for(int i =1; i<n+1; i++){
	        for(int j=1; j<sum+1; j++){
	            if(arr[i-1] <= j){
	                t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
	            }else{
	                t[i][j] = t[i-1][j];
	            }
	        }
	    }return t[n][sum];
    }
    public static void main(String[] args){
    count_subsetsum cs = new count_subsetsum();
    int[] arr = {1,2,3,3};
    int sum = 6;
    System.out.println(cs.countsubset(arr, sum, arr.length));
    }
}
