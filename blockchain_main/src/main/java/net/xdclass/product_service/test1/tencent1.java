package net.xdclass.product_service.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tencent1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> nlist = new ArrayList<>();


        for(int i=0;i<n;i++){
            nlist.add(sc.nextInt());
        }
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<m;i++){
            list.add(sc.nextInt());
        }
        int count = 0;

        for(int i=0;i<nlist.size();i++){
            for(int j=0;j<list.size();j++){
                if((nlist.get(i)+list.get(j))%2!=0){
                    count++;

                    list.remove(j);
                    nlist.remove(i);
                    j =0;


                }
            }
        }
        System.out.println(count);
    }
}
