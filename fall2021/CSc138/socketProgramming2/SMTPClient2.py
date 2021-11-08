from socket import *

msg = "\r\n I love computer networks!"
endmsg = "\r\n.\r\n"

# Choose a mail server (e.g. Google mail server) and call it mailserver
mailserver = "smtp.csus.edu"
port = 25

# Create socket called clientSocket and establish a TCP connection with mailserver
clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect((mailserver, port))

recv = clientSocket.recv(1024)
print(recv)
if recv[:3] != b'220':
    print('220 reply not received from server.')

# Send HELO command and print server response.
heloCommand = 'HELO Alice\r\n'
clientSocket.send(heloCommand)
recv1 = clientSocket.recv(1024)
print(recv1)
if recv1[:3] != b'250':
    print('250 reply not received from server.')

# Send MAIL FROM command and print server response.

# Send RCPT TO command and print server response.

# Send DATA command and print server response.

print(recv)
if recv[:3] != b'250':
    print('250 reply not received from server.')

# Send message data.

# Message ends with a single period.

# Send QUIT command and get server response.

# Fill in end

print(recv)
if recv[:3] != b'221':
    print('221 reply not received from server.')
