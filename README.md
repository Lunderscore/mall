# 重构中

**实现技术**
* 前端技术: HTML，CSS， JavaScript， jQuery， Bootstrap框架
* 编程语言: Java
* 后端技术: JSP， Spring， SpringMVC， Mybatis
* 数据库： MySQL
* 项目构建管理：Maven
* 其他技术：Ajax
* IED: eclipse

## 项目基本结构
![](http://www.yqplayer.com/netpicyd/f116ff28d7bf2aff5b227e5e8b3b9a5f.png)

本项目使用MVC设计模式
* com.ou.mall.bean
    > 负责管理类模型，与数据库进行数据交换
* com.ou.mall.controller
    > 负责页面的数据获取与服务的调用
* com.ou.mall.dao
    > 负责管理Mybatis mapper 文件的接口
* com.ou.mall.service
    > 负责调用 dao接口
* com.ou.mall.util
    > 常用类封装
* **resource文件夹**
	> 存放配置文件
* bootstrap文件夹
	> bootstrap框架文件
* **include文件夹**
	> 存放页面中代码的table, modal的长代码,便于查看与管理
* js文件夹
	> 存放js 文件,便于查看
* statis文件夹
	> 存放导航栏, 分页条等 固定页面

**一般流程**
1. 用户进入主页
2. 用户查看商品详情
3. 系统提醒用户没有登录
3. 用户登录账号(或注册账号)
4. 用户添加对应商品进入购物车
5. 用户确认订单,填写收货地址
6. 用户支付
7. 用户查看订单详情(根据订单状态执行对应操作)

**后端流程(以登录为例)**
1. 前端检查用户名与密码是否不为空以及是否符合正则表达式

		function checkLogin(){
			var username = $("#username").val().trim();
			var password1 = $("#password1").val().trim();
			if (username == "" || password1 == ""){
				alert("用户名和密码不能为空");
				return false;
			}
			if ( /^[a-zA-Z][a-zA-Z0-9_]{4,15}$/.test(username) == false){
				alert("账号格式：字母开头，允许5-16字节，允许字母数字下划线");
				return;
			}else if (/^[a-zA-Z]\w{5,17}$/.test(password1) == false){
				alert("密码格式：字母开头，长度在6~18之间，只能包含字母、数字和下划线")
				return;
			}
			return true;
		}
2. 后端User类使用 hibernate-validator 进行后端验证

	    @NotNull
		@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$")
		private String userUsername;

		@NotNull
		@Pattern(regexp="^[a-zA-Z]\\w{5,17}$")
		private String userPassword;

3. 在得到数据合法后进入控制器,用户账号密码正确则session添加用户标识符

		@ResponseBody
		@RequestMapping(value="loglogin")
		public Msg login(@Valid User user, BindingResult result){
			if (result.hasErrors()){
				return Msg.failure().add("msg", "账号或密码错误");
			}
			user = userService.getUserByUsername(user.getUserUsername());
			session.setAttribute("userSession", user);
			if (user == null){
				return Msg.failure().add("msg", "账号或密码错误");
			}
			return Msg.success();
		}

3. 在得到用户正确后返回自定义成功标识(用户账号密码错误则返回失败标识)

		public class Msg {
			/*
			* code = 0 成功
			* code = 1 失败
			* 
			*/
			private int code;
			private String message;
			
			// 数据
			private Map<String, Object> content = new HashMap<String, Object>();
			
			public Msg add(String key, Object value){
				this.getContent().put(key, value);
				return this;
			}
			public static Msg success(){
				Msg msg = new Msg();
				msg.setCode(0);
				msg.setMessage("操作成功");
				return msg;
			}
			public static Msg failure(){
				Msg msg = new Msg();
				msg.setCode(1);
				msg.setMessage("操作失败");
				return msg;
			}
			/.....get set 方法....../
		}

4. 浏览器根据返回信息决定是跳转指主界面还是提示错误信息

		$.post("loglogin", {userUsername:username, userPassword:password1 }, function(data){
			if (data.code == 0){
				location.href = "index.jsp";
			}else{
				alert(data.content.msg);
			}
		});

5. 处理完成

# 主界面展示

**主界面商品分为三行五列，超过十五个商品将进行分页处理**

![](http://www.yqplayer.com/netpicyd/3d59a8415d8de80d5ef1dd21b0075a76.png)


## 主界面前台核心代码

	<c:if test="${not empty pages }">
		<c:forEach items="${pages.list }" var="product" varStatus="i">
			<c:if test="${i.index%5 == 0 }">
				<div class="row col-md-offset-1">
			</c:if>
			<div class="col-md-2">
				<a href="itemDetail.jsp?pid=${product.productId }">
					<div class="thumbnail item">
						<img src="${product.productImg1 }">
						<div class="caption">
							<h5>${product.productTitle }</h5>
							<h4>价格：${product.productPrice }</h4>
						</div>
					</div>
				</a>
			</div>
			<c:if test="${i.index%5 == 4 }">
				</div>
			</c:if>
		</c:forEach>
		</div>
	</c:if>

## 主界面控制器代码

	@RequestMapping(value="index")
	public String index(@RequestParam(value="keyword", required=false) String keyword
			, @RequestParam(value = "pn", defaultValue = "1") Integer pn){
		// 使用PageHelper插件进行分页操作
		// 设置每页有15条数据
		PageHelper.startPage(pn, 15);
		ProductExample example = new ProductExample();
		Criteria createCriteria = example.createCriteria();
		
		// 查看是否关键词搜索
		if ("".equals(keyword) || keyword == null){
			keyword = null;
		}else{
			createCriteria.andProductTitleLike(keyword);
		}
		// 显示有图片1的商品
		// 商品状态 0 表示为上架状态， 1为下架状态， -1为删除
		createCriteria.andProductImg1IsNotNull();
		createCriteria.andProductStatusEqualTo(0);
		List<Product> all = productService.selectByExample(example);   //根据条件选择查询
		PageInfo<Product> page = new PageInfo<Product>(all, 5);  // 分页条最多有5个
		request.setAttribute("pages", page);	// 将数据放入request 作用于供前台使用
		return "index";						// 转发回主页
	}

# 用户个人中心

用户可以在个人中心执行相对应的操作
* 上传头像
* 修改密码
* 虚拟充值
* 修改收货地址

![](http://www.yqplayer.com/netpicyd/6d768b59e652328dbbd1de4e5ad11438.png)

# 管理员后台管理页面
地址: [http://www.yqplayer.com:8080/mall/adminLogin.jsp](http://www.yqplayer.com:8080/mall/adminLogin.jsp)  
管理员用户名: admin  
管理员密码: admin

管理员可以执行相对应的操作
* 上传商品
* 上传商品图片
* 编辑商品
* 下架商品
* 删除商品

**后台管理界面商品超过五个将进行分页处理**

![](http://www.yqplayer.com/netpicyd/13f7d6d21c95b3cba7d3d6f5938b82c0.png)

