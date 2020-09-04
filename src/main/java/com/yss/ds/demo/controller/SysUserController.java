package com.yss.ds.demo.controller;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.yss.ds.demo.entity.SysUser;
import com.yss.ds.demo.service.ISysUserService;
import com.yss.ds.demo.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author qjwyss
 * @since 2020-09-02
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private ISysUserService iSysUserService;

    // http://localhost:8000/sysUser/selectUser?uid=5
    @GetMapping("/selectUser")
    public ResultVO selectUser(Integer uid) {
        SysUser sysUser = this.iSysUserService.selectUser(uid);
        return ResultVO.getSuccess("", sysUser);
    }


    // http://localhost:8000/sysUser/selectUserSlave?uid=5
    @GetMapping("/selectUserSlave")
    public ResultVO selectUserSlave(Integer uid) {
        SysUser sysUser = this.iSysUserService.selectUserSlave(uid);
        return ResultVO.getSuccess("", sysUser);
    }


    // http://localhost:8000/sysUser/save
    @GetMapping("/save")
    public ResultVO saveSysUser() {
        this.iSysUserService.saveSysUser();
        return ResultVO.getSuccess("");
    }


    // http://localhost:8000/sysUser/saveUserAndQueryGoods
    @GetMapping("/saveUserAndQueryGoods")
    public ResultVO saveUserAndQueryGoods() {
        this.iSysUserService.saveUserAndQueryGoods();
        return ResultVO.getSuccess("");
    }


}
