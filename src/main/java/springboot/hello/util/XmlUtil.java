package springboot.hello.util;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import springboot.hello.entity.base.QueryEntity;

/**
 * xml工具类
 * @author Administrator
 *
 */
@Component
public class XmlUtil {
	
	private static RedisTemplate redisTemplate;
	
	public static void main(String[] args) throws Exception {
		
		loadQueryXml();
	}
	
	
	/**
	 * 加载查询xml文件
	 */
	public static void loadQueryXml() {
		if(redisTemplate == null) {
			redisTemplate  = (RedisTemplate) SpringUtil.getContext().getBean("redisTemplate");
		}
		String path = XmlUtil.class.getResource("/").getPath() + "springboot/hello/query";
		//迭代加载所有的xml
		loadAll(new File(path));
		
	}

	
	
	

	private static void loadAll(File f) {
		if(f.isDirectory()) {
			File[] listFiles = f.listFiles();
			for(File file : listFiles) {
				if(file.isDirectory()) {
					loadAll(file);
				}else {
					if(file.getName().endsWith(".xml")) {
						DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
						try {
							 DocumentBuilder builder = dbf.newDocumentBuilder();
					           SAXReader reader =  new SAXReader();
					           
					          Document document = reader.read(file);
					         Element  root =  document.getRootElement();
					         Attribute rootAttr = root.attribute("queryId");
					         QueryEntity qe = new QueryEntity();
					         String sql = root.elementText("sql");
					         //使用xpath
					         List<Element> elements = root.selectNodes("//td");
					         
					         Map<String, Element> eleMap = new HashMap<String, Element>();
					        for(Element e : elements) {
					        	
					        	eleMap.put(e.attributeValue("column"), e);
					        }
					         
					         qe.setSqlOrign(sql);
					         qe.setAttrs(elements);
					         qe.setEleMap(eleMap);
					         
					         //写入缓存
					         redisTemplate.opsForValue().set(rootAttr.getText(), qe);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
	}


	public static void setRedisTemplate(RedisTemplate redisTemplate) {
		XmlUtil.redisTemplate = redisTemplate;
	}
	
	
	
	

}


