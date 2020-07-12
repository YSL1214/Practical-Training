package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import model.*;
import model.AgeChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import service.EmployeeService;
import service.OldService;
import service.VolunteerService;
import service.EventService;
import util.UploadPictureUtil;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
public class PersonController {
    @Autowired
    private OldService oldService;
    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/success",method = RequestMethod.GET)
    @ApiOperation(value = "操作成功",httpMethod = "GET")
    public String m() {
        return "forward:/success";
    }

    @RequestMapping(value = "/old")
    @ApiOperation(value = "老人信息界面",httpMethod = "GET")
    public String OldList() {
        return "oldlist";
    }


    @RequestMapping(value = "/addold")
    @ApiOperation(value = "增加老人页面",httpMethod = "GET")
    public String addold() {
        return "addold";
    }

    @ApiOperation(value = "增加老人",httpMethod = "POST")
    @RequestMapping(value = "/old/add", method = RequestMethod.POST)
    public String infoEdit(@RequestParam String username,@RequestParam String sex,@RequestParam String age,@RequestParam String phone,@RequestParam String health_state,@RequestParam String desc) throws UnsupportedEncodingException {
        Old old = new Old();
        String Username = new String(username.getBytes("ISO-8859-1"),"utf-8");
        old.setUserName(Username);
        String Sex = new String(sex.getBytes("ISO-8859-1"),"utf-8");
        old.setGender(Sex);
        old.setAge(Integer.valueOf(age));
        old.setPhone(phone);
        String Health_state = new String(health_state.getBytes("ISO-8859-1"),"utf-8");
        old.setHealth_state(Health_state);
        String Desc = new String(desc.getBytes("ISO-8859-1"),"utf-8");
        old.setDESCRIPTION(Desc);
        oldService.addOldperson(old);
        return "redirect:/old";
    }

    @RequestMapping(value = "/deleteoldperson/{id}")
    @ApiOperation(value = "删除老人详细信息",httpMethod = "GET")
    public String deleteold(@PathVariable int id) {
        oldService.deleteSelectIdOld(id);
        return "success";
    }

    @RequestMapping(value = "/editold/{id}")
    @ApiOperation(value = "编辑老人详细信息页面",httpMethod = "GET")
    public String old_editpage(@PathVariable int id, Model model) {
        model.addAttribute("old", oldService.getSelectOldInfo(id));
        return "old_edit";
    }

    @RequestMapping(value = "/old/edit/{id}")
    @ApiOperation(value = "编辑老人详细信息",httpMethod = "POST")
    public String old_edit(@PathVariable int id,@RequestParam String username,@RequestParam String sex,@RequestParam String age,@RequestParam String phone,@RequestParam String health_state,@RequestParam String desc) throws UnsupportedEncodingException {
        Old old = new Old();
        old.setId(id);
        String Username = new String(username.getBytes("ISO-8859-1"),"utf-8");
        old.setUserName(Username);
        String Sex = new String(sex.getBytes("ISO-8859-1"),"utf-8");
        old.setGender(Sex);
        old.setAge(Integer.valueOf(age));
        old.setPhone(phone);
        String Health_state = new String(health_state.getBytes("ISO-8859-1"),"utf-8");
        old.setHealth_state(Health_state);
        String Desc = new String(desc.getBytes("ISO-8859-1"),"utf-8");
        old.setDESCRIPTION(Desc);
        oldService.updateOldperson(old);
        return "success";
    }

    @RequestMapping(value = "/oldperson/{id}")
    @ApiOperation(value = "查看老人详细信息",httpMethod = "GET")
    public String old_info(@PathVariable int id, Model model) {
        model.addAttribute("old", oldService.getSelectOldInfo(id));
        return "oldinfo";
    }

    @ResponseBody
    @ApiOperation(value = "上传图片接口",httpMethod = "POST")
    @RequestMapping(value = "/upload/oldicon", method = RequestMethod.POST)
    public Object uploadIcon(HttpServletRequest request, MultipartFile file, @RequestParam String id) throws IOException {
        String path= UploadPictureUtil.addMutiparFile(file,request.getSession().getServletContext().getRealPath("/"));
        Map result=new HashMap();
        result.put("path",path);
        result.put("id", id);
        //保存图片链接到数据库
        oldService.updateAddressOfPic(Integer.valueOf(id), path);
        return  result;
    }


    @RequestMapping(value = "/oldlistjson/",method = RequestMethod.GET)
    @ApiOperation(value = "老人列表接口",httpMethod = "GET")
    public @ResponseBody Map<String,Object> getList(@RequestParam(required = false, defaultValue = "1") Integer page,@RequestParam(required = false, defaultValue = "10") Integer limit){
        PageHelper.startPage(page, limit);
        List<Old> list=oldService.getOldInfo();
        System.out.println(list.size());
        PageInfo<Old> p = new PageInfo<>(list);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",p.getTotal());
        resultMap.put("data",p.getList());
        return resultMap;
    }

    @RequestMapping(value = "/oldchart")
    @ApiOperation(value = "查看老人统计分析",httpMethod = "GET")
    public String oldchart() {
        return "oldEChart";
    }


    @ResponseBody
    @RequestMapping(value = "/oldechart")
    @ApiOperation(value = "老人年龄图表")
    public  List<AgeChart> getdata(){
        List<Old> oldlist = oldService.getOldInfo();
        List<AgeChart> list = new ArrayList<AgeChart>();
        int a,b,c,d;
        a=0;b=0;c=0;d=0;

        for (Old old : oldlist) {
            if(old.getAge()>80){
                d=d+1;
            }else if(70<=old.getAge()&&old.getAge()<=80){
                c=c+1;
            }else if(60<=old.getAge()&&old.getAge()<70){
                b=b+1;
            }else {
                a=a+1;
            }
        }

        AgeChart ageChart1 =new AgeChart();
        ageChart1.setDivage("60岁以下");
        ageChart1.setNum(a);

        AgeChart ageChart2 =new AgeChart();
        ageChart2.setDivage("60岁-70岁");
        ageChart2.setNum(b);

        AgeChart ageChart3 =new AgeChart();
        ageChart3.setDivage("70岁-80岁");
        ageChart3.setNum(c);

        AgeChart ageChart4 =new AgeChart();
        ageChart4.setDivage("80岁以上");
        ageChart4.setNum(d);

        list.add(ageChart1);
        list.add(ageChart2);
        list.add(ageChart3);
        list.add(ageChart4);

        return list;
    }


    @RequestMapping(value = "/volunteer")
    @ApiOperation(value = "志愿者信息界面",httpMethod = "GET")
    public String VolunteerList() {
        return "volunteerlist";
    }

    @RequestMapping(value = "/addvolunteer")
    @ApiOperation(value = "增加志愿者页面",httpMethod = "GET")
    public String addvolunteer() {
        return "addvolunteer";
    }

    @ApiOperation(value = "增加志愿者",httpMethod = "POST")
    @RequestMapping(value = "/volunteer/add", method = RequestMethod.POST)
    public String volunteerinfoEdit(@RequestParam String username,@RequestParam String sex,@RequestParam String age,@RequestParam String phone,@RequestParam String desc) throws UnsupportedEncodingException {
        Volunteer volunteer = new Volunteer();
        String Username = new String(username.getBytes("ISO-8859-1"),"utf-8");
        volunteer.setUserName(Username);
        String Sex = new String(sex.getBytes("ISO-8859-1"),"utf-8");
        volunteer.setGender(Sex);
        volunteer.setAge(Integer.valueOf(age));
        volunteer.setPhone(phone);

        String Desc = new String(desc.getBytes("ISO-8859-1"),"utf-8");
        volunteer.setDESCRIPTION(Desc);
        volunteerService.addVolunteer(volunteer);
        return "redirect:/volunteer";
    }
    @RequestMapping(value = "/deletevolunteer/{id}")
    @ApiOperation(value = "删除志愿者详细信息",httpMethod = "GET")
    public String deletevolunteer(@PathVariable int id) {
        volunteerService.deleteSelectIdVolunteer(id);
        return "success";
    }

    @RequestMapping(value = "/editvolunteer/{id}")
    @ApiOperation(value = "编辑志愿者详细信息页面",httpMethod = "GET")
    public String volunteer_editpage(@PathVariable int id, Model model) {
        model.addAttribute("volunteer", volunteerService.getSelectVolunteerInfo(id));
        return "volunteer_edit";
    }

    @RequestMapping(value = "/volunteer/edit/{id}")
    @ApiOperation(value = "编辑志愿者详细信息",httpMethod = "POST")
    public String volunteer_edit(@PathVariable int id,@RequestParam String username,@RequestParam String sex,@RequestParam String age,@RequestParam String phone,@RequestParam String desc) throws UnsupportedEncodingException {
        Volunteer volunteer = new Volunteer();
        volunteer.setId(id);
        String Username = new String(username.getBytes("ISO-8859-1"),"utf-8");
        volunteer.setUserName(Username);
        String Sex = new String(sex.getBytes("ISO-8859-1"),"utf-8");
        volunteer.setGender(Sex);
        volunteer.setAge(Integer.valueOf(age));
        volunteer.setPhone(phone);
        String Desc = new String(desc.getBytes("ISO-8859-1"),"utf-8");
        volunteer.setDESCRIPTION(Desc);
        volunteerService.updateVolunteer(volunteer);
        return "success";
    }

    @RequestMapping(value = "/volunteer/{id}")
    @ApiOperation(value = "查看志愿者详细信息",httpMethod = "GET")
    public String volunteer_info(@PathVariable int id, Model model) {
        model.addAttribute("volunteer", volunteerService.getSelectVolunteerInfo(id));
        return "volunteerinfo";
    }

    @ResponseBody
    @ApiOperation(value = "上传图片接口",httpMethod = "POST")
    @RequestMapping(value = "/upload/volunteericon", method = RequestMethod.POST)
    public Object uploadvolunteerIcon(HttpServletRequest request, MultipartFile file, @RequestParam String id) throws IOException {
        String path= UploadPictureUtil.addMutiparFile(file,request.getSession().getServletContext().getRealPath("/"));
        Map result=new HashMap();
        result.put("path",path);
        result.put("id", id);
        //保存图片链接到数据库
        volunteerService.updateAddressOfPic(Integer.valueOf(id), path);
        return  result;
    }

    @RequestMapping(value = "/volunteerlistjson/",method = RequestMethod.GET)
    @ApiOperation(value = "志愿者列表接口",httpMethod = "GET")
    public @ResponseBody Map<String,Object> getVolunteerList(@RequestParam(required = false, defaultValue = "1") Integer page,@RequestParam(required = false, defaultValue = "10") Integer limit){
        List<Volunteer> volunteer = volunteerService.getVolunteerInfo();
        PageHelper.startPage(page, limit);
        List<Volunteer> list=volunteerService.getVolunteerInfo();
        PageInfo<Volunteer> p = new PageInfo<Volunteer>(list);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",p.getTotal());
        resultMap.put("data",p.getList());
        return resultMap;
    }


    @RequestMapping(value = "/volunteerchart")
    @ApiOperation(value = "查看老人统计分析",httpMethod = "GET")
    public String volunteerchart() {
        return "volunteerEChart";
    }




    @ResponseBody
    @RequestMapping(value = "/volunteerechart")
    @ApiOperation(value = "老人年龄图表")
    public  List<AgeChart> getvolunteerage(){
        List<Volunteer> volunteerlist = volunteerService.getVolunteerInfo();
        List<AgeChart> list = new ArrayList<AgeChart>();
        int a,b,c,d;
        a=0;b=0;c=0;d=0;

        for (Volunteer volunteer : volunteerlist) {
            if(volunteer.getAge()>40){
                d=d+1;
            }else if(30<=volunteer.getAge()&&volunteer.getAge()<=40){
                c=c+1;
            }else if(20<=volunteer.getAge()&&volunteer.getAge()<30){
                b=b+1;
            }else {
                a=a+1;
            }
        }

        AgeChart ageChart1 =new AgeChart();
        ageChart1.setDivage("20岁以下");
        ageChart1.setNum(a);

        AgeChart ageChart2 =new AgeChart();
        ageChart2.setDivage("20岁-30岁");
        ageChart2.setNum(b);

        AgeChart ageChart3 =new AgeChart();
        ageChart3.setDivage("30岁-40岁");
        ageChart3.setNum(c);

        AgeChart ageChart4 =new AgeChart();
        ageChart4.setDivage("40岁以上");
        ageChart4.setNum(d);

        list.add(ageChart1);
        list.add(ageChart2);
        list.add(ageChart3);
        list.add(ageChart4);

        return list;
    }


    @RequestMapping(value = "/employee")
    @ApiOperation(value = "员工信息界面",httpMethod = "GET")
    public String EmployeeList() {
        return "employeelist";
    }



    @RequestMapping(value = "/addemployee")
    @ApiOperation(value = "增加员工页面",httpMethod = "GET")
    public String addemployee() {
        return "addemployee";
    }

    @ApiOperation(value = "增加员工",httpMethod = "POST")
    @RequestMapping(value = "/employee/add", method = RequestMethod.POST)
    public String EmployeeinfoEdit(@RequestParam String username,@RequestParam String sex,@RequestParam String age,@RequestParam String phone,@RequestParam String desc) throws UnsupportedEncodingException {
        Employee employee = new Employee();
        String Username = new String(username.getBytes("ISO-8859-1"),"utf-8");
        employee.setUserName(Username);
        String Sex = new String(sex.getBytes("ISO-8859-1"),"utf-8");
        employee.setGender(Sex);
        employee.setAge(Integer.valueOf(age));
        employee.setPhone(phone);
        String Desc = new String(desc.getBytes("ISO-8859-1"),"utf-8");
        employee.setDESCRIPTION(Desc);
        employeeService.addEmployee(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/deleteemployee/{id}")
    @ApiOperation(value = "删除员工详细信息",httpMethod = "GET")
    public String deleteemployee(@PathVariable int id) {
        employeeService.deleteSelectIdEmployee(id);
        return "success";
    }

    @RequestMapping(value = "/editemployee/{id}")
    @ApiOperation(value = "编辑员工详细信息页面",httpMethod = "GET")
    public String employee_editpage(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.getSelectEmployeeInfo(id));
        return "employee_edit";
    }

    @RequestMapping(value = "/employee/edit/{id}")
    @ApiOperation(value = "编辑员工详细信息",httpMethod = "POST")
    public String old_edit(@PathVariable int id,@RequestParam String username,@RequestParam String sex,@RequestParam String age,@RequestParam String phone,@RequestParam String desc) throws UnsupportedEncodingException {
        Employee employee = new Employee();
        employee.setId(id);
        String Username = new String(username.getBytes("ISO-8859-1"),"utf-8");
        employee.setUserName(Username);
        String Sex = new String(sex.getBytes("ISO-8859-1"),"utf-8");
        employee.setGender(Sex);
        employee.setAge(Integer.valueOf(age));
        employee.setPhone(phone);
        String Desc = new String(desc.getBytes("ISO-8859-1"),"utf-8");
        employee.setDESCRIPTION(Desc);
        employeeService.updateEmployee(employee);
        return "success";
    }

    @RequestMapping(value = "/employee/{id}")
    @ApiOperation(value = "查看员工详细信息",httpMethod = "GET")
    public String employee_info(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.getSelectEmployeeInfo(id));
        return "employeeinfo";
    }

    @ResponseBody
    @ApiOperation(value = "上传图片接口",httpMethod = "POST")
    @RequestMapping(value = "/upload/employeeicon", method = RequestMethod.POST)
    public Object uploademployeeIcon(HttpServletRequest request, MultipartFile file, @RequestParam String id) throws IOException {
        String path= UploadPictureUtil.addMutiparFile(file,request.getSession().getServletContext().getRealPath("/"));
        Map result=new HashMap();
        result.put("path",path);
        result.put("id", id);
        //保存图片链接到数据库
        employeeService.updateAddressOfPic(Integer.valueOf(id), path);
        return  result;
    }

    @RequestMapping(value = "/employeelistjson/",method = RequestMethod.GET)
    @ApiOperation(value = "员工列表接口",httpMethod = "GET")
    public @ResponseBody Map<String,Object> getEmployeeList(@RequestParam(required = false, defaultValue = "1") Integer page,@RequestParam(required = false, defaultValue = "10") Integer limit){
        List<Employee> employee = employeeService.getEmployeeInfo();
        PageHelper.startPage(page, limit);
        List<Employee> list=employeeService.getEmployeeInfo();
        PageInfo<Employee> p = new PageInfo<>(list);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",p.getTotal());
        resultMap.put("data",p.getList());
        return resultMap;
    }
    @RequestMapping(value = "/employeechart")
    @ApiOperation(value = "查看员工统计分析",httpMethod = "GET")
    public String employeechart() {
        return "employeeEChart";
    }

    @ResponseBody
    @RequestMapping(value = "/employeeechart")
    @ApiOperation(value = "员工年龄图表")
    public  List<AgeChart> getemployeeage(){
        List<Employee> employeelist = employeeService.getEmployeeInfo();
        List<AgeChart> list = new ArrayList<AgeChart>();
        int a,b,c,d;
        a=0;b=0;c=0;d=0;

        for (Employee employee : employeelist) {
            if(employee.getAge()>40){
                d=d+1;
            }else if(30<=employee.getAge()&&employee.getAge()<=40){
                c=c+1;
            }else if(20<=employee.getAge()&&employee.getAge()<30){
                b=b+1;
            }else {
                a=a+1;
            }
        }

        AgeChart ageChart1 =new AgeChart();
        ageChart1.setDivage("20岁以下");
        ageChart1.setNum(a);

        AgeChart ageChart2 =new AgeChart();
        ageChart2.setDivage("20岁-30岁");
        ageChart2.setNum(b);

        AgeChart ageChart3 =new AgeChart();
        ageChart3.setDivage("30岁-40岁");
        ageChart3.setNum(c);

        AgeChart ageChart4 =new AgeChart();
        ageChart4.setDivage("40岁以上");
        ageChart4.setNum(d);

        list.add(ageChart1);
        list.add(ageChart2);
        list.add(ageChart3);
        list.add(ageChart4);

        return list;
    }


    @RequestMapping(value = "/eventlistjson/",method = RequestMethod.GET)
    @ApiOperation(value = "事件列表接口",httpMethod = "post")
    public @ResponseBody Map<String,Object> getEventList(@RequestParam(required = false, defaultValue = "1") Integer page,@RequestParam(required = false, defaultValue = "10") Integer limit){

        List<Event>  event= eventService.getEventInfo();
        PageHelper.startPage(page, limit);
        List<Event> list=eventService.getEventInfo();
        PageInfo<Event> p = new PageInfo<Event>(list);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",p.getTotal());
        resultMap.put("data",p.getList());
        return resultMap;
    }

    @RequestMapping(value = "/event")
    @ApiOperation(value = "事件界面",httpMethod = "GET")
    public String eventList() {
        return "event";
    }

    @RequestMapping(value = "/event1")
    @ApiOperation(value = "事件界面",httpMethod = "GET")
    public String eventList1() {
        return "eventchart1";
    }
    @RequestMapping(value = "/deleteevent/{id}")
    @ApiOperation(value = "删除详细信息",httpMethod = "GET")
    public String deleteevent(@PathVariable int id) {
        eventService.deleteSelectIdEvent(id);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/eventechart")
    @ApiOperation(value = "图表")
    public  List<Event> getevent1(){
        List<Event> event1 = eventService.getEventInfo();
        return event1;
    }

    @RequestMapping(value = "/camera1")
    @ApiOperation(value = "摄像头界面",httpMethod = "GET")
    public String camera1() {
        return "camera1";
    }




}
