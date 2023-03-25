# Projet-fin-de-formation

## Cahier de charge
Projet : Gestion de compte bancaire

Objectif : développer une plateforme web pour la gestion de comptes bancaires.

Utilisateurs : Agence, Client

Client : Consultation, retrait, dépôt, simulation crédit

Agence : gestion de comptes : création, modification, clôture

Règles de gestion :

- Un client peut créer un seul compte.

- Un compte à un seul propriétaire.

- Une opération concerne un seul compte.

- Un compte peut subir plusieurs opérations.

- Un client peut effectuer plusieurs simulations.

- Une simulation concerne un seul client

La présentation doit contenir les éléments suivants :

- Une description de projet.
- Les différentes fonctionnalités
- Le dictionnaire de données.
- Le Modèle conceptuel de données (MCD)
- Les diagrammes UML :
- Diagramme Use case.
- Diagramme de classe.
- Quelques diagrammes de séquence.

- Etude technique :
- Architecture.
- Framework avec une argumentation sur le choix.
- La base de données.
- Le langage de développement.
- Mise en œuvre :
- Template.
- Réalisation.
- Tests.
- Livrable WAR.

## Comment lancer le projet ?

### Initialiser la BDD

- Créer une base de données MySQL de nom gestiondecomptedb avec l'utilisateur root (ou alors adapter le fichier application.properties du projet Spring Boot)

- importer le script de création de tables / remplissage des tables avec des données

### Lancer le Backend Spring Boot

- ouvrir le projet avec eclipse
- Run as maven install OU ```mvn install ```
- Run as spring boot app OU ```mvn spring-boot:run ```

### Lancer le Frontend Angular

- ouvrir gestionDeCompteBancaire App
- (installer angular/cli si nécessaire) ```npm i -g @angular/cli```
- ```npm install ```
- ```ng serve ```
- l'application devrait être utilisable : http://localhost:4200


