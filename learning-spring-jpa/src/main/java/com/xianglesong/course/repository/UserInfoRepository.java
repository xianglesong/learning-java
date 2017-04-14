package com.xianglesong.course.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.xianglesong.course.entity.UserInfo;

/**
 * Created by rollin on 17/4/14.
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    //public interface UserInfoRepository extends PagingAndSortingRepository<UserInfo, String> {
    UserInfo findByStatus(int status);

    List<UserInfo> findByStatusAndUserName(int status, String userName);

    @Query("from UserInfo u where u.userName = ?1 AND u.userPwd = ?2")
    List<UserInfo> findByqQ(String userName, String userPwd);

    Page<UserInfo> findAll(Pageable pageRequest);
}

