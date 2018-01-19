package lijingqian.bawei.com.login_2018117.model;


import lijingqian.bawei.com.login_2018117.bean.AddCartBean;

/**
 * date:2018/1/16 13:58
 * introduction:
 */

public interface AddCartModelCallback {
    void success(AddCartBean bean);
    void failure(int code);
}
