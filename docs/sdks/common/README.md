# Common
(*common()*)

## Overview

### Available Operations

* [ping](#ping) - Checks API availability and version

## ping

<br><br>Check the API connection and the current API availability status. Also you will get the current API version number. The method doesn't accept any parameters. Please use builder style:<br>
```
PingResponse res = sdk.common().ping()
   .call();
```
<br>As a successful result a `PingResponse` object will be returned.

### Example Usage

```java
package hello.world;

import java.lang.Exception;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.PingResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

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
| models/errors/ErrorResponse | 400, 4XX                    | application/problem+json    |
| models/errors/ErrorResponse | 503, 5XX                    | application/problem+json    |