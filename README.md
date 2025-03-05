[![Maven Central Version](https://img.shields.io/maven-central/v/pl.gsmservice/gateway)](https://central.sonatype.com/artifact/pl.gsmservice/gateway)
[![GitHub License](https://img.shields.io/github/license/gsmservice-pl/messaging-sdk-php)](https://github.com/gsmservice-pl/messaging-sdk-java/blob/main/LICENSE)
[![Static Badge](https://img.shields.io/badge/built_by-Speakeasy-yellow)](https://www.speakeasy.com/?utm_source=openapi&utm_campaign=java)
# SzybkiSMS.pl Messaging REST API SDK for Java (powered by GSMService.pl)



This package includes Messaging SDK for Java to send SMS & MMS messages directly from your app via https://szybkisms.pl messaging platform.

## Additional documentation:

A documentation of all methods and types is available below in section [Available Resources and Operations
](#available-resources-and-operations).

Also you can refer to the [REST API documentation](https://api.szybkisms.pl/rest/) for additional details about the basics of this SDK.

<!-- No Summary [summary] -->

<!-- Start Table of Contents [toc] -->
## Table of Contents
<!-- $toc-max-depth=2 -->
* [SzybkiSMS.pl Messaging REST API SDK for Java (powered by GSMService.pl)](#szybkismspl-messaging-rest-api-sdk-for-java-powered-by-gsmservicepl)
  * [Additional documentation:](#additional-documentation)
  * [SDK Installation](#sdk-installation)
  * [SDK Example Usage](#sdk-example-usage)
  * [Available Resources and Operations](#available-resources-and-operations)
  * [Retries](#retries)
  * [Error Handling](#error-handling)
  * [Server Selection](#server-selection)
  * [Authentication](#authentication)
* [Development](#development)
  * [Maturity](#maturity)
  * [Contributions](#contributions)

<!-- End Table of Contents [toc] -->

<!-- Start SDK Installation [installation] -->
## SDK Installation

### Getting started

JDK 11 or later is required.

The samples below show how a published SDK artifact is used:

Gradle:
```groovy
implementation 'pl.gsmservice:gateway:3.0.1'
```

Maven:
```xml
<dependency>
    <groupId>pl.gsmservice</groupId>
    <artifactId>gateway</artifactId>
    <version>3.0.1</version>
</dependency>
```

### How to build
After cloning the git repository to your file system you can build the SDK artifact from source to the `build` directory by running `./gradlew build` on *nix systems or `gradlew.bat` on Windows systems.

If you wish to build from source and publish the SDK artifact to your local Maven repository (on your filesystem) then use the following command (after cloning the git repo locally):

On *nix:
```bash
./gradlew publishToMavenLocal -Pskip.signing
```
On Windows:
```bash
gradlew.bat publishToMavenLocal -Pskip.signing
```
<!-- End SDK Installation [installation] -->

<!-- Start SDK Example Usage [usage] -->
## SDK Example Usage

### Sending single SMS Message

This example demonstrates simple sending SMS message to a single recipient:

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

### Sending single MMS Message

This example demonstrates simple sending MMS message to a single recipient:

```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.components.Attachments;
import pl.gsmservice.gateway.models.components.MmsMessage;
import pl.gsmservice.gateway.models.components.Recipients;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.SendMmsRequestBody;
import pl.gsmservice.gateway.models.operations.SendMmsResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        SendMmsRequestBody req = SendMmsRequestBody.of(List.of(
                MmsMessage.builder()
                    .recipients(Recipients.of2(List.of(
                        "+48999999999")))
                    .subject("To jest temat wiadomości")
                    .message("To jest treść wiadomości")
                    .attachments(Attachments.of(List.of(
                        "<file_body in base64 format>")))
                    .build()));

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

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

<details open>
<summary>Available methods</summary>

### [accounts()](docs/sdks/accounts/README.md)

* [get](docs/sdks/accounts/README.md#get) - Get account details
* [getSubaccount](docs/sdks/accounts/README.md#getsubaccount) - Get subaccount details


### [common()](docs/sdks/common/README.md)

* [ping](docs/sdks/common/README.md#ping) - Checks API availability and version

### [incoming()](docs/sdks/incoming/README.md)

* [list](docs/sdks/incoming/README.md#list) - List the received SMS messages
* [getByIds](docs/sdks/incoming/README.md#getbyids) - Get the incoming messages by IDs

### [outgoing()](docs/sdks/outgoing/README.md)

* [getByIds](docs/sdks/outgoing/README.md#getbyids) - Get the messages details and status by IDs
* [cancelScheduled](docs/sdks/outgoing/README.md#cancelscheduled) - Cancel a scheduled messages
* [list](docs/sdks/outgoing/README.md#list) - Lists the history of sent messages

#### [outgoing().mms()](docs/sdks/mms/README.md)

* [getPrice](docs/sdks/mms/README.md#getprice) - Check the price of MMS Messages
* [send](docs/sdks/mms/README.md#send) - Send MMS Messages

#### [outgoing().sms()](docs/sdks/sms/README.md)

* [getPrice](docs/sdks/sms/README.md#getprice) - Check the price of SMS Messages
* [send](docs/sdks/sms/README.md#send) - Send SMS Messages

### [senders()](docs/sdks/senders/README.md)

* [list](docs/sdks/senders/README.md#list) - List allowed senders names
* [add](docs/sdks/senders/README.md#add) - Add a new sender name
* [delete](docs/sdks/senders/README.md#delete) - Delete a sender name
* [setDefault](docs/sdks/senders/README.md#setdefault) - Set default sender name

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Retries [retries] -->
## Retries

Some of the endpoints in this SDK support retries. If you use the SDK without any configuration, it will fall back to the default retry strategy provided by the API. However, the default retry strategy can be overridden on a per-operation basis, or across the entire SDK.

To change the default retry strategy for a single API call, you can provide a `RetryConfig` object through the `retryConfig` builder method:
```java
package hello.world;

import java.lang.Exception;
import java.util.concurrent.TimeUnit;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.GetAccountDetailsResponse;
import pl.gsmservice.gateway.utils.BackoffStrategy;
import pl.gsmservice.gateway.utils.RetryConfig;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build();

        GetAccountDetailsResponse res = sdk.accounts().get()
                .retryConfig(RetryConfig.builder()
                    .backoff(BackoffStrategy.builder()
                        .initialInterval(1L, TimeUnit.MILLISECONDS)
                        .maxInterval(50L, TimeUnit.MILLISECONDS)
                        .maxElapsedTime(1000L, TimeUnit.MILLISECONDS)
                        .baseFactor(1.1)
                        .jitterFactor(0.15)
                        .retryConnectError(false)
                        .build())
                    .build())
                .call();

        if (res.accountResponse().isPresent()) {
            // handle response
        }
    }
}
```

If you'd like to override the default retry strategy for all operations that support retries, you can provide a configuration at SDK initialization:
```java
package hello.world;

import java.lang.Exception;
import java.util.concurrent.TimeUnit;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.GetAccountDetailsResponse;
import pl.gsmservice.gateway.utils.BackoffStrategy;
import pl.gsmservice.gateway.utils.RetryConfig;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .retryConfig(RetryConfig.builder()
                    .backoff(BackoffStrategy.builder()
                        .initialInterval(1L, TimeUnit.MILLISECONDS)
                        .maxInterval(50L, TimeUnit.MILLISECONDS)
                        .maxElapsedTime(1000L, TimeUnit.MILLISECONDS)
                        .baseFactor(1.1)
                        .jitterFactor(0.15)
                        .retryConnectError(false)
                        .build())
                    .build())
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
<!-- End Retries [retries] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.

By default, an API error will throw a `models/errors/SDKError` exception. When custom error responses are specified for an operation, the SDK may also throw their associated exception. You can refer to respective *Errors* tables in SDK docs for more details on possible exception types for each operation. For example, the `get` method throws the following exceptions:

| Error Type                  | Status Code   | Content Type             |
| --------------------------- | ------------- | ------------------------ |
| models/errors/ErrorResponse | 401, 403, 4XX | application/problem+json |
| models/errors/ErrorResponse | 5XX           | application/problem+json |

### Example

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
<!-- End Error Handling [errors] -->

<!-- Start Server Selection [server] -->
## Server Selection

### Select Server by Name

You can override the default server globally using the `.server(AvailableServers server)` builder method when initializing the SDK client instance. The selected server will then be used as the default on the operations that use it. This table lists the names associated with the available servers:

| Name      | Server                                  | Description           |
| --------- | --------------------------------------- | --------------------- |
| `prod`    | `https://api.szybkisms.pl/rest`         | Production system     |
| `sandbox` | `https://api.szybkisms.pl/rest-sandbox` | Test system (SANDBOX) |

#### Example

```java
package hello.world;

import java.lang.Exception;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.GetAccountDetailsResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .server(Client.AvailableServers.SANDBOX)
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

### Override Server URL Per-Client

The default server can also be overridden globally using the `.serverURL(String serverUrl)` builder method when initializing the SDK client instance. For example:
```java
package hello.world;

import java.lang.Exception;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;
import pl.gsmservice.gateway.models.operations.GetAccountDetailsResponse;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .serverURL("https://api.szybkisms.pl/rest")
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
<!-- End Server Selection [server] -->

<!-- Start Authentication [security] -->
## Authentication

### Per-Client Security Schemes

This SDK supports the following security scheme globally:

| Name     | Type | Scheme      |
| -------- | ---- | ----------- |
| `bearer` | http | HTTP Bearer |

To authenticate with the API the `bearer` parameter must be set when initializing the SDK client instance. For example:
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
<!-- End Authentication [security] -->

<!-- Placeholder for Future Speakeasy SDK Sections -->

# Development

## Maturity

This SDK is in continuous development and there may be breaking changes between a major version update. Therefore, we recommend pinning usage
to a specific package version. This way, you can install the same version each time without breaking changes unless you are intentionally
looking for the latest version.

## Contributions

While we value open-source contributions to this SDK, this library is generated programmatically. Any manual changes added to internal files will be overwritten on the next generation.
We look forward to hearing your feedback. Feel free to open a PR or an issue with a proof of concept and we'll do our best to include it in a future release. 
