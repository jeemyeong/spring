package examples.board.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class StandaloneDataSourceConfig {

    @Value("#{jdbcProperties['jdbc.driverClassName']}")
    private String jdbcDriverClassName;
    @Value("#{jdbcProperties['jdbc.url']}")
    private String jdbcUrl;
    @Value("#{jdbcProperties['jdbc.username']}")
    private String jdbcUserName;
    @Value("#{jdbcProperties['jdbc.password']}")
    private String jdbcPassword;

    @Value("#{jdbcProperties['jdbc.pool.initialsize']}")
    private int poolInitialSize;
    @Value("#{jdbcProperties['jdbc.pool.maxtotal']}")
    private int poolMaxTotal;
    @Value("#{jdbcProperties['jdbc.pool.maxidle']}")
    private int poolMaxIdle;
    @Value("#{jdbcProperties['jdbc.pool.minidle']}")
    private int poolMinIdle;


    @Bean(value = "dataSource")
    public DataSource rawLocalBatchDataSource() {
        DataSource dataSource = newInstance(poolInitialSize, poolMaxTotal, poolMaxIdle, poolMinIdle);
        return dataSource;
    }

    private DataSource newInstance(int initialSize, int maxTotal, int maxIdle, int minIdle) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(jdbcDriverClassName);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUserName);
        dataSource.setPassword(jdbcPassword);

        dataSource.setInitialSize(initialSize);
        dataSource.setMaxTotal(maxTotal);
        dataSource.setMaxIdle(maxIdle);
        dataSource.setMinIdle(minIdle);

        return dataSource;
    }
}
