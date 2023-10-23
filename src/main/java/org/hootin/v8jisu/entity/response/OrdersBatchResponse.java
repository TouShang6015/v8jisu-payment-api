package org.hootin.v8jisu.entity.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hootin.v8jisu.entity.V8CommonResponse;

import java.util.List;

/**
 * OrdersResponse
 * 批量订单信息响应实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrdersBatchResponse extends V8CommonResponse {

    List<OrderInfoResponse> data;

}
