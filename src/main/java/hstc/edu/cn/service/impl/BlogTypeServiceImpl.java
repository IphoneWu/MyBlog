package hstc.edu.cn.service.impl;

import hstc.edu.cn.mapper.BlogTypeMapper;
import hstc.edu.cn.po.BlogType;
import hstc.edu.cn.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by win8 on 2017/3/15.
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {
    @Autowired
    private BlogTypeMapper blogTypeMapper;
    public List<BlogType> getBlogTypeData() {
        return blogTypeMapper.getBlogTypeData();
    }

    public List<BlogType> listBlogType(Map<String, Object> map) {
        return blogTypeMapper.listBlogType(map);
    }

    public Long getTotal(Map<String, Object> map) {
        return blogTypeMapper.getTotal(map);
    }

    public Integer addBlogType(BlogType blogType) {
        return blogTypeMapper.addBlogType(blogType);
    }

    public Integer updateBlogType(BlogType blogType) {
        return blogTypeMapper.updateBlogType(blogType);
    }

    public Integer deleteBlogType(Integer id) {
        return blogTypeMapper.deleteBlogType(id);
    }
}
