package hstc.edu.cn.service.impl;

import hstc.edu.cn.mapper.BloggerMapper;
import hstc.edu.cn.po.Blogger;
import hstc.edu.cn.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by win8 on 2017/3/15.
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {
    @Autowired
    private BloggerMapper bloggerMapper;
    public Blogger getByUsername(String username) {
        return bloggerMapper.getByUsername(username);
    }

    public Blogger getBloggerData() {
        return bloggerMapper.getBloggerData();
    }

    public Integer updateBlogger(Blogger blogger) {
        return bloggerMapper.updateBlogger(blogger);
    }
}
