package system.bld.request;

/**
 * Created with IntelliJ IDEA.
 * 分页实体请求类
 * @Author: LiTao
 * @Date: 2020/5/13
 * @Time: 15:47
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class GenericPageRequest extends GenericRequest {
	private static final long serialVersionUID = -2249185564951641656L;

	private Integer pageSize = Integer.valueOf(20);

	private Integer pageNum = Integer.valueOf(1);

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize.intValue() > 10000) {
			pageSize = 10000;
		}
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
}
