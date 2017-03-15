package hstc.edu.cn.service.impl;

import hstc.edu.cn.mapper.LinkMapper;
import hstc.edu.cn.po.Link;
import hstc.edu.cn.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by win8 on 2017/3/15.
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkMapper linkMapper;
    public List<Link> getLinkData() {
        return linkMapper.getLinkData();
    }

    public List<Link> listLinkData(Map<String, Object> map) {
        return linkMapper.listLinkData(map);
    }

    public Long getTotal(Map<String, Object> map) {
        return linkMapper.getTotal(map);
    }

    public Integer addLink(Link link) {
        return linkMapper.addLink(link);
    }

    public Integer updateLink(Link link) {
        return linkMapper.updateLink(link);
    }

    public Integer deleteLink(Integer id) {
        return linkMapper.deleteLink(id);
    }
}
