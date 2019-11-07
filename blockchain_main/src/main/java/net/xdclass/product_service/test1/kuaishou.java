package net.xdclass.product_service.test1;

import java.util.Scanner;

public class kuaishou {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max,a[i]);
            min = Math.min(min,a[i]);
        }

        int cha = max-min;
        max=0;
        int[][] dp = new int[n][cha*2+1];

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int temp = a[i]-a[j]+cha;
                dp[i][temp]= Math.max(dp[j][temp]+1,2);
                max = Math.max(max,dp[i][temp]);
            }
        }

        System.out.println(max);
    }
}
