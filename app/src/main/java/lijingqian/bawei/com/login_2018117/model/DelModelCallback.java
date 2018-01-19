package lijingqian.bawei.com.login_2018117.model;


import lijingqian.bawei.com.login_2018117.bean.DeleteBean;

/**
 * date:2018/1/17 13:43
 * introduction:
 */

public interface DelModelCallback {
    void success(DeleteBean bean);
    void failure(int code);
}
