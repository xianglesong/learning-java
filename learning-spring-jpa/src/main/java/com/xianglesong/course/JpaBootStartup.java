package com.xianglesong.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.xianglesong.course.entity.UserInfo;
import com.xianglesong.course.repository.UserInfoRepository;
import com.xianglesong.course.service.UserInfoService;

/**
 * SyncBootStartup
 *
 * @author ma.rulin
 * @date 17/4/12
 */
//@EnableAutoConfiguration
//@Configuration
//@ComponentScan
@SpringBootApplication
public class JpaBootStartup {
    public static Logger logger = LoggerFactory.getLogger(JpaBootStartup.class);

    public static void main(String[] args) {
        logger.info("sync boot start up.");

        ConfigurableApplicationContext context = SpringApplication.run(JpaBootStartup.class, args);

        UserInfoService userInfoService = context.getBean("userInfoService", UserInfoService.class);
        UserInfoRepository userInfoRepository = context.getBean("userInfoRepository", UserInfoRepository.class);
        UserInfo userInfo = new UserInfo();

        userInfo.setId("11232");
        userInfo.setUserName("test");
        userInfo.setUserPwd("pwd");
        userInfoService.save(userInfo);

        userInfo = userInfoRepository.findOne("11");
        logger.info("userInfo: " + userInfo);

        userInfo = userInfoRepository.findOne("22");
        logger.info("userInfo: " + userInfo);

        userInfo = userInfoRepository.findOne("11");
        logger.info("userInfo: " + userInfo);
        userInfo.setStatus(1);
        userInfo.setUpdateTime(Calendar.getInstance().getTime());
        userInfoService.save(userInfo);

        userInfo.setId("2323");
        userInfo.setStatus(1);
        userInfo.setUpdateTime(Calendar.getInstance().getTime());
        userInfoService.save(userInfo);

//        userInfoRepository.delete("2");

//        userInfo = userInfoRepository.findByStatus(1);
//        logger.info("userInfo: " + userInfo);

        List<UserInfo>  userInfos= userInfoRepository.findByStatusAndUserName(1,"test");
        logger.info("userInfo: " + userInfos.size());

        userInfos = userInfoRepository.findByqQ("test", "pwd");
        logger.info("userInfo: " + userInfos.size());

//        Sort.Direction;

//        Pageable pageable = new PageRequest(0, 2);
        List<Sort.Order> orders=new ArrayList<Sort.Order>();
        orders.add( new Sort.Order(Sort.Direction. DESC, "id"));
        orders.add( new Sort.Order(Sort.Direction. ASC, "status"));
        Pageable pageable= new PageRequest(1, 2, new Sort(orders));
        Page<UserInfo> pages= userInfoRepository.findAll(pageable);

        logger.info("sync boot end.");
    }

}
