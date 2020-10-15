package springboot.hello.controller;


import springboot.hello.service.ZhangSanService;
import springboot.hello.entity.ZhangSan;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageHelper;


/** 
* Created by hbm Generator<27683139@qq.com> on 2020年10月6日.
*/
@Controller
@RequestMapping("/zhangsan")
@Cacheable(value = "zs")
public class ZhangSanController{
	
	Logger log = LoggerFactory.getLogger(ZhangSanController.class);

    @Autowired
    ZhangSanService zhangSanService;

    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public Object listZhangSan(){
        ZhangSan zhangSan=new ZhangSan();
        return zhangSanService.list(zhangSan);
    }

    @RequestMapping(value="getById.ztc",method = RequestMethod.GET)
    @ResponseBody
    public Object getByIdZhangSan(String id){
        return zhangSanService.getById(id);
    }

    @RequestMapping(value="",method = RequestMethod.POST)
    @ResponseBody
    public Object insertZhangSan(@RequestBody ZhangSan zhangSan){
        return zhangSanService.insert(zhangSan);
    }


    @RequestMapping(value="",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateZhangSan(@RequestBody ZhangSan zhangSan){
        return zhangSanService.update(zhangSan);
    }


    @RequestMapping(value="",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteZhangSan(@RequestBody ZhangSan zhangSan){
        return zhangSanService.delete(zhangSan);
    }

    @RequestMapping(value="/selective",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteZhangSanByIds(@RequestBody String[] ids){
        return zhangSanService.deleteByIds(ids);
    }
}
