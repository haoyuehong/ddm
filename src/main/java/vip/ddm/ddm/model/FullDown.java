package vip.ddm.ddm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class FullDown implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column full_down.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column full_down.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column full_down.descr
     *
     * @mbg.generated
     */
    private String descr;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column full_down.hightest_price
     *
     * @mbg.generated
     */
    private Double hightestPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column full_down.lowest_price
     *
     * @mbg.generated
     */
    private Double lowestPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column full_down.superposition
     *
     * @mbg.generated
     */
    private Byte superposition;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column full_down.date
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column full_down.status
     *
     * @mbg.generated
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column full_down.price
     *
     * @mbg.generated
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column full_down.store_id
     *
     * @mbg.generated
     */
    private Integer storeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table full_down
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column full_down.id
     *
     * @return the value of full_down.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column full_down.id
     *
     * @param id the value for full_down.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column full_down.name
     *
     * @return the value of full_down.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column full_down.name
     *
     * @param name the value for full_down.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column full_down.descr
     *
     * @return the value of full_down.descr
     *
     * @mbg.generated
     */
    public String getDescr() {
        return descr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column full_down.descr
     *
     * @param descr the value for full_down.descr
     *
     * @mbg.generated
     */
    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column full_down.hightest_price
     *
     * @return the value of full_down.hightest_price
     *
     * @mbg.generated
     */
    public Double getHightestPrice() {
        return hightestPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column full_down.hightest_price
     *
     * @param hightestPrice the value for full_down.hightest_price
     *
     * @mbg.generated
     */
    public void setHightestPrice(Double hightestPrice) {
        this.hightestPrice = hightestPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column full_down.lowest_price
     *
     * @return the value of full_down.lowest_price
     *
     * @mbg.generated
     */
    public Double getLowestPrice() {
        return lowestPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column full_down.lowest_price
     *
     * @param lowestPrice the value for full_down.lowest_price
     *
     * @mbg.generated
     */
    public void setLowestPrice(Double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column full_down.superposition
     *
     * @return the value of full_down.superposition
     *
     * @mbg.generated
     */
    public Byte getSuperposition() {
        return superposition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column full_down.superposition
     *
     * @param superposition the value for full_down.superposition
     *
     * @mbg.generated
     */
    public void setSuperposition(Byte superposition) {
        this.superposition = superposition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column full_down.date
     *
     * @return the value of full_down.date
     *
     * @mbg.generated
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column full_down.date
     *
     * @param date the value for full_down.date
     *
     * @mbg.generated
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column full_down.status
     *
     * @return the value of full_down.status
     *
     * @mbg.generated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column full_down.status
     *
     * @param status the value for full_down.status
     *
     * @mbg.generated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column full_down.price
     *
     * @return the value of full_down.price
     *
     * @mbg.generated
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column full_down.price
     *
     * @param price the value for full_down.price
     *
     * @mbg.generated
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column full_down.store_id
     *
     * @return the value of full_down.store_id
     *
     * @mbg.generated
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column full_down.store_id
     *
     * @param storeId the value for full_down.store_id
     *
     * @mbg.generated
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table full_down
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
        sb.append(", name=").append(name);
        sb.append(", descr=").append(descr);
        sb.append(", hightestPrice=").append(hightestPrice);
        sb.append(", lowestPrice=").append(lowestPrice);
        sb.append(", superposition=").append(superposition);
        sb.append(", date=").append(date);
        sb.append(", status=").append(status);
        sb.append(", price=").append(price);
        sb.append(", storeId=").append(storeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}