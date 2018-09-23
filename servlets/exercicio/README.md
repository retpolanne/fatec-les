# CheckLogin servlet

Usage
```
./compile.sh
./run.sh
```

Obs: é necessário ter o Docker instalado e ter o jar `servlet-api.jar` nessa pasta. 

Se não tiver, execute o `./run.sh` em um terminal e `./extract-servlet.sh` em outro.

Execute `./recover-sql-local.sh` para criar e atualizar o banco de dados (obs: é realizado um DROP na tabela, utilize com precaução)

No final, acesse `localhost:8080/CheckLogin/`

## TODO
[ ] Parametrizar o context.xml