package system.bld.model;

import java.io.Serializable;
import java.util.Date;

public class HotNewsRecords implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hot_news_records.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hot_news_records.source
     *
     * @mbg.generated
     */
    private String source;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hot_news_records.news_title
     *
     * @mbg.generated
     */
    private String newsTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hot_news_records.new_title_md5
     *
     * @mbg.generated
     */
    private String newTitleMd5;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hot_news_records.news_link_url
     *
     * @mbg.generated
     */
    private String newsLinkUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hot_news_records.heat_score
     *
     * @mbg.generated
     */
    private Long heatScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hot_news_records.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hot_news_records.modify_time
     *
     * @mbg.generated
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hot_news_records
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hot_news_records.id
     *
     * @return the value of hot_news_records.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hot_news_records.id
     *
     * @param id the value for hot_news_records.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hot_news_records.source
     *
     * @return the value of hot_news_records.source
     *
     * @mbg.generated
     */
    public String getSource() {
        return source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hot_news_records.source
     *
     * @param source the value for hot_news_records.source
     *
     * @mbg.generated
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hot_news_records.news_title
     *
     * @return the value of hot_news_records.news_title
     *
     * @mbg.generated
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hot_news_records.news_title
     *
     * @param newsTitle the value for hot_news_records.news_title
     *
     * @mbg.generated
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hot_news_records.new_title_md5
     *
     * @return the value of hot_news_records.new_title_md5
     *
     * @mbg.generated
     */
    public String getNewTitleMd5() {
        return newTitleMd5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hot_news_records.new_title_md5
     *
     * @param newTitleMd5 the value for hot_news_records.new_title_md5
     *
     * @mbg.generated
     */
    public void setNewTitleMd5(String newTitleMd5) {
        this.newTitleMd5 = newTitleMd5 == null ? null : newTitleMd5.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hot_news_records.news_link_url
     *
     * @return the value of hot_news_records.news_link_url
     *
     * @mbg.generated
     */
    public String getNewsLinkUrl() {
        return newsLinkUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hot_news_records.news_link_url
     *
     * @param newsLinkUrl the value for hot_news_records.news_link_url
     *
     * @mbg.generated
     */
    public void setNewsLinkUrl(String newsLinkUrl) {
        this.newsLinkUrl = newsLinkUrl == null ? null : newsLinkUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hot_news_records.heat_score
     *
     * @return the value of hot_news_records.heat_score
     *
     * @mbg.generated
     */
    public Long getHeatScore() {
        return heatScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hot_news_records.heat_score
     *
     * @param heatScore the value for hot_news_records.heat_score
     *
     * @mbg.generated
     */
    public void setHeatScore(Long heatScore) {
        this.heatScore = heatScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hot_news_records.create_time
     *
     * @return the value of hot_news_records.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hot_news_records.create_time
     *
     * @param createTime the value for hot_news_records.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hot_news_records.modify_time
     *
     * @return the value of hot_news_records.modify_time
     *
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hot_news_records.modify_time
     *
     * @param modifyTime the value for hot_news_records.modify_time
     *
     * @mbg.generated
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hot_news_records
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", source=").append(source);
        sb.append(", newsTitle=").append(newsTitle);
        sb.append(", newTitleMd5=").append(newTitleMd5);
        sb.append(", newsLinkUrl=").append(newsLinkUrl);
        sb.append(", heatScore=").append(heatScore);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}