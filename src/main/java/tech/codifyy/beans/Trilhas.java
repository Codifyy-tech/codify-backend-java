package tech.codifyy.beans;

import java.util.List;

public class Trilhas {
    private Integer _id;
    private String title, author, description, category, url;
    private List<String> topics;

    private Tecnologia technology;

    public Trilhas () {
    }

    public Trilhas(Integer _id, String title, String author, String description, String category, String url, List<String> topics, Tecnologia technology) {
        this._id = _id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.category = category;
        this.url = url;
        this.topics = topics;
        this.technology = technology;
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

    public Tecnologia getTechnology() {
        return technology;
    }

    public void setTechnology(Tecnologia technology) {
        this.technology = technology;
    }
}
