# Exercício

Um hacker invadiu a rede da sua empresa e travou todos os equipamentos (Servidores e Desktops). Porém a equipe de segurança conseguiu identificar o programa que está fazendo isso, e descobriu que ele pode ser desativado caso receba a seguinte mensagem pela porta 1110 :

`[ATTACK DISABLED]`
`[UNLOCK SYSTEM]`

􏰀O único equipamento que você tem disponível que não foi afetado é seu BlackBerry, que possui um compilador java e acesso a rede via wireless. Faça um programa que simule um cliente de conexão socket e envie esta mensagem para todos os equipamentos que estiverem no rede 172.16.168.X.

􏰀Suponha que a rede wireless esteja estabelecida e que os comandos Java do seu Blackberry são os mesmos usados no eclipse.

## Compilando o servidor

```
cd socket-server && ./compile.sh
./run.sh
```

## Executando o client

```
cd socket-client && ./compile.sh
./run.sh
```