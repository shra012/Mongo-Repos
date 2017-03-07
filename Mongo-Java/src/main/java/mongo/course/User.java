package mongo.course;

import org.bson.Document;

/**
 * Created by Hiruzen on 07/03/17.
 */
public class User  {
    private String _id;
    private String password;
    private String email;
    private Document user;

    public User() {
    }

    public User(String _id, String password) {
        this._id = _id;
        this.password = password;
        this.user = new Document("_id",_id).append("password",password);
    }

    public User(String _id, String password, String email) {
        this._id = _id;
        this.password = password;
        this.email = email;
        this.user = new Document("_id",_id).append("password",password).append("email",email);
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Document getUser() {
        return user;
    }

    public void setUser(Document user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "User{" +
                "_id='" + _id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

