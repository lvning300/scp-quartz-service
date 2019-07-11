package com.lv.cloud.quartz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

 /*   @Value("${swagger2.auth.clientId:}")
    private String clientId;
    @Value("${swagger2.auth.clientSecret:}")
    private String clientSecret;
    @Value("${swagger2.auth.authorizationUri:}")
    private String authorizationUri;
    @Value("${swagger2.auth.tokenUri:}")
    private String tokenUri;
    @Value("${swagger2.auth.scopes:}")
    private String scopes;
*/

    @Bean
    public Docket api() {

        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("token").description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header").required(false).build();
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lv.cloud.quartz.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(info());
        //.globalOperationParameters(pars)
        //.securityContexts(Collections.singletonList(securityContext()))
        //.securitySchemes(Arrays.asList(securitySchema(), apiKey(), apiCookieKey()));

    }

    private ApiInfo info() {

        return new ApiInfo(
                "scp-quartz-service集成框架服务",
                "scp-quartz-service集成框架服务接口.",
                "1.0",
                "http://www.lvning300.com",
                new Contact("LvNing", "lvning@300@163.com", "lvning@300@163.com"),
                "Commercial Licensing", "http://www.lvning300.com",
                Collections.emptyList());
    }

    /*private SecurityScheme securityScheme() {
        return new OAuthBuilder()
                .name("OAuth2")
                .grantTypes(grantTypes())
                .scopes(Arrays.asList(scopes()))
                .build();
    }

    *//**
     * 设置 swagger2 认证的安全上下文
     *//*
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(new SecurityReference("oauth2", scopes())))
                .forPaths(PathSelectors.any())
                .build();
    }

    *//**
     * 设置认证的scope
     * @return
     *//*
    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[]{
                new AuthorizationScope("ALL", "All scope!")
        };
    }

    *//**
     *  使用密码模式
     *//*
    @Bean
    List<GrantType> grantTypes() {
        List<GrantType> grantTypes = new ArrayList<>();
        GrantType grantType = new ResourceOwnerPasswordCredentialsGrant(tokenUri);
        grantTypes.add(grantType );
        return grantTypes;
    }
*/


  /*  @Bean
    public SecurityScheme apiKey() {
        return new ApiKey(HttpHeaders.AUTHORIZATION, "apiKey", "header");
    }

    @Bean
    public SecurityScheme apiCookieKey() {
        return new ApiKey(HttpHeaders.COOKIE, "apiKey", "cookie");
    }

    private OAuth securitySchema() {

        List<AuthorizationScope> authorizationScopeList = newArrayList();
        authorizationScopeList.add(new AuthorizationScope("read", "read all"));
        authorizationScopeList.add(new AuthorizationScope("write", "access all"));

        List<GrantType> grantTypes = newArrayList();
        GrantType passwordCredentialsGrant = new ResourceOwnerPasswordCredentialsGrant(tokenUri);
        grantTypes.add(passwordCredentialsGrant);

        return new OAuth("oauth2", authorizationScopeList, grantTypes);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth())
                .build();
    }



    private List<SecurityReference> defaultAuth() {

        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[3];
        authorizationScopes[0] = new AuthorizationScope("read", "read all");
        authorizationScopes[1] = new AuthorizationScope("trust", "trust all");
        authorizationScopes[2] = new AuthorizationScope("write", "write all");

        return Collections.singletonList(new SecurityReference("oauth2", authorizationScopes));
    }

    @Bean
    public SecurityConfiguration security() {
       return SecurityConfigurationBuilder.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();


        //(clientId, clientSecret, "", "", "Bearer access token", ApiKeyVehicle.HEADER, HttpHeaders.AUTHORIZATION,"");
    }
*/
}