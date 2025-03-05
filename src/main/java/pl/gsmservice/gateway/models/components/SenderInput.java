/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */


package pl.gsmservice.gateway.models.components;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import pl.gsmservice.gateway.utils.Utils;
/**
 * SenderInput - An object with the properties of the message sender
 */

public class SenderInput {

    /**
     * Message sender name
     */
    @JsonProperty("sender")
    private String sender;

    /**
     * Description of the purpose of the sender name (required when adding new sender name)
     */
    @JsonProperty("description")
    private String description;

    @JsonCreator
    public SenderInput(
            @JsonProperty("sender") String sender,
            @JsonProperty("description") String description) {
        Utils.checkNotNull(sender, "sender");
        Utils.checkNotNull(description, "description");
        this.sender = sender;
        this.description = description;
    }

    /**
     * Message sender name
     */
    @JsonIgnore
    public String sender() {
        return sender;
    }

    /**
     * Description of the purpose of the sender name (required when adding new sender name)
     */
    @JsonIgnore
    public String description() {
        return description;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * Message sender name
     */
    public SenderInput withSender(String sender) {
        Utils.checkNotNull(sender, "sender");
        this.sender = sender;
        return this;
    }

    /**
     * Description of the purpose of the sender name (required when adding new sender name)
     */
    public SenderInput withDescription(String description) {
        Utils.checkNotNull(description, "description");
        this.description = description;
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
        SenderInput other = (SenderInput) o;
        return 
            Objects.deepEquals(this.sender, other.sender) &&
            Objects.deepEquals(this.description, other.description);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            sender,
            description);
    }
    
    @Override
    public String toString() {
        return Utils.toString(SenderInput.class,
                "sender", sender,
                "description", description);
    }
    
    public final static class Builder {
 
        private String sender;
 
        private String description;  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Message sender name
         */
        public Builder sender(String sender) {
            Utils.checkNotNull(sender, "sender");
            this.sender = sender;
            return this;
        }

        /**
         * Description of the purpose of the sender name (required when adding new sender name)
         */
        public Builder description(String description) {
            Utils.checkNotNull(description, "description");
            this.description = description;
            return this;
        }
        
        public SenderInput build() {
            return new SenderInput(
                sender,
                description);
        }
    }
}

