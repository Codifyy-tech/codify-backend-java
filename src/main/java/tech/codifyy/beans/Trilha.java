package tech.codifyy.beans;

import java.util.List;

public class Trilha {
    private Integer _id, id_tecnologia;
    private String title, author, description, category, url;
    private List<String> topics;

    public Trilha() {
    }

    public Trilha(Integer _id, Integer id_tecnologia, String title, String author, String description, String category, String url, List<String> topics) {
        this._id = _id;
        this.id_tecnologia = id_tecnologia;
        this.title = title;
        this.author = author;
        this.description = description;
        this.category = category;
        this.url = url;
        this.topics = topics;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public Integer getId_tecnologia() {
        return id_tecnologia;
    }

    public void setId_tecnologia(Integer id_tecnologia) {
        this.id_tecnologia = id_tecnologia;
    }
}
