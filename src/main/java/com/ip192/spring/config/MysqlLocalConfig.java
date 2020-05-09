package com.ip192.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
@MapperScan(basePackages = {"com.ip192.spring.mapper"}, sqlSessionTemplateRef = "mysqlLocalSqlSessionTemplate")
public class MysqlLocalConfig {
    private Logger logger = LoggerFactory.getLogger(MysqlLocalConfig.class);
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.driverClassName}")
    String driver;
    @Value("${spring.datasource.username}")
    String userName;
    @Value("${spring.datasource.password}")
    String password;
//    @Value("${spring.datasource.maxActive}")
//    int maxActive;
//    @Value("${spring.datasource.filters}")
//    String filters;
//    @Value("${spring.datasource.initialSize}")
//    int initialSize;
//    @Value("${spring.datasource.minIdle}")
//    int minIdle;
//    @Value("${spring.datasource.maxWait}")
//    int maxWait;
//    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
//    int timeBetweenEvictionRunsMillis;
//    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
//    int minEvictableIdleTimeMillis;
//    @Value("${spring.datasource.validationQuery}")
//    String validationQuery;
//    @Value("${spring.datasource.testWhileIdle}")
//    boolean testWhileIdle;
//    @Value("${spring.datasource.testOnBorrow}")
//    boolean testOnBorrow;
//    @Value("${spring.datasource.testOnReturn}")
//    boolean testOnReturn;
//    @Value("${spring.datasource.poolPreparedStatements}")
//    boolean poolPreparedStatements;
//    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
//    int maxPoolPreparedStatementPerConnectionSize;
//    @Value("${spring.datasource.connectionProperties}")
//    String connectionProperties;
//    @Value("${spring.datasource.useGlobalDataSourceStat}")
//    boolean useGlobalDataSourceStat;


//    @Bean
//    public ServletRegistrationBean druidStatViewServlet() {
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        registrationBean.addInitParameter("allow", "127.0.0.1");
//        registrationBean.addInitParameter("deny", "192.168.31.234");
//        registrationBean.addInitParameter("loginUsername", "admin");
//        registrationBean.addInitParameter("loginPassword", "123456");
//        registrationBean.addInitParameter("resetEnable", "false");
//
//        return registrationBean;
//    }


//    @Bean
//    public FilterRegistrationBean druidWebStatViewFilter() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
//        registrationBean.addInitParameter("urlPatterns", "/*");
//        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
//
//        return registrationBean;
//    }


    @Primary
    @Bean(name = "mysqlLocalDataSource")
//    @ConfigurationProperties(prefix = "mysql")
    public DataSource mysqlLocalDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        /*数据源主要配置*/
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        /*数据源补充配置*/
//        dataSource.setMaxActive(maxActive);
//        dataSource.setInitialSize(initialSize);
//        dataSource.setMinIdle(minIdle);
//        dataSource.setMaxWait(maxWait);
//        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        dataSource.setValidationQuery(validationQuery);
//        dataSource.setTestOnBorrow(testOnBorrow);
//        dataSource.setTestOnReturn(testOnReturn);
//        dataSource.setTestWhileIdle(testWhileIdle);
//        dataSource.setPoolPreparedStatements(poolPreparedStatements);
//        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
//        dataSource.setConnectionProperties(connectionProperties);
//        dataSource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);

        System.out.println("Druid数据源初始化设置成功......");
//        try {
//            dataSource.setFilters(filters);
//            System.out.println("Druid数据源初始化设置成功......");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Druid数据源filters设置失败......");
//        }
        return dataSource;
    }

    @Bean
    public SqlSessionFactory mysqlLocalSqlSessionFactory(@Qualifier("mysqlLocalDataSource") DataSource dataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        try {
            bean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
            bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
            return bean.getObject();
        } catch (Exception e) {
            System.out.println("MYSQL数据源创建异常" + e);
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate mysqlLocalSqlSessionTemplate(@Qualifier("mysqlLocalSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
