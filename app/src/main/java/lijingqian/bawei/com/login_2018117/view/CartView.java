package lijingqian.bawei.com.login_2018117.view;


import lijingqian.bawei.com.login_2018117.bean.CartBean;

/**
 * date:2018/1/16 14:16
 * introduction:
 */

public interface CartView {
    void success(CartBean bean);
    void failure(int code);
}
