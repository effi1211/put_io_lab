# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego.

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1)[UC2](#uc2))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2)[UC3](#uc3))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu. ([UC4](#uc4))
5. [Sprzedający](#ac1) przekazuje produktu Kupującemu. ([UC5](#uc5))

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC5](#uc5): Przekazanie produktu Kupującemu

[Kupujący](#ac2)
* [UC2](#uc2): Oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty
* [UC3](#uc3): Wygrywa aukcję
* [UC4](#uc4): Przekanie należności Sprzedającemu

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Licytacja produktu ([BR1](#br1))

**Aktorzy:** [Kupujący](#ac1)

**Scenariusz główny:**
1. [Kupujący](#ac1) zgłasza chęć zakupu produktu.
2. System prosi o podanie kwoty wyższej niż poprzednia.
3. [Kupujący](#ac1) podaje nową kwotę.
4. Sysytem sprawdza poprawność kwoty.
5. System informuje o pomyślnym aktualizowaniu ceny.

**Scenariusze alternatywne:** 

4.A. Podanie niepoprawnej kwoty.
* 4.A.1. System informuje o podaniu błędnej kwoty.
* 4.A.2. Przejdź do kroku 2.

3.A. Kupujący jest pierwszym licytującym.
* 3.A.1. System sprawdza czy kwota jest wyższa niż cena wywoławcza.
* 3.A.2. Przejdź do kroku 2.

3.A.1.A. Kupujący jest pierwszym licytującym i podał niepoprawną kwotę.
* 3.A.1.A.1. System informuje o podaniu błędnej kwoty.
* 3.A.1.A.2. Przejdź do kroku 2.

---

<a id="uc3"></a>
### UC3: Zakończenie licytacji produktu ([BR2](#br2))

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. System informuje o zakończeniu licytacji produktu.
2. System sprawdza najwyższą kwotę.
3. [Kupujący](#ac2) wygrywa aukcję.
4. [Kupujący](#ac2) przekazuje kwotę [Sprzedający](#ac1)emu.
5. System sprawdza poprawność przekazanej kwoty.
6. [Sprzedający](#ac1) przekazuje produkt [Kupujący](#ac2)emu.
7. System informuje o przekazaniu produktu.
8. [Kupujący](#ac2) odbiera produkt.
9. System informuje o odebraniu produktu.

**Scenariusze alternatywne:** 

5.A. Przekazana kwota jest niepoprawna
* 5.A.1. System informuje o przekazaniu błędnej kwoty.
* 5.A.2. Przejdź do kroku 4.

---

## Obiekty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

### BO3: Należność

Kwota, która musi być przekazana za zakupiony przedmiot.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt |Należność|
| ------------------------------------------------- | ------ | ------- | ------- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    |    C    |
| UC2: Oferowanie kwoty                             |    -   |    -    |   R,U   |
| UC3: Wygranie aukcji                              |    -   |    -    |    R    |
| UC4: Przekazanie należności                       |    -   |    -    |   R,D   |
| UC5: Przekazanie produktu                         |    D   |    D    |    -    |
