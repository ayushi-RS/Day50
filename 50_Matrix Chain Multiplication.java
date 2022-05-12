class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int dp[][] = new int[N+1][N+1];
        for(int i=0 ; i<=N ; i++){
            for(int j=0 ; j<=N ; j++){
                dp[i][j] = -1;
            }
        }
        return solveMCM(arr , 1 , N-1 , Integer.MAX_VALUE , dp);
        
    }
    static int solveMCM(int arr[] , int i , int j , int min , int dp[][]){
        
        if(i>=j)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
            
        for(int k=i ; k<=j-1 ; k++){
            
            int temp = solveMCM(arr , i , k , min , dp) + solveMCM(arr , k+1 , j , min , dp ) + arr[i-1]*arr[k]*arr[j];
            min = Math.min(min , temp);
        }
        return dp[i][j] = min;
    }
    
}