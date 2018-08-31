package springboot.hello.controller;


import springboot.hello.service.TbUserService;
import springboot.hello.entity.TbUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/** 
* Created by hbm Generator<27683139@qq.com> on 2018-8-31.
*/
@Controller
@RequestMapping("/tbuser")
public class TbUserController{

    @Autowired
    TbUserService tbUserService;

    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public Object listTbUser(){
        TbUser tbUser=new TbUser();
        return tbUserService.list(tbUser);
    }

    @RequestMapping(value="getById.ztc",method = RequestMethod.GET)
    @ResponseBody
    public Object getByIdTbUser(String id){
        return tbUserService.getById(id);
    }

    @RequestMapping(value="",method = RequestMethod.POST)
    @ResponseBody
    public Object insertTbUser(@RequestBody TbUser tbUser){
        return tbUserService.insert(tbUser);
    }


    @RequestMapping(value="",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateTbUser(@RequestBody TbUser tbUser){
        return tbUserService.update(tbUser);
    }


    @RequestMapping(value="",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteTbUser(@RequestBody TbUser tbUser){
        return tbUserService.delete(tbUser);
    }

    @RequestMapping(value="/selective",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteTbUserByIds(@RequestBody String[] ids){
        return tbUserService.deleteByIds(ids);
    }
}
