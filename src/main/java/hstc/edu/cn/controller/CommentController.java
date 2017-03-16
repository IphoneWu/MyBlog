package hstc.edu.cn.controller;

import hstc.edu.cn.po.Blog;
import hstc.edu.cn.po.Comment;
import hstc.edu.cn.service.BlogService;
import hstc.edu.cn.service.CommentService;
import hstc.edu.cn.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by win8 on 2017/3/16.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private BlogService blogService;
    //添加或者修改评论
    @RequestMapping("/save")
    public String save(
            Comment comment,
            @RequestParam("imageCode")String imageCode, //前台传来的验证码
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session) throws Exception {

        String sRand = (String) session.getAttribute("sRand");//获取session中正确的验证码，验证码产生后会存到session中的
        JSONObject result = new JSONObject();
        int resultTotal = 0; //执行记录数
        if(!imageCode.equals(sRand)) {
            result.put("success", false);
            result.put("errorInfo", "验证码有误");
        } else {
            String userIp = request.getRemoteAddr(); //获取评论用户的ip
            comment.setUserIp(userIp);  //将userIp设置进去
            if(comment.getId() == null) { //没有id表示添加
                resultTotal = commentService.addComment(comment); //添加评论
                Blog blog = blogService.findById(comment.getBlog().getId()); //更新一下博客的评论次数
                blog.setReplyHit(blog.getReplyHit() + 1);
                blogService.update(blog);
            } else { //有id表示修改

            }
        }
        //判断是否添加成功
        if(resultTotal > 0) {
            result.put("success", true);
        }
        ResponseUtil.write(response, result);
        return null;
    }
}
