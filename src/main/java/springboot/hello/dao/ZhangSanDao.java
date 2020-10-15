package springboot.hello.dao;

import springboot.hello.entity.ZhangSan;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月6日.
*/
@org.apache.ibatis.annotations.Mapper
public interface ZhangSanDao extends Mapper<ZhangSan>{

    int insert(ZhangSan zhangSan);

    int delete(ZhangSan zhangSan);

    int deleteByIds(@Param("ids") String[] ids);

    int update(ZhangSan zhangSan);

    ZhangSan getById(@Param("id") String id);

    List<ZhangSan> list(ZhangSan zhangSan);
}