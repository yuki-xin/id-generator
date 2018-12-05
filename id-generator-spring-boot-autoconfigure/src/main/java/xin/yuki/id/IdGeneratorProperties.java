package xin.yuki.id;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * IdGeneratorProperties
 * @author zhang
 */
@ConfigurationProperties(prefix = IdGeneratorProperties.ID_GENERATOR_PREFIX)
@Data
public class IdGeneratorProperties {
    public static final String ID_GENERATOR_PREFIX = "id";

    private Long workerId = 0L;

    private Long datacenterId = -1L;

    private Zookeeper zookeeper=new Zookeeper();

    private Type type=new Type();

    @Data
    public static class Zookeeper {
        private Boolean enable = false;

        private String serverLists;

        private String digest;

        private String namespace = "id-generator";

        private Integer baseSleepTime = 1000;

        private Integer maxSleepTime = 3000;

        private Integer maxRetries = 3;

        private Integer sessionTimeout = 60000;

        private Integer connectionTimeout = 30000;

    }

    @Data
    public static class Type {
        private Boolean second = false;
    }

}
