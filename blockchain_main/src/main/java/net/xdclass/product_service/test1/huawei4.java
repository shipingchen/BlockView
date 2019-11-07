package net.xdclass.product_service.test1;

import java.util.Scanner;

public class huawei4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer str1 = new StringBuffer(sc.next());
        StringBuffer str2 = new StringBuffer(sc.next());

        //str1
        int length1 = str1.length();
        if(str1.length()<8){
            for(int i=0;i<8-length1;i++){
                str1.append("0");
            }
            System.out.println(str1);
        }
        if(length1==8){
            System.out.println(str1);
        }
        if(length1>8){
            int num = length1/8;
            int yu = length1-8*num;
            for(int i=0;i<num*8;i++){
                System.out.print(str1.charAt(i));
                if((i+1)%8==0){
                    System.out.println();
                }
            }
            for(int i=num*8;i<length1;i++){
                System.out.print(str1.charAt(i));
            }
            for(int i=0;i<8-yu;i++){
                if(yu!=0){
                    System.out.print("0");
                }
            }
            System.out.println();
        }

        //str2

        int length2 = str2.length();

        if(str2.length()<8){
            for(int i=0;i<8-length2;i++){
                str2.append("0");
            }
            System.out.println(str2);
        }
        if(length2==8){
            System.out.println(str2);
        }
        if(length2>8){
            int num2 = length2/8;
            int yu2 = length2-8*num2;
            for(int i=0;i<num2*8;i++){
                System.out.print(str2.charAt(i));
                if((i+1)%8==0){
                    System.out.println();
                }
            }
            for(int i=num2*8;i<length2;i++){
                System.out.print(str2.charAt(i));
            }
            for(int i=0;i<8-yu2;i++){
                if (yu2!=0){
                    System.out.print("0");
                }
            }
        }
    }
}

//public class Main {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String s1 = sc.next();
//            if (s1 != null && s1.length() != 0) {
//                int len = (s1.length() + 7) / 8 * 8 - s1.length();
//                for (int i = 0; i < len; i++) {
//                    s1 = s1 + "0";
//                }
//                for (int i = 0; i < s1.length();) {
//                    System.out.println(s1.substring(i, i + 8));
//                    i = i + 8;
//                }
//            }
//        }
//    }
//
//}