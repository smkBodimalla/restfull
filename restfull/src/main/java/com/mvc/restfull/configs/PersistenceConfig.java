package com.mvc.restfull.configs;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan(basePackages = "com.mvc.restfull.repository")
public class PersistenceConfig {

	@Bean
	public DataSource createDataSource() {

		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
		bean.setJndiName("java:/comp/env/DSJndi");
		return (DataSource) bean.getObject();
	}

	private final Properties hibernateProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		return props;

	}

	/*
	 * @Bean public LocalSessionFactoryBean createLocalSessionFactory() {
	 * 
	 * LocalSessionFactoryBean localSessionFactoryBean = null;
	 * localSessionFactoryBean = new LocalSessionFactoryBean();
	 * localSessionFactoryBean.setDataSource(createDataSource()); // spring 4.x
	 * there is no option to add annotatedClassess for entity clasess
	 * 
	 * // localSessionFactoryBean.setAnnotatedClasses(class[t] tyeps); // for this
	 * we can user AnnotationSessionFactory
	 * localSessionFactoryBean.setHibernateProperties(hibernateProperties());
	 * 
	 * return localSessionFactoryBean;
	 * 
	 * }
	 */

	@Bean
	public AnnotationSessionFactoryBean createAnnotaionSessionFactory() {
		AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
		sessionFactoryBean.setDataSource(createDataSource());
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		sessionFactoryBean.setPackagesToScan(new String[] { "com.mvc.restfull.entity" });
		return sessionFactoryBean;
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public HibernateTemplate createHibernateTemplate() {

		HibernateTemplate hibernateTemplate = new HibernateTemplate(createAnnotaionSessionFactory().getObject());

		return hibernateTemplate;
	}

	@Bean
	public PlatformTransactionManager platformTransactionManager() {
		PlatformTransactionManager manager = new HibernateTransactionManager(
				createAnnotaionSessionFactory().getObject());
		return manager;

	}

}
