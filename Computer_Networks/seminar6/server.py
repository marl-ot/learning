#!/bin/python3
import socket

# Connection Data
host = '127.0.0.1'
port = 8000

# Starting Server
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server:
    server.bind((host, port))
    server.listen()

    # Lists For Clients and Their Nicknames
    clients = []
    nicknames = []

    # Sending Messages To All Connected Clients

    def broadcast(message):
        for client in clients:
            client.send(message)

    # Handling Messages From Clients

    def handle(client):
        while True:
            try:
                # Broadcasting Messages
                message = client.recv(1024)
                broadcast(message)
            except Exception as e:
                # Removing And Closing Clients
                print(e)
                index = clients.index(client)
                clients.remove(client)
                client.close()
                nickname = nicknames[index]
                broadcast('{} left!'.format(nickname).encode('utf-8'))
                nicknames.remove(nickname)
                break

    print("Server is listening...")

    while True:
        # Accept Connection
        client, address = server.accept()
        print("Connected with {}".format(str(address)))

        # Request And Store Nickname
        client.send('NICK'.encode('utf-8'))
        nickname = client.recv(1024).decode('utf-8')
        nicknames.append(nickname)
        clients.append(client)

        # Print And Broadcast Nickname
        print("Nickname is {}".format(nickname))
        broadcast("{} joined!".format(nickname).encode('utf-8'))
        client.send('Connected to server!'.encode('utf-8'))

        # Start Handling For Client
        handle(client)
