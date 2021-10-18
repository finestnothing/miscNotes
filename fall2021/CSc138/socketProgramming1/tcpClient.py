from socket import *
serverIP = '127.0.0.1'
serverPort = 12004
clientSocket = socket(AF_INET, SOCK_STREAM)
try:
    clientSocket.connect((serverIP, serverPort))
    message = input('Input sentence: ').encode()
    clientSocket.send(message)
    modifiedMessage = clientSocket.recv(1024)
    print('From Server: ', modifiedMessage)
    clientSocket.close()
except:
    print('Connection Refused.')
