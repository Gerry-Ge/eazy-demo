package org.gerry.requestMap;

import org.gerry.Utils.ResJasonTemplate;
import org.gerry.Utils.applicationAware;
import org.gerry.mapper.UserMapper;
import org.gerry.model.User;
import org.gerry.services.UserService;
import org.gerry.test.Child;
import org.gerry.yml.readYml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.AsyncBoxView;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloTest {

    @Autowired
    UserService userService;



    @RequestMapping("/test")
    public String test(){
        Child chi=new Child();
        ResJasonTemplate res=new ResJasonTemplate();
        res.setResCode("200");
        res.setResMsg("dasdas");
        System.out.println(chi.getMapperClass());
        return JSON.toJSONString(res);
    }

    //http://localhost:8081/hello/app?idp=2
    @Path("/app/{idp}")
    public String getApplication(@PathParam(value="idp") String idp){
        User user=userService.search(Integer.parseInt(idp));

        ResJasonTemplate res=new ResJasonTemplate();
        res.setResCode("200");
        res.setResMsg(user.toString());

        return JSON.toJSONString(res);
    }

    //http://localhost:8080/hello/testQP?namep=gerry
    //大小写敏感
    @RequestMapping("/testQP")
    public String hello(@QueryParam(value="namep") String namep){
        ResJasonTemplate res=new ResJasonTemplate();
        res.setResCode("200");
        res.setResMsg("Hello "+namep+" !");
        return JSON.toJSONString(res);
    }

    //http://localhost:8080/hello/testPP?namep=gerry
    @Path("testPP/{namep}")
    public String hello2(@PathParam("namep") String namep){
        ResJasonTemplate res=new ResJasonTemplate();
        res.setResCode("200");
        res.setResMsg("Hello "+namep+" !");
        return JSON.toJSONString(res);
    }

    //http://localhost:8080/hello/testRP?name=cc
    @RequestMapping("testRP")
    public String hello3(@RequestParam(value = "name",defaultValue = "gerry") String name){
        ResJasonTemplate res=new ResJasonTemplate();
        res.setResCode("200");
        res.setResMsg("Hello "+name+" !");
        return JSON.toJSONString(res);
    }

    //http://localhost:8080/hello/testpv/gerry
    @RequestMapping("/testpv/{id}")
    public String hello4(@PathVariable(value="id") String name){
        ResJasonTemplate res=new ResJasonTemplate();
        res.setResCode("200");
        res.setResMsg("Hello "+name+" !");
        return JSON.toJSONString(res);
    }
}