/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package pl.gsmservice.gateway.models.operations;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import pl.gsmservice.gateway.utils.SpeakeasyMetadata;
import pl.gsmservice.gateway.utils.Utils;


public class CancelMessagesRequest {

    /**
     * Message IDs assigned by the system (separated by comma). The system will accept a maximum of 50 identifiers in one call.
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=true,name=ids")
    private List<Long> ids;

    @JsonCreator
    public CancelMessagesRequest(
            List<Long> ids) {
        Utils.checkNotNull(ids, "ids");
        this.ids = ids;
    }

    /**
     * Message IDs assigned by the system (separated by comma). The system will accept a maximum of 50 identifiers in one call.
     */
    @JsonIgnore
    public List<Long> ids() {
        return ids;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * Message IDs assigned by the system (separated by comma). The system will accept a maximum of 50 identifiers in one call.
     */
    public CancelMessagesRequest withIds(List<Long> ids) {
        Utils.checkNotNull(ids, "ids");
        this.ids = ids;
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
        CancelMessagesRequest other = (CancelMessagesRequest) o;
        return 
            Objects.deepEquals(this.ids, other.ids);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            ids);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CancelMessagesRequest.class,
                "ids", ids);
    }
    
    public final static class Builder {
 
        private List<Long> ids;  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Message IDs assigned by the system (separated by comma). The system will accept a maximum of 50 identifiers in one call.
         */
        public Builder ids(List<Long> ids) {
            Utils.checkNotNull(ids, "ids");
            this.ids = ids;
            return this;
        }
        
        public CancelMessagesRequest build() {
            return new CancelMessagesRequest(
                ids);
        }
    }
}

