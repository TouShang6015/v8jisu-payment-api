package org.hootin.v8jisu.entity.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hootin.v8jisu.entity.V8CommonResponse;

/**
 * ShopInfoResponse
 * 商户信息响应实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AppInfoResponse extends V8CommonResponse {

    /**
     * 商户ID
     */
    private Integer pid;

    /**
     * 商户密钥
     */
    private String key;

    /**
     * 商户状态，1为正常，0为封禁
     */
    private Integer active;

    /**
     * 商户余额
     */
    private String money;

    /**
     * 结算方式，1:支付宝,2:微信,3:QQ,4:银行卡
     */
    private Integer type;

    /**
     * 结算账号
     */
    private String account;

    /**
     * 结算姓名
     */
    private String username;

    /**
     * 订单总数统计
     */
    private Integer orders;

    /**
     * 今日订单数量
     */
    private Integer order_today;

    /**
     * 昨日订单数量
     */
    private Integer order_lastday;
}
