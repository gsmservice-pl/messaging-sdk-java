# Mms
(*outgoing().mms()*)

## Overview

### Available Operations

* [getPrice](#getprice) - Check the price of MMS Messages
* [send](#send) - Send MMS Messages

## getPrice

<br><br>Check the price of single or multiple MMS messages at the same time before sending them. You can pass a single `MmsMessage` object using `GetMmsPriceRequestBody.of(MmsMessage)` method (for single message) or `List<SmsMessage>` using `GetMmsPriceRequestBody.of(List.of(MmsMessage,...))` method (for multiple messages).<br><br>Each `MmsMessage` object has several properties, describing message parameters such recipient phone number, content of the message, attachments, etc. Please use builder style:<br>
```
GetMmsPriceResponse res = sdk.outgoing().mms().getPrice()
   .request(req) // here pass GetMmsPriceRequestBody.of(...) object
   .call();
```
<br>The method will accept maximum <strong>50</strong> messages in one call.<br><br>As a successful result a `GetMmsPriceResponse` object will be returned with `prices` property of type `List<Price>` containing a `Price` objects, one object per each single message. You should check the `error` property of each `Price` object to make sure which messages were priced successfully and which finished with an error. Successfully priced messages will have `null` value of `error` property.<br><br>`GetMmsPriceResponse` object will include also `headers` property with `X-Success-Count` (a count of messages which were processed successfully) and `X-Error-Count` (count of messages which were rejected) elements.

### Example Usage

<!-- UsageSnippet language="java" operationID="getMmsPrice" method="post" path="/messages/mms/price" -->
```java
package hello.world;

import java.lang.Exception;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.components.*;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.GetMmsPriceRequestBody;
import pl.gsmservice.gateway.models.operations.GetMmsPriceResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        GetMmsPriceRequestBody req = GetMmsPriceRequestBody.of(MmsMessage.builder()
                .recipients(Recipients.of("+48999999999"))
                .subject("This is a subject of the message")
                .message("This is MMS message content.")
                .attachments(Attachments.of("<file body in base64 format>"))
                .build());

        GetMmsPriceResponse res = sdk.outgoing().mms().getPrice()
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
| `request`                                                                   | [GetMmsPriceRequestBody](../../models/operations/GetMmsPriceRequestBody.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[GetMmsPriceResponse](../../models/operations/GetMmsPriceResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 401, 4XX               | application/problem+json    |
| models/errors/ErrorResponse | 5XX                         | application/problem+json    |

## send

<br><br>Send single or multiple MMS messages at the same time. You can pass a single `MmsMessage` object using `SendMmsRequestBody.of(MmsMessage)` method (for single message) or `List<MmsMessage>` using `SendMmsRequestBody.of(List.of(MmsMessage,...))` method (for multiple messages). Each `MmsMessage` object has several properties, describing message parameters such recipient phone number, content of the message, attachments or scheduled sending date, etc. Please use builder style:<br>
```
SendMmsResponse res = sdk.outgoing().mms().send()
   .request(req) // here pass GetMmsPriceRequestBody.of(...) object
   .call();
```
<br>This method will accept maximum 50 messages in one call.<br><br>As a successful result a `SendMmsResponse` object will be returned with `messages` property of type List<Message> containing `Message` objects, one object per each single message. You should check the `statusCode` property of each `Message` object to make sure which messages were accepted by gateway (queued) and which were rejected. In case of rejection, `statusDescription` property will include a reason.<br><br>`SendMmsResponse` will also include `headers` property with `X-Success-Count` (a count of messages which were processed successfully), `X-Error-Count` (count of messages which were rejected) and `X-Sandbox` (if a request was made in Sandbox or Production system) elements.

### Example Usage

<!-- UsageSnippet language="java" operationID="sendMms" method="post" path="/messages/mms" -->
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

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `request`                                                           | [SendMmsRequestBody](../../models/operations/SendMmsRequestBody.md) | :heavy_check_mark:                                                  | The request object to use for the request.                          |

### Response

**[SendMmsResponse](../../models/operations/SendMmsResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 401, 403, 4XX          | application/problem+json    |
| models/errors/ErrorResponse | 5XX                         | application/problem+json    |