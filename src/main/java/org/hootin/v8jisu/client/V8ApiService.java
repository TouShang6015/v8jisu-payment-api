package org.hootin.v8jisu.client;

import io.reactivex.Single;
import org.hootin.v8jisu.api.Api;
import org.hootin.v8jisu.entity.request.MapiRequest;
import org.hootin.v8jisu.entity.response.AppInfoResponse;
import org.hootin.v8jisu.entity.response.MapiResponse;
import org.hootin.v8jisu.entity.response.OrderInfoResponse;
import org.hootin.v8jisu.entity.response.SettlementRecordResponse;
import org.hootin.v8jisu.properties.V8AccountConfig;
import org.hootin.v8jisu.sign.SignUtil2;
import retrofit2.HttpException;

import java.io.IOException;
import java.util.Objects;

/**
 * 支付服务入口
 *
 * @author WuHao
 * @since 2023/10/23 11:09
 */
public class V8ApiService {

    private final Api api;

    public V8ApiService(Api api) {
        this.api = api;
    }

    /**
     * API接口支付
     * 此接口可用于服务器后端发起支付请求，会返回支付二维码链接或支付跳转url。
     * <p>
     * URL地址：https://pay.v8jisu.cn/mapi.php
     * <p>
     * 请求方式：POST
     *
     * @param request
     * @return
     */
    public MapiResponse mapi(MapiRequest request) {
        if (Objects.isNull(request))
            throw new RuntimeException("V8ApiService error [API - mapi]：请求参数不能为空");
        request.setSign(SignUtil2.getSign(request));
        request.setSign_type("MD5");
        return execute(api.mapi(request));
    }

    /**
     * [API]查询商户信息
     * <p>URL地址：https://pay.v8jisu.cn/api.php?act=query&pid={商户ID}&key={商户密钥}</p>
     *
     * @return
     */
    public AppInfoResponse queryAppInfo() {
        return execute(api.queryAppInfo("query", V8AccountConfig.getAppId(), V8AccountConfig.getAppKey()));
    }

    /**
     * [API]查询结算记录
     * <p>URL地址：https://pay.v8jisu.cn/api.php?act=settle&pid={商户ID}&key={商户密钥}</p>
     *
     * @return
     */
    public SettlementRecordResponse querySettlementRecord() {
        return execute(api.querySettlementRecord("settle", V8AccountConfig.getAppId(), V8AccountConfig.getAppKey()));
    }

    /**
     * [API]查询单个订单
     * <p>URL地址：https://pay.v8jisu.cn/api.php?act=order&pid={商户ID}&key={商户密钥}&out_trade_no={商户订单号}</p>
     *
     * @param trade_no
     * @param out_trade_no
     * @return
     */
    public OrderInfoResponse queryOrderInfo(String trade_no, String out_trade_no) {
        return execute(api.queryOrderInfo("order", V8AccountConfig.getAppId(), V8AccountConfig.getAppKey(), trade_no, out_trade_no));
    }

    /**
     * [API]批量查询订单
     * URL地址：https://pay.v8jisu.cn/api.php?act=orders&pid={商户ID}&key={商户密钥}
     *
     * @param limit
     * @param page
     * @return
     */
    public OrderInfoResponse queryOrdersBatch(int limit, int page) {
        return execute(api.queryOrdersBatch("orders", V8AccountConfig.getAppId(), V8AccountConfig.getAppKey(), limit, page));
    }

    // -------------------------------------------------------------------

    /**
     * 执行器
     *
     * @param apiCall
     * @param <T>
     * @return
     */
    public static <T> T execute(Single<T> apiCall) {
        try {
            return apiCall.blockingGet();
        } catch (HttpException e) {
            e.printStackTrace();
            try {
                if (e.response() == null || e.response().errorBody() == null) {
                    throw e;
                }
                String errorBody = e.response().errorBody().string();
                throw e;
            } catch (IOException ex) {
                ex.printStackTrace();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
