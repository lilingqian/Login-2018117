package lijingqian.bawei.com.login_2018117.model;


import lijingqian.bawei.com.login_2018117.bean.CartBean;

/**
 * date:2018/1/16 14:11
 * introduction:
 */

public interface CartModelCallback {
    void success(CartBean bean);
    void failure(int code);
}
