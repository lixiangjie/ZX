import java.util.List;
import java.util.Set;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;
import java.util.Iterator;

/**
 * @Author: Administrator
 * @Tags:
 * @Description: redis测试
 * @Date: 2017年7月28日 下午3:42:20
 */
public class TestRedis {

	public static void main(String args[]) {

		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
		// 查看服务是否运行
		System.out.println("服务正在运行：" + jedis.ping());

		// jedis字符串
		jedis.set("lxj", "zj");
		System.out.println("存储的字符串为：" + jedis.get("lxj"));

		// jedis列表
		jedis.lpush("1", "111");
		jedis.lpush("1", "222");
		jedis.lpush("1", "333");
		List<String> list = jedis.lrange("1", 0, 2);
		for (int i = 0; i < list.size(); i++) {
			// 结果以倒序显示
			System.out.println("列表项为：" + list.get(i));
		}

		// jedis keys
		Set<String> keys = jedis.keys("*");
		Iterator<String> iterator = keys.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key);
		}

		
		System.out.println("=====================");
		//删除指定key的数据
		jedis.del("1");
		System.out.println(jedis.get("1"));
		System.out.println("=====================");
		
		
		// 遍历所有数据
		RedisDO redisDO = new RedisDO();
		redisDO.open();
				
		Set<String> keys2 = redisDO.jedis.keys("*");
		Iterator<String> iterator2 = keys2.iterator();
		while (iterator2.hasNext()) {
			String KEY2 = (String) iterator2.next();
			String VALUE = redisDO.jedis.get(KEY2);
			System.out.println("KEY - VALUE : " + KEY2 + " - " + VALUE);
		}
		
		redisDO.close();
	}

}



//redis-JedisPoolConfig配置
class RedisDO {

	public Jedis jedis;

	public void close() {
		jedis.disconnect();
		jedis = null;
	}

	@SuppressWarnings({ "resource", "deprecation" })
	public Jedis open() {

		JedisPoolConfig config = new JedisPoolConfig();
		
		//连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
		config.setBlockWhenExhausted(true);
		 
		//设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
		config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
		 
		//是否启用pool的jmx管理功能, 默认true
		config.setJmxEnabled(true);
		 
		//默认
		config.setJmxNamePrefix("pool");
		 
		//是否启用后进先出, 默认true
		config.setLifo(true);
		 
		//最大空闲连接数, 默认8个
		config.setMaxIdle(20);
		 
		//最大连接数, 默认8个
		config.setMaxTotal(100);
		 
		//获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
		config.setMaxWaitMillis(-1);
		 
		//逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
		config.setMinEvictableIdleTimeMillis(1800000);
		 
		//最小空闲连接数, 默认0
		config.setMinIdle(0);
		 
		//每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
		config.setNumTestsPerEvictionRun(3);
		 
		//对象空闲多久后逐出, 当空闲时间>该值 且 空闲连接>最大空闲数 时直接逐出,不再根据MinEvictableIdleTimeMillis判断  (默认逐出策略)   
		config.setSoftMinEvictableIdleTimeMillis(1800000);
		 
		//在获取连接的时候检查有效性, 默认false
		config.setTestOnBorrow(false);
		 
		//在空闲时检查有效性, 默认false
		config.setTestWhileIdle(false);
		 
		//逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
		config.setTimeBetweenEvictionRunsMillis(-1);
			
		
		//新建jedis连接池
		JedisPool pool = new JedisPool(config, "localhost", 6379);

		boolean borrowOrOprSuccess = true;
		
		try {
			jedis = pool.getResource();
			// do redis opt by instance
		} catch (JedisConnectionException e) {
			borrowOrOprSuccess = false;
			if (jedis != null)
				pool.returnBrokenResource(jedis);
		} finally {
			if (borrowOrOprSuccess)
				pool.returnResource(jedis);
		}
		jedis = pool.getResource();
		return jedis;
	}

}
