package lijingqian.bawei.com.login_2018117.model;


import lijingqian.bawei.com.login_2018117.bean.LoginBean;

/**
 * date:2018/1/15 17:48
 * introduction:
 */

public interface LoginModelCallback {
    void success(LoginBean bean);
    void failure(int code);
}
