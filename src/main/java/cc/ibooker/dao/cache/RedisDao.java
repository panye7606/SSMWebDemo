package cc.ibooker.dao.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.JedisPool;

/**
 * Redis缓存Dao
 * 
 * @author 邹峰立
 */
public class RedisDao {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final JedisPool jedisPool;
	
	public RedisDao(String ip, int port) {
		this.jedisPool = new JedisPool(ip, port);
	}

	
}
