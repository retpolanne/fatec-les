# IOStrategy

Lib de IO utilizando strategy pattern

## Usage
`./compile`

Localize o .jar e importe para o projeto utilizando o eclipse ou passando a flag `-classpath`

Obs: o `-classpath` deve conter o endereço absoluto do .jar.

No seu código, importe: 
```
import iohelper.contexts.IOContext;
import iohelper.strategies.SocketIOStrategy; // Se estiver usando sockets
```

Exemplo:

```
Socket socket = new Socket(host, port);
IOContext ioContext = new IOContext(socket);
ioContext.setIOStrategy(new SocketIOStrategy());
ioContext.attachIO();
ioContext.write("GET", false);
```