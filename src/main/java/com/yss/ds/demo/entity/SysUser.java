package com.yss.ds.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author qjwyss
 * @since 2020-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账号
     */
    private String username;

    /**
     * MD5加密的密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像路径
     */
    @TableField("head_img_url")
    private String headImgUrl;

    /**
     * 状态：0-删除，1-启用，2-禁用
     */
    private Integer state;

    /**
     * 注册来源：1-系统注册，2-用户注册，3-QQ，4-WX
     */
    @TableField("register_source")
    private Integer registerSource;

    /**
     * 创建信息
     */
    @TableField("create_info")
    private String createInfo;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改信息
     */
    @TableField("update_info")
    private String updateInfo;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;


}
