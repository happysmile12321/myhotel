package com.hm.controller;

import com.hm.pojo.User;
import com.hm.service.userservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/ma")
public class ManageAction {
	private static final long serialVersionUID = -4304509122548259589L;
	@Autowired
	private IUserService userService;
	//注册
	//跳转到注册页面method,并携带注册Handler的路径到form表单
	@RequestMapping(value = "/jumpToRegister")
	public String jumpToRegister(ModelMap modelMap){
		//添加注册jsp post提交路径
		modelMap.addAttribute("url","/ma/register.action");
		return "zcuser/zcuseradd";
	}
	//注册method
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String register(User user, HttpServletResponse response, ModelMap modelMap, HttpServletRequest request) throws IOException {
		System.out.println(user);
		//设置注册时间
		user.setCreatetime(new Date());
		//用户注册
		Integer userID = userService.register(user);
		if(userID==0){
			//System.out.println("注册失败");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			modelMap.addAttribute("errorMessage","注册失败!!!");
			response.getWriter().print(
					"<script language=javascript>alert('errorMessage');</script>"
			);

			return "zcuser/zcuseradd";
		}else {
			//System.out.println("注册成功");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('操作成功');window.location.href='method!userlist';</script>");

			return "forward:/login.jsp";
		}
	}
//登录
	//登陆method
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(User user, ModelMap modelMap,HttpServletResponse response,HttpServletRequest request) throws IOException {
		//封装pojo对象，传给userservice
		User loginUser = new User();
		loginUser.setUsername(user.getUsername());
		loginUser.setPassword(user.getPassword());
		loginUser.setRole(user.getRole());
		//model层携带数据
		//user作为最初的参数绑定的参数
		user = userService.login(loginUser);
		if(user!=null){
			modelMap.addAttribute("user",user);
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			return "index";
		}else{
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('用户名或者密码错误，或者是用户不存在');</script>");
			return "redirect:/login.jsp";
		}
	}
//登录模块
	//共用method
		//退出method
	@RequestMapping(value = "/loginout")
	public String loginout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/login.jsp";
	}

	//role:普通用户
		//修改密码
	//跳转到修改密码页面
	@RequestMapping(value = "/jumpTochangepwd")
	public String jumpTochangepwd() {
		return "user/password";
	}
	//普通用户修改密码操作
	//*用户登录进去了，代表用户已经知道密码。
	  //这时候用户想修改它。

	@RequestMapping(value = "/changepwd")
	public void changepwd(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
		User u = (User)session.getAttribute("user");
		//得到原密码
		String password1 = request.getParameter("password1");
		//得到新密码
		String password2 = request.getParameter("password2");
		//调用service进行查询
		boolean isExits = userService.selectUserIsExit(u.getUsername(), password1, 0);
		//存在用户，调用修改密码的服务
		if(isExits){
			Integer integer = userService.modifyPasswordByUserName(u.getUsername(), password2);
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('修改成功');</script>");
		}else{
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('原密码错误');</script>");
		}
	}


		//客房预订
		@RequestMapping(value = "/jumpToyuding_User")
		public String jumpToyuding_User() {
			return "yuding/yudinglist";
		}













	

}