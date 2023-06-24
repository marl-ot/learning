import socket

# Choosing Nickname
nickname = input("Choose your nickname: ")

# Connecting To Server
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client:
    client.connect(('127.0.0.1', 8000))

    # Listening to Server and Sending Nickname
    def receive():
        while True:
            try:
                # Receive Message From Server
                # If 'NICK' Send Nickname
                message = client.recv(1024).decode('utf-8')
                if message == 'NICK':
                    client.send(nickname.encode('utf-8'))
                else:
                    print(message)
            except Exception as e:
                # Close Connection When Error
                print(e)
                client.close()
                break

    def write():
        while True:
            message = '{}: {}'.format(nickname, input(''))
            client.send(message.encode('utf-8'))

    # Start Listening and Writing Threads
    receive()
    write()
