package com.tsys.enterprise.productchange.listener.application.config.db;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ComponentScan
@EnableTransactionManagement
@ConditionalOnClass(DbProperties.class)
public class BalanceTransferDBConfig {

    public static final String BALANCETRANSFER_LISTENER_DATASOURCE = "balanceTransferlistenerDB";
    public static final String BALANCETRANSFER_LISTENER_SESSION_FACTORY = "balanceTransferlistenerSessionFactory";
    public static final String BALANCETRANSFER_LISTENER_SESSION_TEMPLATE = "balanceTransferlistenerSessionTemplate";

    @Autowired
    private DbProperties dbProperties;

    @Value("${productchangelistener.mybatis.config}")
    private String configLocation;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Primary
    public DataSourceTransactionManager datasourceTransactionManager() throws SQLException {
        return new DataSourceTransactionManager(this.balanceTransferDataSource());
    }

    @Bean(name = BALANCETRANSFER_LISTENER_DATASOURCE)
    @Primary
    public DataSource balanceTransferDataSource() throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dbProperties.getDriverClassName());
        dataSource.setUrl(dbProperties.getUrl());
        dataSource.setUsername(dbProperties.getUsername());
        dataSource.setPassword(dbProperties.getPassword());
        dataSource.setInitialSize(dbProperties.getInitialSize());
        dataSource.setMaxTotal(dbProperties.getMaxActive());
        dataSource.setTestOnBorrow(true);

        return dataSource;
    }

    @Bean(name = BALANCETRANSFER_LISTENER_SESSION_FACTORY)
    @Primary
    public SqlSessionFactory balanceTransferSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(configLocation));
        sqlSessionFactoryBean.setDataSource(this.balanceTransferDataSource());
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        sqlSessionFactory.getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
        sqlSessionFactory.getConfiguration().setDatabaseId(dbProperties.getName());
        return sqlSessionFactory;
    }

    @Bean(name = BALANCETRANSFER_LISTENER_SESSION_TEMPLATE)
    @Primary
    public SqlSessionTemplate polaronSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(this.balanceTransferSqlSessionFactory());
    }
}
