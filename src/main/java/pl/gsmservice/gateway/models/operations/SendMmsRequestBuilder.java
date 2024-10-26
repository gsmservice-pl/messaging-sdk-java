/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package pl.gsmservice.gateway.models.operations;

import java.util.Optional;
import pl.gsmservice.gateway.utils.Options;
import pl.gsmservice.gateway.utils.RetryConfig;
import pl.gsmservice.gateway.utils.Utils;

public class SendMmsRequestBuilder {

    private SendMmsRequestBody request;
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKMethodInterfaces.MethodCallSendMms sdk;

    public SendMmsRequestBuilder(SDKMethodInterfaces.MethodCallSendMms sdk) {
        this.sdk = sdk;
    }

    public SendMmsRequestBuilder request(SendMmsRequestBody request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }
                
    public SendMmsRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public SendMmsRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public SendMmsResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
                                                    .retryConfig(retryConfig)
                                                    .build());
        return sdk.send(
            request,
            options);
    }
}