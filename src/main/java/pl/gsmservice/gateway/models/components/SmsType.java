/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package pl.gsmservice.gateway.models.components;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * SmsType - SMS type according to the table
 *     
 * |type|Description|
 * |----|-----------|
 * |  1 |  SMS PRO  |
 * |  3 |  SMS ECO  |
 * |  4 |  SMS 2WAY |
 */
public enum SmsType {
    SmsPro(1L),
    SmsEco(3L),
    SmsTwoWay(4L);

    @JsonValue
    private final long value;

    private SmsType(long value) {
        this.value = value;
    }
    
    public long value() {
        return value;
    }
}
