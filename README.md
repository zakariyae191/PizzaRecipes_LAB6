# LAB 6: Pizza Recipes Android Application 🍕

##  1. Objectif du TP
Le but de ce TP est de développer une application Android en Java permettant d’afficher une liste de pizzas avec leurs informations et d’accéder à un écran de détails.

#  2. Structure du projet
<img width="509" height="852" alt="image" src="https://github.com/user-attachments/assets/97804dd6-27a2-4e5c-ba15-a1df03b46fcf" />

##  Étape 2 — Classe Produit

Fichier :
<img width="1184" height="932" alt="image" src="https://github.com/user-attachments/assets/a928f488-5455-4228-b88d-0f67a6c9465c" />|Cette classe représente une pizza.

Attributs :

- id (auto incrémenté)
- nom
- prix
- imageRes
- durée
- ingrédients
- description
- étapes

Contient :
- constructeur vide
- constructeur complet
- getters/setters

---
##  Étape 3 — Interface DAO

Fichier :
<img width="1026" height="752" alt="image" src="https://github.com/user-attachments/assets/8d141892-4d46-4b34-8edf-41b07fe5483b" />
Méthodes définies :

- create(T t)
- update(T t)
- delete(long id)
- findById(long id)
- findAll()
- ##  Étape 4 — Service ProduitService

Ce service :

- implémente IDao<Produit>
- stocke les pizzas dans une ArrayList
- utilise un Singleton
- initialise les pizzas avec seed()

Il joue le rôle d’une base de données mémoire.
##  Étape 5 — Splash Screen


