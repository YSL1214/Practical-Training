package controller;

import io.swagger.annotations.ApiOperation;
import model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.SysUserService;
import util.UploadPictureUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(value = "/user/detail/{userId}",method = RequestMethod.GET)
    @ApiOperation(value = "返回个人页面信息",httpMethod = "GET")
    public String userDetail(@PathVariable int userId, Model model) {
        model.addAttribute("sysUser", sysUserService.selectByUserId(userId));
        return "userInfo";
    }

    @ResponseBody
    @ApiOperation(value = "上传图片接口",httpMethod = "POST")
    @RequestMapping(value = "/upload/usericon", method = RequestMethod.POST)
    public Object uploadIcon(HttpServletRequest request, MultipartFile file, @RequestParam String id) throws IOException {
        String path= UploadPictureUtil.addMutiparFile(file,request.getSession().getServletContext().getRealPath("/"));
        Map result=new HashMap();
        result.put("path",path);
        result.put("id", id);
        //保存图片链接到数据库
        sysUserService.updateAddressOfPic(Integer.valueOf(id), path);
        return  result;
    }

    @RequestMapping(value = "/user/info_submit/{userId}",method = RequestMethod.GET)
    @ApiOperation(value = "返回个人页面信息",httpMethod = "GET")
    public String userDetail_edit(@PathVariable int userId, Model model) {
        model.addAttribute("sysUser", sysUserService.selectByUserId(userId));
        return "info_edit";
    }


    @ApiOperation(value = "管理员信息编辑",httpMethod = "POST")
    @RequestMapping(value = "/user/info_edit/{userId}", method = RequestMethod.POST)
    public String infoEdit(HttpServletRequest request,@PathVariable int userId,@RequestParam String username, @RequestParam String password,@RequestParam String realname,@RequestParam String sex,@RequestParam String phone,@RequestParam String mobile,@RequestParam String email,@RequestParam String desc) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        SysUser sysUser = new SysUser();
        sysUser.setId(userId);
        sysUser.setUserName(username);
        sysUser.setPassword(password);
        String Sex = new String(sex.getBytes("ISO-8859-1"),"utf-8");
        sysUser.setSex(Sex);
        String Realname = new String(realname.getBytes("ISO-8859-1"),"utf-8");
        sysUser.setRealName(Realname);
        sysUser.setPhone(phone);
        sysUser.setMobile(mobile);
        sysUser.setEmail(email);
        String Desc = new String(desc.getBytes("ISO-8859-1"),"utf-8");
        sysUser.setDescription(Desc);
        sysUserService.updateSysUserInfo(sysUser);
        return "redirect:/user/detail/{userId}";
    }


}
