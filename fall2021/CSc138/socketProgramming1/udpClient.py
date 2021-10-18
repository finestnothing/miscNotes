from socket import *
import time
serverIP = "127.0.0.1"
serverPort = 12000
clientSocket = socket(AF_INET, SOCK_DGRAM)
message = input('Input lowercase sentence: ')
response = 1
waitTime=0
while(response != 0):
    try:
        clientSocket.connect((serverIP, serverPort))
        response = 0
        clientSocket.sendto(message.encode(),(serverIP,serverPort))
        modifiedMessage, serverAddress = clientSocket.recvfrom(2048)
        print(modifiedMessage)
    except:
        if(waitTime <= 20):
            response = 1
            time.sleep(1)
            waitTime = waitTime + 1
        else:
            print("Request timed out.")
            response = 0
clientSocket.close()
