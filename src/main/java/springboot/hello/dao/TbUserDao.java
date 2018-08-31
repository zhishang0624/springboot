package springboot.hello.dao;

import springboot.hello.entity.TbUser;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
* Created by hbm Generator<27683139@qq.com> on 2018-8-31.
*/
public interface TbUserDao extends Mapper<TbUser>{

    int insert(TbUser tbUser);

    int delete(TbUser tbUser);

    int deleteByIds(@Param("ids") String[] ids);

    int update(TbUser tbUser);

    TbUser getById(@Param("id") String id);

    List<TbUser> list(TbUser tbUser);
}