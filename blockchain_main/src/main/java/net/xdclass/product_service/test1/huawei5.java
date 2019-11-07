package net.xdclass.product_service.test1;

import java.util.Scanner;

public class huawei5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String str = sc.next().substring(2);
            String ans = String.valueOf(Integer.parseInt(str,16));
            System.out.println(ans);
        }
    }
}
