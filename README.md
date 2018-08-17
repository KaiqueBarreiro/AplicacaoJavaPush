# AplicacaoJavaPush
Enviando uma notificação PUSH para o aplicativo ANDROID atravpés de uma aplicação JAVA utilizando http

Criar um projeto no site:
    console.firebase.google.com

E já existir um projeto ANDROID, e seguir os passos para criação do projeto.

Após criado o projeto no firebase, ir em -> configurações do projeto -> cloud messaging
Depois copiar a chave herdade do servidor e inserir na variável KEY_SERVIDOR.
Para conseguir seu token, seguir o projeto do android que se encontra aqui: 
    https://github.com/KaiqueBarreiro/JavaAndroidPush

No projeto android será inserido na log o seu token. Copiar esse token e colocar na variável TOKEN_DSV
E após inserido essas duas informações, só executar o programar e uma notificação será enviada para seu aplicativo desenvolvido.
