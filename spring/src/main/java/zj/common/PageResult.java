package zj.common;

import java.util.List;

/**
 * @author lzj
 * @date 2018/1/15
 */
public class PageResult<T> {

    private Integer total;

    private List<T> rows;

    public PageResult(int total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}