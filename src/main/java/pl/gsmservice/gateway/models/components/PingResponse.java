/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package pl.gsmservice.gateway.models.components;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import pl.gsmservice.gateway.utils.Utils;

/**
 * PingResponse - 'Ping' response object
 */

public class PingResponse {

    /**
     * API service status: OK - API available, ERR - API unavailable
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("status")
    private Optional<String> status;

    /**
     * Current API Version
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("version")
    private Optional<String> version;

    /**
     * Was the connection established with the test system (SANDBOX)?
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("sandbox")
    private Optional<Boolean> sandbox;

    @JsonCreator
    public PingResponse(
            @JsonProperty("status") Optional<String> status,
            @JsonProperty("version") Optional<String> version,
            @JsonProperty("sandbox") Optional<Boolean> sandbox) {
        Utils.checkNotNull(status, "status");
        Utils.checkNotNull(version, "version");
        Utils.checkNotNull(sandbox, "sandbox");
        this.status = status;
        this.version = version;
        this.sandbox = sandbox;
    }
    
    public PingResponse() {
        this(Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * API service status: OK - API available, ERR - API unavailable
     */
    @JsonIgnore
    public Optional<String> status() {
        return status;
    }

    /**
     * Current API Version
     */
    @JsonIgnore
    public Optional<String> version() {
        return version;
    }

    /**
     * Was the connection established with the test system (SANDBOX)?
     */
    @JsonIgnore
    public Optional<Boolean> sandbox() {
        return sandbox;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * API service status: OK - API available, ERR - API unavailable
     */
    public PingResponse withStatus(String status) {
        Utils.checkNotNull(status, "status");
        this.status = Optional.ofNullable(status);
        return this;
    }

    /**
     * API service status: OK - API available, ERR - API unavailable
     */
    public PingResponse withStatus(Optional<String> status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
        return this;
    }

    /**
     * Current API Version
     */
    public PingResponse withVersion(String version) {
        Utils.checkNotNull(version, "version");
        this.version = Optional.ofNullable(version);
        return this;
    }

    /**
     * Current API Version
     */
    public PingResponse withVersion(Optional<String> version) {
        Utils.checkNotNull(version, "version");
        this.version = version;
        return this;
    }

    /**
     * Was the connection established with the test system (SANDBOX)?
     */
    public PingResponse withSandbox(boolean sandbox) {
        Utils.checkNotNull(sandbox, "sandbox");
        this.sandbox = Optional.ofNullable(sandbox);
        return this;
    }

    /**
     * Was the connection established with the test system (SANDBOX)?
     */
    public PingResponse withSandbox(Optional<Boolean> sandbox) {
        Utils.checkNotNull(sandbox, "sandbox");
        this.sandbox = sandbox;
        return this;
    }
    
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PingResponse other = (PingResponse) o;
        return 
            Objects.deepEquals(this.status, other.status) &&
            Objects.deepEquals(this.version, other.version) &&
            Objects.deepEquals(this.sandbox, other.sandbox);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            status,
            version,
            sandbox);
    }
    
    @Override
    public String toString() {
        return Utils.toString(PingResponse.class,
                "status", status,
                "version", version,
                "sandbox", sandbox);
    }
    
    public final static class Builder {
 
        private Optional<String> status = Optional.empty();
 
        private Optional<String> version = Optional.empty();
 
        private Optional<Boolean> sandbox = Optional.empty();  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * API service status: OK - API available, ERR - API unavailable
         */
        public Builder status(String status) {
            Utils.checkNotNull(status, "status");
            this.status = Optional.ofNullable(status);
            return this;
        }

        /**
         * API service status: OK - API available, ERR - API unavailable
         */
        public Builder status(Optional<String> status) {
            Utils.checkNotNull(status, "status");
            this.status = status;
            return this;
        }

        /**
         * Current API Version
         */
        public Builder version(String version) {
            Utils.checkNotNull(version, "version");
            this.version = Optional.ofNullable(version);
            return this;
        }

        /**
         * Current API Version
         */
        public Builder version(Optional<String> version) {
            Utils.checkNotNull(version, "version");
            this.version = version;
            return this;
        }

        /**
         * Was the connection established with the test system (SANDBOX)?
         */
        public Builder sandbox(boolean sandbox) {
            Utils.checkNotNull(sandbox, "sandbox");
            this.sandbox = Optional.ofNullable(sandbox);
            return this;
        }

        /**
         * Was the connection established with the test system (SANDBOX)?
         */
        public Builder sandbox(Optional<Boolean> sandbox) {
            Utils.checkNotNull(sandbox, "sandbox");
            this.sandbox = sandbox;
            return this;
        }
        
        public PingResponse build() {
            return new PingResponse(
                status,
                version,
                sandbox);
        }
    }
}

