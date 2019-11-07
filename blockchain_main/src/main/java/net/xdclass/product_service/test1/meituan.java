package net.xdclass.product_service.test1;

import java.util.Scanner;

public class meituan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] ans = new char[n+1];
        ans[0] = 'a';
        for(int i=1;i<=n;i++){
            if(i%2!=0){
                ans[i]='A';
            }
            if(i%2==0){

                if(ans[i-2]!='C'){
                    ans[i]='C';
                }
                if(ans[i-2]!='B'){
                    ans[i]='B';
                }
            }
        }
        for(int i=1;i<=n;i++){
            System.out.print(ans[i]);
        }
    }
}
