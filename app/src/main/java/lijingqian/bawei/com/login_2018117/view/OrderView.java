package lijingqian.bawei.com.login_2018117.view;


import lijingqian.bawei.com.login_2018117.bean.OrderBean;

/**
 * date:2018/1/16 19:28
 * introduction:
 */

public interface OrderView {
    void success(OrderBean bean);
    void failure(int code);
}
