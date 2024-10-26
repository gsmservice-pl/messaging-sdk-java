# SmsMessageRecipients

The recipient number or multiple recipients numbers of single message. To set one recipient, please use `SmsMessageRecipients.of(String)` method simply passing to it a `string` with his phone number. To set multiple recipients, please use `SmsMessageRecipients.ofArrayOfStrings(List.of(String,...))` method passing to it `List<string>`. Optionally you can also set custom id (user identifier) for each message - use `SmsMessageRecipients.of(PhoneNumberWithCid)` method passing `PhoneNumberWithCid` object (in case of single recipient) or `SmsMessageRecipients.ofArrayOfPhoneNumberWithCids(Recipients.of(PhoneNumberWithCid,...))` method passing List<PhoneNumberWithCid> (in case of multiple recipients).

