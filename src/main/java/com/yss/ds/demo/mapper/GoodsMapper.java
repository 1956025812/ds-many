package com.yss.ds.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yss.ds.demo.entity.Goods;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author qjwyss
 * @since 2020-09-02
 */
@DS("goods")
public interface GoodsMapper extends BaseMapper<Goods> {

}
