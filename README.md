# oblig2-obj1
GruppeID: Gruppe 17
<p>Vår løsning på obligatorisk oppgave 2 "Lighting Simulator", i faget Objektorientert programmering i Java</p>
<p>Prosjektnavn: "Fade Light"</p>
<p> Forklaringer til json-filene:</p>
<p>Denne settings.json-filen er lagt til fordi VS Code ikke automatisk finner JavaFX-bibliotekene.
Ved å bruke "java.project.referencedLibraries" peker vi eksplisitt på alle JavaFX .jar-filene
i lib/-mappen til JavaFX SDK. Dette gjør at VS Code gjenkjenner javafx.importer,
fjerner røde streker, og sørger for at Java-språkserveren (Language Server) kan kompilere
prosjektet riktig. Dette er nødvendig fordi JavaFX ikke lenger følger med i standard JDK,
og Temurin/OpenJDK krever at bibliotekene registreres manuelt. Dette var et problem for Maria, vel og merke.</p>
<p>launch.json brukes av VS Code for å kunne kjøre en JavaFX-applikasjon direkte fra editoren.
Fordi JavaFX ikke er en del av JDK, må vi sende inn VM-argumenter manuelt:
--module-path  (peker til JavaFX SDK sin lib/-mappe)
--add-modules  (forteller JVM hvilke JavaFX-moduler som skal lastes).

Uten denne konfigurasjonen vil programmet kompilere, men ikke starte, og
man får feilen: "java.lang.NoClassDefFoundError: javafx/application/Application".
launch.json sikrer at JavaFX-modulene lastes inn når MainApp kjører.</p>



