## Przypadki użycia

0. Przypadek użycia Rejestracja

Cel: Utworzenie konta przyszłemu klientowi banku.

Założenia wejściowe: Podmiot rejestrujący się nie jest jeszcze klientem
banku i spełnia ograniczenia wiekowe.

Założenia wyjściowe: Zostanie utworzone danemu użytkownikowi konto
bankowe.

Przebieg:
0. Przyjęcie od użytkownika danych imię, nazwisko, PESEL, numer dokumentu tożsamości, adres do korespondencji, datę urodzenia.
0. Sprawdzenie, czy wprowadzone dane są zgodne z odpowiadającym im formatom.
0. Jeśli dane są nie poprawne, wyświetlany jest komunikat o błędzie i proces rejestracyjny jest przerywany.
0. Wygenerowanie i wyświetlanie loginu i hasła użytkownikowi.
0. Wyświetlenie danych potrzebnych do autoryzacji dwuetapowej (2FA).
0. Utworzenie konta na podstawie uzyskanych danych.


0. 0. Przypadek użycia logowanie

Cel: Autoryzacja użytkownika.

Założenia wejściowe: PU rejestracja został wykonany.

Założenia wyjściowe: Użytkownik zostanie zalogowany.

Przebieg:
0. Przyjęcie od użytkownika loginu, hasła i kodu autoryzacji dwustopniowej (2FA).
0. Sprawdzenie, czy wprowadzone dane są zgodne z odpowiadającym im formatom.
0. Jeśli dane są nie poprawne, wyświetlany jest komunikat o błędzie i proces logowania jest przerywany.
0. Sprawdzenie, czy konto z podanymi danymi do logowania istnieje.
0. Jeśli konto nie istnieje, wyświetlany jest komunikat o błędzie i proces logowania jest przerywany.
0. Użytkownik zostaje zalogowany.



0. 0. Przypadek użycia wgląd do stanu konta.

Cel: Użytkownik ma wgląd do stanu swojego konta.

Założenia wejściowe: PU logowanie został wykonany.

Założenia wyjściowe: Wyświetlenie stanu konta.

Przebieg:
0. Zgodnie z identyfikatorem użytkownika, odpytywany jest system bazy
danych o stan konta.



0. 0. Przypadek użycia wgląd do historii wpływów i wypływów.

Cel: Użytkownik ma wgląd do historii transakcyjnych.

Założenia wejściowe: PU logowanie został wykonany.

Założenia wyjściowe: Wyświetlenie stanu konta.

Przebieg:
0. Zgodnie z identyfikatorem użytkownika, odpytywany jest system bazy
danych o stan konta.
