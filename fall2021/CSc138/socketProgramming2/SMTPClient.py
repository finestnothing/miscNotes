from socket import *
import base64

msg = "\r\n I love computer networks!"
endmsg = "\r\n.\r\n"
mailserver = ("smtp.csus.edu", 587)

# Create socket called clientSocket and establish a TCP connection with mailserver
clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect(mailserver)

recv = clientSocket.recv(1024).decode()
print("Message after connection request: ", recv)
if recv[:3] != '220':
    print("220 reply not received from server.")

# Send HELO command and print server response.
heloCommand = 'EHLO smtp.csus.edu\r\n'
clientSocket.send(heloCommand.encode())
recv1 = clientSocket.recv(1024).decode()
print("Message after EHLO command: ", recv1)
if recv1[:3] != '250':
    print("250 reply not received from server.")

# Send starttls command and print server response.
starttlsCommand = 'STARTTLS\r\n'
clientSocket.send(starttlsCommand.encode())
recv2 = clientSocket.recv(1024).decode()
print("Message after STARTTLS command: ", recv2)
if recv2[:3] != '220':
    print("220 reply not received from server.")

# Info for username and password
username = "alecresha@csus.edu"
password = "Sandston1234@"

base64_str = ("\x00" + username + "\x00" + password).encode()
base64_str = base64.b64encode(base64_str)
authMsg = "AUTH PLAIN ".encode() + base64_str + "\r\n".encode()
clientSocket.send(authMsg)
recv2 = clientSocket.recv(1024).decode()
print("Message after AUTH command: ", recv2)
if recv2[:3] != '235':
    print("235 reply not received from server.")

# Send MAIL FROM command and print server response.
mailFrom = "MAIL FROM:<alecresha@csus.edu>\r\n"
clientSocket.send(mailFrom.encode())
recv2 = clientSocket.recv(1024).decode()
print("Message after MAIL FROM command: ", recv2)
if recv2[:3] != '250':
    print("250 reply not received from server.")

# Send RCPT TO command and print server response.
rcptTo = "RCPT TO:<iforgot52@gmail.com>\r\n"
clientSocket.send(rcptTo.encode())
recv2 = clientSocket.recv(1024).decode()
print("Message after RCPT TO command: ", recv2)
if recv2[:3] != '250':
    print("250 reply not received from server.")

# Send DATA command and print server response.
data = "DATA\r\n"
clientSocket.send(data.encode())
recv4 = clientSocket.recv(1024).decode()
print("Message after DATA command: ", recv4)
if recv4[:3] != '250':
    print("250 reply not received from server.")

# Send message data.
subject = "Subject: Test Message\r\n"
clientSocket.send(subject.encode())
clientSocket.send(msg.encode())
clientSocket.send(endmsg.encode())
recv_msg = clientSocket.recv(1024).decode()
print("Message after sending message: ", recv_msg)
if recv_msg[:3] != '250':
    print("250 reply not received from server.")

# Send QUIT command and get server response.
clientSocket.send("QUIT\r\n".encode())
message = clientSocket.recv(1024).decode()
print("Message after QUIT command: ", message)
clientSocket.close()

