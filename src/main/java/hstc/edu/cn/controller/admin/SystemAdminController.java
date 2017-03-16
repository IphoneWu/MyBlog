package hstc.edu.cn.controller.admin;

import hstc.edu.cn.po.Blog;
import hstc.edu.cn.po.BlogType;
import hstc.edu.cn.po.Blogger;
import hstc.edu.cn.po.Link;
import hstc.edu.cn.service.BlogService;
import hstc.edu.cn.service.BlogTypeService;
import hstc.edu.cn.service.BloggerService;
import hstc.edu.cn.service.LinkService;
import hstc.edu.cn.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description ����Աϵͳcontroller��
 */
@Controller
@RequestMapping("/admin/system")
public class SystemAdminController {

	@Resource
	private BloggerService bloggerService;
	@Resource
	private LinkService linkService;
	@Resource
	private BlogTypeService blogTypeService;
	@Resource
	private BlogService blogService;

	// ˢ��ϵͳ����
	@RequestMapping("/refreshSystemCache")
	public String refreshSystemCache(
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ServletContext application = RequestContextUtils.getWebApplicationContext(request).getServletContext();
		
		// ��ȡ������Ϣ
		Blogger blogger = bloggerService.getBloggerData();
		blogger.setPassword(null);
		application.setAttribute("blogger", blogger);

		// ��ȡ����������Ϣ
		List<Link> linkList = linkService.getLinkData();
		application.setAttribute("linkList", linkList);

		// ��ȡ���������Ϣ
		List<BlogType> blogTypeList = blogTypeService.getBlogTypeData();
		application.setAttribute("blogTypeList", blogTypeList);

		// ��ȡ������Ϣ������ʱ������
		List<Blog> blogTimeList = blogService.getBlogData();
		application.setAttribute("blogTimeList", blogTimeList);
		
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
