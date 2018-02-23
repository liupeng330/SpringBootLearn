package me.penliu330;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by peng on 18/2/19.
 */
@RestController
// 给当前controller下的所有方法加了默认访问路径/hello
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    //对应url为http://127.0.0.1:8081/learn/hello/say/345
    @RequestMapping(value = {"/say/{id}"}, method = RequestMethod.GET)
    public String getSay(@PathVariable("id") Integer myId) {
        return "this is get, id=" + myId;
    }

    //对应url为http://127.0.0.1:8081/learn/hello/anotherSay?id=345
    @RequestMapping(value = {"/anotherSay"}, method = RequestMethod.GET)
    public String getAnotherSay(@RequestParam("id") Integer myId) {
        return "this is another get, id=" + myId;
    }

    //对应url为http://127.0.0.1:8081/learn/hello/anotherSay?id=345
    @RequestMapping(value = {"/anotherSayWithDefaultValue"}, method = RequestMethod.GET)
    public String getAnotherSayWithDefaultValue(@RequestParam(value="id", required = false, defaultValue = "0") Integer myId) {
        return "this is another get, with default value, id=" + myId;
    }

    // post方式
    @RequestMapping(value = "/say", method = RequestMethod.POST)
    public String postSay(@RequestParam(value = "id") Integer id, @RequestParam(value = "name") String name) {
        return "this is post, id = " + id + " name = " + name;
    }
}
