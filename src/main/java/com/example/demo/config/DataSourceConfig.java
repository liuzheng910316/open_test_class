package com.example.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.example.demo.model.Course;
import com.example.demo.model.Suscribe;
import com.example.demo.model.User;



@Configuration
public class DataSourceConfig {

	/**
	@Value("${spring.datasource.url}")
	String url;
	@Value("${spring.datasource.password}")
	String password;
	@Value("${spring.datasource.username}")
	String username;
	@Value("${spring.datasource.driverClassName}")
	String driverClassName;
	**/
	@Value("${hibernate.dialect}")
	String hibernateDialect;
	/**
	@Bean
	DataSource dataSource(){
		DataSourceBuilder builder = new DataSourceBuilder(null);
		builder.url(url);
		builder.username(username);
		builder.password(password);
		builder.driverClassName(driverClassName);
		return builder.build();
	}
	**/
	@Autowired
	DataSource dataSource;
	@Bean
	SessionFactory sessionFactory() throws Exception{
		LocalSessionFactoryBean bean
			= new LocalSessionFactoryBean();
		bean.setDataSource(dataSource);
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", hibernateDialect);
		bean.setAnnotatedClasses(new Class[] {
				User.class,       
				Course.class,
				Suscribe.class
		});
		bean.setHibernateProperties(prop);
		bean.afterPropertiesSet();
		return bean.getObject();
	}
}
