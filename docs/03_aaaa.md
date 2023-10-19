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


0. Przypadek użycia logowanie

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



0. Przypadek użycia wgląd do stanu konta.

    Cel: Użytkownik ma wgląd do stanu swojego konta.

    Założenia wejściowe: PU logowanie został wykonany.

    Założenia wyjściowe: Wyświetlenie stanu konta.

    Przebieg:

    0. Zgodnie z identyfikatorem użytkownika, odpytywany jest system bazy
    danych o stan konta.



0. Przypadek użycia wgląd do historii wpływów i wypływów.

    Cel: Użytkownik ma wgląd do historii transakcyjnych.

    Założenia wejściowe: PU logowanie został wykonany.

    Założenia wyjściowe: Wyświetlenie stanu konta.

    Przebieg:

    0. Zgodnie z identyfikatorem użytkownika, odpytywany jest system bazy
    danych o stan konta.


0. Przypadek użycia zamykania konta

    Cel: Usunięcie niechcianego przez UKB konta które posiada.

    Założenia wejściowe: PU logowanie został wykonany.

    Założenia wyjściowe: Konto UKB zostaje oznaczone jako do usunięcia

    Przebieg:

    0. Przyjęcie od UKB danych z formularza usuwania konta.
    0. Jeśli dane są nie poprawne, wyświetlany jest komunikat o błędzie i proces zamykania konta jest przerywany.
    0. Jeśli konto UKB posiada jakieś środki, wyświetlany jest komunikat o konieczności
    opróżnienia konta i proces zamykania konta jest przerywany. 
    0. Jeśli konto UKB posiada jakieś nieuregulowane rachunki, wyświetlany jest komunikat o konieczności
    uregulowania rachunków i proces zamykania konta jest przerywany. 
    0. Zgodnie z identyfikatorem użytkownika, wysyłane jest polecenie do systemu bazy danych o oznaczenie konta UKB do usunięcia.
    0. Wyświetlony zostanie komunikat o pomyślnym przeznaczeniu konta do usunięcia.



0. Przypadek użycia zmiany stanu automatycznego przewalutowania

    Cel: UKB włącza automatyczne przewalutowania, bądź je wyłącza

    Założenia wejściowe: PU logowanie został wykonany.

    Założenia wyjściowe: Nastąpiła zmiana stanu opcji automatycznego przewalutowania.

    Przebieg:

    0. Przyjęcie od UKB danych z formularza automatycznego przewalutowania.
    0. Jeśli dane są nie poprawne, wyświetlany jest komunikat o błędzie i proces zmiany przewalutowania jest przerywany.
    0. Zgodnie z identyfikatorem użytkownika, wysyłane jest polecenie do systemu bazy danych o zmianę 
    0. Wyświetlony zostanie komunikat o pomyślnym zmienieniu stanu automatycznego przewalutowania.



0. Przypadek użycia zlecenia przelewu 

    Cel: UKB przelewa określoną ilość środków swojego konta na konto adresata

    Założenia wejściowe: PU logowanie został wykonany, lub PU wykonania przelewu cyklicznego jest wykonywany.

    Założenia wyjściowe: Przelew został zlecony

    Przebieg:

    0. Przyjęcie od UKB danych z formularza zlecenia przelewu.
    0. Jeśli kwota przelewu jest wyższa niż stan konta UKB zlecającego przelew, wyświetlany jest
    komunikat o błędzie i proces zlecania przelewu jest przerywany.
    0. Jeśli adresat przelewu jest w zewnętrznym banku, wykonywany jest przypadek użycia zlecenia
    przelewu do zewnętrznego systemu bankowego.
    0. Jeśli adresat przelewu nie jest w zewnętrznym banku, wykonywany jest przypadek użycia zlecenia
    przelewu w obrębie tego samego systemu bankowego
    0. Sprawdzone jest czy wykonana procedura zwróciła błąd.
    0. Jeśli wykonana procedura zwróciła błąd, wyświetlany jest błąd i przerywana jest procedura 
    zlecania przelewu.




0. Przypadek użycia zlecenia przelewu do zewnętrznego systemu bankowego

    Cel: UKB przelewa określoną ilość środków swojego konta na konto adresata

    Założenia wejściowe: Wykonywany jest przypadek użycia zlecenia przelewu

    Założenia wyjściowe: Przelew został zlecony

    OSB - obcy system bankowy - system bankowy działający niezależnie od tego systemu bankowego.
    LSB - lokalny system bankowy - ten system bankowy.

    Przebieg:

    0. OSB odpytany jest o walutę której używa.
    0. Jeśli waluta OSB nie jest taka sama jak LSB, sprawdzana jest opcja automatycznego
    przewalutowania UKB zlecającego przelew.
    0. Jeśli opcja automatycznego przewalutowania nie jest włączona, wyświetlany jest komunikat błędu i 
    proces zlecania przelewu jest przerywany z błędem.
    0. Kwota przelewu na koncie UKB zlecającego przelew jest zamrażana.
    0. Jeśli waluta OSB nie jest taka sama jak LSB, podana kwota środków przelewu jest przewalutowywana.
    0. Jeśli waluta OSB nie jest taka sama jak LSB, przewalutowana kwota środków przelewu jest
    przesyłana do OSB z danymi adresata.
    0. Jeśli waluta OSB jest taka sama jak LSB, kwota środków przelewu jest przesyłana do OSB z danymi 
    aadresata.
    0. Zamrożona kwota środków zostaje usunięta z konta UKB zlecającego przelew.



0. Przypadek użycia zlecenia przelewu w obrębie tego samego systemu bankowego.

    Cel: UKB przelewa określoną ilość środków swojego konta na konto adresata

    Założenia wejściowe: Wykonywany jest przypadek użycia zlecenia przelewu

    Założenia wyjściowe: Przelew został zlecony

    LSB - lokalny system bankowy - ten system bankowy.

    Przebieg:

    0. Kwota przelewu na koncie UKB zlecającego przelew jest zamrażana.
    0. Zamrożona kwota przelewu zostaje dodana do konta UKB będącego adresatem przelewu.
    0. Zamrożona kwota środków zostaje usunięta z konta UKB zlecającego przelew.
    0. Zamrożona kwota środków zostaje odmrożona z konta UKB będącego adresatem przelewu.



0. Przypadek użycia zlecenia przelewu cyklicznego

    Cel: UKB przelewa określoną ilość środków swojego konta na konto adresata określoną ilość razy,
    w określonych odstępach czasowych.

    Założenia wejściowe: PU logowanie został wykonany.

    Założenia wyjściowe: Przelew cykliczny został zapisany.

    Przebieg:

    0. Przyjęcie od UKB danych z formularza zlecenia przelewu cyklicznego.
    0. Przesłanie danych do systemu bazy danych.


0. Przypadek użycia wykonania przelewu cyklicznego

    Cel: System informatyczny zleca wykonania przelewów na podstawie zapisanych 
    informacji podanych przez przypadek użycia przelewu cyklicznego.

    Założenia wejściowe: Przypadek jest wykonywany o północy każdego dnia roboczego.

    Założenia wyjściowe: Przelew został zlecony

    Przebieg:

    0. System bazy danych jest odpytany o zapisane zlecenia przelewów cyklicznych.
    0. Dla każdego zlecenia, wykonaj PU wykonania przelewu.
    0. Jeśli PU wykonania przelewu nie został wykonany pomyślnie, prześlij błąd UKB który zlecił zlecenie i usuń zlecenie.


0. Przypadek użycia wyświetlenia zleceń cyklicznych

    Cel: UKB dowiaduje się o swoich 
    informacji podanych przez przypadek użycia przelewu cyklicznego.

    Założenia wejściowe: PU logowanie zostało wykonane.

    Założenia wyjściowe: UKB dowiaduje się o swoich zleceniach cyklicznych.

    Przebieg:

    0. System bazy danych jest odpytany o zlecenia cykliczny przypisane do identyfikatora UKB.
    0. Zlecenia cykliczne sią wyświetlane UKB


0. Przypadek użycia modyikowanie zlecenia cyklicznego

    Cel: UKB dowiaduje się o swoich 
    informacji podanych przez przypadek użycia przelewu cyklicznego.

    Założenia wejściowe: PU logowanie zostało wykonane.

    Założenia wyjściowe: UKB dowiaduje się o swoich zleceniach cyklicznych.

    Przebieg:

    0. Przyjęcie od UKB danych z formularza modyfikacji przelewu cyklicznego.
    0. Przesłanie danych do systemu bazy danych.


0. Przypadek użycia usuwanie zlecenia cyklicznego

    Cel: UKB usuwa zlecone przez siebie zlecenie cykliczne

    Założenia wejściowe: PU logowanie zostało wykonane.

    Założenia wyjściowe: Zlecenie cykliczne zostało usunięte.

    Przebieg:

    0. Przyjęcie od UKB danych z formularza usunięcia przelewu cyklicznego.
    0. Przesłanie informacji o usunięciu zlecenia do systemu bazy danych.
