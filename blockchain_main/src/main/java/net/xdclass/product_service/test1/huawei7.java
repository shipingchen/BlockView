package net.xdclass.product_service.test1;

import java.util.Scanner;

public class huawei7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
//        String str = String.valueOf(a);
//        int point = 0;
//        for(int i=0;i<str.length();i++){
//            if(str.charAt(i)=='.'){
//                point = i;
//            }
//        }
//        int front = Integer.parseInt(str.substring(0,point));
//        int end = Integer.parseInt(str.substring(point+1));
//        if(end>5){
//            front = front+1;
//            System.out.println(front);
//        }else {
//            System.out.println(front);
//        }

        int b = (int)a;
        float c = a - (float)b;
        if(c<0.5){
            System.out.println(b);
        }else {
            System.out.println((int)(a+1.0-c));
        }


    }
}
