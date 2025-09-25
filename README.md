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
  * [Asynchronous Support](#asynchronous-support)
  * [Authentication](#authentication)
  * [Debugging](#debugging)
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
implementation 'pl.gsmservice:gateway:4.0.1'
```

Maven:
```xml
<dependency>
    <groupId>pl.gsmservice</groupId>
    <artifactId>gateway</artifactId>
    <version>4.0.1</version>
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

        SendSmsRequestBody req = SendSmsRequestBody.of(SmsMessage.builder()
                .recipients(SmsMessageRecipients.of("+48999999999"))
                .message("This is SMS message content.")
                .unicode(true)
                .build());

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
#### Asynchronous Call
An asynchronous SDK client is also available that returns a [`CompletableFuture<T>`][comp-fut]. See [Asynchronous Support](#asynchronous-support) for more details on async benefits and reactive library integration.
```java
package hello.world;

import java.util.concurrent.CompletableFuture;
import pl.gsmservice.gateway.AsyncClient;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.operations.async.GetAccountDetailsResponse;

public class Application {

    public static void main(String[] args) {

        AsyncClient sdk = Client.builder()
                .bearer("<YOUR API ACCESS TOKEN>")
            .build()
            .async();

        CompletableFuture<GetAccountDetailsResponse> resFut = sdk.accounts().get()
                .call();

        resFut.thenAccept(res -> {
            if (res.accountResponse().isPresent()) {
            // handle response
            }
        });
    }
}
```

[comp-fut]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html
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

<!-- Start Asynchronous Support [async-support] -->
## Asynchronous Support

The SDK provides comprehensive asynchronous support using Java's [`CompletableFuture<T>`][comp-fut] and [Reactive Streams `Publisher<T>`][reactive-streams] APIs. This design makes no assumptions about your choice of reactive toolkit, allowing seamless integration with any reactive library.

<details>
<summary>Why Use Async?</summary>

Asynchronous operations provide several key benefits:

- **Non-blocking I/O**: Your threads stay free for other work while operations are in flight
- **Better resource utilization**: Handle more concurrent operations with fewer threads
- **Improved scalability**: Build highly responsive applications that can handle thousands of concurrent requests
- **Reactive integration**: Works seamlessly with reactive streams and backpressure handling

</details>

<details>
<summary>Reactive Library Integration</summary>

The SDK returns [Reactive Streams `Publisher<T>`][reactive-streams] instances for operations dealing with streams involving multiple I/O interactions. We use Reactive Streams instead of JDK Flow API to provide broader compatibility with the reactive ecosystem, as most reactive libraries natively support Reactive Streams.

**Why Reactive Streams over JDK Flow?**
- **Broader ecosystem compatibility**: Most reactive libraries (Project Reactor, RxJava, Akka Streams, etc.) natively support Reactive Streams
- **Industry standard**: Reactive Streams is the de facto standard for reactive programming in Java
- **Better interoperability**: Seamless integration without additional adapters for most use cases

**Integration with Popular Libraries:**
- **Project Reactor**: Use `Flux.from(publisher)` to convert to Reactor types
- **RxJava**: Use `Flowable.fromPublisher(publisher)` for RxJava integration
- **Akka Streams**: Use `Source.fromPublisher(publisher)` for Akka Streams integration
- **Vert.x**: Use `ReadStream.fromPublisher(vertx, publisher)` for Vert.x reactive streams
- **Mutiny**: Use `Multi.createFrom().publisher(publisher)` for Quarkus Mutiny integration

**For JDK Flow API Integration:**
If you need JDK Flow API compatibility (e.g., for Quarkus/Mutiny 2), you can use adapters:
```java
// Convert Reactive Streams Publisher to Flow Publisher
Flow.Publisher<T> flowPublisher = FlowAdapters.toFlowPublisher(reactiveStreamsPublisher);

// Convert Flow Publisher to Reactive Streams Publisher
Publisher<T> reactiveStreamsPublisher = FlowAdapters.toPublisher(flowPublisher);
```

For standard single-response operations, the SDK returns `CompletableFuture<T>` for straightforward async execution.

</details>

<details>
<summary>Supported Operations</summary>

Async support is available for:

- **[Server-sent Events](#server-sent-event-streaming)**: Stream real-time events with Reactive Streams `Publisher<T>`
- **[JSONL Streaming](#jsonl-streaming)**: Process streaming JSON lines asynchronously
- **[Pagination](#pagination)**: Iterate through paginated results using `callAsPublisher()` and `callAsPublisherUnwrapped()`
- **[File Uploads](#file-uploads)**: Upload files asynchronously with progress tracking
- **[File Downloads](#file-downloads)**: Download files asynchronously with streaming support
- **[Standard Operations](#example)**: All regular API calls return `CompletableFuture<T>` for async execution

</details>

[comp-fut]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html
[reactive-streams]: https://www.reactive-streams.org/
<!-- End Asynchronous Support [async-support] -->

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

<!-- Start Debugging [debug] -->
## Debugging

### Debug
You can setup your SDK to emit debug logs for SDK requests and responses.

For request and response logging (especially json bodies), call `enableHTTPDebugLogging(boolean)` on the SDK builder like so:
```java
SDK.builder()
    .enableHTTPDebugLogging(true)
    .build();
```
Example output:
```
Sending request: http://localhost:35123/bearer#global GET
Request headers: {Accept=[application/json], Authorization=[******], Client-Level-Header=[added by client], Idempotency-Key=[some-key], x-speakeasy-user-agent=[speakeasy-sdk/java 0.0.1 internal 0.1.0 org.openapis.openapi]}
Received response: (GET http://localhost:35123/bearer#global) 200
Response headers: {access-control-allow-credentials=[true], access-control-allow-origin=[*], connection=[keep-alive], content-length=[50], content-type=[application/json], date=[Wed, 09 Apr 2025 01:43:29 GMT], server=[gunicorn/19.9.0]}
Response body:
{
  "authenticated": true, 
  "token": "global"
}
```
__WARNING__: This should only used for temporary debugging purposes. Leaving this option on in a production system could expose credentials/secrets in logs. <i>Authorization</i> headers are redacted by default and there is the ability to specify redacted header names via `SpeakeasyHTTPClient.setRedactedHeaders`.

__NOTE__: This is a convenience method that calls `HTTPClient.enableDebugLogging()`. The `SpeakeasyHTTPClient` honors this setting. If you are using a custom HTTP client, it is up to the custom client to honor this setting.

Another option is to set the System property `-Djdk.httpclient.HttpClient.log=all`. However, this second option does not log bodies.
<!-- End Debugging [debug] -->

<!-- Placeholder for Future Speakeasy SDK Sections -->

# Development

## Maturity

This SDK is in continuous development and there may be breaking changes between a major version update. Therefore, we recommend pinning usage
to a specific package version. This way, you can install the same version each time without breaking changes unless you are intentionally
looking for the latest version.

## Contributions

While we value open-source contributions to this SDK, this library is generated programmatically. Any manual changes added to internal files will be overwritten on the next generation.
We look forward to hearing your feedback. Feel free to open a PR or an issue with a proof of concept and we'll do our best to include it in a future release. 
