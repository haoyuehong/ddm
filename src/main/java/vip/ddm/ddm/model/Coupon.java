package vip.ddm.ddm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Coupon implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon.descr
     *
     * @mbg.generated
     */
    private String descr;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon.lowest_price
     *
     * @mbg.generated
     */
    private Double lowestPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon.date
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon.superposition
     *
     * @mbg.generated
     */
    private Byte superposition;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon.price
     *
     * @mbg.generated
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon.status
     *
     * @mbg.generated
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon.type
     *
     * @mbg.generated
     */
    private Byte type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon.num
     *
     * @mbg.generated
     */
    private Integer num;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon.has_get
     *
     * @mbg.generated
     */
    private Integer hasGet;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table coupon
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.id
     *
     * @return the value of coupon.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.id
     *
     * @param id the value for coupon.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.name
     *
     * @return the value of coupon.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.name
     *
     * @param name the value for coupon.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.descr
     *
     * @return the value of coupon.descr
     *
     * @mbg.generated
     */
    public String getDescr() {
        return descr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.descr
     *
     * @param descr the value for coupon.descr
     *
     * @mbg.generated
     */
    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.lowest_price
     *
     * @return the value of coupon.lowest_price
     *
     * @mbg.generated
     */
    public Double getLowestPrice() {
        return lowestPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.lowest_price
     *
     * @param lowestPrice the value for coupon.lowest_price
     *
     * @mbg.generated
     */
    public void setLowestPrice(Double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.date
     *
     * @return the value of coupon.date
     *
     * @mbg.generated
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.date
     *
     * @param date the value for coupon.date
     *
     * @mbg.generated
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.superposition
     *
     * @return the value of coupon.superposition
     *
     * @mbg.generated
     */
    public Byte getSuperposition() {
        return superposition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.superposition
     *
     * @param superposition the value for coupon.superposition
     *
     * @mbg.generated
     */
    public void setSuperposition(Byte superposition) {
        this.superposition = superposition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.price
     *
     * @return the value of coupon.price
     *
     * @mbg.generated
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.price
     *
     * @param price the value for coupon.price
     *
     * @mbg.generated
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.status
     *
     * @return the value of coupon.status
     *
     * @mbg.generated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.status
     *
     * @param status the value for coupon.status
     *
     * @mbg.generated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.type
     *
     * @return the value of coupon.type
     *
     * @mbg.generated
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.type
     *
     * @param type the value for coupon.type
     *
     * @mbg.generated
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.num
     *
     * @return the value of coupon.num
     *
     * @mbg.generated
     */
    public Integer getNum() {
        return num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.num
     *
     * @param num the value for coupon.num
     *
     * @mbg.generated
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon.has_get
     *
     * @return the value of coupon.has_get
     *
     * @mbg.generated
     */
    public Integer getHasGet() {
        return hasGet;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon.has_get
     *
     * @param hasGet the value for coupon.has_get
     *
     * @mbg.generated
     */
    public void setHasGet(Integer hasGet) {
        this.hasGet = hasGet;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon
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
        sb.append(", lowestPrice=").append(lowestPrice);
        sb.append(", date=").append(date);
        sb.append(", superposition=").append(superposition);
        sb.append(", price=").append(price);
        sb.append(", status=").append(status);
        sb.append(", type=").append(type);
        sb.append(", num=").append(num);
        sb.append(", hasGet=").append(hasGet);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}