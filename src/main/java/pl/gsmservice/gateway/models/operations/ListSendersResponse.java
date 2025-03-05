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
import java.util.Objects;
import java.util.Optional;
import pl.gsmservice.gateway.models.components.Sender;
import pl.gsmservice.gateway.utils.Response;
import pl.gsmservice.gateway.utils.Utils;

public class ListSendersResponse implements Response {

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
     * The request was processed successfully. Please find senders details in returned Sender objects
     */
    private Optional<? extends List<Sender>> senders;

    @JsonCreator
    public ListSendersResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends List<Sender>> senders) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(senders, "senders");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.senders = senders;
    }
    
    public ListSendersResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse) {
        this(contentType, statusCode, rawResponse, Optional.empty());
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
     * The request was processed successfully. Please find senders details in returned Sender objects
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<Sender>> senders() {
        return (Optional<List<Sender>>) senders;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * HTTP response content type for this operation
     */
    public ListSendersResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public ListSendersResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public ListSendersResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * The request was processed successfully. Please find senders details in returned Sender objects
     */
    public ListSendersResponse withSenders(List<Sender> senders) {
        Utils.checkNotNull(senders, "senders");
        this.senders = Optional.ofNullable(senders);
        return this;
    }

    /**
     * The request was processed successfully. Please find senders details in returned Sender objects
     */
    public ListSendersResponse withSenders(Optional<? extends List<Sender>> senders) {
        Utils.checkNotNull(senders, "senders");
        this.senders = senders;
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
        ListSendersResponse other = (ListSendersResponse) o;
        return 
            Objects.deepEquals(this.contentType, other.contentType) &&
            Objects.deepEquals(this.statusCode, other.statusCode) &&
            Objects.deepEquals(this.rawResponse, other.rawResponse) &&
            Objects.deepEquals(this.senders, other.senders);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            contentType,
            statusCode,
            rawResponse,
            senders);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListSendersResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "senders", senders);
    }
    
    public final static class Builder {
 
        private String contentType;
 
        private Integer statusCode;
 
        private HttpResponse<InputStream> rawResponse;
 
        private Optional<? extends List<Sender>> senders = Optional.empty();  
        
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
         * The request was processed successfully. Please find senders details in returned Sender objects
         */
        public Builder senders(List<Sender> senders) {
            Utils.checkNotNull(senders, "senders");
            this.senders = Optional.ofNullable(senders);
            return this;
        }

        /**
         * The request was processed successfully. Please find senders details in returned Sender objects
         */
        public Builder senders(Optional<? extends List<Sender>> senders) {
            Utils.checkNotNull(senders, "senders");
            this.senders = senders;
            return this;
        }
        
        public ListSendersResponse build() {
            return new ListSendersResponse(
                contentType,
                statusCode,
                rawResponse,
                senders);
        }
    }
}

