# Common
(*common()*)

## Overview

This section describes other usefull operations and tools

### Available Operations

* [ping](#ping) - Checks API availability and version

## ping

Check the API connection and the current API availability status. Also you will get the current API version number. The request doesn't contain a body or any parameters.

As a successful result a `PingResponse` object will be returned. This request doesn't need to be authenticated.

In case of an error, the `ErrorResponse` object will be returned with proper HTTP header status code (our error response complies with [RFC 9457](https://www.rfc-editor.org/rfc/rfc7807)).

### Example Usage

```java
package hello.world;

import java.lang.Exception;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.PingResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
            .build();

        PingResponse res = sdk.common().ping()
                .call();

        if (res.pingResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[PingResponse](../../models/operations/PingResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 4XX, 503, 5XX          | application/problem+json    |