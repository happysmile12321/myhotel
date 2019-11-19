package com.hm.controller;

import com.hm.pojo.*;
import com.hm.service.fenleiservice.IFenleiService;
import com.hm.service.kaifangservice.IKaiFangService;
import com.hm.service.kefangservice.IKeFangService;
import com.hm.service.tuifangservice.ITuiFangService;
import com.hm.service.userservice.IUserService;
import com.hm.service.yudingservice.IYudingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/ma")
public class ManageAction {
	private static final long serialVersionUID = -4304509122548259589L;
	@Autowired
	private IUserService userService;
	@Autowired
	private IYudingService yudingService;
	@Autowired
	private IFenleiService fenleiService;
	@Autowired
	private IKeFangService keFangService;
	@Autowired
	private IKaiFangService kaiFangService;
	@Autowired
	private ITuiFangService tuiFangService;
	@Autowired
	private HttpServletRequest request;
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




		//普通用户--预订记录查询
		@RequestMapping(value = "/yudinglist_user")
		public String yudingList_User(HttpSession session,ModelMap modelMap){

			User u = (User)session.getAttribute("user");
			List<UserYuding> userYudings = yudingService.yudingChaXun(u.getId());
			modelMap.addAttribute("list",userYudings);
			modelMap.addAttribute("id",u.getId());
			return "yuding/yudinglist";
		}

		@RequestMapping(value = "/jumpToyuding_User",method = RequestMethod.GET)
		//普通用户--预订
		public String jumpToyuding_User(ModelMap modelMap,HttpSession session,int kefangid){
			modelMap.addAttribute("url","/ma/yuding_User.action");
			/*查询预订信息*/
			User u = (User)session.getAttribute("user");
			Yuding yuding = yudingService.yudingChaXunByYuDingKeFangIDAndUserID(kefangid,u.getId());
			modelMap.addAttribute("bean",yuding);
			return "yuding/yudingupdate";
		}

		@RequestMapping(value = "/yuding_User")
		//普通用户--预订
		public String yuding_User(){
			/*处理预订事务*/
			return "";
		}

		@RequestMapping("/jumpToUserList")
		/*管理员功能*/
		//跳转到用户管理
		public String jumpToUserList(ModelMap modelMap){
			List<User> users = userService.selectUsers();
			modelMap.addAttribute("list",users);
			return "/user/userlist";
		}

		@RequestMapping("/jumpToAddUser")
		//跳转到添加新用户
		public String jumpToAddUser(ModelMap modelMap){
			modelMap.addAttribute("url","/ma/addUser.action");
			return "/user/useradd";
		}

		@RequestMapping("/addUser")
		@ResponseBody
		//添加新的用户
		public String AddUser(User user){
			int i = userService.addUser(user);
			if(i>0)
				return "<script language=javascript>alert('add User Success!!!');</script>";
			return "<script language=javascript>alert('add User Failed!!!');</script>";
		}

		@RequestMapping("/jumpToUserUpdate")
		//跳转到修改用户信息
		public String jumpToUserUpdate(ModelMap modelMap,int id){
			modelMap.addAttribute("url","/ma/userUpdate.action");
			modelMap.addAttribute("id",id);
			return "/user/userupdate";
		}

		@RequestMapping("/userUpdate")
		@ResponseBody
		//修改用户信息
		public String userUpdate(User user){
			int i = userService.updateUser(user);
			if(i>0){
				return "<script language=javascript>alert('update User Success!!!');</script>";
			}
			return "<script language=javascript>alert('update User Failed!!!');</script>";
		}

		//删除用户信息
		@RequestMapping("/userDelete")
		@ResponseBody
		//修改用户信息
		public String userDelete(int id){
			int i = userService.deleteUser(id);
			if(i>0){
				return "<script language=javascript>alert('Delete User Success!!!');</script>";
			}
			return "<script language=javascript>alert('Delete User Failed!!!');</script>";
		}
/*用户管理结束*/

		//跳转到客房分类管理
		@RequestMapping("/jumpToKefangFenleiManage")
		public String jumpToKefangFenleiManage(ModelMap modelMap){
			modelMap.addAttribute("url","/ma/KefangFenleiManage.action");
			modelMap.addAttribute("url2","/ma/jumpToRoomTypeAdd.action");
			return "/fenlei/fenleilist";
		}

		@RequestMapping("/ajax_selectRoomType")
		//ajax查询房间类型
		@ResponseBody
		public List<Fenlei> ajax_selectRoomType(){

			List<Fenlei> roomLists = fenleiService.selectRoomType();

			return roomLists;
		}
		@RequestMapping("/KefangFenleiManage")
		@ResponseBody
		//客房分类管理--ajax形式异步请求
		public Fenlei ajax_KefangFenleiManage(int id){
			//将分类id接受过来
			System.out.println("id:"+id);
			//根据id查询分类表中的房间类型，房价
			Fenlei fenlei = fenleiService.selectRoomTypeByID(id);
			return fenlei;
		}
		//类型删除
		@RequestMapping("/deleteRoomType")
		@ResponseBody
		public String deleteRoomType(int id){
			System.out.println(id);
			int row = fenleiService.deleteRoomTypeByID(id);
			if(row > 0){
				return "<script language=javascript>alert('Delete RoomType Success!!!');</script>";
			}
			return "<script language=javascript>alert('Delete RoomType Failed!!!');</script>";
		}
		@RequestMapping("/jumpToUpdateRoomType")
		//跳转到客房分类类型更新页面
		public String jumpToUpdateRoomType(int id,ModelMap modelMap){
			modelMap.addAttribute("url","/ma/updateRoomType.action");

			//修改的id号
			modelMap.addAttribute("id",id);
			return "/fenlei/fenleiupdate";
		}

		@RequestMapping("/updateRoomType")
		@ResponseBody
		//客房分类类型更新页面
		public String updateRoomType(String leixing,int jiage,int id){

		/*	System.out.println("进来了,id是：" + request.getParameter("id"));
			System.out.println("进来了,价格是："+jiage);
			System.out.println("进来了，类型id是:"+leixing);*/
			int row =fenleiService.updateFenleiInfoByFenleiID(leixing,jiage,id);
			if(row>0){
				return "<script language=javascript>alert('Update RoomType Success!!!');</script>";
			}
			return "<script language=javascript>alert('Update RoomType Failed!!!');</script>";
		}
		@RequestMapping("/jumpToRoomTypeAdd")
		//客房分类添加
		public String jumpToRoomTypeAdd(ModelMap modelMap){
			modelMap.addAttribute("url","/ma/roomTypeAdd.action");
			return "/fenlei/fenleiadd";
		}

		@RequestMapping("/roomTypeAdd")
		@ResponseBody
		public String RoomTypeAdd(String leixing,double jiage){
			int row = fenleiService.addRoomType(leixing,jiage,null);
			if(row>0){
				return "<script language=javascript>alert('Insert RoomType Success!!!');</script>";
			}
			return "<script language=javascript>alert('Insert RoomType Failed!!!');</script>";
		}


		//跳转到客房信息管理
		@RequestMapping("/jumpToKefangXinxiManage")
		public String jumpToKefangXinxiManage(ModelMap modelMap){
			modelMap.addAttribute("url","/ma/kefangXinxiManage.action");
			return "/kefang/kefanglist";
		}

		@RequestMapping("/ajax_kefangfeilei")
		@ResponseBody
		//ajax请求的方法，查询数据到两个select
		public List<KefangFeilei> ajax_kefangfeilei(ModelMap modelMap){
			KefangFeilei kefangFeilei = new KefangFeilei();
			Kefang kefang = new Kefang();
			kefang.setFangjianhao(null);
			Fenlei fenlei = new Fenlei();
			fenlei.setLeixing(null);
			kefangFeilei.setKefang(kefang);
			kefangFeilei.setFenlei(fenlei);
			List <KefangFeilei>kefangFeileiList = keFangService.selectKeFang(kefangFeilei);
			return kefangFeileiList;
		}




	//ajax请求的方法，查询的数据返回的是List<KefangFeileing>
		@RequestMapping(value = "/ajax2_kefangfeilei",method = RequestMethod.POST)
		@ResponseBody
		public  List<KefangFeilei> ajax2_kefangfeilei(String kefang_fangjianhao, String fenlei_leixing, ModelMap modelMap) {
			//System.out.println("房间编号：" + kefang_fangjianhao);
			//System.out.println("类型：" + fenlei_leixing);
			KefangFeilei kefangFeilei = new KefangFeilei();
			Kefang kefang = new Kefang();
			kefang.setFangjianhao(kefang_fangjianhao);
			Fenlei fenlei = new Fenlei();
			fenlei.setLeixing(fenlei_leixing);
			if(kefang_fangjianhao.equals("0")){
				kefang_fangjianhao = null;
				kefang.setFangjianhao(kefang_fangjianhao);
			}
			if(fenlei_leixing.equals("0")){
				fenlei_leixing = null;
				fenlei.setLeixing(fenlei_leixing);
			}
			kefangFeilei.setKefang(kefang);
			kefangFeilei.setFenlei(fenlei);
			List<KefangFeilei> kefangFeileiList = keFangService.selectKeFang(kefangFeilei);
			return kefangFeileiList;
		}





		//跳转到开房管理页面
		@RequestMapping("/jumpToKaifangMangage")
		public String jumpToKaifangMangage(ModelMap modelMap){
			List<KefangKaifangFenlei> kefangKaifangFenleis = kaiFangService.selectKaiFang();
			modelMap.addAttribute("list",kefangKaifangFenleis);
			System.out.println(kefangKaifangFenleis);
			return "/kaifang/kaifanglist";
		}

		//跳转到退房管理
		@RequestMapping("/jumpToTuifangManage")
		public String jumpToTuifangManage(ModelMap modelMap){
			List<KefangKaifangFenlei> kefangKaifangFenleis = tuiFangService.selectTuiFang();
			modelMap.addAttribute("list",kefangKaifangFenleis);
			return "/tuifang/tuifanglist";
		}

		//跳转到开房记录查询
		@RequestMapping("/jumpToKaifangjiluChaxun")
		public String jumpToKaifangjiluChaxun(ModelMap modelMap){
			List<UserYudingKefangFenleiKaifang> userYudings = yudingService.yudingChaXunAll();
			modelMap.addAttribute("list",userYudings);
			return "/kfjilu/kfjilulist";
		}

		//跳转到预订记录查询
		@RequestMapping("/jumpToYudingjiluChaxun")
		public String jumpToYudingjuluChaxun(ModelMap modelMap){
			List<YudingKefangFenlei> yudingKefangFenleis = yudingService.yudingChaXunAll_real();
			modelMap.addAttribute("list",yudingKefangFenleis);
			return "/ydjilu/ydjilulist";
		}
}