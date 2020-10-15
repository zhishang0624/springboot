package springboot.hello.service;

import springboot.hello.entity.base.ParamObject;

/**
* 查询服务
*/
public interface queryService {
	
	 Object queryById(ParamObject po) throws Exception;
    
}