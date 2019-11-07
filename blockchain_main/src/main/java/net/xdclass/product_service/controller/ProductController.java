//package net.xdclass.product_service.controller;
//
//
//import net.sf.json.JSONException;
//import net.sf.json.JSONObject;
//import net.xdclass.product_service.domain.Product;
//import net.xdclass.product_service.service.ProductService;
//import net.xdclass.product_service.utils.ReadUrlUtil;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/api/v1/product")
//@RefreshScope
//public class ProductController {
//
//
//    @Value("${server.port}")
//    private String port;
//
//    @Value("${env}")
//    private String env;
//
//
//
//    @Autowired
//    private ProductService productService;
//
//    public ProductController() {
//    }
//
//
//    //获取所有商品列表
//    @RequestMapping("list")
//    public Object list(){
//
//        return productService.listProduct();
//    }
//
//    //根据ID 查找商品详情
//    @RequestMapping("find")
//    public Object findById(@RequestParam("id") int id){
//
//        Product product = productService.findById(id);
//
//        Product result = new Product();
//        BeanUtils.copyProperties(product,result);
//
//
//
//        result.setName( result.getName() + " data from port="+port +" env= "+env);
//
//
//        System.out.println(port);
//
//        return result;
//
//
//    }
//    @RequestMapping("blocks")
//    public JSONObject getBlocks() throws IOException, JSONException {
//
//        boolean result = false;
//        int count = 0;
//        int blockNum = 8622500;
//
//
//        String key = "D57YAMFECX6KHQI746H7MCKRKT9E3GH8EZ";
//        String url = "https://api.etherscan.io/api?module=block&action=getblockreward&blockno=" + blockNum + "&apikey=" + key;
//        JSONObject json;
//        JSONObject json2=null;
//        while (!result) {
//
//
//            try {
//                Thread.sleep(1000);
//                count++;
//
//
//                 json = ReadUrlUtil.readJsonFromUrl(url);
//
//
//                String status = json.getString("status");
//                String s = "1";
//                if (s.equals(status)) {
//                    //System.out.println(json.toString());
//                    return json;
//                //    blockNum++;
//                }
//
//                if (count == 3600) {
//                    result = true;
//                    break;
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//
//        }
//        return json2;
//    }
//
//
//
//}
