/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package pl.gsmservice.gateway;

import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import pl.gsmservice.gateway.utils.HTTPClient;
import pl.gsmservice.gateway.utils.RetryConfig;
import pl.gsmservice.gateway.utils.SpeakeasyHTTPClient;
import pl.gsmservice.gateway.utils.Utils;

/**
 * Messaging Gateway SzybkiSMS.pl (former GSMService.pl): 
 * <br>
 * <br>This package includes Messaging SDK for JAVA to send SMS &amp; MMS messages directly from your app via <a href="https://szybkisms.pl">https://szybkisms.pl</a> messaging platform.
 * <br>
 * <br><em>Client</em> class is used to initialize SDK environment.
 * <br>
 * <br>Please initialize it this way:
 * <br>
 * <pre><code>
 * import java.lang.Exception;
 * import pl.gsmservice.gateway.Client;
 * import pl.gsmservice.gateway.models.errors.ErrorResponse;
 * 
 * Client sdk = Client.builder()
 *    .bearer("&lt;YOUR API ACCESS TOKEN&gt;")
 *    .build();
 * </code></pre>
 * 
 * <br>If you want to use a Sandbox test system please initialize it as follows:
 * <br>
 * <pre><code>
 * Client sdk = Client.builder()
 *    .server(Client.AvailableServers.SANDBOX)
 *    .bearer("&lt;YOUR API ACCESS TOKEN&gt;")
 *    .build();
 * </code></pre>
 */
public class Client {

  
    /**
     * AvailableServers contains identifiers for the servers available to the SDK.
     */
    public enum AvailableServers {
        /**
         * PROD - Production system
         */
      PROD("prod"),
        /**
         * SANDBOX - Test system (SANDBOX)
         */
      SANDBOX("sandbox");

        private final String server;

        private AvailableServers(String server) {
            this.server = server;
        }

        public String server() {
           return server;
        }
    }

    /**
     * SERVERS contains the list of server urls available to the SDK.
     */
    @SuppressWarnings("serial")
    public static final Map<AvailableServers, String> SERVERS = new HashMap<>() { {
    put(AvailableServers.PROD, "https://api.szybkisms.pl/rest");
    put(AvailableServers.SANDBOX, "https://api.szybkisms.pl/rest-sandbox");
    }};

    private final Accounts accounts;

    private final Outgoing outgoing;

    private final Incoming incoming;

    private final Common common;

    private final Senders senders;

    public Accounts accounts() {
        return accounts;
    }

    public Outgoing outgoing() {
        return outgoing;
    }

    public Incoming incoming() {
        return incoming;
    }

    public Common common() {
        return common;
    }

    public Senders senders() {
        return senders;
    }

    private final SDKConfiguration sdkConfiguration;

    /**
     * The Builder class allows the configuration of a new instance of the SDK.
     */
    public static class Builder {

        private final SDKConfiguration sdkConfiguration = new SDKConfiguration();

        private Builder() {
        }

        /**
         * Allows the default HTTP client to be overridden with a custom implementation.
         *
         * @param client The HTTP client to use for all requests.
         * @return The builder instance.
         */
        public Builder client(HTTPClient client) {
            this.sdkConfiguration.defaultClient = client;
            return this;
        }
        /**
         * Configures the SDK security to use the provided secret.
         *
         * @param bearer The secret to use for all requests.
         * @return The builder instance.
         */
        public Builder bearer(String bearer) {
            this.sdkConfiguration.securitySource = SecuritySource.of(pl.gsmservice.gateway.models.components.Security.builder()
              .bearer(bearer)
              .build());
            return this;
        }

        /**
         * Configures the SDK to use a custom security source.
         * @param securitySource The security source to use for all requests.
         * @return The builder instance.
         */
        public Builder securitySource(SecuritySource securitySource) {
            this.sdkConfiguration.securitySource = securitySource;
            return this;
        }
        
        /**
         * Overrides the default server URL.
         *
         * @param serverUrl The server URL to use for all requests.
         * @return The builder instance.
         */
        public Builder serverURL(String serverUrl) {
            this.sdkConfiguration.serverUrl = serverUrl;
            return this;
        }

        /**
         * Overrides the default server URL  with a templated URL populated with the provided parameters.
         *
         * @param serverUrl The server URL to use for all requests.
         * @param params The parameters to use when templating the URL.
         * @return The builder instance.
         */
        public Builder serverURL(String serverUrl, Map<String, String> params) {
            this.sdkConfiguration.serverUrl = Utils.templateUrl(serverUrl, params);
            return this;
        }
        
        /**
         * Overrides the default server by name.
         *
         * @param server The server to use for all requests.
         * @return The builder instance.
         */
        public Builder server(AvailableServers server) {
            this.sdkConfiguration.server = server.server();
            this.sdkConfiguration.serverUrl = SERVERS.get(server);
            return this;
        }
        
        /**
         * Overrides the default configuration for retries
         *
         * @param retryConfig The retry configuration to use for all requests.
         * @return The builder instance.
         */
        public Builder retryConfig(RetryConfig retryConfig) {
            this.sdkConfiguration.retryConfig = Optional.of(retryConfig);
            return this;
        }
        /**
         * Builds a new instance of the SDK.
         * @return The SDK instance.
         */
        public Client build() {
            if (sdkConfiguration.defaultClient == null) {
                sdkConfiguration.defaultClient = new SpeakeasyHTTPClient();
            }
	        if (sdkConfiguration.securitySource == null) {
	    	    sdkConfiguration.securitySource = SecuritySource.of(null);
	        }
            if (sdkConfiguration.serverUrl == null || sdkConfiguration.serverUrl.isBlank()) {
                sdkConfiguration.serverUrl = SERVERS.get(AvailableServers.PROD);
                sdkConfiguration.server = AvailableServers.PROD.server();
            }
            if (sdkConfiguration.serverUrl.endsWith("/")) {
                sdkConfiguration.serverUrl = sdkConfiguration.serverUrl.substring(0, sdkConfiguration.serverUrl.length() - 1);
            }
            return new Client(sdkConfiguration);
        }
    }
    
    /**
     * Get a new instance of the SDK builder to configure a new instance of the SDK.
     * @return The SDK builder instance.
     */
    public static Builder builder() {
        return new Builder();
    }

    private Client(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.accounts = new Accounts(sdkConfiguration);
        this.outgoing = new Outgoing(sdkConfiguration);
        this.incoming = new Incoming(sdkConfiguration);
        this.common = new Common(sdkConfiguration);
        this.senders = new Senders(sdkConfiguration);
        this.sdkConfiguration.initialize();
    }}
