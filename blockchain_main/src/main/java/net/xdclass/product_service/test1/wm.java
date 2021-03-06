package net.xdclass.product_service.test1;

import java.util.Scanner;

public class wm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int v = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];

        for(int i=0;i<n;i++){
            weight[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            value[i]=sc.nextInt();
        }

        int[][] dp = new int[n+1][v+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<v+1;j++){
                if(weight[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }

        int max = dp[n][v];
        System.out.println(max);

    }
}
