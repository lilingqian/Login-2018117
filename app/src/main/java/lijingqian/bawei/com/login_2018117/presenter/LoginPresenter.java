package lijingqian.bawei.com.login_2018117.presenter;


import lijingqian.bawei.com.login_2018117.bean.LoginBean;
import lijingqian.bawei.com.login_2018117.model.LoginModel;
import lijingqian.bawei.com.login_2018117.model.LoginModelCallback;
import lijingqian.bawei.com.login_2018117.view.LoginView;

/**
 * date:2018/1/15 19:01
 * introduction:
 */

public class LoginPresenter {
    private LoginView view;
    private LoginModel model;

    public LoginPresenter(LoginView view) {
        this.view = view;
        model=new LoginModel();
    }


    public void Login(){
        String mobile = view.getMobile();
        String pwd = view.getPwd();
        model.getData(mobile, pwd, new LoginModelCallback() {
            @Override
            public void success(LoginBean bean) {
                if(bean.getMsg().length()==4){
                    view.success(bean);
                }else{
                    view.failure(bean.getMsg());
                }

            }

            @Override
            public void failure(int code) {

            }
        });
    }

    /**
     * 解除绑定
     */
     public void dettach(){
         this.view=null;
     }
}
