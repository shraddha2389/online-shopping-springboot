package com.dss.shopping_backend_config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.dss.shopping_backend.dto"}) //we are adding entity classes in dto
@EnableTransactionManagement
public class HibernateConfig {

	//change based on your DBMS
	public final static String DATABASE_URL="jdbc:h2~/onlineshopping";
	public final static String DATABASE_DRIVER="org.h2.Driver";
	public final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	public final static String DATABASE_USERNAME="sa";
	public final static String DATABASE_PASSWORD="";

	@Bean
	private DataSource getDataSource()
	{
	  BasicDataSource datasource=new BasicDataSource();
	  
	  //providing database information
	  datasource.setDriverClassName(DATABASE_DRIVER);
	  datasource.setUrl(DATABASE_URL);
	  datasource.setUrl(DATABASE_DIALECT);
	  datasource.setUsername(DATABASE_USERNAME);
	  datasource.setPassword(DATABASE_PASSWORD);
	  
	  return datasource;
	}
	
	//Sessionfactory bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource)
	{
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(datasource);
		
		builder.addProperties(getHibernateProperties());
	    builder.scanPackages("com.dss.shopping_backend.dto");	
		
	   
	    return builder.buildSessionFactory();
		
		
	}

	//All hibernate properties will be return in this method
	private Properties getHibernateProperties() {
		
		Properties properties=new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.format_sql", "true");
		
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
		
	}
}
