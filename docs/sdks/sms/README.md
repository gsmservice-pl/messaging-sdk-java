# Sms
(*outgoing().sms()*)

## Overview

### Available Operations

* [getPrice](#getprice) - Check the price of SMS Messages
* [send](#send) - Send SMS Messages

## getPrice

<br><br>Check the price of single or multiple SMS messages at the same time before sending them. You can pass a single `SmsMessage` object using `GetSmsPriceRequestBody.of(SmsMessage)` method (for single message) or `List<SmsMessage>` using `GetSmsPriceRequestBody.of(List.of(SmsMessage,...))` method (for multiple messages).<br><br>Each `SmsMessage` object has several properties, describing message parameters such as recipient phone number, content of the message, type, etc. Please use builder style:<br>
```
GetSmsPriceResponse res = sdk.outgoing().sms().getPrice()
   .request(req) // here pass GetSmsPriceRequestBody.of(...) object
   .call();
```
<br>The method will accept maximum <strong>100</strong> messages in one call.<br><br>As a successful result a `GetSmsPriceResponse` object will be returned with `prices` property of type `List<Price>` containing a `Price` objects, one object per each single message. You should check the `error` property of each `Price` object to make sure which messages were priced successfully and which finished with an error. Successfully priced messages will have `null` value of `error` property.<br><br>`GetSmsPriceResponse` object will include also `headers` property with `X-Success-Count` (a count of messages which were processed successfully) and `X-Error-Count` (count of messages which were rejected) elements.

### Example Usage

```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.components.PhoneNumberWithCid;
import pl.gsmservice.gateway.models.components.SmsMessage;
import pl.gsmservice.gateway.models.components.SmsMessageRecipients;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.GetSmsPriceRequestBody;
import pl.gsmservice.gateway.models.operations.GetSmsPriceResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        GetSmsPriceRequestBody req = GetSmsPriceRequestBody.of(List.of(
                SmsMessage.builder()
                    .recipients(SmsMessageRecipients.of(PhoneNumberWithCid.builder()
                        .nr("+48999999999")
                        .cid("my-id-1113")
                        .build()))
                    .message("To jest treść wiadomości")
                    .build()));

        GetSmsPriceResponse res = sdk.outgoing().sms().getPrice()
                .request(req)
                .call();

        if (res.prices().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [GetSmsPriceRequestBody](../../models/operations/GetSmsPriceRequestBody.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[GetSmsPriceResponse](../../models/operations/GetSmsPriceResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 401, 4XX               | application/problem+json    |
| models/errors/ErrorResponse | 5XX                         | application/problem+json    |

## send

<br><br>Send single or multiple SMS messages at the same time. You can pass a single `SmsMessage` object using `SendSmsRequestBody.of(SmsMessage)` method (for single message) or `List<SmsMessage>` using `SendSmsRequestBody.of(List.of(SmsMessage,...))` method (for multiple messages). Each `SmsMessage` object has several properties, describing message parameters such recipient phone number, content of the message, type or scheduled sending date, etc. Please use builder style:<br>
```
SendSmsResponse res = sdk.outgoing().sms().send()
   .request(req) // here pass GetSmsPriceRequestBody.of(...) object
   .call();
```
<br>This method will accept maximum 100 messages in one call.<br><br>As a successful result a `SendSmsResponse` object will be returned with `messages` property of type List<Message> containing `Message` objects, one object per each single message. You should check the `statusCode` property of each `Message` object to make sure which messages were accepted by gateway (queued) and which were rejected. In case of rejection, `statusDescription` property will include a reason.<br><br>`SendSmsResponse` will also include `headers` property with `X-Success-Count` (a count of messages which were processed successfully), `X-Error-Count` (count of messages which were rejected) and `X-Sandbox` (if a request was made in Sandbox or Production system) elements.

### Example Usage

```java
package hello.world;

import java.lang.Exception;
import java.util.List;
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

        SendSmsRequestBody req = SendSmsRequestBody.of(List.of(
                SmsMessage.builder()
                    .recipients(SmsMessageRecipients.ofArrayOfStrings(List.of(
                        "+48999999999")))
                    .message("To jest treść wiadomości")
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

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `request`                                                           | [SendSmsRequestBody](../../models/operations/SendSmsRequestBody.md) | :heavy_check_mark:                                                  | The request object to use for the request.                          |

### Response

**[SendSmsResponse](../../models/operations/SendSmsResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 401, 403, 4XX          | application/problem+json    |
| models/errors/ErrorResponse | 5XX                         | application/problem+json    |