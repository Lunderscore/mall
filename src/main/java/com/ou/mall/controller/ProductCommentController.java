// package com.ou.mall.controller;
//
// import java.sql.Date;
// import java.util.List;
//
// import javax.servlet.http.HttpSession;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
//
// import com.ou.mall.bean.Msg;
// import com.ou.mall.bean.ProductComment;
// import com.ou.mall.bean.ProductCommentExample;
// import com.ou.mall.bean.User;
// import com.ou.mall.service.ProductCommentService;
//
// @Controller
// public class ProductCommentController {
//
// 	@Autowired
// 	ProductCommentService productCommentService;
//
// 	/*
// 	 * 增加一条商品评论
// 	 */
// 	@ResponseBody
// 	@RequestMapping("addComment")
// 	public Msg addComment(ProductComment record, HttpSession session){
// 		User user = (User) session.getAttribute("userSession");
// 		Date date = new Date(System.currentTimeMillis());
//
// 		record.setCommentDateTime(date);
// 		record.setCommentUid(user.getUserId());
// 		productCommentService.addComment(record);
// 		return Msg.success();
// 	}
//
// //	在商品详情的页面获取该商品的评论
// 	@ResponseBody
// 	@RequestMapping("getCommentByPid")
// 	public Msg getCommentByPid(@RequestParam("pid") Integer pid){
// 		ProductCommentExample example = new ProductCommentExample();
// 		example.createCriteria().andCommentPidEqualTo(pid);
//
// 		List<ProductComment> commentByExample = productCommentService.getCommentByExample(example);
//
// 		if (commentByExample.isEmpty()){
// 			return Msg.failure();
// 		}
// 		return Msg.success().add("comments", commentByExample);
// 	}
// }
