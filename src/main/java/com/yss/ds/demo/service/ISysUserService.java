package com.yss.ds.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yss.ds.demo.entity.SysUser;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author qjwyss
 * @since 2020-09-02
 */
public interface ISysUserService extends IService<SysUser> {

    SysUser selectUser(Integer uid);

    SysUser selectUserSlave(Integer uid);

    void saveSysUser();

    void saveUserAndQueryGoods();

    void saveSingleUser();
}
