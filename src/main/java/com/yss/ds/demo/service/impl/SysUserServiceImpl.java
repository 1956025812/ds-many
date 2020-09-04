package com.yss.ds.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yss.ds.demo.entity.Goods;
import com.yss.ds.demo.entity.SysUser;
import com.yss.ds.demo.mapper.SysUserMapper;
import com.yss.ds.demo.service.IGoodsService;
import com.yss.ds.demo.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author qjwyss
 * @since 2020-09-02
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private IGoodsService iGoodsService;


    @DS("user_master")
    @Override
    public SysUser selectUser(Integer uid) {
        return this.getById(uid);
    }


    @DS("user_slave")
    @Override
    public SysUser selectUserSlave(Integer uid) {
        return this.getById(uid);
    }


    /**
     * 支持主数据源的事务
     */
    @DS("user_master")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveSysUser() {
        SysUser sysUser = new SysUser().setUsername("yss013").setPassword("123456").setEmail("yss@013.com").setState(1).setRegisterSource(1)
                .setCreateTime(new Date());
        save(sysUser);
        System.out.println(1 / 0);
        save(sysUser);
    }


    /**
     * 嵌套数据源的话最外层不要加数据源
     * 内层方法加各自的数据源 保证一个service只有一个数据源
     */
    @Override
    public void saveUserAndQueryGoods() {
        this.saveSingleUser();
        Goods goods = this.iGoodsService.selectGoods(1);
        log.info("商品信息为：{}", JSONObject.toJSONString(goods));
    }


    @DS("user_master")
    @Override
    public void saveSingleUser() {
        SysUser sysUser = new SysUser().setUsername("yss013").setPassword("123456").setEmail("yss@013.com").setState(1).setRegisterSource(1)
                .setCreateTime(new Date());
        this.save(sysUser);
    }
}
