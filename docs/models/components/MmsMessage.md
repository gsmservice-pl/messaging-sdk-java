# MmsMessage

An object with a new MMS message properties


## Fields

| Field                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  | Type                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | Required                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            | Example                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `recipients`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           | [Recipients](../../models/components/Recipients.md)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     | The recipient number or multiple recipients numbers of single message. To set one recipient, please use `Recipients.of(String)` method simply passing to it a `string` with his phone number. To set multiple recipients, please use `Recipients.ofArrayOfStrings(List.of(String,...))` method passing to it `List<string>`. Optionally you can also set custom id (user identifier) for each message - use `Recipients.of(PhoneNumberWithCid)` method passing `PhoneNumberWithCid` object (in case of single recipient) or `Recipients.ofArrayOfPhoneNumberWithCids(Recipients.of(PhoneNumberWithCid,...))` method passing List<PhoneNumberWithCid> (in case of multiple recipients). |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| `subject`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     | MMS message subject                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    | To jest temat wiadomości                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| `message`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     | MMS message content                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    | To jest treść wiadomości                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| `attachments`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          | [Optional\<Attachments>](../../models/components/Attachments.md)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     | Attachments for the message. You can pass here images, audio and video files bodies. To set one attachment please use `Attachments.of(String)` method simply passing to it a `string` with attachment body encoded by `base64`. To set multiple attachments please use `Attachments.of(List.of(String,...))` method passing to it `List<string>` with attachments bodies encoded by `base64`. Max 3 attachments per message.                                                                                                                                                                                                                                                           |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| `date`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     | Scheduled future date and time of sending the message (in ISO 8601 format). If missing or null - message will be sent immediately                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      | <nil>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |