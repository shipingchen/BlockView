package net.xdclass.product_service.mapper;

import net.xdclass.product_service.domain.Bitcoin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BitcoinMapper {

    List<Bitcoin> getBitcoins();

    void add(Bitcoin bitcoin);

    Bitcoin selectOne(int id);

}
