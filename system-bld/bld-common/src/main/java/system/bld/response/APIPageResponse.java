package system.bld.response;

/**
 * Created with IntelliJ IDEA.
 * 接口结果 response
 * @Author: LiTao
 * @Date: 2020/5/6
 * @Time: 20:16
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class APIPageResponse extends APIResponse{

    private static final long serialVersionUID = 5064941176827711859L;

    /**
	 * 总条数
	 */
    private Long totalCount;

    /**
     * 总页数
     */
    private Integer pages;

    /**
     * 当前页
     */
    private Integer currentPages;

    public APIPageResponse() {
    }

    public APIPageResponse(Integer code, String msg, Object data) {
        super(code, msg, data);
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getCurrentPages() {
        return currentPages;
    }

    public void setCurrentPages(Integer currentPages) {
        this.currentPages = currentPages;
    }

}
