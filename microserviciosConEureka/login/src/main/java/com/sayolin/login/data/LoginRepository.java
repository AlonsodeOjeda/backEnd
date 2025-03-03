package com.sayolin.login.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sayolin.login.model.pojo.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
