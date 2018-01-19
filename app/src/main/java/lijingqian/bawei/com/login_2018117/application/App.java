package lijingqian.bawei.com.login_2018117.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import lijingqian.bawei.com.login_2018117.fresco.ImagePipelineConfigFactory;

/**
 * date:2018/1/16 13:10
 * introduction:
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /*DiskCacheConfig cacheConfig= DiskCacheConfig.newBuilder(this)
                .setBaseDirectoryName("fresco")
                .setBaseDirectoryPath(getExternalCacheDir())
                .build();
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(cacheConfig)
                .build();*/


        Fresco.initialize(this, ImagePipelineConfigFactory.getImagePipelineConfig(this));
        //Fresco.initialize(this);
    }
}
