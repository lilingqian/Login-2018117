package lijingqian.bawei.com.login_2018117.model;


import lijingqian.bawei.com.login_2018117.bean.RegBean;

/**
 * date:2018/1/15 20:06
 * introduction:
 */

public interface RegModelCallback {
    void success(RegBean bean);
    void failure(int code);
}
