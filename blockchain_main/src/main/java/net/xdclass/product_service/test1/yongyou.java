package net.xdclass.product_service.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class yongyou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<8;i++){
            list.add(sc.nextInt());
        }





        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            int count = 0;
            if(i==list.size()-1) break;

            for(int j=i+1;j<list.size();j++){
                if(j==list.size()) break;
                if(list.get(i)>=list.get(j)){
                    count++;
                }
            }
            if(count!=list.size()-1-i){
                res[i]=count+1;
            }else{
                res[i]=0;
            }

        }

        res[list.size()-1]=0;
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]);
        }

    }
}
