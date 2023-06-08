import socket

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_address = ('localhost', 8888) 

sock.bind(server_address)

sock.listen(5)
print('Socket a la escucha.....')
while True:
    (connection, client_address) = sock.accept()
    try:
        while True:
            mensRecibido = connection.recv(2024)
            print('Cliente: {!r}'.format(mensRecibido))
            
            
            mensaje1=str(input('Ingrese su Mensaje: ')) 
            connection.sendall(str(mensaje1).encode())
            print('Server: '+mensaje1)
              
            
        
    finally:
        connection.close()