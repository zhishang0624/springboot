package springboot;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import springboot.hello.Application;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class Test {

	@Autowired
    ApplicationContext applicationContext;
	
	@Before
	public void before() {
		System.out.println("before");
	}
	
	@org.junit.Test
	public void test() {
//		System.out.println(statisticTourismCircleDao.list(new StatisticTourismCircle()));
//		System.out.println(applicationContext.getBean(DataSource.class).getClass());
	}
	
	@After
	public void after() {
		System.out.println("after");
	}
}
