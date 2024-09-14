# Conversor de Moedas em Java

Este documento explica o funcionamento do código do conversor de moedas, tanto em português quanto em inglês.

### Explicação do Código em Português

Este programa é um conversor de moedas em Java que permite ao usuário escolher uma moeda de origem e uma moeda de destino, a partir de uma lista de sete opções, e calcular a conversão entre elas usando a API ExchangeRate. Aqui está um passo a passo do funcionamento:

#### Passo a Passo:
1. **Importação de Bibliotecas:**
   - O programa importa bibliotecas necessárias para fazer solicitações HTTP (`HttpClient`, `HttpRequest`, `HttpResponse`) e para deserializar os dados da API em formato JSON (`Gson`).

2. **Entrada do Usuário (moeda de origem e destino):**
   - O programa exibe uma lista de moedas e solicita que o usuário escolha uma moeda de origem e uma moeda de destino, digitando o número correspondente.
   - As moedas disponíveis são: Dólar Americano (USD), Real Brasileiro (BRL), Euro (EUR), Libra Esterlina (GBP), Iene Japonês (JPY), Dólar Canadense (CAD), e Franco Suíço (CHF).

3. **Obtenção dos Códigos das Moedas:**
   - O método `getCodigoMoeda` converte a opção numérica escolhida pelo usuário no código da moeda correspondente (como "USD" para Dólar Americano).

4. **Obtenção dos Nomes das Moedas:**
   - O método `getNomeMoeda` recebe o código da moeda e retorna seu nome oficial para exibição ao usuário (por exemplo, "Dólar Americano" para "USD").

5. **Solicitação à API ExchangeRate:**
   - O programa faz uma solicitação HTTP à API ExchangeRate para obter as taxas de câmbio da moeda de origem escolhida pelo usuário.

6. **Conversão das Moedas:**
   - Após receber a resposta da API, o programa usa o método `getTaxa` para buscar a taxa de câmbio da moeda de destino.
   - Em seguida, o valor inserido pelo usuário é multiplicado pela taxa de câmbio para calcular o valor convertido.

7. **Exibição do Resultado:**
   - O valor convertido é então exibido ao usuário, junto com o nome oficial da moeda de destino.

---

### Explicação do Código em Inglês

This program is a currency converter in Java that allows the user to choose a source currency and a target currency from a list of seven options and calculates the conversion between them using the ExchangeRate API. Here is a step-by-step explanation of how it works:

#### Step-by-Step:
1. **Importing Libraries:**
   - The program imports necessary libraries to make HTTP requests (`HttpClient`, `HttpRequest`, `HttpResponse`) and to deserialize JSON data from the API (`Gson`).

2. **User Input (source and target currency):**
   - The program displays a list of currencies and asks the user to choose a source and target currency by entering the corresponding number.
   - Available currencies are: US Dollar (USD), Brazilian Real (BRL), Euro (EUR), British Pound (GBP), Japanese Yen (JPY), Canadian Dollar (CAD), and Swiss Franc (CHF).

3. **Getting Currency Codes:**
   - The `getCodigoMoeda` method converts the numeric option chosen by the user into the corresponding currency code (such as "USD" for US Dollar).

4. **Getting Official Currency Names:**
   - The `getNomeMoeda` method receives the currency code and returns its official name for display to the user (e.g., "US Dollar" for "USD").

5. **Request to the ExchangeRate API:**
   - The program makes an HTTP request to the ExchangeRate API to get the exchange rates for the source currency chosen by the user.

6. **Currency Conversion:**
   - After receiving the response from the API, the program uses the `getTaxa` method to retrieve the exchange rate for the target currency.
   - Then, the value entered by the user is multiplied by the exchange rate to calculate the converted amount.

7. **Displaying the Result:**
   - The converted value is displayed to the user, along with the official name of the target currency.

---

Este markdown explica cada etapa do programa, tanto em português quanto em inglês, para ajudar a entender o funcionamento e a lógica do conversor de moedas.
