# ZaawansowanaJavaProjekt

Instrukcja Obsługi Programu:
1) Logowanie 
- dane użytkownika (login i hasło) odczytywane są z BD. Jeżeli podane dane są prawidłowe, możemy przejść dalej.
- w przeciwnym przypadku program sugeruje nam abyśmy się zarejestrowali. Przechodząc do rejestracji wpisujemy swoje dane. Są one widoczne od razu w bazie.
2) Po zalogowaniu
- po pozytywnym przejściu procesu uwierzytelniaina, przechodzimy do głównego program. Pojawia się okno z pięcioma zakładkami: Start, Projects, Tasks, Users oraz Sign out
- w zakładce Start możemy dodać nowy projekt(przydatne dla nowo zarejestrowanych użytkowników)
- w zakładce Projects możemy  dodać nowy Projekt, obejrzeć listę wszystkich projektów, kto jest liderem danego projektu, a także zobaczyć jakie Zadania zostały utworzone w ramach danego projektu i kto się nimi zajmuje.
- w zakładce Tasks możemy dodać nowe Zadanie dla istniejącego już projektu
- zakładka Users pokazuje nam Listę obecnie zarejestrowanych Użytkowników. W tej zakładce możemy także edytować dane wybranego użytkownika, oraz usuwać go z BD oraz programu.
Aby dodać nowego użytkownika należy go zarejestrować(patrz Logowanie)
- ostatnia zakładka Sign out służy do wylogowywania z programu.

Niestety nasz program nie jest idealny, wymaga jeszcze duużej ilości czasu, aby dopracować go w 100% :(
Dlatego też w niektórych miejscach możecie natknąć się na informację, że dana funkcjonalność jest ciągle w budowie i nie została jeszcze uruchomoina.

Przydatne linki:

Travis:
https://travis-ci.org/kosmala195627/ZaawansowanaJavaProjekt

Uwagi dodatkowe:
1. Czasem w przypadku problemem z zależnościami mavena pomaga wywołanie z konsoli: 
mvn -U clean install

2. Testy jednostkowe pisać z użyciem mockito - odpowiednia biblioteka jest podpięta do projektu

MongoDB:
1) INSTALACJA I KONFIGURACJA
	- pobieramy instalkę MongoDB (https://www.mongodb.com/) wybieramy plik odpowiedni dla naszego systemu
	- uruchamiamy instalację i wykonujemy pojawiające się na ekranie polecenia
	- jeśli używasz Linux'a to już wszystko i możesz rzejść do następnego punktu ;)
	- jeśli korzystasz z systemu Windows, musisz do zmiennej środowiskowej PATH dodać ścieżkę do katalogu bin znajdującego się w katalogu z instalacją mongo. Ścieżka zależy od tego gdzie zainstalowałeś mongo. U mnie ma ona domyślną wartość i wygląda tak: C:\Program Files\MongoDB\Server\3.4\bin
		*otwieramy terminal - CMD i wpisujemy polecenia:
		- md \data
		- md \data\db
		Katalogi te są domyślną przestrzenią, w której Mongo zapisuje dane
		* w następnym kroku przechozimy w terminalu do katalogu C:\Program Files\MongoDB\Server\3.4
		* w terminalu wpisujemy:
		mongod
		* otwieramy nowe okno terminala i wpisujemy:
		mongo
		* Jeśli wszystko pójdzie pomyślnie w terminalu powinien pojawić się znak ostrego nawiasu (>). W tym momencie Mongo jest uruchomoine
2) TWORZENIE BAZY
	- W konsoli Mongo wpisujemy polecenie: use Java2017
	Polecenie to tworzy bazę o nazwie Java2017 i przełącza nas w obszar tej bazy.
	- Kopiujemy pliki: users-collection.json, projects-collection.json oraz tasks-collection.json do katalogu C:\Program Files\MongoDB\Server\3.4
	- Otwieramy drugie okno terminala jako Administrator
	- W terminalu przechodzimy do katalogu C:\Program Files\MongoDB\Server\3.4 i wpisyjemy polecenie:
		* mongoimport -d Java2017 -c users --file users-collection.json
		* mongoimport -d Java2017 -c projects --file projects-collection.json
		* mongoimport -d Java2017 -c tasks --file tasks-collection.json
		* mongoimport -d Java2017 -c taskUsers --file tasksUsers-collection.json
	Pozwoli nam to importować dane do kolekcji w programie.
3) Uruchamiamy program w naszym IDE
