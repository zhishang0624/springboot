package springboot.hello.sys.service.impl;

import springboot.hello.sys.service.SysMenuService;
import springboot.hello.sys.dao.SysMenuDao;
import springboot.hello.sys.entity.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import springboot.hello.entity.base.ParamObject;
import springboot.hello.util.BeanUtil;
import java.util.List;

/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月9日.
*/
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object delSelected(ParamObject<SysMenu> paramObject ) throws Exception {
    	BeanUtil.buildEntity(SysMenu.class, paramObject);
    	String idsArr = (String) paramObject.getValue("ids");
    	String[] ids =  idsArr.split(",");
    	sysMenuDao.deleteByIds(ids);
    	paramObject.setMsg( "删除成功");
    	return null;
    }

    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object add(ParamObject<SysMenu> paramObject ) throws Exception {
    	BeanUtil.buildEntity(SysMenu.class, paramObject);
    	sysMenuDao.insert(paramObject.getEntity());
    	paramObject.setMsg( "添加成功");
    	return null;
    }
    
   @CacheEvict(value = "sysMenu", key = "#p0.id")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object del(ParamObject<SysMenu> paramObject ) throws Exception{
    	BeanUtil.buildEntity(SysMenu.class, paramObject);
    	sysMenuDao.delete(paramObject.getEntity());
    	paramObject.setMsg( "删除成功");
    	 return null;
    }
    
    
    @Cacheable(value = "sysMenu", key = "#p0.id")
    public Object getBId(ParamObject<SysMenu> paramObject) throws Exception{
    	BeanUtil.buildEntity(SysMenu.class, paramObject);
        return  sysMenuDao.getById(paramObject.getId());
    }
    
    
    @CachePut(value = "sysMenu", key = "#p0.id")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object edit(ParamObject<SysMenu> paramObject ) throws Exception{
    	BeanUtil.buildEntity(SysMenu.class, paramObject);
    	SysMenu entity = paramObject.getEntity();
    	sysMenuDao.update(entity);
    	paramObject.setMsg( "保存成功");
        return entity;
    }




    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(SysMenu sysMenu){
        return sysMenuDao.insert(sysMenu);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(SysMenu sysMenu){
        return sysMenuDao.delete(sysMenu);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(String[] ids) {
        return  sysMenuDao.deleteByIds(ids);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(SysMenu sysMenu){
        return sysMenuDao.update(sysMenu);
    }

    @Override
    public SysMenu getById(String id){
        return sysMenuDao.getById(id);
    }

    @Override
    public List<SysMenu> list(SysMenu sysMenu){
        return sysMenuDao.list(sysMenu);
    }
    
    /**
    *getter and setter
    */
    public SysMenuDao getSysMenu(){
    	return this.sysMenuDao;
    }
    
    public void setSysMenuDao(SysMenuDao sysMenuDao){
      this.sysMenuDao = sysMenuDao;
    }
    

}