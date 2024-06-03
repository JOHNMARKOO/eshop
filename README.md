# eshop
Projekt „,eShop":
Aufgabe 1: Anwendungskern + CUI
Im ersten Schritt soll zunächst der Anwendungskern entwickelt werden, in dem die für den eShop relevanten Datenstrukturen wie z.B. Artikeldaten (vertikale ,„Schicht") und die darauf arbeitenden Operationen wie z.B. das Ein- und Auslagern von Artikeln (Anwendungslogik, mittlere Schicht) sinnvoll in Klassen strukturiert werden. Beachten Sie, dass diese Klassen ggf. miteinander kooperieren müssen, indem sie gegenseitig Methoden aufrufen.
Die (minimalen) fachlichen Anforderungen an den eShop in der Übersicht:
•	In einem eShop werden Artikel mit eindeutiger Artikelnummer, Bezeichnung und Bestand gespeichert und können auf dem Bildschirm ausgegeben werden (Ausgabe • Aufgabe der Benutzungsschnittstelle auf Schicht 1).
•	Es gibt Mitarbeiter (mit eindeutiger Nummer und Name) und Kunden (ebenfalls mit Nummer und Name, aber auch mit Adresse), die sich über Benutzerkennung und Passwort einloggen können. Beliebige Nutzer können sich selbst als Kunden registrieren. Ein Mitarbeiter kann neue Mitarbeiter im System registrieren.
•	Mitarbeiter können neue Artikel anlegen und den Bestand existierender Artikel verändern.
•	Kunden können (mehrere!) Artikel in ihren Warenkorb legen, die Stückzahl von Artikeln im Warenkorb ändern und den Warenkorb leeren. •
•	Kunden können im Warenkorb enthaltene Artikel kaufen, wobei der Warenkorb geleert wird und die Artikel aus dem Bestand genommen werden. Es wird eine Rechnung erzeugt und auf dem Bildschirm ausgegeben. Die Rechnung enthält u.a. Kunde, Datum, die gekauften Artikel inkl. Stückzahl und Preisinformation sowie den Gesamtpreis. •
•	Jede Ein- und Auslagerung wird als Ereignis mit Datum (Nummer des Jahrestags reicht), betroffenem Artikel, Anzahl sowie beteiligtem Mitarbeiter bzw. Kunden festgehalten.

