package me.penliu330;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by peng on 18/2/21. */
public interface GirlRepository extends JpaRepository<Girl, Integer> {
    // 通过年龄来查询
    List<Girl> findByAge(Integer age);
}
