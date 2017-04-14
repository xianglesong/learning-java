package com.xianglesong.course.service;

import com.xianglesong.course.repository.UserInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xianglesong.course.entity.UserInfo;

/**
 * HeliosMVSubjectService
 *
 * @author ma.rulin
 * @date 17/4/13
 */
@Service
public class UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    public void save(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }
}
