package com.didi.biz.addr.search;

import java.util.List;

import android.location.Address;

/**
 * 搜索操作相关接口
 * 
 * @author houshengyong
 * @since 2015-5-29
 */

interface ISearchOpCallback {
    // 开始搜索，做必要的界面提示
    void onSearchStart();

    // 由于网络等原因导致失败，做必要的界面提示
    void onSearchFail();

    // 搜索操作成功并有数据返回，做数据展示
    void onSearchSuccess(List<Address> addressList);

    // 搜索操作成功但没搜索到结果
    void onSearchSuccess();
}