package org.v8jisu.entity.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.v8jisu.entity.V8CommonResponse;

/**
 * @author WuHao
 * @since 2023/10/23 13:39
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SettlementRecordResponse extends V8CommonResponse {

    private Object data;

}
