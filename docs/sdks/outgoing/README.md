# Outgoing
(*outgoing()*)

## Overview

### Available Operations

* [getByIds](#getbyids) - Get the messages details and status by IDs
* [cancelScheduled](#cancelscheduled) - Cancel a scheduled messages
* [list](#list) - Lists the history of sent messages

## getByIds

<br><br>Check the current status and details of one or more messages using their `ids`. You should pass the `ListOf()` containing unique message <em>IDs</em> (`Long` type) which details you want to fetch. Please use builder style:<br>
```
GetMessagesResponse res = sdk.outgoing().getByIds()
   .ids(List.of(43456L))
   .call();
```
<br>This method will accept maximum 50 identifiers in one call.<br><br>As a successful result a `GetMessagesResponse` object will be returned containing `messages` property of type `List<Message>` with `Message` objects, each object per single found message. `GetMessagesResponse` object will also contain `headers` property where you can find `X-Success-Count` (a count of messages which were found and returned correctly) and `X-Error-Count` (count of messages which were not found) elements.

### Example Usage

<!-- UsageSnippet language="java" operationID="getMessages" method="get" path="/messages/{ids}" -->
```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.GetMessagesResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        GetMessagesResponse res = sdk.outgoing().getByIds()
                .ids(List.of(
                    43456L))
                .call();

        if (res.messages().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                         | Type                                                                                                              | Required                                                                                                          | Description                                                                                                       |
| ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| `ids`                                                                                                             | List\<*long*>                                                                                                     | :heavy_check_mark:                                                                                                | List<Long> of Message IDs assigned by the system. The system will accept a maximum of 50 identifiers in one call. |

### Response

**[GetMessagesResponse](../../models/operations/GetMessagesResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 401, 403, 404, 4XX     | application/problem+json    |
| models/errors/ErrorResponse | 5XX                         | application/problem+json    |

## cancelScheduled

<br><br>Cancel messages using their `ids` which were scheduled to be sent at a specific time. You have to pass a `ListOf()` containing the unique message IDs (`Long` type), which were returned after sending a message. Please use builder style:<br>
```
CancelMessagesResponse res2 = sdk.outgoing().cancelScheduled()
   .ids(List.of(43456L))
   .call();
```
<br>This method will accept maximum 50 identifiers in one call. You can cancel only messages with <em>SCHEDULED</em> status.
 
As a successful result a `CancelMessagesResponse` object will be returned, with `cancelledMessages` property of type `List<CancelledMessage>` containing `CancelledMessage` objects. The `status` property of each `CancelledMessage` object will contain a status code of operation - `204` if a particular message was cancelled successfully and other code if an error occured.
 
`CancelMessagesResponse` object will also contain `headers` property where you can find `X-Success-Count` (a count of messages which were cancelled successfully), `X-Error-Count` (count of messages which were not cancelled) and `X-Sandbox` (if a request was made in Sandbox or Production system) elements.

### Example Usage

<!-- UsageSnippet language="java" operationID="cancelMessages" method="delete" path="/messages/{ids}" -->
```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.CancelMessagesResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        CancelMessagesResponse res = sdk.outgoing().cancelScheduled()
                .ids(List.of(
                    43456L))
                .call();

        if (res.cancelledMessages().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                         | Type                                                                                                              | Required                                                                                                          | Description                                                                                                       |
| ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| `ids`                                                                                                             | List\<*long*>                                                                                                     | :heavy_check_mark:                                                                                                | List<Long> of Message IDs assigned by the system. The system will accept a maximum of 50 identifiers in one call. |

### Response

**[CancelMessagesResponse](../../models/operations/CancelMessagesResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 401, 403, 404, 4XX     | application/problem+json    |
| models/errors/ErrorResponse | 5XX                         | application/problem+json    |

## list

<br><br>Get the details and current status of all of sent messages from your account message history. This method supports pagination so you have to pass a `page` (number of page with messages which you want to access, `Long` type) and a `limit` (max of messages per page, `Long` type) parameters. Please use builder style:<br>
```
ListMessagesResponse res = sdk.outgoing().list()
   .page(1L)
   .limit(10L)
   .call();
```
<br>Messages are fetched from the latest one. This method will accept maximum value of <strong>50</strong> as `limit` parameter value.<br><br>As a successful result a `ListMessagesResponse` object will be returned containing `messages` property of type `List<Message>` with a `Message` objects, each object per single message. `ListMessagesResponse` will also contain `headers` property where you can find `X-Total-Results` (a total count of all messages which are available in history on your account), `X-Total-Pages` (a total number of all pages with results), `X-Current-Page` (A current page number) and `X-Limit` (messages count per single page) elements.

### Example Usage

<!-- UsageSnippet language="java" operationID="listMessages" method="get" path="/messages" -->
```java
package hello.world;

import java.lang.Exception;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.ListMessagesResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        ListMessagesResponse res = sdk.outgoing().list()
                .page(1L)
                .limit(10L)
                .call();

        if (res.messages().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                     | Type                          | Required                      | Description                   | Example                       |
| ----------------------------- | ----------------------------- | ----------------------------- | ----------------------------- | ----------------------------- |
| `page`                        | *Optional\<Long>*             | :heavy_minus_sign:            | Page number of results        | 1                             |
| `limit`                       | *Optional\<Long>*             | :heavy_minus_sign:            | Number of results on one page | 10                            |

### Response

**[ListMessagesResponse](../../models/operations/ListMessagesResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 401, 403, 404, 4XX     | application/problem+json    |
| models/errors/ErrorResponse | 5XX                         | application/problem+json    |