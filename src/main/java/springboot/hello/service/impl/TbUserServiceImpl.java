package springboot.hello.service.impl;

import springboot.hello.service.TbUserService;
import springboot.hello.dao.TbUserDao;
import springboot.hello.entity.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* Created by hbm Generator<27683139@qq.com> on 2018-8-31.
*/
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
   // @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(TbUser tbUser){
        return tbUserDao.insert(tbUser);
    }

    @Override
   // @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(TbUser tbUser){
        return tbUserDao.delete(tbUser);
    }

    @Override
   // @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(String[] ids) {
        return  tbUserDao.deleteByIds(ids);
    }

    @Override
   // @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(TbUser tbUser){
        return tbUserDao.update(tbUser);
    }

    @Override
   // @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public TbUser getById(String id){
        return tbUserDao.getById(id);
    }

    @Override
   // @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<TbUser> list(TbUser tbUser){
        return tbUserDao.list(tbUser);
    }
    
    /**
    *getter and setter
    */
    public TbUserDao getTbUser(){
    	return this.tbUserDao;
    }
    
    public void setTbUserDao(TbUserDao tbUserDao){
      this.tbUserDao = tbUserDao;
    }
    

}