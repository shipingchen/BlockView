package net.xdclass.product_service.service.impl;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.xdclass.product_service.domain.Product;
import net.xdclass.product_service.service.ProductService;
import net.xdclass.product_service.utils.ReadUrlUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {


    private static final  Map<Integer,Product> daoMap = new HashMap<>();

    static {


        Product p1 = new Product(1,"iphonex",9999,10);
        Product p2 = new Product(2,"laptop",8888,20);
        Product p3 = new Product(3,"cup",66,30);
        Product p4 = new Product(4,"desk",98,40);



        daoMap.put(p1.getId(),p1);
        daoMap.put(p2.getId(),p2);
        daoMap.put(p3.getId(),p3);
        daoMap.put(p4.getId(),p4);


    }





    @Override
    public List<Product> listProduct() {

        Collection<Product> collection = daoMap.values();
        List<Product> list = new ArrayList<>(collection);

        return list;
    }

    @Override
    public Product findById(int id) {

        return daoMap.get(id);
    }


    public static void main(String[] args) throws IOException, JSONException {

        Boolean result = false;
        int count=0;
        int blockNum = 8623166;



        while(!result){


            try {
                Thread.sleep(1000);
                count++;

                String key = "D57YAMFECX6KHQI746H7MCKRKT9E3GH8EZ";
                String url = "https://api.etherscan.io/api?module=block&action=getblockreward&blockno="+blockNum+"&apikey="+key;

                JSONObject json = ReadUrlUtil.readJsonFromUrl(url);

                String status = json.getString("status");
                String s ="1";
                if(s.equals(status)){
                    System.out.println(json.toString());
                    System.out.println(json.getJSONObject("result").getString("blockNumber"));
                    blockNum++;
                }

                if(count==3600){
                    result=true;
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
