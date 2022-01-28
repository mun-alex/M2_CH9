package kz.mun.m2.model;

public class Comment {
    private Long id;
    private String comment;
    private Long authorId;
    private Long blogId;

    public Comment() {
    }

    public Comment(Long id, String comment, Long authorId, Long blogId) {
        this.id = id;
        this.comment = comment;
        this.authorId = authorId;
        this.blogId = blogId;
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", authorId=" + authorId +
                ", blogId=" + blogId +
                '}';
    }
}
