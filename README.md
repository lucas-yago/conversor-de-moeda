# 💱 Conversor de Moeda

Este é um conversor de moedas em **Java**, que utiliza uma API externa para obter cotações atualizadas em tempo real. O projeto é modular, interativo e conta com **registro de histórico** das conversões realizadas pelo usuário.

---

## 📌 Funcionalidades

- ✅ Conversão de valores entre diferentes moedas (USD, BRL, ARS, etc.)
- ✅ Consumo de API REST com retorno em JSON
- ✅ Entrada de dados interativa via console
- ✅ Persistência do histórico de conversões em arquivo
- ✅ Configuração externa para chave da API

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Requisições HTTP com `java.net.http`
- Manipulação de JSON com a biblioteca Gson `com.google.gson`
- Leitura e gravação de arquivos `FileWriter`
- Arquivo `config.properties` para configuração externa da chave da API

---

## ⚙️ Configuração da Chave da API

Para que o conversor funcione corretamente, é necessário fornecer uma **chave de API** válida. Essa chave é usada para acessar os dados de câmbio de moedas por meio de um serviço externo.

### 🔐 Passo a Passo para Configuração

1. **Crie um arquivo chamado** `config.properties` **na raiz do projeto**.

2. **Adicione a seguinte linha ao arquivo**, substituindo `SUA_CHAVE_AQUI` pela chave da API que você obteve:

    ```properties
    api.key=SUA_CHAVE_AQUI
    ```

3. **Salve o arquivo.** Ele será lido automaticamente pela aplicação quando for executada.


### 🛡️ Segurança

- O arquivo `config.properties` **já está incluído no `.gitignore`**, então ele **não será enviado ao GitHub**, mantendo sua chave segura.
- **Nunca compartilhe sua chave de API publicamente.**


### 🌍 Onde obter uma chave de API?

Você pode se registrar gratuitamente no **ExchangeRate API**, um serviço confiável e fácil de usar para obter taxas de câmbio de moedas em tempo real. O ExchangeRate API oferece planos gratuitos que atendem a necessidades básicas, permitindo acessar cotações atualizadas e realizar conversões simples, além de planos pagos com recursos adicionais para usos mais avançados.

Para se cadastrar, acesse: [exchangerate-api.com](https://www.exchangerate-api.com/)


---

## 🚀 Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/lucas-yago/conversor-de-moeda.git
cd conversor-de-moeda
```

2. Crie e configure o `config.properties` conforme instruído acima.

3. Compile os arquivos Java:

```bash
javac ConversorMoeda.java
```

4. Execute a aplicação:

```bash
java ConversorMoeda
```

---

## 🧾 Histórico de Conversões

Todas as conversões realizadas são salvas automaticamente em um arquivo chamado `conversionHistory.json`. Isso permite que o usuário acompanhe os valores convertidos ao longo do tempo.

---

## 📂 Estrutura do Projeto

```text
conversor-de-moedas/
├── src/
│   ├── client/
│   │   ├── ApiKeyProvider.java           # Fornece a chave da API
│   │   └── ExchangeRateClient.java       # Cliente para consumir taxas de câmbio
│   ├── model/
│   │   ├── ConversionRateResponse.java   # Representa a resposta da API de câmbio
│   │   └── Menu.java                     # Interface de menu do app
│   ├── service/
│   │    └── ConversionHistorySaver.java  # Salva o histórico de conversões
│   └── Main.java                         # Classe principal para execução
├── config.properties                     # Configurações (chave da API)
└── conversionHistory.json                # Arquivo com histórico de conversões
```

---

## 🤝 Contribuindo

Contribuições são bem-vindas!

1. Faça um fork
2. Crie uma branch (`git checkout -b feature/nova-funcionalidade`)
3. Commit suas alterações (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push na branch (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

---

Desenvolvido com 💻 por [Lucas Yago](https://github.com/lucas-yago).
