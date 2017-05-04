package org.yong.mall.web.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yong.mall.cache.RedisCache;
import org.yong.mall.dto.BaseResult;
import org.yong.mall.entity.AdminUserInfo;
import org.yong.mall.entity.SystemModule;
import org.yong.mall.service.AdminUserService;
import org.yong.mall.service.SystemModuleService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    RedisCache redis;

    @Autowired
    AdminUserService adminUserService;

    @Autowired
    SystemModuleService moduleService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goLogin() {
        return "/admin/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = { "application/json;charset=utf8" })
    @ResponseBody
    public BaseResult<String> userLogin(@RequestParam("phone") long phone, @RequestParam("password") String password,
            HttpSession session) {
        AdminUserInfo info = adminUserService.login(phone, password);
        if (info == null) {
            return new BaseResult<>(false, "账号不存在或用户密码不匹配");
        }
        session.setAttribute("adminUser", info);
        return new BaseResult<>(true, "登录成功");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String userLogout(HttpSession session) {
        AdminUserInfo info = (AdminUserInfo) session.getAttribute("adminUser");
        redis.deleteCacheWithPattern(RedisCache.CACHENAME + "|" + info.getPhone() + "|*");
        session.removeAttribute("adminUser");
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String goAdmin(HttpSession session, Model model) {
        AdminUserInfo adminUser = (AdminUserInfo) session.getAttribute("adminUser");
        if (adminUser == null) {
            return "redirect:/admin/login";
        }

        // 获取用户已被授权的模块
        List<SystemModule> modules = moduleService.listModuleWithUser(adminUser);
        model.addAttribute("modules", modules);
        return "/admin/index";
    }
}
