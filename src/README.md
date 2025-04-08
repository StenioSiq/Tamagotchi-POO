
# Tamagotchi em Java - POO | Unilavras

Projeto de um Tamagotchi virtual desenvolvido em Java, utilizando o padrão de projeto **Strategy**, com estrutura modular organizada em **pacotes**.

---

## 📋 Funcionalidades

- Alimentar, dormir, brincar, tomar banho e conversar com o Tamagotchi.
- Sistema de **ciclo de vida**: Bebê → Adolescente → Adulto.
- **Eventos aleatórios**: como doenças e mudanças climáticas que afetam os atributos.
- Atributos adicionais: **higiene** e **socialização**.
- Mini-jogo de **Jokenpô** implementado com Strategy (ponto extra).
- Estrutura 100% **orientada a objetos**.

---

## 🗂️ Estrutura de Pastas

```
tamagotchi/
│
├── main/                # Ponto de entrada
│   └── Main.java
│
├── core/                # Núcleo do Tamagotchi
│   ├── Tamagotchi.java
│   └── CicloDeVida.java
│
├── estados/             # Estratégias (ações do Tamagotchi)
│   ├── Estado.java
│   ├── Comer.java
│   ├── Dormir.java
│   ├── Brincar.java
│   ├── TomarBanho.java
│   └── Conversar.java
│
├── eventos/             # Eventos aleatórios
│   └── EventoAleatorio.java
│
├── jokenpo/             # Mini-jogo de Jokenpô
│   ├── JokenpoStrategy.java
│   ├── Pedra.java
│   ├── Papel.java
│   ├── Tesoura.java
│   └── JokenpoGame.java
```

---

## ⚙️ Como compilar e executar

1. **Compile todos os arquivos:**
   ```bash
   javac tamagotchi/**/*.java
   ```

2. **Execute o programa:**
   ```bash
   java tamagotchi.main.Main
   ```


