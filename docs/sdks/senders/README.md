# Senders
(*senders()*)

## Overview

### Available Operations

* [list](#list) - List allowed senders names
* [add](#add) - Add a new sender name
* [delete](#delete) - Delete a sender name
* [setDefault](#setdefault) - Set default sender name

## list

<br><br>Get a list of allowed senders defined in your account. The method doesn't take any parameters. Please use builder style:<br>
```
ListSendersResponse res = sdk.senders().list()
   .call();
```
<br>As a successful result a `ListSendersResponse` object will be returned wich `senders` property of type `List<Sender>` containing `Sender` objects, each object per single sender.

### Example Usage

<!-- UsageSnippet language="java" operationID="listSenders" method="get" path="/senders" -->
```java
package hello.world;

import java.lang.Exception;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.ListSendersResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        ListSendersResponse res = sdk.senders().list()
                .call();

        if (res.senders().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[ListSendersResponse](../../models/operations/ListSendersResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 401, 403, 4XX          | application/problem+json    |
| models/errors/ErrorResponse | 5XX                         | application/problem+json    |

## add

<br><br>Define a new allowed sender on your account. You should pass as parameter a `SenderInput` object with two properties: `sender` (defines sender name) and `description`. Please use builder style:<br>
```
AddSenderResponse res = sdk.senders().add()
   .request(req)
   .call();
```
<br>Please carefully fill this property with the extensive description of a sender name (what will be its use, what the name mean, etc). <br><br>As a successful result a `AddSenderResponse` object will be returned with a `sender` property containing a `Sender` object with details and status of added sender name.

### Example Usage

<!-- UsageSnippet language="java" operationID="addSender" method="post" path="/senders" -->
```java
package hello.world;

import java.lang.Exception;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.components.SenderInput;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.AddSenderResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        SenderInput req = SenderInput.builder()
                .sender("Bramka SMS")
                .description("This is our company name. It contains our registered trademark.")
                .build();

        AddSenderResponse res = sdk.senders().add()
                .request(req)
                .call();

        if (res.sender().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                         | Type                                              | Required                                          | Description                                       |
| ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- |
| `request`                                         | [SenderInput](../../models/shared/SenderInput.md) | :heavy_check_mark:                                | The request object to use for the request.        |

### Response

**[AddSenderResponse](../../models/operations/AddSenderResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 401, 403, 4XX          | application/problem+json    |
| models/errors/ErrorResponse | 5XX                         | application/problem+json    |

## delete

<br><br>Removes defined sender name from your account. This method accepts a `string` with a <strong>sender name</strong> you want to remove. Please use builder style:<br>
```
DeleteSenderResponse res = sdk.senders().delete()
   .sender("Podpis")
   .call();
```
<br>Sender name will be deleted immediately.<br><br>As a successful response a `DeleteSenderResponse` object will de returned with `statusCode` property of `204`.

### Example Usage

<!-- UsageSnippet language="java" operationID="deleteSender" method="delete" path="/senders/{sender}" -->
```java
package hello.world;

import java.lang.Exception;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.DeleteSenderResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        DeleteSenderResponse res = sdk.senders().delete()
                .sender("Podpis")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                 | Type                      | Required                  | Description               | Example                   |
| ------------------------- | ------------------------- | ------------------------- | ------------------------- | ------------------------- |
| `sender`                  | *String*                  | :heavy_check_mark:        | Sender name to be removed | Podpis                    |

### Response

**[DeleteSenderResponse](../../models/operations/DeleteSenderResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 401, 403, 404, 4XX     | application/problem+json    |
| models/errors/ErrorResponse | 5XX                         | application/problem+json    |

## setDefault

<br><br>Set default sender name to one of the senders names already defined on your account. This method accepts a `string` containing a <strong>sender name</strong> to be set as default on your account. Please use a builder style:<br>
```
SetDefaultSenderResponse res = sdk.senders().setDefault()
   .sender("Podpis")
   .call();
```
<br>As a successful response a `SetDefaultSenderResponse` will be returned with `statusCode` property of `204`.

### Example Usage

<!-- UsageSnippet language="java" operationID="setDefaultSender" method="patch" path="/senders/{sender}" -->
```java
package hello.world;

import java.lang.Exception;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.SetDefaultSenderResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        SetDefaultSenderResponse res = sdk.senders().setDefault()
                .sender("Podpis")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                     | Type                          | Required                      | Description                   | Example                       |
| ----------------------------- | ----------------------------- | ----------------------------- | ----------------------------- | ----------------------------- |
| `sender`                      | *String*                      | :heavy_check_mark:            | Sender name to set as default | Podpis                        |

### Response

**[SetDefaultSenderResponse](../../models/operations/SetDefaultSenderResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/json            |
| models/errors/ErrorResponse | 400, 401, 403, 4XX          | application/problem+json    |
| models/errors/ErrorResponse | 5XX                         | application/problem+json    |