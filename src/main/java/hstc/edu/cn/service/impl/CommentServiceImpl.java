package hstc.edu.cn.service.impl;

import hstc.edu.cn.mapper.CommentMapper;
import hstc.edu.cn.po.Comment;
import hstc.edu.cn.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by win8 on 2017/3/15.
 */

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    public List<Comment> getCommentData(Map<String, Object> map) {
        return commentMapper.getCommentData(map);
    }

    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    public Long getTotal(Map<String, Object> map) {
        return commentMapper.getTotal(map);
    }

    public Integer update(Comment comment) {
        return commentMapper.update(comment);
    }

    public Integer deleteComment(Integer id) {
        return commentMapper.deleteComment(id);
    }

    public Integer deleteCommentByBlogId(Integer blogId) {
        return commentMapper.deleteCommentByBlogId(blogId);
    }
}
