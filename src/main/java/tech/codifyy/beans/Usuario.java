package tech.codifyy.beans;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
@XmlRootElement
public class Usuario {

    private Integer _id;
    private String email;
    private String genre;
    private String name;
    private String password;
    private String confirm_password;
    private Long phone;
    private Date birth_date;
    private String type;
    private String address;
    private Integer cep;
    private String city;
    private String district;
    private String state;

    public Usuario(){

    }

    public Usuario(Integer _id, String email, String genre, String name, String password, String confirm_password, Long phone, Date birth_date, String type, String address, Integer cep, String city, String district, String state) {
        this._id = _id;
        this.email = email;
        this.genre = genre;
        this.name = name;
        this.password = password;
        this.confirm_password = confirm_password;
        this.phone = phone;
        this.birth_date = birth_date;
        this.type = type;
        this.address = address;
        this.cep = cep;
        this.city = city;
        this.district = district;
        this.state = state;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}