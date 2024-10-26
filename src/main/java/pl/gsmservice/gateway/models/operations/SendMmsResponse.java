/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package pl.gsmservice.gateway.models.operations;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.InputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import pl.gsmservice.gateway.models.components.Message;
import pl.gsmservice.gateway.utils.Response;
import pl.gsmservice.gateway.utils.Utils;


public class SendMmsResponse implements Response {

    /**
     * HTTP response content type for this operation
     */
    private String contentType;

    /**
     * HTTP response status code for this operation
     */
    private int statusCode;

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    private HttpResponse<InputStream> rawResponse;

    /**
     * The request was processed successfully. Please check statuses of particular messages in each <code>Message</code> object.
     */
    private Optional<? extends List<Message>> messages;

    private Map<String, List<String>> headers;

    @JsonCreator
    public SendMmsResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends List<Message>> messages,
            Map<String, List<String>> headers) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(messages, "messages");
        headers = Utils.emptyMapIfNull(headers);
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.messages = messages;
        this.headers = headers;
    }
    
    public SendMmsResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Map<String, List<String>> headers) {
        this(contentType, statusCode, rawResponse, Optional.empty(), headers);
    }

    /**
     * HTTP response content type for this operation
     */
    @JsonIgnore
    public String contentType() {
        return contentType;
    }

    /**
     * HTTP response status code for this operation
     */
    @JsonIgnore
    public int statusCode() {
        return statusCode;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    @JsonIgnore
    public HttpResponse<InputStream> rawResponse() {
        return rawResponse;
    }

    /**
     * The request was processed successfully. Please check statuses of particular messages in each <code>Message</code> object.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<Message>> messages() {
        return (Optional<List<Message>>) messages;
    }

    @JsonIgnore
    public Map<String, List<String>> headers() {
        return headers;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * HTTP response content type for this operation
     */
    public SendMmsResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public SendMmsResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public SendMmsResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * The request was processed successfully. Please check statuses of particular messages in each <code>Message</code> object.
     */
    public SendMmsResponse withMessages(List<Message> messages) {
        Utils.checkNotNull(messages, "messages");
        this.messages = Optional.ofNullable(messages);
        return this;
    }

    /**
     * The request was processed successfully. Please check statuses of particular messages in each <code>Message</code> object.
     */
    public SendMmsResponse withMessages(Optional<? extends List<Message>> messages) {
        Utils.checkNotNull(messages, "messages");
        this.messages = messages;
        return this;
    }

    public SendMmsResponse withHeaders(Map<String, List<String>> headers) {
        Utils.checkNotNull(headers, "headers");
        this.headers = headers;
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
        SendMmsResponse other = (SendMmsResponse) o;
        return 
            Objects.deepEquals(this.contentType, other.contentType) &&
            Objects.deepEquals(this.statusCode, other.statusCode) &&
            Objects.deepEquals(this.rawResponse, other.rawResponse) &&
            Objects.deepEquals(this.messages, other.messages) &&
            Objects.deepEquals(this.headers, other.headers);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            contentType,
            statusCode,
            rawResponse,
            messages,
            headers);
    }
    
    @Override
    public String toString() {
        return Utils.toString(SendMmsResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "messages", messages,
                "headers", headers);
    }
    
    public final static class Builder {
 
        private String contentType;
 
        private Integer statusCode;
 
        private HttpResponse<InputStream> rawResponse;
 
        private Optional<? extends List<Message>> messages = Optional.empty();
 
        private Map<String, List<String>> headers;  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * HTTP response content type for this operation
         */
        public Builder contentType(String contentType) {
            Utils.checkNotNull(contentType, "contentType");
            this.contentType = contentType;
            return this;
        }

        /**
         * HTTP response status code for this operation
         */
        public Builder statusCode(int statusCode) {
            Utils.checkNotNull(statusCode, "statusCode");
            this.statusCode = statusCode;
            return this;
        }

        /**
         * Raw HTTP response; suitable for custom response parsing
         */
        public Builder rawResponse(HttpResponse<InputStream> rawResponse) {
            Utils.checkNotNull(rawResponse, "rawResponse");
            this.rawResponse = rawResponse;
            return this;
        }

        /**
         * The request was processed successfully. Please check statuses of particular messages in each <code>Message</code> object.
         */
        public Builder messages(List<Message> messages) {
            Utils.checkNotNull(messages, "messages");
            this.messages = Optional.ofNullable(messages);
            return this;
        }

        /**
         * The request was processed successfully. Please check statuses of particular messages in each <code>Message</code> object.
         */
        public Builder messages(Optional<? extends List<Message>> messages) {
            Utils.checkNotNull(messages, "messages");
            this.messages = messages;
            return this;
        }

        public Builder headers(Map<String, List<String>> headers) {
            Utils.checkNotNull(headers, "headers");
            this.headers = headers;
            return this;
        }
        
        public SendMmsResponse build() {
            return new SendMmsResponse(
                contentType,
                statusCode,
                rawResponse,
                messages,
                headers);
        }
    }
}

