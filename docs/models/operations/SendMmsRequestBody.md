# SendMmsRequestBody

To send a single MMS or messages with the same content to multiple recipients, please use `SendMmsRequestBody.of(MmsMessage)` method with a single `MmsMessage` object with the properties of this message. To send multiple messages with different content at the same time, please use `SendMmsRequestBody.of(List.of(MmsMessage,...))` method passing to it `List<MmsMessage>` with the properties of each message.

