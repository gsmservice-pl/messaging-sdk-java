/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package pl.gsmservice.gateway.models.operations;

import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.Long;
import java.util.Optional;
import pl.gsmservice.gateway.utils.LazySingletonValue;
import pl.gsmservice.gateway.utils.Options;
import pl.gsmservice.gateway.utils.RetryConfig;
import pl.gsmservice.gateway.utils.Utils;

public class ListMessagesRequestBuilder {

    private Optional<Long> page = Utils.readDefaultOrConstValue(
                            "page",
                            "1",
                            new TypeReference<Optional<Long>>() {});
    private Optional<Long> limit = Utils.readDefaultOrConstValue(
                            "limit",
                            "10",
                            new TypeReference<Optional<Long>>() {});
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKMethodInterfaces.MethodCallListMessages sdk;

    public ListMessagesRequestBuilder(SDKMethodInterfaces.MethodCallListMessages sdk) {
        this.sdk = sdk;
    }
                
    public ListMessagesRequestBuilder page(long page) {
        Utils.checkNotNull(page, "page");
        this.page = Optional.of(page);
        return this;
    }

    public ListMessagesRequestBuilder page(Optional<Long> page) {
        Utils.checkNotNull(page, "page");
        this.page = page;
        return this;
    }
                
    public ListMessagesRequestBuilder limit(long limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = Optional.of(limit);
        return this;
    }

    public ListMessagesRequestBuilder limit(Optional<Long> limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = limit;
        return this;
    }
                
    public ListMessagesRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public ListMessagesRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public ListMessagesResponse call() throws Exception {
        if (page == null) {
            page = _SINGLETON_VALUE_Page.value();
        }
        if (limit == null) {
            limit = _SINGLETON_VALUE_Limit.value();
        }        Optional<Options> options = Optional.of(Options.builder()
                                                    .retryConfig(retryConfig)
                                                    .build());
        return sdk.list(
            page,
            limit,
            options);
    }

    private static final LazySingletonValue<Optional<Long>> _SINGLETON_VALUE_Page =
            new LazySingletonValue<>(
                    "page",
                    "1",
                    new TypeReference<Optional<Long>>() {});

    private static final LazySingletonValue<Optional<Long>> _SINGLETON_VALUE_Limit =
            new LazySingletonValue<>(
                    "limit",
                    "10",
                    new TypeReference<Optional<Long>>() {});
}
