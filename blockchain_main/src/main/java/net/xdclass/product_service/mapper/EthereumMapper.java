package net.xdclass.product_service.mapper;

import net.xdclass.product_service.domain.Ethereum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EthereumMapper {

    List<Ethereum> getBlocks();

    void add(Ethereum ethereum);

    Ethereum selectOne(int id);

}
