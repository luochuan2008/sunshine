package red.lixiang.tools.common.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import red.lixiang.tools.jdk.StringTools;

/**
 * @author lixiang
 * @date 2020/3/12
 **/
public class RedisConfig {

    /**
     * 当前配置的标识
     */
    private Long id;
    private String tag;
    private String host;
    private Integer port=6379;
    private String password;
    private Boolean ssl;
    private Integer database;

    public RedisConfig(String host, Integer port, String password) {
        this.host = host;
        this.port = port;
        this.password = password;
    }

    public RedisConfig(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public RedisConfig(String host, String password) {
        this.host = host;
        this.password = password;
    }

    public RedisConfig() {
    }

    public String getTag() {
        return tag;
    }

    public Long getId() {
        return id;
    }

    public RedisConfig setId(Long id) {
        this.id = id;
        return this;
    }

    public RedisConfig setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public Boolean getSsl() {
        return ssl;
    }

    public RedisConfig setSsl(Boolean ssl) {
        this.ssl = ssl;
        return this;
    }

    public Integer getDatabase() {
        return database;
    }

    public RedisConfig setDatabase(Integer database) {
        this.database = database;
        return this;
    }

    public String getHost() {
        return host;
    }

    public RedisConfig setHost(String host) {
        this.host = host;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public RedisConfig setPort(Integer port) {
        this.port = port;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RedisConfig setPassword(String password) {
        this.password = password;
        return this;
    }

    public RedisClient fetchRedisClient(){
        RedisURI.Builder builder = RedisURI.Builder.redis(host, port);
        if(StringTools.isNotBlank(password)){
            builder.withPassword(password);
        }
        if(database!=null){
            builder.withDatabase(database);
        }
        if(ssl!=null){
            builder.withSsl(ssl);
        }
        RedisURI redisURI = builder.build();
        return RedisClient.create(redisURI);
    }
}
