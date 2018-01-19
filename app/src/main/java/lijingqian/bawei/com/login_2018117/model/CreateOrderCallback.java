package lijingqian.bawei.com.login_2018117.model;


import lijingqian.bawei.com.login_2018117.bean.CreatOrderBean;

/**
 * date:2018/1/17 14:07
 * introduction:
 */

public interface CreateOrderCallback {
    void success(CreatOrderBean bean);
    void failure(int code);
}
