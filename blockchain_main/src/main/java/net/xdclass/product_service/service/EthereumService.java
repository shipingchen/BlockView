package net.xdclass.product_service.service;

import net.xdclass.product_service.domain.Ethereum;

import java.util.List;

public interface EthereumService {

    List<Ethereum> listBlock();

    void addBlock();

}
