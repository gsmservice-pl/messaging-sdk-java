# Incoming
(*incoming()*)

## Overview

### Available Operations

* [list](#list) - List the received SMS messages
* [getByIds](#getbyids) - Get the incoming messages by IDs

## list

<br><br>Get the details of all received messages from your account incoming messages box. This method supports pagination so you have to pass `page` (number of page with received messages which you want to access, `Long` type) and a `limit` (max of received messages per page, `Long` type) parameters. Please use builder style:<br>
```
ListIncomingMessagesResponse res = sdk.incoming().list()
   .page(1L)
   .limit(10L)
   .call();
```
<br>Messages are fetched from the latest one. This method will accept maximum <strong>50</strong> as `limit` parameter value.<br><br>As a successful result a `ListIncomingMessagesResponse` object will be returned with `incomingMessages` property of type `List<IncomingMessage>` containing `IncomingMessage` objects, each object per single received message.<br><br>`ListIncomingMessagesResponse` object will contain also a `headers` property where you can find `X-Total-Results` (a total count of all received messages which are available in incoming box on your account), `X-Total-Pages` (a total number of all pages with results), `X-Current-Page` (A current page number) and `X-Limit` (messages count per single page) elements.

### Example Usage

<!-- UsageSnippet language="java" operationID="listIncomingMessages" method="get" path="/incoming" -->
```java
package hello.world;

import java.lang.Exception;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.ListIncomingMessagesResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        ListIncomingMessagesResponse res = sdk.incoming().list()
                .page(1L)
                .limit(10L)
                .call();

        if (res.incomingMessages().isPresent()) {
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

**[ListIncomingMessagesResponse](../../models/operations/ListIncomingMessagesResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 401, 403, 404, 4XX     | application/problem+json    |
| models/errors/ErrorResponse | 5XX                         | application/problem+json    |

## getByIds

<br><br>Get the details of one or more received messages using their `ids`. You should pass the ListOf() containing unique incoming message IDs (Long type) which details you want to fetch. Please use builder style:<br>
```
GetIncomingMessagesResponse res = sdk.incoming().getByIds()
   .ids(List.of(43456L))
   .call();
```
<br>The method will accept maximum 50 identifiers in one call.<br><br>As a successful result a `GetIncomingMessagesResponse` object will be returned with an `incomingMessages` property of type `List<IncomingMessage>` containing `IncomingMessage` objects, each object per single received message.<br><br>`GetIncomingMessagesResponse` object will contain also a `headers` property where you can find `X-Success-Count` (a count of incoming messages which were found and returned correctly) and `X-Error-Count` (count of incoming messages which were not found) elements.

### Example Usage

<!-- UsageSnippet language="java" operationID="getIncomingMessages" method="get" path="/incoming/{ids}" -->
```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.GetIncomingMessagesResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        GetIncomingMessagesResponse res = sdk.incoming().getByIds()
                .ids(List.of(
                    43456L))
                .call();

        if (res.incomingMessages().isPresent()) {
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

**[GetIncomingMessagesResponse](../../models/operations/GetIncomingMessagesResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 401, 404, 4XX          | application/problem+json    |
| models/errors/ErrorResponse | 5XX                         | application/problem+json    |