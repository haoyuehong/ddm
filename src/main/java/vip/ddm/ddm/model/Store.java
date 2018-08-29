package vip.ddm.ddm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

public class Store implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.username
     *
     * @mbg.generated
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.date
     *
     * @mbg.generated
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.password
     *
     * @mbg.generated
     */
    @JsonIgnore
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.phone
     *
     * @mbg.generated
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.status
     *
     * @mbg.generated
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.type
     *
     * @mbg.generated
     */
    private Byte type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.am_order_status
     *
     * @mbg.generated
     */
    private Byte amOrderStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.pm_order_status
     *
     * @mbg.generated
     */
    private Byte pmOrderStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table store
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.id
     *
     * @return the value of store.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.id
     *
     * @param id the value for store.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.name
     *
     * @return the value of store.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.name
     *
     * @param name the value for store.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.username
     *
     * @return the value of store.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.username
     *
     * @param username the value for store.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.address
     *
     * @return the value of store.address
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.address
     *
     * @param address the value for store.address
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.date
     *
     * @return the value of store.date
     *
     * @mbg.generated
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.date
     *
     * @param date the value for store.date
     *
     * @mbg.generated
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.password
     *
     * @return the value of store.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.password
     *
     * @param password the value for store.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.phone
     *
     * @return the value of store.phone
     *
     * @mbg.generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.phone
     *
     * @param phone the value for store.phone
     *
     * @mbg.generated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.status
     *
     * @return the value of store.status
     *
     * @mbg.generated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.status
     *
     * @param status the value for store.status
     *
     * @mbg.generated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.type
     *
     * @return the value of store.type
     *
     * @mbg.generated
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.type
     *
     * @param type the value for store.type
     *
     * @mbg.generated
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.am_order_status
     *
     * @return the value of store.am_order_status
     *
     * @mbg.generated
     */
    public Byte getAmOrderStatus() {
        return amOrderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.am_order_status
     *
     * @param amOrderStatus the value for store.am_order_status
     *
     * @mbg.generated
     */
    public void setAmOrderStatus(Byte amOrderStatus) {
        this.amOrderStatus = amOrderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.pm_order_status
     *
     * @return the value of store.pm_order_status
     *
     * @mbg.generated
     */
    public Byte getPmOrderStatus() {
        return pmOrderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.pm_order_status
     *
     * @param pmOrderStatus the value for store.pm_order_status
     *
     * @mbg.generated
     */
    public void setPmOrderStatus(Byte pmOrderStatus) {
        this.pmOrderStatus = pmOrderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store
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
        sb.append(", username=").append(username);
        sb.append(", address=").append(address);
        sb.append(", date=").append(date);
        sb.append(", password=").append(password);
        sb.append(", phone=").append(phone);
        sb.append(", status=").append(status);
        sb.append(", type=").append(type);
        sb.append(", amOrderStatus=").append(amOrderStatus);
        sb.append(", pmOrderStatus=").append(pmOrderStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}