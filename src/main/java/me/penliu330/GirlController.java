package me.penliu330;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by peng on 18/2/21.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    // 获取所有
    @RequestMapping(value = "/girls", method= RequestMethod.GET)
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    // 创建
    @RequestMapping(value = "/girls", method= RequestMethod.POST)
    public Girl girlAdd(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    // 通过ID获取
    @RequestMapping(value = "/girls/{id}", method= RequestMethod.GET)
    public Girl getGirl(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    // 通过age获取
    @RequestMapping(value = "/girls/age/{age}", method= RequestMethod.GET)
    public List<Girl> getGirlByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    // 更新
    @RequestMapping(value = "/girls/{id}", method= RequestMethod.PUT)
    public Girl updateGirl(@PathVariable("id") Integer id,
                        @RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    // 删除
    @RequestMapping(value = "/girls/{id}", method= RequestMethod.DELETE)
    public void deleteGirl(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    // 事务测试
    @RequestMapping(value = "/girls/inserttwo", method= RequestMethod.GET)
    public void insertTwo() {
        girlService.insertTwo();
    }
}
