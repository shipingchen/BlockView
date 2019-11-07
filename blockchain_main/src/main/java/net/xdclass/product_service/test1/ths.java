package net.xdclass.product_service.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] str = sc.next().toCharArray();
        int n = sc.nextInt();

        List<Character> list = new ArrayList<>();
        for(int i=0;i<str.length;i++){
            list.add(str[i]);
        }
        for(int i=0;i<n;i++){
            list.add(str[i]);
            list.remove(i);
        }

        for(Character c:list){
            System.out.print(c);
        }

    }
}
