package lijingqian.bawei.com.login_2018117.view;


import lijingqian.bawei.com.login_2018117.bean.LoginBean;

/**
 * date:2018/1/15 18:04
 * introduction:
 */

public interface LoginView {
    String getMobile();
    String getPwd();
    void success(LoginBean bean);
    void failure(String s);
}
