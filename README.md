# Cafeteria — refatoração SOLID

Estudo de caso: uma classe que calcula o valor de um pedido e grava um log em arquivo, violando quase todos os princípios SOLID de uma vez. O repositório contém o código original, a análise das violações e a versão refatorada.

---

## O código original

Uma única classe `Cafeteria` que:
- calcula o preço do pedido por meio de uma cadeia de condicionais sobre o tipo de bebida
- formata a saída
- abre um arquivo e grava o log

Funciona. E é impossível de mudar sem quebrar.

---

## As violações

**Single Responsibility.** A classe tem três motivos para mudar: alteração de preço, alteração de formato de saída, alteração de destino do log. Três razões, três responsabilidades, uma classe.

**Open/Closed.** Adicionar uma bebida nova exige editar o método de cálculo. A classe não está fechada para modificação — cada produto novo é uma cirurgia no código já testado.

**Dependency Inversion.** A regra de negócio depende diretamente de escrita em arquivo texto. A camada de alto nível conhece um detalhe de infraestrutura de baixo nível.

---

## A refatoração

O cálculo de preço sai da cadeia de condicionais e vira polimorfismo — cada produto sabe seu próprio preço. A persistência do log sai da classe de negócio e vira uma abstração, com implementações concretas para cada destino.

Resultado: a classe de negócio passa a depender de interfaces, não de decisões.

---

## Os três cenários de mudança

O valor da refatoração se mede pelo custo de mudar. Os três cenários abaixo estruturam a análise:

**1 — Trocar log de arquivo TXT por banco SQL.**
No código original: editar a classe de negócio e testar tudo de novo.
Refatorado: escrever uma nova implementação da abstração de log e injetá-la. **Zero linhas alteradas na classe de negócio.**

**2 — Vender Frappuccino.**
No original: mais um `if` na cadeia de condicionais, dentro de código já testado.
Refatorado: uma classe nova. Nada existente é tocado — que é literalmente a definição de Open/Closed.

**3 — Versão "Totem de Autoatendimento", sem log em arquivo.**
No original: impossível reaproveitar a classe `Cafeteria` — a escrita em arquivo está soldada a ela.
Refatorado: injeta-se uma implementação que não faz nada, ou que escreve em outro destino. A regra de negócio é reaproveitada sem alteração.

---

## Como executar

```bash
javac -d bin src/**/*.java
java -cp bin Main
```

---

Trabalho de implementação — Projeto e Arquitetura de Software, Universidade de Caxias do Sul (UCS).

---

> ⚠️ **Confirmar antes de publicar:** ajuste os nomes de classe e o comando de execução ao seu código real. Se você manteve o código original em uma pasta e o refatorado em outra, diga isso no README — a comparação lado a lado é o que dá valor ao repositório.
