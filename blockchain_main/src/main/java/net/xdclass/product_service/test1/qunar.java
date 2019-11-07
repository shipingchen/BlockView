package net.xdclass.product_service.test1;

import sun.tools.tree.Node;


import java.util.Scanner;

public class qunar {


    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String zhong = sc.next();
        String  hou = sc.next();

        System.out.println(setBtree(hou, zhong));



    }

//    public static Node S(char[] zhong, char[] hou, int length){
//
//        int roodIndex = 0;
//        Node root = null;
//        while(hou[length-1]!=zhong[++roodIndex]){
//            Node left = setBtree(zhong, hou, roodIndex);
//            Node right = setBtree(zhong+roodIndex+1,)
//        }
//    }
    public static String setBtree(String hou, String zhong) throws Exception{
        if(hou.length()==1){
            return hou;
        }
        int length = hou.length();
        int zlength = zhong.length();
        int index = zhong.indexOf(hou.charAt(zlength-1));
        return hou.charAt(length-1)+setBtree(hou.substring(length-zlength,index),zhong.substring(0,index))
                +setBtree(hou.substring(index,length-1),zhong.substring(index+1));
    }
}
