package com.kakaopay.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.kakaopay.dao")
public class DataAccessConfig {
	
	/*
	 * 마이바티스 사용을 위해 SqlSessionFactoryBean를 생성하기 위한 클래스
	 * DB 사용을 위한 설정 파일로 application.properties에 선언된 spring.datasource.* 값들로 DataSource로 빌드하기 위해 사용
	 * 
	 */
	@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		/*
		 * "classpath:mapper/*.xml"
		 * MapperLocation을 다음과 같이 설정함, 설정대로 Resources 하위에 mapper 폴더와 *.xml 파일을 생성
		 */

        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(
        		new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
