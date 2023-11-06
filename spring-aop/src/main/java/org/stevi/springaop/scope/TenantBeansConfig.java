package org.stevi.springaop.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TenantBeansConfig {

    @Scope(scopeName = "tenant")
    @Bean
    public TenantBean foo() {
        return new TenantBean();
    }

    @Scope(scopeName = "tenant")
    @Bean
    public TenantBean bar() {
        return new TenantBean();
    }
}