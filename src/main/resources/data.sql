INSERT INTO category
    (id, name, description, image)
VALUES
    (1, 'Śniadanie', 'Najlepsze przepisy na najlepsze i zdrowe poranne posiłki', 'cat_breakfast_logo.jpeg'),
    (2, 'Obiad', 'Zdrowe i pełnowartościowe obiady dla Ciebie i Twojej rodziny', 'cat_dinner_logo.jpeg'),
    (3, 'Kolacja', 'Te przepisy zmienią Twoje postrzeganie ostatniego posiłku dnia', 'cat_supper_logo.jpeg'),
    (4, 'Deser', 'Pyszne, zdrowe i domowe.', 'cat_dessert_logo.jpeg');

INSERT INTO recipe
(name, description, difficulty, time_needed, category_id, popularity)
VALUES
    ('Jajecznica', 'Pokrojoną cebulę wrzucamy na patelnię i czekamy, aż się zeszkli. Jajka doprawiamy solą i pieprzem, a następnie rozbijamy za pomocą trzepaczki. Do podsmażonej cebuli dodajemy boczek i lekko podsmażamy. Wlewamy jajka na patelnię i cały czas mieszamy.', 'EASY', 10, 1, 29),
    ('Owsianka', 'Najprostsza i najszybsza w wykonaniu. Wystarczy 3-4 łyżki płatków górskich zalać niewielką ilością wrzątku, poczekać kilka minut aż napęcznieją a następnie dolać do nich mleka roślinnego. Sprawdzi się sojowe, migdałowe, owsiane. Potem pozostaje już tylko dorzucenie ulubionych owoców i nasion – polecam łyżeczkę sezamu.', 'MEDIUM', 8, 1, 40),
    ('Ser feta z miodem', 'Ser feta wyjmij z opakowania, połóż na ręczniku papierowym aby odsączyć nadmiar płynu. W jednej misce rozkłóć jajko, a do drugiej dodaj bułkę tartą. Ser najpierw obtocz w jajku a później w bułce tartej, tak aby stworzyć panierkę. Na koniec panierkę popieprz z obu stron. Na patelni rozgrzej olej lub oliwę. Smaż ser przez 2-3 minuty z każdej strony. W tym czasie przygotuj sałatkę. Pokrój pomidorki, dodaj do nich łyżkę oliwy z oliwek, listki bazylii, sól oraz pieprz.Na talerzu połóż sałatkę, usmażony ser, placki pity lub inne. Ser polej łyżką miodu.', 'HARD', 40, 3, 101),
    ('Shake owocowy', 'Do miski wlać jogurt, mleko, syrop, dodać owoce i miód. Wszystko zmiksować na gładką masę, używając odpowiedniej końcówki miksera (możemy również użyć blendera).', 'MEDIUM', 9, 1, 8),
    ('Kurczak curry z ryżem', 'Pokrojoną pierś z kurczaka nacieramy curry, wrzucamy na patelnię i zalewamy na niej jogurtem, tak by powstał gęsty, aromatyczny sos. Tak przygotowanego kurczaka można podać z ryżem i sałatką.', 'MEDIUM', 40, 2, 100);