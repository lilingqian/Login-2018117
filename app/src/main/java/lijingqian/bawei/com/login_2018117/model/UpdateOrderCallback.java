package lijingqian.bawei.com.login_2018117.model;


import lijingqian.bawei.com.login_2018117.bean.UpdateOrderBean;

/**
 * date:2018/1/17 16:01
 * introduction:
 */

public interface UpdateOrderCallback {
    void success(UpdateOrderBean bean);
    void failure(int code);
}
