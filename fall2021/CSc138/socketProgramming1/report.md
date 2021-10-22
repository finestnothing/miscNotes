# Socket Programming 1: Class Example

## Alec Resha

### TCP Server and Client

Very similar to class code, but added connection received/message received and sent message.
Also added connection refused to client incase server isn't running yet.

![tcpServerClient image](tcpServerClient.jpg =500x)

### UDP Server and Client

Similar to class code.
Added message receieved/sent to server. 
Added 20 second timeout to client, retries sending every 1 second incase server isn't running yet. Allows server to be started after client instead of client being stuck waiting.

![udpServerClient image](udpServerClient.jpg =500x)
