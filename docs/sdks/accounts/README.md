# Accounts
(*accounts()*)

## Overview

### Available Operations

* [get](#get) - Get account details
* [getSubaccount](#getsubaccount) - Get subaccount details

## get

<br><br>Get current account balance and other details of your account. You can check also account limit and if account is main one. Main accounts have unlimited privileges and using [User Panel](https://panel.szybkisms.pl) you can create as many subaccounts as you need.<br><br>This method doesn't take any parameters. As a successful result a details of current account you are logged in using an API Access Token will be returned.

### Example Usage

<!-- UsageSnippet language="java" operationID="getAccountDetails" method="get" path="/account" -->
```java
package hello.world;

import java.lang.Exception;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.GetAccountDetailsResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        GetAccountDetailsResponse res = sdk.accounts().get()
                .call();

        if (res.accountResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[GetAccountDetailsResponse](../../models/operations/GetAccountDetailsResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 401, 403, 4XX               | application/problem+json    |
| models/errors/ErrorResponse | 5XX                         | application/problem+json    |

## getSubaccount

<br><br>Check account balance and other details such subcredit balance of a subaccount. Subaccounts are additional users who can access your account services and the details. You can restrict access level and setup privileges to subaccounts using [User Panel](https://panel.szybkisms.pl).<br><br>You should pass the subaccount user login to access its data. Please use builder style: <br>
```
GetSubaccountDetailsResponse res = sdk.accounts().getSubaccount()
   .userLogin("some-login")
   .call();
```
<br>As a successful result the details of subaccount with provided login will be returned.

### Example Usage

<!-- UsageSnippet language="java" operationID="getSubaccountDetails" method="get" path="/account/{user_login}" -->
```java
package hello.world;

import java.lang.Exception;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.GetSubaccountDetailsResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        GetSubaccountDetailsResponse res = sdk.accounts().getSubaccount()
                .userLogin("some-login")
                .call();

        if (res.accountResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                          | Type                                               | Required                                           | Description                                        | Example                                            |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| `userLogin`                                        | *String*                                           | :heavy_check_mark:                                 | Login of the subaccount (user) to get the data for | some-login                                         |

### Response

**[GetSubaccountDetailsResponse](../../models/operations/GetSubaccountDetailsResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 401, 403, 404, 4XX          | application/problem+json    |
| models/errors/ErrorResponse | 5XX                         | application/problem+json    |