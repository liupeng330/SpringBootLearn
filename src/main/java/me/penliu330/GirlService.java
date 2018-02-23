package me.penliu330;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by peng on 18/2/21.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girl = new Girl();
        girl.setAge(123);
        girl.setCupSize("A");
        girlRepository.save(girl);

        Girl girl2 = new Girl();
        girl2.setAge(12);
        girl2.setCupSize("B");
        girlRepository.save(girl2);
    }
}
