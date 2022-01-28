package kz.mun.m2.db;

import kz.mun.m2.model.Author;
import kz.mun.m2.model.Blog;
import kz.mun.m2.model.Comment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static Connection connection;

    public static void connectToDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myBlog?useUnicode=true&serverTimezone=UTC", "root", "");
            System.out.println("DB connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Author getAuthorByEmail(String email) {
        Author author = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from authors where email = ?");
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                author = new Author(
                        result.getLong("id"),
                        result.getString("name"),
                        result.getString("email"),
                        result.getString("password")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return author;
    }

    public static void addBlog(Blog blog) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into blogs values (null, ?,?,?)");
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setLong(3, blog.getAuthorId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Blog> getAllBlogs() {
        List<Blog> blogList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from blogs order by id desc ");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Long id = result.getLong("id");
                String title = result.getString("title");
                String content = result.getString("content");
                Long authorId = result.getLong("author_id");
                blogList.add(new Blog(id, title, content, authorId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blogList;
    }

    public static String authorNameByBlogId(Long id) {
        String authorName = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select a.name from authors a join blogs b on b.author_id = a.id where b.id = ?");
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                authorName = result.getString("name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorName;
    }

    public static void addComment(Comment comment) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into comments values (null, ?,?,?)");
            statement.setString(1, comment.getComment());
            statement.setLong(2, comment.getAuthorId());
            statement.setLong(3, comment.getBlogId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Comment> getCommentsByBlogId(Long blogId) {
        List<Comment> comments = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from comments where blog_id = ? order by id desc ");
            statement.setLong(1, blogId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Long id = result.getLong("id");
                String comment = result.getString("comment");
                Long authorId = result.getLong("author_id");
                comments.add(new Comment(id, comment, authorId, blogId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }
}
