package com.gcit.lms.lib;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.gcit.service.LibrarianService;

import dao.AuthorDAO;
import dao.BookCopiesDAO;
import dao.BookDAO;
import dao.BookLoansDAO;
import dao.BorrowerDAO;
import dao.BranchDAO;
import dao.GenreDAO;
import dao.PublisherDAO;



@Configuration
public class LMSConfig {
	
/*	public final String driver = "com.mysql.cj.jdbc.Driver";
	public final String url = "jdbc:mysql://localhost/library";
	public final String username = "root";
	public final String password = "manasa";
	
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}
	
	
	
	@Bean
	public PlatformTransactionManager txManager(){
		return new DataSourceTransactionManager(dataSource());
	}*/
	
	@Bean
	public AuthorDAO aDao(){
		return new AuthorDAO();
	}
	
	@Bean
	public BookDAO bDao(){
		return new BookDAO();
	}
	
	@Bean
	public BranchDAO brDao(){
		return new BranchDAO();
	}
	
	@Bean
	public BookCopiesDAO bcDao(){
		return new BookCopiesDAO();
	}
	
	@Bean
	public BookLoansDAO blDao(){
		return new BookLoansDAO();
	}
	
	@Bean
	public BorrowerDAO brwDao(){
		return new BorrowerDAO();
	}
	
	@Bean
	public PublisherDAO pDao(){
		return new PublisherDAO();
	}
	
	@Bean
	public GenreDAO gDao(){
		return new GenreDAO();
	}
	
//	@Bean
//	public AdminService adminService(){
//		return new AdminService();
//	}
//	
	@Bean
	public LibrarianService libService(){
		return new LibrarianService();
	}
	
//	@Bean
//	public BorrowerService brwService() {
//		return new BorrowerService();
//	}
//	
}
