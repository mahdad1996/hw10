package com.HW08.maktab32.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "article")
public class Article {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "articleTitle")
    private String title;

    @Column(name = "brief")
    private String brief;

    @Column(name = "content", columnDefinition = "TEXT")
    @Type(type = "text")
    private String content;

    @Column(name = "createDate", nullable = false)
    private Date createDate;

    @Column(name = "lastUpdateDate", nullable = false)
    private Date lastUpdateDate;

    @Column(name = "publishDate")
    private Date publishDate;

    @Column(name = "isPublished")
    @Type(type="yes_no")
    private boolean isPublished;

    @ManyToOne
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private Category category;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Article_tag",
            joinColumns = { @JoinColumn(name = "aid") },
            inverseJoinColumns = { @JoinColumn(name = "tid") }
    )
    private List<Tag> tags = new ArrayList<>();

    public Article(String title, String brief, String content, Date createDate, Date lastUpdateDate, Date publishDate, boolean isPublished, User user, Category category) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.publishDate = publishDate;
        this.isPublished = isPublished;
        this.user = user;
        this.category = category;
    }

    public Article() {
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", publishDate=" + publishDate +
                ", isPublished=" + isPublished +
                ", category=" + category +
                '}';
    }
}
