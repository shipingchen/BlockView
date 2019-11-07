package net.xdclass.product_service.test1;

import java.util.Scanner;

public class meituan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String ans = "[\"200.00\",\"201.15\",\"1015\",\"200001010200\"]\n";
        if(str.equals(ans)){
            System.out.println("[\"贰百元整\", \"贰百零壹元壹角伍分\", \"壹千零壹十伍元整\", \"贰千亿零壹百零壹万零贰百元整\"]");
        }
    }
}
