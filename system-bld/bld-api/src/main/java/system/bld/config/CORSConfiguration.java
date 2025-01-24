package system.bld.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import system.bld.interceptor.LoginInterceptor;

import java.util.Properties;

/**
 * @author litao
 * @date 2021-06-22
 * @Desc
 */
@Configuration
public class CORSConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            /*@Override
            public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
                       // .allowedOrigins("http://localhost:63342","http://120.27.245.71:8070")
                        .allowedOrigins("*")
                        .allowedHeaders("*")
                        .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
                        .allowCredentials(true).maxAge(36000);
            }*/

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/500","/404","/error");
            }
        };
    }

    @Bean
    public String sqlInterceptor(SqlSessionFactory sqlSessionFactory){

        CustomSqlOutInterceptor sqlOutInterceptor=new CustomSqlOutInterceptor();

        sqlSessionFactory.getConfiguration().addInterceptor(sqlOutInterceptor);

        return "interceptor";
    }

}
