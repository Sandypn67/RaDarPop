# RaDarPop : The Ghibli App

[![forthebadge](http://forthebadge.com/images/badges/built-with-love.svg)](http://forthebadge.com) [![forthebadge](https://forthebadge.com/images/badges/powered-by-coffee.svg)](https://forthebadge.com)

### Une petite description du projet
Mon application a pour but de donner envie aux utilisateurs de découvrir les films d'animation du studio japonais Ghibli. Elle se compose d'une page d'accueil avec une liste des différents films créé par ce studio depuis sa création en 1985, d'une page de description du film - le synopsis en anglais de celui-ci- et d'une dernière page d'informations concernant le studio.

![alt text](https://github.com/Sandypn67/RaDarPop/blob/master/icone.PNG)

Ce qu'il est requis pour commencer avec RaDarPop: The Ghibli App 

    Android Studio
    Emulateur portable supportant SdkVersion >= 23
    Télécharger le projet depuis la branche master de ce répertoire et l'importer dans votre logiciel AndroidStudio
    Avoir une bonne connexion internet pour télécharger les données de l'API

##  Installation

Si ce n'est pas déjà fait, installer le logiciel AndroidStudio
->    https://developer.android.com/studio

Etre sur d'avoir une connexion internet pour pouvoir se connecter à l'API Ghibli

Lancer l'application sur AndroidStudio en appuyant sur l'icone de run ( sous forme de flèche verte dans la barre d'outils)

Programmes, logiciels et ressources utilisées dans ce projet:

    ghibliapi.herokuapp.com - API Ghibli
    AndroidStudio -  environnement de développement
    Google Images - moteur de recherche
    
## Projet en pratique
### Auteur:

    Sandrine Miconnet alias @Sandypn67
    
### Le contenu du Github:

Nécessaire:
####
* Ecran avec une liste d'élements
* Appel WebService à une API Rest
* Stockage de données en cache
* Ecran avec le détail d'un élément
-----------------
Les plus:
####
* Singleton
* Design
* MVC
* 3ème écran d'information et navigation

## Design
La page d'accueil: liste des films disponibles (*titre en anglais car API anglaise)

![alt text](https://github.com/Sandypn67/RaDarPop/blob/master/Accueil.PNG)

La page de détail: affiche le synopsis du film (*description en anglais car API anglaise)

![alt text](https://github.com/Sandypn67/RaDarPop/blob/master/detailPage.PNG)

La page d'informations complémentaire sur le studio: (*texte en français car contenu fixe)

![alt text](https://github.com/Sandypn67/RaDarPop/blob/master/troisi%C3%A8mePage.PNG)


**Enjoy your app !**
