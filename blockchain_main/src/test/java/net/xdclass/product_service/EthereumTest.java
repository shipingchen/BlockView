package net.xdclass.product_service;

import net.sf.json.JSONObject;
import net.xdclass.product_service.domain.Ethereum;
import net.xdclass.product_service.mapper.EthereumMapper;
import net.xdclass.product_service.utils.ReadUrlUtil;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;


public class EthereumTest {

    @org.junit.Test
    public void test() throws IOException{




        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/block?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("19941220qin");
        dataSource.setDefaultAutoCommit(false);

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development",transactionFactory,dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(EthereumMapper.class);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(configuration);



        boolean result = false;
        int count = 0;
        int blockNum = 8875327;





        while (!result) {


            try {
                Thread.sleep(1000);
                count++;

                String key = "D57YAMFECX6KHQI746H7MCKRKT9E3GH8EZ";
                String url = "https://api.etherscan.io/api?module=block&action=getblockreward&blockno=" + blockNum + "&apikey=" + key;

                JSONObject json = ReadUrlUtil.readJsonFromUrl(url);

                String status = json.getString("status");
                String s = "1";
                if (s.equals(status)) {


                    SqlSession session = sessionFactory.openSession();

                    EthereumMapper ethereumMapper = session.getMapper(EthereumMapper.class);



                    JSONObject internalJson = json.getJSONObject("result");

                    Ethereum ethereum = new Ethereum(Integer.parseInt(internalJson.getString("blockNumber")),
                            internalJson.getString("timeStamp"),
                            internalJson.getString("blockMiner"),
                            internalJson.getString("blockReward"),
                            internalJson.getString("uncleInclusionReward"));

                    ethereumMapper.add(ethereum);
                    System.out.println(blockNum);
                    blockNum++;

                    session.commit();
                    session.close();
                    System.out.println(1);
                }

                if (count == 3600) {
                    result = true;
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }










    }


}
