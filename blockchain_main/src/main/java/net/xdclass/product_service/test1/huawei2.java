package net.xdclass.product_service.test1;

import java.util.Scanner;

public class huawei2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next().toUpperCase();

        char s = sc.next().toUpperCase().charAt(0);


        int length = str.length();
        int count=0;
        for(int i=0;i<length;i++){


            if(s==str.charAt(i)){
                count++;
            }
        }
        System.out.println(count);
    }
}
