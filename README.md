# FinalProjectPOO

## Github

https://github.com/ArthurVarez/FinalProjectPOO

Quentin KLEBAUR
Arthur VAREZ

## Objectif

L'objectif de ce projet était de créer un comparateur de performances entre plusieurs design petterns pour scrapper un site web ou une API.
En application, nous avons fait le choix d'utiliser l'API d'Imgur afin de scrapper des images.
Les design patterns implémentés sont la *Facory* et le *FlyWeight*.

## Documentation

La documentation technique du projet peut être consultée dans en ouvrant le fichier **[html/index.html](html/index.html)**.

## Utilisation

Le projet peut être lancé via un IDE adapté à Java tels que Eclipse ou IntelliJ.

Une fois lancé, le programme va télécharger des images dans les dossier **[ImageWebObjectFactory](ImageWebObjectFactory)** et **[ImageFlyweightFactory](ImageFlyweightFactory)**.

Les paramètres du programme peuvent être modifiés en changeant les variables du fichier **[src/com/FinalProject/Constants.java](src/com/FinalProject/Constants.java)**:
- **Query** est l'argument de recherche d'images sur l'API d'Imgur
- **OutputFile** est le fichier de sortie du logger
- **ImageNumber** est le nombre d'Images à télécharger

## Observations

Les résultats n'ont pas été ceux attendues. En effet, l'objectif était de montrer, notamment, que le design pattern *FlyWeight* était moins gourmand en ressource de la RAM que la *Factory*. Malheureusement, la gestion de la mémoire automatique du langage Java par garbage collector rend les resultats compliqués à exploiter. Ne pouvant pas libérer la mémoire manuellement on constate que la taille totale des objets du programme est quasiment la même entre le moment où un pattern à charger tous ses objets dans la mémoire et le moment l'espace de ces derniers est sensé être libéré. De ce fait la comparaison des performances des deux patterns est délicate. Cependant nous pouvont remarquer que la *Factory* est légèrement plus rapide que le *FlyWeight*.