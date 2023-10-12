# Inżynieria Oprogramowania - Projekt
Temat: Program obsługujący konto bankowe
## Słowny opis wymagań
UKB
### Wymagania funkcjonalne
0. Potencjalny klient banku może zarejestrować nowe konto bankowe.
0. UKB ma wgląd do stanu swojego konta bankowego w PLN.
0. UKB ma wgląd do przypisanych do konta i aktywnych lokat.
0. UKB może przelewać pieniądze ze swojego konta bankowego na konto bankowe innego UKB tego samego systemu.
0. UKB może przelewać pieniądze ze swojego konta bankowego na konto bankowe innego UKB zewnętrzego systemu bankowego.
0. UKB może zakładać lokaty bankowe o określonym oprocentowaniu określonym w katalogu lokat banku.
0. UKB może włączyć lub wyłączyć opcję przewalutowanie przelewów ze swojego konta bankowego.
0. UKB ma prawo złożyć podanie elektroniczne o zamknięcie konta bankowe.
0. UKB może zamknąć lokatę przed terminem jej zakończenia.
0. UKB może stworzyć cykliczne zlecenie przelewu ze swojego konta.
0. UKB może zamknąć cykliczne zlecenie przelewu ze swojego konta.
0. UKB ma wgląd do historii wpływów i wypływów finansowych ze swojego konta.
0. UKB może rozpocząć, prowadzić i zakończyć chat z chatbotem w celu uzyskania pomocy i/lub oferty banku.

### Wymagania niefunkcjonalne
0. Dostęp do konta UKB wymaga autoryzacji przez podanie danych dostępowych: loginu i hasła.
0. System obsługuje po stronie użytkownika język polski m.in., generując komunikaty o błędach czy udostępniając interfejs użytkownika w tym języku.
0. Przelew między UKB jest możliwy tylko pod warunkiem posiadania wystarczających środków na koncie.
0. Przelew do banku, w którym waluta jest inna niż PLN jest możliwy wyłącznie, kiedy UKB ma włączoną opcję przewalutowania.

