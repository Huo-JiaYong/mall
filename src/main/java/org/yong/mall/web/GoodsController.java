
package org.yong.mall.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yong.mall.entity.GoodsInfo;
import org.yong.mall.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listGoods(Model model, Integer offset, Integer limit) {
        offset = offset == null ? 0 : offset;
        limit = limit == null ? 20 : limit;

        List<GoodsInfo> infos = goodsService.listGoods(offset, limit);
        model.addAttribute("infos", infos);
        return "goods_list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getGoodsById(Model model, @PathVariable("id") Long id) {
        GoodsInfo info = goodsService.getGoodsById(id);
        if (info == null) {
            return "404";
        }
        model.addAttribute("info", info);
        return "goods_detail";
    }

}
