# TransactionsApp
Rest API umożliwiające audyt operacji finansowych klientów.

1. Technologie:

Spring boot 2.4.3
Spring data
Spring Security
Kotlin
MongoDB
RestAssured

2. Aplikacja:
- Wymaga autoryzacji z poziomu uzytkownika (login: User, hasło: 1234).
- Przyjmuje dwa parametry wyszukiwania: id klienta (customerID) oraz typ konta (accountType).
- Dane zostały załadowane do bazy MongoDB z załączonych plików: transactions.csv, customer.csv, accounttypes.csv.
- Wynikiem są dane posortowane po Kwocie transakcji (rosnąco) i wyświetlone w formacie JSON.
- W przypadku podania parametórw poza zakresem zwrócona zostanie pusta lista.


3. Obsługa Aplikacji przy uzyciu Postman:

Typ żądania: **GET**;
Edpoint: **http://localhost:8080/transactions**

_Sekcja Authorization:_ 
Typ: **Basic Aauth**

Username: **User**
Password: **1234**

_Sekcja Body_
Typ: form_data

Key - Przykładowe wartości do podania (Value):
- customerID: 1, lub 1,3,5 (wyszukj "1" i "3" i "5) lub all (wszystkie). Puste pole powoduje wyszukanie wszystkich.
- accountType: 1, lub 1,3,5 (wyszukj "1" i "3" i "5) lub all (wszystkie). Puste pole powoduje wyszukanie wszystkich.


Testy jednostkowe w InelliJ Idea.




        
        

