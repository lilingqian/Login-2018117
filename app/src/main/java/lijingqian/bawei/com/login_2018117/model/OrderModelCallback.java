package lijingqian.bawei.com.login_2018117.model;


import lijingqian.bawei.com.login_2018117.bean.OrderBean;

/**
 * date:2018/1/16 19:22
 * introduction:
 */

public interface OrderModelCallback {
    void success(OrderBean bean);
    void failure(int code);
}
