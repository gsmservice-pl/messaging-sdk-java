# Client SDK

## Overview

Messaging Gateway SzybkiSMS.pl (former GSMService.pl): <br><br>This package includes Messaging SDK for JAVA to send SMS & MMS messages directly from your app via [https://szybkisms.pl](https://szybkisms.pl) messaging platform.<br><br><em>Client</em> class is used to initialize SDK environment.<br><br>Please initialize it this way:<br>
```
import java.lang.Exception;
import pl.gsmservice.gateway.Client;
import pl.gsmservice.gateway.models.errors.ErrorResponse;

Client sdk = Client.builder()
   .bearer("<YOUR API ACCESS TOKEN>")
   .build();
```
<br>If you want to use a Sandbox test system please initialize it as follows:<br>
```
Client sdk = Client.builder()
   .server(Client.AvailableServers.SANDBOX)
   .bearer("<YOUR API ACCESS TOKEN>")
   .build();
```

### Available Operations
