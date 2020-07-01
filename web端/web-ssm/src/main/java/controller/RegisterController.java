package controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.SysUserService;

@Controller
public class RegisterController {

    @Autowired
    private SysUserService sysUserService;
    @ApiOperation(value = "返回注册页面",httpMethod = "GET")
    @RequestMapping(value = "/user/register",method = RequestMethod.GET)
    public String reg() {
        return "register";
    }

    @ApiOperation(value = "注册跳转",httpMethod = "POST")
    @RequestMapping(value = "/registerPro", method = RequestMethod.POST)
    public String register(@RequestParam String username, @RequestParam String password,@RequestParam String email) {
        sysUserService.register(username,password,email);
        return "redirect:/user/login";
    }


}
