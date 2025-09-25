<!-- Start SDK Example Usage [usage] -->
### Sending single SMS Message

This example demonstrates simple sending SMS message to a single recipient:

```java
package hello.world;

import java.lang.Exception;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.components.SmsMessage;
import pl.gsmservice.gateway.models.components.SmsMessageRecipients;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.SendSmsRequestBody;
import pl.gsmservice.gateway.models.operations.SendSmsResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        SendSmsRequestBody req = SendSmsRequestBody.of(SmsMessage.builder()
                .recipients(SmsMessageRecipients.of("+48999999999"))
                .message("This is SMS message content.")
                .unicode(true)
                .build());

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
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.components.*;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.SendMmsRequestBody;
import pl.gsmservice.gateway.models.operations.SendMmsResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        SendMmsRequestBody req = SendMmsRequestBody.of(MmsMessage.builder()
                .recipients(Recipients.of("+48999999999"))
                .subject("This is a subject of the message")
                .message("This is MMS message content.")
                .attachments(Attachments.of("<file body in base64 format>"))
                .build());

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