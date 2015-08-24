package com.nath.webConfiguration;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

//import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.nath.util.ProperyReader;
@Configuration
@ComponentScan({"com.nath.webConfiguration"})
@EnableTransactionManagement
public class PersistenceConfig {
	
	@Bean(name="sessionFactory")
	public LocalSessionFactoryBean localSessionFactory() throws PropertyVetoException{
		final LocalSessionFactoryBean localSessionFactory = 
					new LocalSessionFactoryBean();
		localSessionFactory.setDataSource(dataSource());
		localSessionFactory.setPackagesToScan("com.nath.model");
//		annotationSessionFactoryBean.setLobHandler(org.springframework.jdbc.core.support);
		localSessionFactory.setAnnotatedPackages("com.nath.model");
		Properties hibernateProperties = loadHibernateProperties();
		localSessionFactory.setHibernateProperties(hibernateProperties );
		return localSessionFactory;
	}

	@Bean(name="dataSource")
	public DataSource dataSource() throws PropertyVetoException {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
			dataSource.setUrl(ProperyReader.getProperty("dburl"));
			dataSource.setUsername(ProperyReader.getProperty("userName"));
			dataSource.setPassword(ProperyReader.getProperty("password"));
			/*dataSource.setMaxWait(1000l);
			dataSource.setValidationQuery("SELECT COUNT(*) FROM DUAL");
			dataSource.setTestWhileIdle(true);
			dataSource.setTimeBetweenEvictionRunsMillis(180000000);
			dataSource.setMinEvictableIdleTimeMillis(360000);*/
		return dataSource;
	}
	
	public  Properties loadHibernateProperties() {
		 Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.show_sql", "false");
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibernateProperties.setProperty("hbm2ddl.auto", "create");
//		hibernateProperties.setProperty("hibernate.cache.use_query_cache", value);
		hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", "true");
		hibernateProperties.put("hibernate.jdbc.batch_size", "50");
		return hibernateProperties ;
	}
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager hibernateTransactionManager() throws PropertyVetoException{
		HibernateTransactionManager transactionManager =  new HibernateTransactionManager();
		transactionManager.setDataSource(dataSource());
		transactionManager.setRollbackOnCommitFailure(true);
		transactionManager.setSessionFactory(localSessionFactory().getObject());
		return transactionManager;
	
	}
	
	@Bean(name="hibernateTemplate")
	@Scope("singleton")
	public HibernateTemplate hibernateTemplate() throws PropertyVetoException{
		return new HibernateTemplate(localSessionFactory().getObject());
		
	}
	
}
