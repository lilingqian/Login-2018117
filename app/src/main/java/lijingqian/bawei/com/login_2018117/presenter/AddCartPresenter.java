package lijingqian.bawei.com.login_2018117.presenter;


import lijingqian.bawei.com.login_2018117.bean.AddCartBean;
import lijingqian.bawei.com.login_2018117.model.AddCartModel;
import lijingqian.bawei.com.login_2018117.model.AddCartModelCallback;
import lijingqian.bawei.com.login_2018117.view.AddCartView;

/**
 * date:2018/1/16 14:03
 * introduction:
 */

public class AddCartPresenter {
    private AddCartView view;
    private AddCartModel model;

    public AddCartPresenter(AddCartView view) {
        this.view = view;
        model=new AddCartModel();
    }

    public void addIntoCart(String pid,String uid){
        model.AddIntoCart(pid, uid, new AddCartModelCallback() {
            @Override
            public void success(AddCartBean bean) {
                view.success(bean);
            }

            @Override
            public void failure(int code) {
                view.failure(code);
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
