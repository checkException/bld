package system.bld.bean;

public class TurntablePrizeDomain {

    private String prizeLevel;

    private String prizeDesc;

    private Double weight;

    private Long redPackId;

	/**
	 * 实物id，1，橘右京修罗皮肤;2 玛莎拉蒂皮肤
	 */
	private Long entityId;


    public String getPrizeLevel() {
        return prizeLevel;
    }

    public void setPrizeLevel(String prizeLevel) {
        this.prizeLevel = prizeLevel;
    }

    public String getPrizeDesc() {
        return prizeDesc;
    }

    public void setPrizeDesc(String prizeDesc) {
        this.prizeDesc = prizeDesc;
    }

    public Long getRedPackId() {
        return redPackId;
    }

    public void setRedPackId(Long redPackId) {
        this.redPackId = redPackId;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}
}
