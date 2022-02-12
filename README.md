# CLI-menu-server

Partie frontend de menu-server

## Installation

1. Télécharger l'artifact de la dernière release.
2. Ajouter l'alias menucli à votre system :
- Sur Ubuntu :
Dans votre dossier root créer un fichier .bash_aliases:
`touch ~/.bash_aliases`
Ajouter l'alias au fichier .bash_aliases:
alias menucli='java -cp "/chemin/vers/MenuCli-jar-with-dependencies.jar" MenuCli'

## Utilisation

### Lister tous les menus :
`menucli list-menu`

### Supprimer un menu :
`menucli delete-menu <id>`
où id est l'identifiant du menu à supprimer

### Changer l'url du server auquel l'application se connecte :
`menucli --server-url="urlDuServer"`
ou
`menucli -s="urlDuServer"`