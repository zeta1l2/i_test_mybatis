package anno_test.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.yourbatis.Dbs;
import com.yourbatis.Dbs2;
@Configuration  // 설정파일
@EnableWebMvc  // 스프링 MVC 설정
@ComponentScan(basePackages = {"anno_test.controller"}) // 컨트롤러 패키지 스캐닝
@MapperScan(basePackages= {"anno_test.maps"})//맵퍼 스캐닝
public class MvcConfig {
	
	@Bean(name="amap")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		return getDbs().sqlSessionFactory();
	}
	//데이터베이스와 통신 담당
	@Bean DataSourceTransactionManager transactionManager() {
		return getDbs().transactionManager();
	}
	
	//선생님 db 테스트
	@Bean(name="dbs2")
	public Dbs2 getDbs2() {
		return new Dbs2();
	}
	
	@Bean(name="dbs")
	public Dbs getDbs() {
		return new Dbs();
	}
	
	@Bean(name="hello_anno")
	public ViewResolver viewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setViewClass(JstlView.class);
		irvr.setPrefix("/WEB-INF/view/");
		irvr.setSuffix(".jsp");
		return irvr;
	}
}
