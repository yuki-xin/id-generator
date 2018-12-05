package xin.yuki.id;

import com.lxm.idgenerator.configuration.AutoConfiguration;
import com.lxm.idgenerator.enums.IdType;
import com.lxm.idgenerator.factory.IdServiceBeanFactory;
import com.lxm.idgenerator.service.intf.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  EmbeddedGeneratorAutoConfiguration
 * @author zhang
 */
@Configuration
@EnableConfigurationProperties(IdGeneratorProperties.class)
public class IdGeneratorAutoConfiguration {

    @Autowired
    private IdGeneratorProperties idGeneratorProperties;

    @ConditionalOnProperty(value = "id.zookeeper.enable", havingValue = "false", matchIfMissing = true)
    @Bean
    public IdService idService() {
        return IdServiceBeanFactory.getService(idGeneratorProperties.getDatacenterId(), idGeneratorProperties.getWorkerId(),
                IdType.parse(idGeneratorProperties.getType().getSecond()));
    }

    @ConditionalOnProperty(value = "id.zookeeper.enable", havingValue = "true")
    @Bean
    public IdService zookeeperIdService() {
        AutoConfiguration conf = new AutoConfiguration();
        IdGeneratorProperties.Zookeeper zookeeper = idGeneratorProperties.getZookeeper();
        IdGeneratorProperties.Type type = idGeneratorProperties.getType();

        conf.setDataCenterId(idGeneratorProperties.getDatacenterId());
        conf.setWorkerId(idGeneratorProperties.getWorkerId());

        conf.setEnableZk(zookeeper.getEnable());
        conf.setBaseSleepTimeMilliseconds(zookeeper.getBaseSleepTime());
        conf.setMaxSleepTimeMilliseconds(zookeeper.getMaxSleepTime());
        conf.setConnectionTimeoutMilliseconds(zookeeper.getConnectionTimeout());
        conf.setDigest(zookeeper.getDigest());
        conf.setHost(zookeeper.getServerLists());
        conf.setMaxRetries(zookeeper.getMaxRetries());
        conf.setNamespace(zookeeper.getNamespace());
        conf.setSessionTimeoutMilliseconds(zookeeper.getSessionTimeout());

        conf.setIdType(type.getSecond());

        return IdServiceBeanFactory.getService(conf);
    }

}
