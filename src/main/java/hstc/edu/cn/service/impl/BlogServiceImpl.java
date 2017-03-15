package hstc.edu.cn.service.impl;

import hstc.edu.cn.mapper.BlogMapper;
import hstc.edu.cn.po.Blog;
import hstc.edu.cn.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by win8 on 2017/3/15.
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    public List<Blog> getBlogData() {
        return blogMapper.getBlogData();
    }

    public List<Blog> listBlog(Map<String, Object> map) {
        return blogMapper.listBlog(map);
    }

    public Long getTotal(Map<String, Object> map) {
        return blogMapper.getTotal(map);
    }

    public Blog findById(Integer id) {
        return blogMapper.findById(id);
    }

    public Integer update(Blog blog) {
        return blogMapper.update(blog);
    }

    public Blog getPrevBlog(Integer id) {
        return blogMapper.getPrevBlog(id);
    }

    public Blog getNextBlog(Integer id) {
        return blogMapper.getNextBlog(id);
    }

    public Integer addBlog(Blog blog) {
        return blogMapper.addBlog(blog);
    }

    public Integer deleteBlog(Integer id) {
        return blogMapper.deleteBlog(id);
    }

    public Integer getBlogByTypeId(Integer typeId) {
        return blogMapper.getBlogByTypeId(typeId);
    }
}
