package org.yong.mall.web.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yong.mall.dto.BaseResult;
import org.yong.mall.entity.AdminUserInfo;
import org.yong.mall.entity.GoodsInfo;
import org.yong.mall.service.AuthorityService;
import org.yong.mall.service.GoodsService;

@Controller
@RequestMapping("/admin")
public class AdminGoodsController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    AuthorityService authorityService;

    @RequestMapping(value = "/goods/list", method = RequestMethod.GET)
    public String listGoods(Model model, Integer offset, Integer limit) {
        offset = offset == null ? 0 : offset;
        limit = limit == null ? 20 : limit;

        List<GoodsInfo> infos = goodsService.listGoods(offset, limit);
        model.addAttribute("infos", infos);
        return "/admin/goods_list";
    }

    @RequestMapping(value = "/goods/{id}", method = RequestMethod.GET)
    public String addGoods(@PathVariable("id") Long id, Model model) {
        GoodsInfo info = goodsService.getGoodsById(id);
        model.addAttribute("info", info);
        return "/admin/goods_info";
    }

    @RequestMapping(value = "/goods/{id}", method = RequestMethod.PUT, produces = { "application/json;charset=utf8" })
    @ResponseBody
    public BaseResult<String> updateGoods(HttpSession session, @PathVariable("id") Long id, GoodsInfo info,
            Model model) {
        // TODO 权限检查
        AdminUserInfo userInfo = (AdminUserInfo) session.getAttribute("adminUser");
        if (!authorityService.checkUserAuthority(userInfo, "修改商品")) {
            return new BaseResult<>(false, "无权执行此操作，请联系管理员");
        }
        info.setId(id);
        boolean result = goodsService.updateGoods(info);
        if (result) {
            return new BaseResult<>(true, "");
        }
        return new BaseResult<>(false, "参数错误或系统故障");
    }

    @RequestMapping(value = "/goods/{id}", method = RequestMethod.DELETE, produces = {
            "application/json;charset=utf-8" })
    @ResponseBody
    public BaseResult<String> deleteGoods(HttpSession session, @PathVariable("id") Long id) {
        // TODO 权限检查
        AdminUserInfo userInfo = (AdminUserInfo) session.getAttribute("adminUser");
        if (!authorityService.checkUserAuthority(userInfo, "删除商品")) {
            return new BaseResult<>(false, "无权执行此操作，请联系管理员");
        }
        boolean success = goodsService.removeGoods(id);
        if (success) {
            return new BaseResult<>(true, "删除成功");
        }
        return new BaseResult<>(false, "删除失败");
    }

    @RequestMapping(value = "/goods", method = RequestMethod.GET)
    public String goSaveGoods() {
        return "/admin/goods_info";
    }

    @RequestMapping(value = "/goods", method = RequestMethod.POST, produces = { "application/json;charset=utf8" })
    @ResponseBody
    public BaseResult<String> saveGoods(HttpSession session, GoodsInfo info) {
        // TODO 权限检查
        AdminUserInfo userInfo = (AdminUserInfo) session.getAttribute("adminUser");
        if (!authorityService.checkUserAuthority(userInfo, "新增商品")) {
            return new BaseResult<>(false, "无权执行此操作，请联系管理员");
        }
        boolean result = goodsService.saveGoods(info);
        if (result) {
            return new BaseResult<>(true, "");
        }
        return new BaseResult<>(false, "新增失败 囧..");
    }
}
