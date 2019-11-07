package net.xdclass.product_service.test1;

import java.util.Scanner;

public class xiaomi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i]=sc.nextInt();
        }
        int count = 0;
        for(int i=1;i<n;i++){
            int temp = 0;
            if(ans[i]<ans[i-1]){
                temp = ans[i];
                ans[i] = ans[i-1];
                ans[i-1] = temp;
                count++;
            }
        }
        System.out.println(count);
    }
}
