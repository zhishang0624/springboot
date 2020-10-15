package springboot.hello.service.impl;

import springboot.hello.service.ZhangSanService;
import springboot.hello.util.BeanUtil;
import springboot.hello.dao.ZhangSanDao;
import springboot.hello.entity.ZhangSan;
import springboot.hello.entity.base.ParamObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月6日.
*/
@Service("zhangSanService")
public class ZhangSanServiceImpl implements ZhangSanService {

    @Autowired
    private ZhangSanDao zhangSanDao;
    
    
    
    
//    @CacheEvict(value = "zhangsan", key = "#p0.id")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object delSelected(ParamObject<ZhangSan> paramObject ) throws Exception {
    	BeanUtil.buildEntity(ZhangSan.class, paramObject);
    	String idsArr = (String) paramObject.getValue("ids");
    	String[] ids =  idsArr.split(",");
    	zhangSanDao.deleteByIds(ids);
    	paramObject.getSession().setAttribute("msg", "删除成功");
    	return null;
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object add(ParamObject<ZhangSan> paramObject ) throws Exception {
    	BeanUtil.buildEntity(ZhangSan.class, paramObject);
    	zhangSanDao.insert(paramObject.getEntity());
    	paramObject.getSession().setAttribute("msg", "添加成功");
    	return null;
    }
    
   @CacheEvict(value = "zhangsan", key = "#p0.id")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object del(ParamObject<ZhangSan> paramObject ) throws Exception{
    	BeanUtil.buildEntity(ZhangSan.class, paramObject);
    	zhangSanDao.delete(paramObject.getEntity());
    	paramObject.getSession().setAttribute("msg", "删除成功");
    	 return null;
    }
    
    
    @Cacheable(value = "zhangsan", key = "#p0.id")
    public Object getBId(ParamObject<ZhangSan> paramObject) throws Exception{
    	BeanUtil.buildEntity(ZhangSan.class, paramObject);
        return  zhangSanDao.getById(paramObject.getId());
    }
    
    
    @CachePut(value = "zhangsan", key = "#p0.id")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object edit(ParamObject<ZhangSan> paramObject ) throws Exception{
    	BeanUtil.buildEntity(ZhangSan.class, paramObject);
    	ZhangSan entity = paramObject.getEntity();
    	zhangSanDao.update(entity);
    	paramObject.getSession().setAttribute("msg", "保存成功");
        return entity;
    }
    
    
    
    

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(ZhangSan zhangSan){
        return zhangSanDao.insert(zhangSan);
    }
    
    

    @Override
   // @Cacheable(value = "user_details", key = "#zhangSan.id", unless="#result == null")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(ZhangSan zs){
        return zhangSanDao.delete(zs);
    }
    
   
    
    

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(String[] ids) {
        return  zhangSanDao.deleteByIds(ids);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(ZhangSan zhangSan){
        return zhangSanDao.update(zhangSan);
    }

    
    @Cacheable(value = "zhangsan", key = "#id")
    @Override
    public ZhangSan getById(String id){
        return zhangSanDao.getById(id);
    }

    @Override
    public List<ZhangSan> list(ZhangSan zhangSan){
        return zhangSanDao.list(zhangSan);
    }
    
    
    /**
    *getter and setter
    */
    public ZhangSanDao getZhangSan(){
    	return this.zhangSanDao;
    }
    
    public void setZhangSanDao(ZhangSanDao zhangSanDao){
      this.zhangSanDao = zhangSanDao;
    }
    

}