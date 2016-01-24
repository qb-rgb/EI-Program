Quentin Baert  
Master MOCAD  

# EI - Détermination du modèle minimal

## Remarques

Dans ce projet, les relations sont considérées comme non orientées.

## Outils

Le programme est écrit en Scala. Le seul outil nécessaire à sa compilation et son exécution est SBT (Scala Build Tool, disponible ici : http://www.scala-sbt.org/download.html).

## Utilisation

Pour faire vos propres tests, veuillez ajouter des noeuds, relations et règles au fichier `src/main/scala/programs/Main.scala`.

Pour exécuter le main, taper la commande suivante depuis la racine du projet :
```
sbt run
```

Il est également possible de générer un `jar` exécutable à la racine du projet en utilisant le script `compile.sh` :
```
./compile.sh
```

On exécute ce `jar` grâce à la commande :
```
java -jar program.jar
```

Un `jar` exécutable est fourni, il présente le modèle suivant :
```
[1]--E--[2]--E--[3]--E--[4]

R(x, y) :- E(x, z) E(z, y)
T(x)    :- E(y, z) E(z, w) E(w, x)
```

Voici sa trace de sortie qui présente toutes les relations existantes après avoir itéré sur les règles :
```
E: Node(1), Node(2)
E: Node(3), Node(4)
E: Node(2), Node(3)
R: Node(2), Node(4)
R: Node(1), Node(3)
T: Node(1)
T: Node(4)
```
