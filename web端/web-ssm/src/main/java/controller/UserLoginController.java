package controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.SysUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
public class UserLoginController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    @ApiOperation(value = "返回主页面",httpMethod = "GET")
    public String m() {
        return "forward:/index";
    }

    @RequestMapping(value = "/user/login",method = RequestMethod.GET)
    @ApiOperation(value = "返回登录页面",httpMethod = "GET")
    public String login() {
        return "login";

    }



    @RequestMapping(value = "/index")
    @ApiOperation(value = "返回主页面",httpMethod = "GET")
    public ModelAndView main(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        return modelAndView;
    }

    @RequestMapping(value = "/loginSuccess",method = RequestMethod.POST)
    @ApiOperation(value = "登录成功跳转",httpMethod = "POST")
    public ModelAndView loginSuccess(@RequestParam String username, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        session.setAttribute("user", sysUserService.findSysUserByName(username));
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/user/logout",method = RequestMethod.GET)
    @ApiOperation(value = "登出页面",httpMethod = "GET")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/checkLogin",method = RequestMethod.POST)
    @ApiOperation(value = "检查用户登录输入信息",httpMethod = "POST")
    public int checkLogin(@RequestParam String username,@RequestParam String password) {
        if (sysUserService.findSysUserByName(username) != null) {
            if (sysUserService.checkLogin(username, password)) {
                return 0;//ok
            }else return 1;//wrong password;
        }else return 2;//wrong user;

    }

    @ResponseBody
    @ApiOperation(value = "ajax检查用户是否存在",httpMethod = "POST")
    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public boolean checkUser(@RequestParam String userName) {
        if (sysUserService.findSysUserByName(userName) != null) {
            return true;
        }
        return false;
    }

}
