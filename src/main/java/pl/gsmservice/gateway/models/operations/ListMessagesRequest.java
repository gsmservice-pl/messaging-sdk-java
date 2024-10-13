/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package pl.gsmservice.gateway.models.operations;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import pl.gsmservice.gateway.utils.LazySingletonValue;
import pl.gsmservice.gateway.utils.SpeakeasyMetadata;
import pl.gsmservice.gateway.utils.Utils;


public class ListMessagesRequest {

    /**
     * Page number of results
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=page")
    private Optional<Long> page;

    /**
     * Number of results on one page
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=limit")
    private Optional<Long> limit;

    @JsonCreator
    public ListMessagesRequest(
            Optional<Long> page,
            Optional<Long> limit) {
        Utils.checkNotNull(page, "page");
        Utils.checkNotNull(limit, "limit");
        this.page = page;
        this.limit = limit;
    }
    
    public ListMessagesRequest() {
        this(Optional.empty(), Optional.empty());
    }

    /**
     * Page number of results
     */
    @JsonIgnore
    public Optional<Long> page() {
        return page;
    }

    /**
     * Number of results on one page
     */
    @JsonIgnore
    public Optional<Long> limit() {
        return limit;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * Page number of results
     */
    public ListMessagesRequest withPage(long page) {
        Utils.checkNotNull(page, "page");
        this.page = Optional.ofNullable(page);
        return this;
    }

    /**
     * Page number of results
     */
    public ListMessagesRequest withPage(Optional<Long> page) {
        Utils.checkNotNull(page, "page");
        this.page = page;
        return this;
    }

    /**
     * Number of results on one page
     */
    public ListMessagesRequest withLimit(long limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = Optional.ofNullable(limit);
        return this;
    }

    /**
     * Number of results on one page
     */
    public ListMessagesRequest withLimit(Optional<Long> limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = limit;
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
        ListMessagesRequest other = (ListMessagesRequest) o;
        return 
            Objects.deepEquals(this.page, other.page) &&
            Objects.deepEquals(this.limit, other.limit);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            page,
            limit);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListMessagesRequest.class,
                "page", page,
                "limit", limit);
    }
    
    public final static class Builder {
 
        private Optional<Long> page;
 
        private Optional<Long> limit;  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Page number of results
         */
        public Builder page(long page) {
            Utils.checkNotNull(page, "page");
            this.page = Optional.ofNullable(page);
            return this;
        }

        /**
         * Page number of results
         */
        public Builder page(Optional<Long> page) {
            Utils.checkNotNull(page, "page");
            this.page = page;
            return this;
        }

        /**
         * Number of results on one page
         */
        public Builder limit(long limit) {
            Utils.checkNotNull(limit, "limit");
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        /**
         * Number of results on one page
         */
        public Builder limit(Optional<Long> limit) {
            Utils.checkNotNull(limit, "limit");
            this.limit = limit;
            return this;
        }
        
        public ListMessagesRequest build() {
            if (page == null) {
                page = _SINGLETON_VALUE_Page.value();
            }
            if (limit == null) {
                limit = _SINGLETON_VALUE_Limit.value();
            }            return new ListMessagesRequest(
                page,
                limit);
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
}

