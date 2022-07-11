# TCP-client-server-application 
## Description 
This project is to develop a simple TCP-based client server application. TCP client/server will communicate over the network and exchange data. The server will start in passive mode listening for a transmission from the client. The client will then start and contact the server (on a given IP address and port number). The user of the client application types in a word/phrase that will be sent to the server; the server will send back a copy of the word.
When server is down the client displays an error message.
When server is running, the client will ask the user to select one of the options:
1) open mode (the word/phrase is sent to the server in clear text)
2) secure mode (the word is encrypted by server using a shared encryption key)
3) quit (close server session)


## Prepared By:
- Areej Turky Alotaibi    atsalotaibi03@sm.imamu.edu.sa
- Raghad Adel Alshabana   raaalshabana@sm.imamu.edu.sa
- Shoroog Saad Alarifi    sssalarifi@sm.imamu.edu.sa
- Shoug Ali Alsuhaibani   ssuhaibani@sm.imamu.edu.sa

### Supervised By: Basma Alsouli

## Index
- [Client Code](https://github.com/alsuhaibanishoug/CS330Code/blob/main/Code/Client.java)
- [Server Code](https://github.com/alsuhaibanishoug/CS330Code/blob/main/Code/Server.java)
- [Encryption Decryption Code](https://github.com/alsuhaibanishoug/CS330Code/blob/main/Code/EncryptionDecryption.java)
