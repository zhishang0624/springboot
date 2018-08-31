package springboot.hello.service;

import springboot.hello.entity.TbUser;
import java.util.List;

/**
* Created by hbm Generator<27683139@qq.com> on 2018-8-31.
*/
public interface TbUserService {

    int insert(TbUser tbUser);

    int delete(TbUser tbUser);

    int deleteByIds(String[] ids);

    int update(TbUser tbUser);

    TbUser getById(String id);

    List<TbUser> list(TbUser tbUser);
    
}