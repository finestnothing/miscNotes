from socket import *

msg = "\r\nI loce computer networks!"
endMsg = "\r\n. \r\n"

mailServer = ("smtp.csus.edu", 25)

clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect(mailServer)

recv = clientSocket.recv(1024)
print(recv)
if recv[:3] != '220':
    print('220 reply not received from server.')

# Send HELLO command and print server response.
helloCommand = 'HELLO Alice\r\n'
clientSocket.send(helloCommand.encode())
recv1 = clientSocket.recv(1024)
print(recv1)
if recv1[:3] != '250':
    print('250 reply not received from server.')

# Send MAIL FROM command and print server response.
username = "alecresha@csus.edu"
password = "Sandston1234@"

mailFromCommand = 'MAIL FROM: <' + username + '>\r\n'
clientSocket.send(mailFromCommand.encode())
recv2 = clientSocket.recv(1024)
print(recv2)
if recv2[:3] != '250':
    print('250 reply not received from server.')

# Send RCPT TO command and print server response.
rcptTo = 'RCPT TO: <" + username + ">\r\n'
clientSocket.send(rcptTo.encode())
recv3 = clientSocket.recv(1024)
print(recv3)
if recv3[:3] != '250':
    print('250 reply not received from server.')

# Send DATA command and print server response.
data = 'DATA\r\n'
clientSocket.send(data.encode())
recv4 = clientSocket.recv(1024)
print(recv4)
if recv4[:3] != '250':
    print('250 reply not received from server.')

# Send message data
subject = "Test Message"
clientSocket.send(subject.encode())
clientSocket.send(msg.encode())
clientSocket.send(endMsg.encode())
recv_msg = clientSocket.recv(1024)
print(recv_msg.decode())
if recv_msg[:3] != '250':
    print('250 reply not received from server.')

# Message ends with a single period

# Send QUIT command get server response.
clientSocket.send('QUIT\r\n'.encode())
message=clientSocket.recv(1024)
print(message)
clientSocket.close()