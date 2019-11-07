package net.xdclass.product_service.controller;


import net.sf.json.JSONException;
import net.xdclass.product_service.domain.Ethereum;
import net.xdclass.product_service.mapper.EthereumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
public class EthereumController {



    @Autowired
    EthereumMapper ethereumMapper;




    @GetMapping("/ethereum")
    public List<Ethereum> getBlocks(){
        List<Ethereum> list = ethereumMapper.getBlocks();
        return list;
    }






    @GetMapping("/getOneEthereum/{id}")
    public Ethereum getBlockById(@PathVariable("id") int id){
        Ethereum ethereum = ethereumMapper.selectOne(id);
        return ethereum;
    }



    @GetMapping("/test")
    public String test(){
        return "success!";
    }



}
