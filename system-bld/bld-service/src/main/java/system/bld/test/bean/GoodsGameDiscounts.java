package system.bld.test.bean;


import java.util.List;

public class GoodsGameDiscounts{

    private boolean enable;

    private String gameId;

    private List<Discount> discounts;

	/**
	 * 0:停用所有；1：游戏通用；2：商品通用
	 */
	private Integer type;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
