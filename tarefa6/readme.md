🚀 Como Implementar (Passo a Passo)
Passo 1: Baixar Dependências JAXB
mkdir -p lib
cd lib

# JAXB para Java 11+
# 1. JAXB API
wget https://repo1.maven.org/maven2/javax/xml/bind/jaxb-api/2.3.1/jaxb-api-2.3.1.jar

# 2. JAXB Runtime (Core)
wget https://repo1.maven.org/maven2/org/glassfish/jaxb/jaxb-runtime/2.3.1/jaxb-runtime-2.3.1.jar

# 3. Activation
wget https://repo1.maven.org/maven2/javax/activation/activation/1.1.1/activation-1.1.1.jar

# 4. istack-commons-runtime (FALTAVA ESTA!)
wget https://repo1.maven.org/maven2/com/sun/istack/istack-commons-runtime/3.0.12/istack-commons-runtime-3.0.12.jar

# 5. TXW2
wget https://repo1.maven.org/maven2/org/glassfish/jaxb/txw2/2.3.1/txw2-2.3.1.jar

# 6. JUnit (para testes)
wget https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.1/junit-platform-console-standalone-1.10.1.jar
wget https://repo1.maven.org/maven2/com/sun/istack/istack-commons-runtime/3.0.7/istack-commons-runtime-3.0.7.jar
wget https://repo1.maven.org/maven2/org/glassfish/jaxb/txw2/2.3.1/txw2-2.3.1.jar  
wget https://repo1.maven.org/maven2/com/sun/xml/fastinfoset/FastInfoset/1.2.15/FastInfoset-1.2.15.jar

# JUnit (se ainda não tiver)
wget https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.1/junit-platform-console-standalone-1.10.1.jar

cd ..

Passo 2: Compilar
# Compilar código fonte
javac -d bin -cp "lib/jaxb-api-2.3.1.jar:lib/jaxb-runtime-2.3.1.jar:lib/activation-1.1.1.jar" \
  -sourcepath src $(find src -name "*.java")

# Compilar testes
javac -d bin -cp "bin:lib/junit-platform-console-standalone-1.10.1.jar:lib/jaxb-api-2.3.1.jar:lib/jaxb-runtime-2.3.1.jar:lib/activation-1.1.1.jar" \
  -sourcepath test $(find test -name "*.java")

 Passo 3: Executar
  java -cp "bin:lib/jaxb-api-2.3.1.jar:lib/jaxb-runtime-2.3.1.jar:lib/activation-1.1.1.jar" \
  com.rpglab.game.Main

Passo 4: Testar Save/Load

1. Inicie um novo jogo
2. Jogue algumas fases
3. No menu pós-fase, escolha "Salvar Jogo"
4. Saia do jogo
5. Execute novamente
6. Escolha "Carregar Jogo"
7. Verifique se o progresso foi restaurado