package io.github.hsn.cloud.common.data.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.PostInitTableInfoHandler;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import io.github.hsn.cloud.common.data.mp.CloudIdentifierGenerator;
import io.github.hsn.cloud.common.data.mp.CloudMetaObjectHandler;
import io.github.hsn.cloud.common.data.mp.CloudTableInfo;
import io.github.hsn.cloud.common.data.mp.CloudTenantLineHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class MybatisConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new TenantLineInnerInterceptor(new CloudTenantLineHandler()));
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.POSTGRE_SQL));
        mybatisPlusInterceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        return mybatisPlusInterceptor;
    }

    @Bean
    public CloudMetaObjectHandler cloudMetaObjectHandler() {
        return new CloudMetaObjectHandler();
    }

    @Bean
    public IdentifierGenerator identifierGenerator() {
        return new CloudIdentifierGenerator();
    }

    /**
     * 逻辑删除增强处理
     */
    @Bean
    public PostInitTableInfoHandler postInitTableInfoHandler() {
        return new PostInitTableInfoHandler() {
            @Override
            public TableInfo creteTableInfo(org.apache.ibatis.session.Configuration configuration, Class<?> entityType) {
                return new CloudTableInfo(configuration, entityType);
            }
        };
    }
}
