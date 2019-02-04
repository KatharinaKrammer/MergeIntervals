# MergeIntervals
Programmieraufgabe Brunel / Daimler TSS. Überlappende Intervalle werden gemerged.

Input
Es werden Intervalle als String an die Methode übergeben, die zu implementieren war. In der Form, wie sie in der Aufgabestellung vorkamen. 
Also ein Intervall dargestellt durch 2 eckige Klammern, in denen 2 Zahlen, jeweils durch ein Komma getrennt, die untere und obere Grenze des Intervals darstellen. Zum Beispiel [5,9][100,10000000][-4,0][0,0][101,103][102,200]. Es dürfen keine Intervallgrenzen größer als 2.147.483.647 bzw kleiner als -2.147.483.648 eingegeben werden. 

Output:
Zurückgegeben wird ein String, der die gemergden Intervalle enthält. In diesem Fall also [-4, 0] [5, 9] [100, 10000000].

Hinweis: Die Bezeichnung "Liste" in der Aufgabestellung habe ich nicht im Sinne eines Java-List-Elements verstanden sondern im allgemein gebräuchlichen Sinn.
Die hier eingestellte Implementierung enthält in der Main eine Konsoleneingabe, sodass man sie direkt ausführen kann. 
Unit-Tests sind hier nicht implementiert. 
