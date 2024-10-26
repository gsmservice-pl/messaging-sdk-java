<!-- Start SDK Example Usage [usage] -->
### Sending single SMS Message

This example demonstrates simple sending SMS message to a single recipient:

```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.components.SmsMessage;
import pl.gsmservice.gateway.models.components.SmsMessageRecipients;
import pl.gsmservice.gateway.models.components.SmsType;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.SendSmsRequestBody;
import pl.gsmservice.gateway.models.operations.SendSmsResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        SendSmsRequestBody req = SendSmsRequestBody.of(List.of(
                SmsMessage.builder()
                    .recipients(SmsMessageRecipients.ofArrayOfStrings(List.of(
                        "+48999999999")))
                    .message("To jest treść wiadomości")
                    .sender("Bramka SMS")
                    .type(SmsType.SmsPro)
                    .unicode(true)
                    .flash(false)
                    .date(JsonNullable.of(null))
                    .build()));

        SendSmsResponse res = sdk.outgoing().sms().send()
                .request(req)
                .call();

        if (res.messages().isPresent()) {
            // handle response
        }
    }
}
```

### Sending single MMS Message

This example demonstrates simple sending MMS message to a single recipient:

```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.components.Attachments;
import pl.gsmservice.gateway.models.components.MmsMessage;
import pl.gsmservice.gateway.models.components.Recipients;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.SendMmsRequestBody;
import pl.gsmservice.gateway.models.operations.SendMmsResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        SendMmsRequestBody req = SendMmsRequestBody.of(List.of(
                MmsMessage.builder()
                    .recipients(Recipients.of2(List.of(
                        "+48999999999")))
                    .message("To jest treść wiadomości")
                    .subject("To jest temat wiadomości")
                    .attachments(Attachments.of(List.of(
                        "<file_body in base64 format>")))
                    .date(JsonNullable.of(null))
                    .build()));

        SendMmsResponse res = sdk.outgoing().mms().send()
                .request(req)
                .call();

        if (res.messages().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->