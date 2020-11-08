#### Beschreiben Sie welches Pattern hier geeignet ist, damit die angeschlossenen Zielsysteme jederzeit die aktuellen Temperaturwerte zur Verfügung haben. Beschreiben Sie beispielhaft einen typischen Datenabruf in einem UML Sequence Chart.

Oberserver - Pattern, da hier die Subjects (Sensoren) selber entscheiden wann sie die Observer mit neuen Daten beliefern.

#### Machen Sie eine einfache Überschlagsrechnung für folgendes Szenario: 
     Die Temperatur schwankt täglich um 30° (in 0.5° Schritten) auf und ab.
     Vergleichen Sie die Zahl der täglich übertragenen Datenpakete, wenn ein Sensor minütlich
     seine Messwerte an alle Systeme schickt, im Vergleich zu Ihrer vorgeschlagenen Lösung.
     Sie dürfen dabei (stark vereinfacht) davon ausgehen, dass jeder Methodenaufruf (mit
     Antwort) ein Datenpaket ist.
     
Schwankung: 30°C in 0,5°C Schritten => 60 benötigte Benachrichtigungen über Veränderungen.  
1 Tag = 24h = 1440 Minuten => 1440 Benachrichtigungen an alle Sensoren  
Wir benötigen 60 Benachrichtigungen, während bei minütlichen Benachrichtigungen 1440 Benachrichtigungen benötigt werden.  