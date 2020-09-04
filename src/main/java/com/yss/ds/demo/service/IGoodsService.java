package com.yss.ds.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yss.ds.demo.entity.Goods;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author qjwyss
 * @since 2020-09-02
 */
public interface IGoodsService extends IService<Goods> {


    Goods selectGoods(int id);

    void saveGoods();

}
