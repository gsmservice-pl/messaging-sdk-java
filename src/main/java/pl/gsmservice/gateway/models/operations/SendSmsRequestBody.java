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
import pl.gsmservice.gateway.models.components.SmsMessage;
import pl.gsmservice.gateway.utils.OneOfDeserializer;
import pl.gsmservice.gateway.utils.TypedObject;
import pl.gsmservice.gateway.utils.Utils.JsonShape;
import pl.gsmservice.gateway.utils.Utils.TypeReferenceWithShape;
import pl.gsmservice.gateway.utils.Utils;
/**
 * SendSmsRequestBody - To send a single SMS or messages with the same content to multiple recipients, please use <code>SendSmsRequestBody.of(SmsMessage)</code> method with a single <code>SmsMessage</code> object with the properties of this message. To send multiple messages with different content at the same time, please use <code>SendSmsRequestBody.of(List.of(SmsMessage,...))</code> method passing to it <code>List&lt;SmsMessage&gt;</code> with the properties of each message.
 */

@JsonDeserialize(using = SendSmsRequestBody._Deserializer.class)
public class SendSmsRequestBody {

    @JsonValue
    private TypedObject value;
    
    private SendSmsRequestBody(TypedObject value) {
        this.value = value;
    }

    public static SendSmsRequestBody of(SmsMessage value) {
        Utils.checkNotNull(value, "value");
        return new SendSmsRequestBody(TypedObject.of(value, JsonShape.DEFAULT, new TypeReference<SmsMessage>(){}));
    }

    public static SendSmsRequestBody of(List<SmsMessage> value) {
        Utils.checkNotNull(value, "value");
        return new SendSmsRequestBody(TypedObject.of(value, JsonShape.DEFAULT, new TypeReference<List<SmsMessage>>(){}));
    }
    
    /**
     * Returns an instance of one of these types:
     * <ul>
     * <li>{@code pl.gsmservice.gateway.models.components.SmsMessage}</li>
     * <li>{@code java.util.List<pl.gsmservice.gateway.models.components.SmsMessage>}</li>
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
        SendSmsRequestBody other = (SendSmsRequestBody) o;
        return Objects.deepEquals(this.value.value(), other.value.value()); 
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(value.value());
    }
    
    @SuppressWarnings("serial")
    public static final class _Deserializer extends OneOfDeserializer<SendSmsRequestBody> {

        public _Deserializer() {
            super(SendSmsRequestBody.class, false,
                  TypeReferenceWithShape.of(new TypeReference<List<SmsMessage>>() {}, JsonShape.DEFAULT),
                  TypeReferenceWithShape.of(new TypeReference<SmsMessage>() {}, JsonShape.DEFAULT));
        }
    }
    
    @Override
    public String toString() {
        return Utils.toString(SendSmsRequestBody.class,
                "value", value);
    }
 
}
