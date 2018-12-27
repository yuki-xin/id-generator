# id-generator
基于Twitter的SnowFlake算法实现的高性能分布式ID发号器。支持手动或通过Zookeeper分配workerId。配置简单，操作简易。生成的id具备全局唯一，粗略有序，可反向解码等特性。

### 实现
基于Gitee [lxm23/id-generator](https://gitee.com/simpleweb/id-generator),发布了spring-boot-starter版本,并上传至中央仓库

### 使用方式
引入依赖：
```
<dependency>
      <groupId>xin.yuki</groupId>
      <artifactId>id-generator-spring-boot-starter</artifactId>
      <version>2.3</version>
</dependency>
```
使用IdService:
```

import com.lxm.idgenerator.service.intf.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerSampleApplication {


    @Autowired
    private IdService idService;

    public static void main(final String[] args) {
        SpringApplication.run(ServerSampleApplication.class, args);
    }

    public Long getId(){
        return this.idService.genId();
    }
}

```

### 配置参考
请参考原项目[配置](https://gitee.com/simpleweb/id-generator#%E5%8F%82%E6%95%B0)


