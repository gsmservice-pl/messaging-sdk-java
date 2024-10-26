# Attachments

Attachments for the message. You can pass here images, audio and video files bodies. To set one attachment please use `Attachments.of(String)` method simply passing to it a `string` with attachment body encoded by `base64`. To set multiple attachments please use `Attachments.of(List.of(String,...))` method passing to it `List<string>` with attachments bodies encoded by `base64`. Max 3 attachments per message.

