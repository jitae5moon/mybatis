package org.example.chapter03.domain;

import java.time.LocalDateTime;

public class Comment {

    private Long id;
    private String content;
    private LocalDateTime createdDate;
    private String userId;

    public Comment() {}

    public Comment(Long id, String content, LocalDateTime createdDate, String userId) {
        this.id = id;
        this.content = content;
        this.createdDate = createdDate;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", userId='" + userId + '\'' +
                '}';
    }

}
