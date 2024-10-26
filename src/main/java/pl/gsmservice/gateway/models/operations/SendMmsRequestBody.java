/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package pl.gsmservice.gateway.models.operations;


import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Objects;
import pl.gsmservice.gateway.models.components.MmsMessage;
import pl.gsmservice.gateway.utils.OneOfDeserializer;
import pl.gsmservice.gateway.utils.TypedObject;
import pl.gsmservice.gateway.utils.Utils.JsonShape;
import pl.gsmservice.gateway.utils.Utils.TypeReferenceWithShape;
import pl.gsmservice.gateway.utils.Utils;

/**
 * SendMmsRequestBody - To send a single MMS or messages with the same content to multiple recipients, please use <code>SendMmsRequestBody.of(MmsMessage)</code> method with a single <code>MmsMessage</code> object with the properties of this message. To send multiple messages with different content at the same time, please use <code>SendMmsRequestBody.of(List.of(MmsMessage,...))</code> method passing to it <code>List&lt;MmsMessage&gt;</code> with the properties of each message.
 */

@JsonDeserialize(using = SendMmsRequestBody._Deserializer.class)
public class SendMmsRequestBody {

    @JsonValue
    private TypedObject value;
    
    private SendMmsRequestBody(TypedObject value) {
        this.value = value;
    }

    public static SendMmsRequestBody of(MmsMessage value) {
        Utils.checkNotNull(value, "value");
        return new SendMmsRequestBody(TypedObject.of(value, JsonShape.DEFAULT, new TypeReference<MmsMessage>(){}));
    }

    public static SendMmsRequestBody of(List<MmsMessage> value) {
        Utils.checkNotNull(value, "value");
        return new SendMmsRequestBody(TypedObject.of(value, JsonShape.DEFAULT, new TypeReference<List<MmsMessage>>(){}));
    }
    
    /**
     * Returns an instance of one of these types:
     * <ul>
     * <li>{@code pl.gsmservice.gateway.models.components.MmsMessage}</li>
     * <li>{@code java.util.List<pl.gsmservice.gateway.models.components.MmsMessage>}</li>
     * </ul>
     * 
     * <p>Use {@code instanceof} to determine what type is returned. For example:
     * 
     * <pre>
     * if (obj.value() instanceof String) {
     *     String answer = (String) obj.value();
     *     System.out.println("answer=" + answer);
     * }
     * </pre>
     * 
     * @return value of oneOf type
     **/ 
    public java.lang.Object value() {
        return value.value();
    }    
    
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SendMmsRequestBody other = (SendMmsRequestBody) o;
        return Objects.deepEquals(this.value.value(), other.value.value()); 
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(value.value());
    }
    
    @SuppressWarnings("serial")
    public static final class _Deserializer extends OneOfDeserializer<SendMmsRequestBody> {

        public _Deserializer() {
            super(SendMmsRequestBody.class, false,
                  TypeReferenceWithShape.of(new TypeReference<List<MmsMessage>>() {}, JsonShape.DEFAULT),
                  TypeReferenceWithShape.of(new TypeReference<MmsMessage>() {}, JsonShape.DEFAULT));
        }
    }
    
    @Override
    public String toString() {
        return Utils.toString(SendMmsRequestBody.class,
                "value", value);
    }
 
}