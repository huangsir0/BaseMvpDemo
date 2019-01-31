package com.example.hcl.basemvp.models;

import com.example.hcl.basemvp.others.net.Api;
import com.example.hcl.basemvp.others.utils.HttpUtils;

public class BaseModel {

    protected HttpUtils retrofit = HttpUtils.Instance();


    /**
     * 网络请求
     * @return
     */
    protected Api getApi() {
        return retrofit.createApi(Api.class);
    }
}
