/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package pl.gsmservice.gateway;

import java.lang.String;
import java.util.Optional;
import pl.gsmservice.gateway.hooks.SDKHooks;
import pl.gsmservice.gateway.utils.HTTPClient;
import pl.gsmservice.gateway.utils.Hook.SdkInitData;
import pl.gsmservice.gateway.utils.Hooks;
import pl.gsmservice.gateway.utils.RetryConfig;

class SDKConfiguration {
    public SecuritySource securitySource;
    
    public Optional<SecuritySource> securitySource() {
        return Optional.ofNullable(securitySource);
    }
    public HTTPClient defaultClient;
    public String serverUrl;
    public String server;
    private static final String LANGUAGE = "java";
    public static final String OPENAPI_DOC_VERSION = "0.9.2";
    public static final String SDK_VERSION = "0.0.10";
    public static final String GEN_VERSION = "2.438.3";
    private static final String BASE_PACKAGE = "pl.gsmservice.gateway";
    public static final String USER_AGENT = 
            String.format("speakeasy-sdk/%s %s %s %s %s", 
                LANGUAGE, SDK_VERSION, GEN_VERSION, OPENAPI_DOC_VERSION, BASE_PACKAGE);

    private Hooks _hooks = createHooks();

    private static Hooks createHooks() {
        Hooks hooks = new Hooks();
        return hooks;
    }
    
    public Hooks hooks() {
        return _hooks;
    }

    public void setHooks(Hooks hooks) {
        this._hooks = hooks;
    }

    /** 
     * Initializes state (for example hooks).
     **/
    public void initialize() {
        SDKHooks.initialize(_hooks);
        // apply the sdk init hook immediately
        SdkInitData data = _hooks.sdkInit(new SdkInitData(serverUrl, defaultClient));
        this.serverUrl = data.baseUrl();
        this.defaultClient = data.client();
    }

    
    
    public Optional<RetryConfig> retryConfig = Optional.empty();
}
