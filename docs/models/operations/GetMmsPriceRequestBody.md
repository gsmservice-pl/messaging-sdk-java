# GetMmsPriceRequestBody

To check the price of a single message or messages with the same content to multiple recipients, pass a single `MmsMessage` object with the properties of this message using `GetMmsPriceRequestBody.of(MmsMessage)` method. To check the price of multiple messages with different content at the same time, pass a `List<SmsMessage>` with the properties of each message using `GetMmsPriceRequestBody.of(List.of(MmsMessage,...))` method.

