#!/bin/bash

# Cria o diretório bin se não existir
mkdir -p bin

# Remove arquivos .class antigos
rm -rf bin/*

# Compila todos os arquivos Java do projeto
echo "Compilando os arquivos Java..."
javac -d bin src/Armas/*.java
javac -d bin src/Ferramentas/*.java
javac -d bin src/jogo/*.java
javac -d bin src/jogo/Personagens/*.java
javac -d bin src/Main.java

# Verifica se a compilação foi bem sucedida
if [ $? -eq 0 ]; then
    echo "Compilação concluída com sucesso!"
    echo "Para executar o programa, digite: java -cp bin Main"
    # Executa o programa automaticamente
    java -cp bin Main
else
    echo "Erro na compilação!"
fi