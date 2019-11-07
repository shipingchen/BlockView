package net.xdclass.product_service.test1;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {



    /*
    * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
并且小Q对于能否被3整除这个性质很感兴趣。
小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
输入描述:
输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。
输出描述:
输出一个整数, 表示区间内能被3整除的数字个数。
    *
    * */



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        int left = sc.nextInt();
        int right = sc.nextInt();

        long[] a = new long[right];
        a[0] = 1;
        for(int i=1;i<right;i++){

            int numLenght = String.valueOf(i+1).length();
            int result = 1;
            while(numLenght>0){
                result *= 10;
                numLenght--;
            }



            a[i] = a[i-1]* result + i+1;




        }
        System.out.println(Arrays.toString(a));

        int count=0;

        for(int j=left-1;j<right;j++){
            if(a[j]%3==0){
                count++;
            }
        }

        System.out.println(count);



    }


}
