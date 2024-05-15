package in.reqres.model.response.singleuser;



import in.reqres.model.response.singleuser.Support;
import in.reqres.model.response.singleuser.UserDetail;

public class UserResponse {
    private UserDetail data;
    private Support support;


    public UserDetail getData() {
        return data;
    }

    public void setData(UserDetail data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
