package com.yss.ds.demo.controller;


import com.yss.ds.demo.entity.Goods;
import com.yss.ds.demo.service.IGoodsService;
import com.yss.ds.demo.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author qjwyss
 * @since 2020-09-02
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private IGoodsService iGoodsService;

    // http://localhost:8000/goods/selectGoods?gid=1
    @GetMapping("/selectGoods")
    public ResultVO selectGoods(Integer gid) {
        Goods goods = this.iGoodsService.selectGoods(gid);
        return ResultVO.getSuccess(null, goods);
    }


    // http://localhost:8000/goods/save
    @GetMapping("/save")
    public ResultVO saveGoods() {
        this.iGoodsService.saveGoods();
        return ResultVO.getSuccess("");
    }


}
