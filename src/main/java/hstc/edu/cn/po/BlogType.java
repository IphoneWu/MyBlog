package hstc.edu.cn.po;

import io.swagger.models.auth.In;

/**
 * Created by win8 on 2017/3/15.
 */
public class BlogType {
    private Integer id;
    private String typeName;
    private String prderNum;
    private Integer blogCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPrderNum() {
        return prderNum;
    }

    public void setPrderNum(String prderNum) {
        this.prderNum = prderNum;
    }

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }
}
