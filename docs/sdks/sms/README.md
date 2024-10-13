# Sms
(*outgoing().sms()*)

## Overview

### Available Operations

* [getPrice](#getprice) - Check the price of SMS Messages
* [send](#send) - Send SMS Messages

## getPrice

Check the price of single or multiple SMS messages at the same time before sending them. You have to pass as request body the `Sms` object (for single message) or `array` of `Sms` objects (for multiple messages). Each object has several properties, describing message parameters such recipient phone number, content of the message, type, etc. Please mind that some of them are required.
The system will accept maximum **100** messages in one call. If you need to check the price of larger volume of messages, please split it to several separate requests.

As a successful result an `array` of `Price` objects will be returned, one object per each single message. You should check the `error` property of each message in a response body to make sure which were priced successfully and which finished with an error. Successfully priced messages will have `null` value of `error` property. Response will also include meta-data headers: `X-Success-Count` (a count of messages which were processed successfully) and `X-Error-Count` (count of messages which were rejected).

If you send duplicated messages in one call, API will process such message only once. This request have to be authenticated using **API Access Token**.

In case of an error, the `ErrorResponse` object will be returned with proper HTTP header status code (our error response complies with [RFC 9457](https://www.rfc-editor.org/rfc/rfc7807)).


### Example Usage

```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.components.PhoneNumberWithCid;
import pl.gsmservice.gateway.models.components.Recipients;
import pl.gsmservice.gateway.models.components.Sms;
import pl.gsmservice.gateway.models.components.SmsType;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.GetSmsPriceRequestBody;
import pl.gsmservice.gateway.models.operations.GetSmsPriceResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        GetSmsPriceRequestBody req = GetSmsPriceRequestBody.of(List.of(
                Sms.builder()
                    .recipients(Recipients.of(PhoneNumberWithCid.builder()
                        .nr("+48999999999")
                        .cid("my-id-1113")
                        .build()))
                    .message("To jest treść wiadomości")
                    .sender("Bramka SMS")
                    .type(SmsType.SmsPro)
                    .unicode(true)
                    .flash(false)
                    .date(JsonNullable.of(null))
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
| models/errors/ErrorResponse | 400, 401, 4XX, 5XX          | application/problem+json    |

## send

Send single or multiple SMS messages at the same time. You have to pass as request body the `Sms` object (for single message) or `array` of `Sms` objects (for multiple messages). Each object has several properties, describing message parameters such recipient phone number, content of the message, type or scheduled sending date, etc. Please mind that some of them are required.
The system will accept maximum 100 messages in one call. If you need to send larger volume of messages, please split it to several separate requests.

As a successful result an `array` with `Message` objects will be returned, one object per each single message. You should check the `status_code` property of each message in a response body to make sure which were accepted by gateway (queued) and which were rejected. In case of rejection, `status_description` property will include a reason. Response will also include meta-data headers: `X-Success-Count` (a count of messages which were processed successfully), `X-Error-Count` (count of messages which were rejected) and `X-Sandbox` (if a request was made in Sandbox or Production system).

If you send duplicated messages in one call, API will process such message only once. This request have to be authenticated using **API Access Token**.

In case of an error, the `ErrorResponse` object will be returned with proper HTTP header status code (our error response complies with [RFC 9457](https://www.rfc-editor.org/rfc/rfc7807)).

### Example Usage

```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.components.Recipients;
import pl.gsmservice.gateway.models.components.Sms;
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
                Sms.builder()
                    .recipients(Recipients.of(List.of(
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

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `request`                                                           | [SendSmsRequestBody](../../models/operations/SendSmsRequestBody.md) | :heavy_check_mark:                                                  | The request object to use for the request.                          |

### Response

**[SendSmsResponse](../../models/operations/SendSmsResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 401, 403, 4XX, 5XX     | application/problem+json    |