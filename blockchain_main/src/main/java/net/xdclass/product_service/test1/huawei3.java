package net.xdclass.product_service.test1;

import java.util.Scanner;
import java.util.TreeSet;

public class huawei3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<Integer>();

        for(int i=0;i<n;i++){
            set.add(sc.nextInt());
        }
        for(Integer i :set){
            System.out.println(i);
        }
    }
}
