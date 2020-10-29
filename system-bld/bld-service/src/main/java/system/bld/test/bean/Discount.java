package system.bld.test.bean;


public class Discount {

    private int buy;
    private int free;
    private int type;//0 商户 1平台

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public boolean compare(Discount discount) {
        return discount.getBuy() == buy && discount.getFree() == free;
    }
}
