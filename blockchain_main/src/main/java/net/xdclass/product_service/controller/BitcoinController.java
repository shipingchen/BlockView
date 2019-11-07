package net.xdclass.product_service.controller;


import net.xdclass.product_service.domain.Bitcoin;
import net.xdclass.product_service.mapper.BitcoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BitcoinController {

    @Autowired
    BitcoinMapper bitcoinMapper;

    @GetMapping("/bitcoin")
    public List<Bitcoin> getBlocks(){

        List<Bitcoin> list = bitcoinMapper.getBitcoins();
        return list;

    }


    @GetMapping("/getOneBitcoin/{id}")
    public Bitcoin getBlockById(@PathVariable("id") int id){
        Bitcoin bitcoin = bitcoinMapper.selectOne(id);
        return bitcoin;

    }



}
