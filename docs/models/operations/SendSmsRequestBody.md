# SendSmsRequestBody

To send a single SMS or messages with the same content to multiple recipients, please use `SendSmsRequestBody.of(SmsMessage)` method with a single `SmsMessage` object with the properties of this message. To send multiple messages with different content at the same time, please use `SendSmsRequestBody.of(List.of(SmsMessage,...))` method passing to it `List<SmsMessage>` with the properties of each message.

