package springboot.hello.util;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;



import springboot.hello.Application;
import springboot.hello.dao.ZhangSanDao;
import springboot.hello.entity.ZhangSan;
import springboot.hello.entity.base.ParamObject;
import springboot.hello.entity.base.QueryEntity;
import springboot.hello.service.ZhangSanService;

/**
 * 单元测试工具
 * 
 * @author Administrator
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
public class TestUtil {

	@Autowired
    private RedisTemplate redisTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	
	@Autowired
	private ZhangSanDao zhangSanDao;
	
	@Test
	public void test() {
//		zhangSanDao.list(new ZhangSan());
		
	}

}
