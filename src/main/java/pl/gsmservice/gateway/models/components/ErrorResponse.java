/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */


package pl.gsmservice.gateway.models.components;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import pl.gsmservice.gateway.utils.Utils;
/**
 * ErrorResponse - An object that complies with RFC 9457 containing information about a request error
 */

public class ErrorResponse {

    /**
     * A URI reference that identifies the problem type
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("type")
    private Optional<String> type;

    /**
     * The HTTP status code generated by the origin server for this occurrence of the problem
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("status")
    private Optional<Long> status;

    /**
     * A short, human-readable summary of the problem type
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("title")
    private Optional<String> title;

    /**
     * A human-readable explanation specific to this occurrence of the problem
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("detail")
    private Optional<String> detail;

    /**
     * An API specific error code aiding the provider team understand the error based on their own potential taxonomy or registry
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("code")
    private Optional<String> code;

    /**
     * A URI reference that identifies the specific occurrence of the problem
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("instance")
    private Optional<String> instance;

    @JsonCreator
    public ErrorResponse(
            @JsonProperty("type") Optional<String> type,
            @JsonProperty("status") Optional<Long> status,
            @JsonProperty("title") Optional<String> title,
            @JsonProperty("detail") Optional<String> detail,
            @JsonProperty("code") Optional<String> code,
            @JsonProperty("instance") Optional<String> instance) {
        Utils.checkNotNull(type, "type");
        Utils.checkNotNull(status, "status");
        Utils.checkNotNull(title, "title");
        Utils.checkNotNull(detail, "detail");
        Utils.checkNotNull(code, "code");
        Utils.checkNotNull(instance, "instance");
        this.type = type;
        this.status = status;
        this.title = title;
        this.detail = detail;
        this.code = code;
        this.instance = instance;
    }
    
    public ErrorResponse() {
        this(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * A URI reference that identifies the problem type
     */
    @JsonIgnore
    public Optional<String> type() {
        return type;
    }

    /**
     * The HTTP status code generated by the origin server for this occurrence of the problem
     */
    @JsonIgnore
    public Optional<Long> status() {
        return status;
    }

    /**
     * A short, human-readable summary of the problem type
     */
    @JsonIgnore
    public Optional<String> title() {
        return title;
    }

    /**
     * A human-readable explanation specific to this occurrence of the problem
     */
    @JsonIgnore
    public Optional<String> detail() {
        return detail;
    }

    /**
     * An API specific error code aiding the provider team understand the error based on their own potential taxonomy or registry
     */
    @JsonIgnore
    public Optional<String> code() {
        return code;
    }

    /**
     * A URI reference that identifies the specific occurrence of the problem
     */
    @JsonIgnore
    public Optional<String> instance() {
        return instance;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * A URI reference that identifies the problem type
     */
    public ErrorResponse withType(String type) {
        Utils.checkNotNull(type, "type");
        this.type = Optional.ofNullable(type);
        return this;
    }

    /**
     * A URI reference that identifies the problem type
     */
    public ErrorResponse withType(Optional<String> type) {
        Utils.checkNotNull(type, "type");
        this.type = type;
        return this;
    }

    /**
     * The HTTP status code generated by the origin server for this occurrence of the problem
     */
    public ErrorResponse withStatus(long status) {
        Utils.checkNotNull(status, "status");
        this.status = Optional.ofNullable(status);
        return this;
    }

    /**
     * The HTTP status code generated by the origin server for this occurrence of the problem
     */
    public ErrorResponse withStatus(Optional<Long> status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
        return this;
    }

    /**
     * A short, human-readable summary of the problem type
     */
    public ErrorResponse withTitle(String title) {
        Utils.checkNotNull(title, "title");
        this.title = Optional.ofNullable(title);
        return this;
    }

    /**
     * A short, human-readable summary of the problem type
     */
    public ErrorResponse withTitle(Optional<String> title) {
        Utils.checkNotNull(title, "title");
        this.title = title;
        return this;
    }

    /**
     * A human-readable explanation specific to this occurrence of the problem
     */
    public ErrorResponse withDetail(String detail) {
        Utils.checkNotNull(detail, "detail");
        this.detail = Optional.ofNullable(detail);
        return this;
    }

    /**
     * A human-readable explanation specific to this occurrence of the problem
     */
    public ErrorResponse withDetail(Optional<String> detail) {
        Utils.checkNotNull(detail, "detail");
        this.detail = detail;
        return this;
    }

    /**
     * An API specific error code aiding the provider team understand the error based on their own potential taxonomy or registry
     */
    public ErrorResponse withCode(String code) {
        Utils.checkNotNull(code, "code");
        this.code = Optional.ofNullable(code);
        return this;
    }

    /**
     * An API specific error code aiding the provider team understand the error based on their own potential taxonomy or registry
     */
    public ErrorResponse withCode(Optional<String> code) {
        Utils.checkNotNull(code, "code");
        this.code = code;
        return this;
    }

    /**
     * A URI reference that identifies the specific occurrence of the problem
     */
    public ErrorResponse withInstance(String instance) {
        Utils.checkNotNull(instance, "instance");
        this.instance = Optional.ofNullable(instance);
        return this;
    }

    /**
     * A URI reference that identifies the specific occurrence of the problem
     */
    public ErrorResponse withInstance(Optional<String> instance) {
        Utils.checkNotNull(instance, "instance");
        this.instance = instance;
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
        ErrorResponse other = (ErrorResponse) o;
        return 
            Objects.deepEquals(this.type, other.type) &&
            Objects.deepEquals(this.status, other.status) &&
            Objects.deepEquals(this.title, other.title) &&
            Objects.deepEquals(this.detail, other.detail) &&
            Objects.deepEquals(this.code, other.code) &&
            Objects.deepEquals(this.instance, other.instance);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            type,
            status,
            title,
            detail,
            code,
            instance);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ErrorResponse.class,
                "type", type,
                "status", status,
                "title", title,
                "detail", detail,
                "code", code,
                "instance", instance);
    }
    
    public final static class Builder {
 
        private Optional<String> type = Optional.empty();
 
        private Optional<Long> status = Optional.empty();
 
        private Optional<String> title = Optional.empty();
 
        private Optional<String> detail = Optional.empty();
 
        private Optional<String> code = Optional.empty();
 
        private Optional<String> instance = Optional.empty();  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * A URI reference that identifies the problem type
         */
        public Builder type(String type) {
            Utils.checkNotNull(type, "type");
            this.type = Optional.ofNullable(type);
            return this;
        }

        /**
         * A URI reference that identifies the problem type
         */
        public Builder type(Optional<String> type) {
            Utils.checkNotNull(type, "type");
            this.type = type;
            return this;
        }

        /**
         * The HTTP status code generated by the origin server for this occurrence of the problem
         */
        public Builder status(long status) {
            Utils.checkNotNull(status, "status");
            this.status = Optional.ofNullable(status);
            return this;
        }

        /**
         * The HTTP status code generated by the origin server for this occurrence of the problem
         */
        public Builder status(Optional<Long> status) {
            Utils.checkNotNull(status, "status");
            this.status = status;
            return this;
        }

        /**
         * A short, human-readable summary of the problem type
         */
        public Builder title(String title) {
            Utils.checkNotNull(title, "title");
            this.title = Optional.ofNullable(title);
            return this;
        }

        /**
         * A short, human-readable summary of the problem type
         */
        public Builder title(Optional<String> title) {
            Utils.checkNotNull(title, "title");
            this.title = title;
            return this;
        }

        /**
         * A human-readable explanation specific to this occurrence of the problem
         */
        public Builder detail(String detail) {
            Utils.checkNotNull(detail, "detail");
            this.detail = Optional.ofNullable(detail);
            return this;
        }

        /**
         * A human-readable explanation specific to this occurrence of the problem
         */
        public Builder detail(Optional<String> detail) {
            Utils.checkNotNull(detail, "detail");
            this.detail = detail;
            return this;
        }

        /**
         * An API specific error code aiding the provider team understand the error based on their own potential taxonomy or registry
         */
        public Builder code(String code) {
            Utils.checkNotNull(code, "code");
            this.code = Optional.ofNullable(code);
            return this;
        }

        /**
         * An API specific error code aiding the provider team understand the error based on their own potential taxonomy or registry
         */
        public Builder code(Optional<String> code) {
            Utils.checkNotNull(code, "code");
            this.code = code;
            return this;
        }

        /**
         * A URI reference that identifies the specific occurrence of the problem
         */
        public Builder instance(String instance) {
            Utils.checkNotNull(instance, "instance");
            this.instance = Optional.ofNullable(instance);
            return this;
        }

        /**
         * A URI reference that identifies the specific occurrence of the problem
         */
        public Builder instance(Optional<String> instance) {
            Utils.checkNotNull(instance, "instance");
            this.instance = instance;
            return this;
        }
        
        public ErrorResponse build() {
            return new ErrorResponse(
                type,
                status,
                title,
                detail,
                code,
                instance);
        }
    }
}

