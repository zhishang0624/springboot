package springboot.hello.service;

import springboot.hello.entity.ZhangSan;
import springboot.hello.entity.base.ParamObject;

import java.util.List;

/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月6日.
*/
public interface ZhangSanService {
	

    int insert(ZhangSan zhangSan);

    int delete(ZhangSan zhangSan);

    int deleteByIds(String[] ids);

    int update(ZhangSan zhangSan);

    ZhangSan getById(String id);

    List<ZhangSan> list(ZhangSan zhangSan);

    
}