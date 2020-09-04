package com.yss.ds.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yss.ds.demo.entity.Goods;
import com.yss.ds.demo.mapper.GoodsMapper;
import com.yss.ds.demo.service.IGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author qjwyss
 * @since 2020-09-02
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @DS("goods")
    @Override
    public Goods selectGoods(int id) {
        return this.getById(id);
    }


    /**
     * 商品库数据源也支持事务
     */
    @DS("goods")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveGoods() {
        Goods goods = new Goods().setGoodsName("商品名称A").setStatus(1).setCreateTime(new Date());
        this.save(goods);
        System.out.println(1/0);
        this.save(goods);
    }



}
