## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

### Git
    ## Para publicar sua branch:
    - git add .
    - git commit -m "Implementação"
    - git push -u origin main ou  git push -u origin Nome-da-sua-Branch
    ## Configuração Global do Git(Rpimeira vez):
    - git config --global user.name "Seu Nome"
    - git config --global user.email "seu.email@exemplo.com"

    ## Listar todas as branches remotas:
    - git branch -r
    ## Listar todas as branches (locais e remotas):
    - git branch -a
    ## Atualizar a lista de branches remotas:
    - git fetch origin
    ## Para baixar todas as branches remotas, você pode usar:
    - git fetch --all
    ## Para criar branches locais que acompanham as branches remotas, você pode usar:
        # Para uma branch específica
        - git checkout -b nome-branch origin/nome-branch

        # Para todas as branches remotas
        -git branch -r | grep -v '\->' | while read remote; do git branch --track "${remote#origin/}" "$remote"; done