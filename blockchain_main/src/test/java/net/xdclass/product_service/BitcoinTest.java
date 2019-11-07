package net.xdclass.product_service;





import net.sf.json.JSONObject;
import net.xdclass.product_service.domain.Bitcoin;
import net.xdclass.product_service.mapper.BitcoinMapper;
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

public class BitcoinTest {

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
        configuration.addMapper(BitcoinMapper.class);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(configuration);


        boolean result = false;
        int count = 0;
        int height = 602391;


        while (!result) {

            try {
                Thread.sleep(1000);
                count++;


                String url = "https://chain.api.btc.com/v3/block/"+height;

                JSONObject json = ReadUrlUtil.readJsonFromUrl(url);


                JSONObject data = json.getJSONObject("data");

                if (!data.isNullObject()) {

                    SqlSession session = sessionFactory.openSession();

                    BitcoinMapper bitcoinMapper = session.getMapper(BitcoinMapper.class);

                    Bitcoin bitcoin = new Bitcoin(Integer.parseInt(data.getString("height")),
                            String.valueOf(data.getString("timestamp")),
                            data.getString("hash"),
                            String.valueOf(data.getString("size")),
                            String.valueOf(data.getString("tx_count")),
                            String.valueOf(data.getString("confirmations")));

                    bitcoinMapper.add(bitcoin);
                    System.out.println(height);
                    height++;

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
