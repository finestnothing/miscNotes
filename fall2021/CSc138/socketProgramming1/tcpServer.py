from socket import *
serverPort = 12004
serverSocket =socket(AF_INET, SOCK_STREAM)
serverSocket.bind(("",serverPort))
serverSocket.listen(1)
print('The server is ready to receive.')
while 1:
    connectionSocket, address = serverSocket.accept()
    print('Connection received.')
    connectionSocket.send(connectionSocket.recv(1024).upper())
    print('Message received and returned.')
    connectionSocket.close()
