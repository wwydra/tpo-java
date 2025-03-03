package pjatk.tpo.tpo6_ww;

import java.sql.*;

public class DataBaseInitializer {

    private static Connection connection;
    private static Statement statement;

    public static void connect() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection("jdbc:derby:base;create=true");
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void create(){
        try {
            statement.executeUpdate("DROP TABLE Book");
            statement.executeUpdate("DROP TABLE Genre");
            statement.executeUpdate("DROP TABLE Series");
            statement.executeUpdate("DROP TABLE Publisher");
            statement.executeUpdate("DROP TABLE Author");

                statement.executeUpdate("CREATE TABLE Author(" +
                        "ID int PRIMARY KEY, " +
                        "a_Name varchar(20) NOT NULL, " +
                        "a_Surname varchar(30) NOT NULL)");

                statement.executeUpdate("INSERT INTO Author VALUES(1, 'Stephen', 'King')");
                statement.executeUpdate("INSERT INTO Author VALUES(2, 'Colson', 'Whitehead')");
                statement.executeUpdate("INSERT INTO Author VALUES(3, 'J.R.R', 'Tolkien')");
                statement.executeUpdate("INSERT INTO Author VALUES(4, 'Jane', 'Austen')");
                statement.executeUpdate("INSERT INTO Author VALUES(5, 'Wojciech', 'Tochman')");
                statement.executeUpdate("INSERT INTO Author VALUES(6, 'Ken', 'Kesey')");
                statement.executeUpdate("INSERT INTO Author VALUES(7, 'Rebecca', 'Makkai')");
                statement.executeUpdate("INSERT INTO Author VALUES(8, 'Daphne', 'du Maurier')");
                statement.executeUpdate("INSERT INTO Author VALUES(9, 'Kurt', 'Vonnegut')");
                statement.executeUpdate("INSERT INTO Author VALUES(10, 'Edouard', 'Louis')");
                statement.executeUpdate("INSERT INTO Author VALUES(11, 'Hermann', 'Hesse')");
                statement.executeUpdate("INSERT INTO Author VALUES(12, 'Milan', 'Kundera')");
                statement.executeUpdate("INSERT INTO Author VALUES(13, 'Andrzej', 'Sapkowski')");
                statement.executeUpdate("INSERT INTO Author VALUES(14, 'Haruki', 'Murakami')");
                statement.executeUpdate("INSERT INTO Author VALUES(15, 'Yōko', 'Ogawa')");
                statement.executeUpdate("INSERT INTO Author VALUES(16, 'Bruce', 'Eckel')");
                statement.executeUpdate("INSERT INTO Author VALUES(17, 'George', 'Orwell')");
                statement.executeUpdate("INSERT INTO Author VALUES(18, 'Edogawa', 'Ranpo')");
                statement.executeUpdate("INSERT INTO Author VALUES(19, 'Stuart', 'Turton')");
                statement.executeUpdate("INSERT INTO Author VALUES(20, 'Daniel', 'Keyes')");
                statement.executeUpdate("INSERT INTO Author VALUES(21, 'Stephen', 'Hawking')");
                statement.executeUpdate("INSERT INTO Author VALUES(22, 'Paweł', 'Baszuro')");
                statement.executeUpdate("INSERT INTO Author VALUES(23, 'Christopher', 'Negus')");
                statement.executeUpdate("INSERT INTO Author VALUES(24, 'Bae', 'Suah')");
                statement.executeUpdate("INSERT INTO Author VALUES(25, 'Bartosz', 'Józefiak')");
                statement.executeUpdate("INSERT INTO Author VALUES(26, 'Philip', 'Roth')");
                statement.executeUpdate("INSERT INTO Author VALUES(27, 'Eun-jin', 'Jang')");
                statement.executeUpdate("INSERT INTO Author VALUES(28, 'Cixin', 'Liu')");
                statement.executeUpdate("INSERT INTO Author VALUES(29, 'Michael', 'Crichton')");
                statement.executeUpdate("INSERT INTO Author VALUES(30, 'Mieko', 'Kawakami')");
                statement.executeUpdate("INSERT INTO Author VALUES(31, 'Kristian Bang', 'Foss')");
                statement.executeUpdate("INSERT INTO Author VALUES(32, 'Chuck', 'Palahniuk')");
                statement.executeUpdate("INSERT INTO Author VALUES(33, 'Ryū', 'Murakami')");
                statement.executeUpdate("INSERT INTO Author VALUES(34, 'Ira', 'Levin')");
                statement.executeUpdate("INSERT INTO Author VALUES(35, 'Frank', 'Herbert')");
                statement.executeUpdate("INSERT INTO Author VALUES(36, 'Osamu', 'Dazai')");
                statement.executeUpdate("INSERT INTO Author VALUES(37, 'Rafał', 'Kosik')");
                statement.executeUpdate("INSERT INTO Author VALUES(38, 'Cormac', 'McCarthy')");
                statement.executeUpdate("INSERT INTO Author VALUES(39, 'H.P.', 'Lovecraft')");
                statement.executeUpdate("INSERT INTO Author VALUES(40, 'Becky', 'Chambers')");
                statement.executeUpdate("INSERT INTO Author VALUES(41, 'Brandon', 'Sanderson')");
                statement.executeUpdate("INSERT INTO Author VALUES(42, 'Terry', 'Hayes')");
                statement.executeUpdate("INSERT INTO Author VALUES(43, 'Richard', 'Taylor')");
                statement.executeUpdate("INSERT INTO Author VALUES(44, 'Barbara', 'Demick')");

                statement.executeUpdate("CREATE TABLE Genre(" +
                        "ID int PRIMARY KEY, " +
                        "g_Name varchar(30) NOT NULL)");

                statement.executeUpdate("INSERT INTO Genre VALUES(1, 'Fantasy/Science fiction')");
                statement.executeUpdate("INSERT INTO Genre VALUES(2, 'Horror')");
                statement.executeUpdate("INSERT INTO Genre VALUES(3, 'Kryminał/Sensacja/Thriller')");
                statement.executeUpdate("INSERT INTO Genre VALUES(4, 'Literatura piękna')");
                statement.executeUpdate("INSERT INTO Genre VALUES(5, 'Literatura faktu/Reportaż')");
                statement.executeUpdate("INSERT INTO Genre VALUES(6, 'Informatyka')");
                statement.executeUpdate("INSERT INTO Genre VALUES(7, 'Literatura popularnonaukowa')");

                statement.executeUpdate("CREATE TABLE Series(" +
                        "ID int PRIMARY KEY, " +
                        "s_Name varchar(50) NOT NULL)");

                statement.executeUpdate("INSERT INTO Series VALUES(1, 'Holly Gibney')");
                statement.executeUpdate("INSERT INTO Series VALUES(2, 'Władca Pierścieni')");
                statement.executeUpdate("INSERT INTO Series VALUES(3, 'Wiedźmin')");
                statement.executeUpdate("INSERT INTO Series VALUES(4, 'Wspomnienie o przeszłości Ziemi')");
                statement.executeUpdate("INSERT INTO Series VALUES(5, 'Jurassic Park')");
                statement.executeUpdate("INSERT INTO Series VALUES(6, 'Kroniki Diuny')");
                statement.executeUpdate("INSERT INTO Series VALUES(7, 'Mnich i robot')");
                statement.executeUpdate("INSERT INTO Series VALUES(8, 'Archiwum Burzowego Światła')");

                statement.executeUpdate("CREATE TABLE Publisher(" +
                        "ID int PRIMARY KEY, " +
                        "p_Name varchar(50) NOT NULL)");

                statement.executeUpdate("INSERT INTO Publisher VALUES(1, 'Literackie')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(2, 'Prószyński i S-ka')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(3, 'Albatros')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(4, 'Zysk i S-ka')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(5, 'Świat książki')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(6, 'Rebis')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(7, 'Poznańskie')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(8, 'Pauza')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(9, 'Media Rodzina')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(10, 'W.A.B')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(11, 'superNOWA')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(12, 'Muza')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(13, 'Tajfuny')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(14, 'Helion')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(15, 'Wielka Litera')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(16, 'Czarne')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(17, 'Vesper')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(18, 'Mova')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(19, 'Marpress')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(20, 'Niebieska studnia')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(21, 'Czytelnik')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(22, 'Powergraph')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(23, 'Insignis')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(24, 'Mag')");
                statement.executeUpdate("INSERT INTO Publisher VALUES(25, 'Feeria Science')");

                statement.executeUpdate("CREATE TABLE Book(" +
                        "ID int PRIMARY KEY, " +
                        "ISBN varchar(20) NOT NULL, " +
                        "Title varchar(50) NOT NULL, " +
                        "Release_date date NOT NULL," +
                        "Rating float," +
                        "Num_ratings int," +
                        "Series_ID int, " +
                        "Author_ID int, " +
                        "Genre_ID int, " +
                        "Publisher_ID int, " +
                        "FOREIGN KEY (Series_ID) REFERENCES Series(ID), " +
                        "FOREIGN KEY (Author_ID) REFERENCES Author(ID), " +
                        "FOREIGN KEY (Genre_ID) REFERENCES Genre(ID), " +
                        "FOREIGN KEY (Publisher_ID) REFERENCES Publisher(ID)," +
                        "CoverImage varchar(255)," +
                        "Link varchar(255))");

                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(1, '9788381690805', 'Outsider', '2020-01-30', 7.3, 7258, 1, 1, 2, 2, 'images/Outsider.webp', 'https://www.empik.com/outsider-king-stephen,p1237490132,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(2, '9788367513937', 'Zielona Mila', '2023-02-28', 8.5, 23965, 1, 2, 3, 'images/ZielonaMila.webp', 'https://www.empik.com/zielona-mila-king-stephen,p1366500737,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(3, '9788376480459', 'Ręka mistrza', '2008-09-18', 7.6, 11261, 1, 2, 2, 'images/Rękamistrza.webp', 'https://www.empik.com/reka-mistrza-king-stephen,prod3570425,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(4, '9788367757904', 'Miedziaki', '2023-06-14', 7.2, 2373, 2, 4, 3, 'images/Miedziaki.webp', 'https://www.empik.com/miedziaki-whitehead-colson,p1376923353,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(5, '9788367513722', 'Intuicjonistka', '2023-06-14', 5.8, 130, 2, 4, 3, 'images/Intuicjonistka.webp', 'https://www.empik.com/intuicjonista-colson-whitehead,p1376923265,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(6, '9788365781017', 'Kolej podziemna', '2017-06-14', 7.1, 3108, 2, 4, 3, 'images/Kolejpodziemna.webp', 'https://www.empik.com/kolej-podziemna-czarna-krew-ameryki-whitehead-colson,p1142296968,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(7, '9788382027761', 'Bractwo Pierścienia', '2017-01-01', 8.4, 52145, 2, 3, 1, 4, 'images/BractwoPierścienia.webp', 'https://www.empik.com/bractwo-pierscienia-wladca-pierscieni-tom-1-wersja-ilustrowana-tolkien-john-ronald-reuel,p1409301273,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(8, '9788381161749', 'Dwie Wieże', '2017-11-03', 8.5, 47216, 2, 3, 1, 4, 'images/DwieWieże.webp', 'https://www.empik.com/wladca-pierscieni-dwie-wieze-tom-2-wersja-ilustrowana-tolkien-john-ronald-reuel,p1411550401,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(9, '9788381161756', 'Powrót króla', '2017-11-10', 8.6, 45021, 2, 3, 1, 4, 'images/Powrótkróla.webp', 'https://www.empik.com/wladca-pierscieni-powrot-krola-tom-3-tolkien-john-ronald-reuel,p1432997388,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(10, '9788381160964', 'Silmarillion', '2017-09-25', 8.0, 22685, 3, 1, 4, 'images/Silmarillion.webp', 'https://www.empik.com/silmarillion-wydanie-ilustrowane-tolkien-john-ronald-reuel,p1429482859,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(11, '9788381397384', 'Duma i uprzedzenie', '2020-11-12', 8.1, 19404, 4, 4, 5, 'images/Dumauprzedzenie.webp', 'https://www.empik.com/duma-i-uprzedzenie-austen-jane,p1426511938,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(12, '9788381398770', 'Mansfield Park', '2021-03-25', 7.0, 4697, 4, 4, 5, 'images/MansfieldPark.webp', 'https://www.empik.com/mansfield-park-austin-jane,p1263903370,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(13, '9788381397391', 'Rozważna i romantyczna', '2020-11-12', 7.1, 11394, 4, 4, 5, 'images/Rozważnaromantyczna.webp', 'https://www.empik.com/rozwazna-i-romantyczna-austen-jane,p1257211320,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(14, '9788381399838', 'Opactwo Northanger', '2021-12-08', 6.8, 5080, 4, 4, 5, 'images/OpactwoNorthanger.webp', 'https://www.empik.com/opactwo-northanger-austen-jane,p1348450155,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(15, '9788308068311', 'Pianie kogutów, płacz psów', '2019-02-26', 7.7, 1570, 5, 5, 1, 'images/Pianiekogutów.webp', 'https://www.empik.com/pianie-kogutow-placz-psow-tochman-wojciech,p1220730883,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(16, '9788308065327', 'Jakbyś kamień jadła', '2018-06-20', 7.9, 2489, 5, 5, 1, 'images/Jakbyśkamieńjadła.webp', 'https://www.empik.com/jakbys-kamien-jadla-tochman-wojciech,p1327734973,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(17, '9788308068632', 'Schodów się nie pali', '2019-05-01', 7.6, 1231, 5, 5, 1, 'images/Schodówsię.webp', 'https://www.empik.com/schodow-sie-nie-pali-tochman-wojciech,p1222783056,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(18, '9788382154207', 'Lot nad kukułczym gniazdem', '2018-10-17', 8.2, 17883, 6, 4, 3, 'images/Lotnad.webp', 'https://www.empik.com/lot-nad-kukulczym-gniazdem-kesey-ken,p1259724828,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(19, '8373010548', 'Pieśń żeglarzy', '2003-01-01', 6.7, 94, 6, 4, 6, 'images/Pieśńżeglarzy.webp', 'https://www.empik.com/piesn-zeglarzy-kesey-ken,334422,ksiazka-p?fromSearchQuery=piesn+zeglarzy')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(20, '9788367815703', 'Mam do pana kilka pytań', '2023-09-06', 7.2, 535, 7, 4, 7, 'images/Mamdopana.webp', 'https://www.empik.com/mam-do-pana-kilka-pytan-makkai-rebecca,p1397433192,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(21, '9788366517585', 'Wierzyliśmy jak nikt', '2020-04-15', 7.8, 2345, 7, 4, 7, 'images/Wierzyliśmy.webp', 'https://www.empik.com/wierzylismy-jak-nikt-makkai-rebecca,p1238297514,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(22, '9788367759380', 'Niespokojny duch', '2024-05-15', 7.4, 2177, 8, 4, 3, 'images/Niespokojnyduch.webp', 'https://www.empik.com/niespokojny-duch-du-maurier-daphne,p1455115859,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(23, '9788367513784', 'Zatoka Francuza', '2023-05-17', 7.0, 373, 8, 4, 3, 'images/ZatokaFrancuza.webp', 'https://www.empik.com/zatoka-francuza-du-maurier-daphne,p1369355192,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(24, '9788382158946', 'Kozioł ofiarny', '2022-10-12', 7.3, 889, 8, 3, 3, 'images/Koziołofiarny.webp', 'https://www.empik.com/koziol-ofiarny-du-maurier-daphne,p1323139620,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(25, '9788382025910', 'Hokus-Pokus', '2022-05-31', 7.2, 796, 9, 4, 4, 'images/Hokus-Pokus.webp', 'https://www.empik.com/hokus-pokus-vonnegut-kurt,p1305314458,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(26, '9788382020380', 'Sinobrody', '2020-10-13', 7.3, 875, 9, 4, 4, 'images/Sinobrody.webp', 'https://www.empik.com/sinobrody-vonnegut-kurt,p1247686899,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(27, '9788381164924', 'Rzeźnia numer pięć', '2018-11-12', 7.6, 9300, 9, 4, 4, 'images/Rzeźnia.webp', 'https://www.empik.com/rzeznia-numer-piec-vonnegut-kurt-jr,p1367597192,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(28, '9788396802330', 'Zmiana', '2023-09-09', 7.1, 92, 10, 4, 8, 'images/Zmiana.webp', 'https://www.empik.com/zmiana-louis-edouard,p1398271270,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(29, '9788395703003', 'Kto zabił mojego ojca', '2021-09-20', 7.0, 360, 10, 4, 8, 'images/Ktozabił.webp', 'https://www.empik.com/kto-zabil-mojego-ojca-louis-edouard,p1280905302,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(30, '9788395352386', 'Koniec z Eddym', '2019-10-07', 7.2, 605, 10, 4, 8, 'images/KoniecEddym.webp', 'https://www.empik.com/koniec-z-eddym-louis-edouard,p1234793092,ksiazka-p?fromSearchQuery=koniec+z+eddym')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(31, '9788394941468', 'Historia przemocy', '2018-08-08', 6.5, 732, 10, 4, 8, 'images/Historiaprzemocy.webp', 'https://www.empik.com/historia-przemocy-louis-edouard,p1203656247,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(32, '9788380085237', 'Narcyz i Złotousty', '2018-10-25', 7.7, 696, 11, 4, 9, 'images/NarcyzZłotousty.webp', 'https://www.empik.com/narcyz-i-zlotousty-hesse-hermann,p1443972817,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(33, '9788380083639', 'Demian', '2017-10-30', 7.8, 1767, 11, 4, 9, 'images/Demian.webp', 'https://www.empik.com/demian-hesse-hermann,p1294457404,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(34, '9788382652383', 'Siddhartha', '2017-01-01', 7.8, 2803, 11, 4, 9, 'images/Siddhartha.webp', 'https://www.empik.com/siddhartha-hesse-hermann,p1312557501,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(35, '9788377479100', 'Nieznośna lekkość bytu', '2013-09-25', 7.9, 14192, 12, 4, 10, 'images/Nieznośnalekkośćbytu.webp', 'https://www.empik.com/nieznosna-lekkosc-bytu-kundera-milan,p1079958687,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(36, '9788328014459', 'Święto nieistotności', '2015-05-06', 6.3, 543, 12, 4, 10, 'images/Świętonieistotności.webp', 'https://www.empik.com/swieto-nieistotnosci-kundera-milan,p1105678811,ksiazka-p?fromSearchQuery=swieto+nieistotnosci')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(37, '9788377479094', 'Żart', '2014-01-01', 7.5, 2610, 12, 4, 10, 'images/zart.webp', 'https://www.empik.com/zart-kundera-milan,p1099527555,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(38, '9788375781809', 'Ostatnie życzenie', '2019-12-01', 8.4, 47297, 3, 13, 1, 11, 'images/Ostatnieżyczenie.jpg', 'https://www.empik.com/wiedzmin-ostatnie-zyczenie-sapkowski-andrzej,p1102239921,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(39, '9788375781816', 'Miecz przeznaczenia', '2019-12-01', 8.4, 39818, 3, 13, 1, 11, 'images/Mieczprzeznaczenia.jpg', 'https://www.empik.com/wiedzmin-miecz-przeznaczenia-sapkowski-andrzej,p1102239806,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(40, '9788375781823', 'Krew elfów', '2019-12-01', 8.2, 42799, 3, 13, 1, 11, 'images/Krewelfów.jpg', 'https://www.empik.com/wiedzmin-tom-3-krew-elfow-sapkowski-andrzej,p1103064458,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(41, '9788375781830', 'Czas pogardy', '2019-12-01', 8.2, 33305, 3, 13, 1, 11, 'images/Czaspogardy.jpg', 'https://www.empik.com/wiedzmin-tom-4-czas-pogardy-sapkowski-andrzej,p1103074330,ksiazka-p?qa=czas%20pogardy%20wied%C5%BAmin%20tom%204&ac=true')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(42, '9788375781847', 'Chrzest ognia', '2019-12-01', 8.4, 35890, 3, 13, 1, 11, 'images/Chrzestognia.jpg', 'https://www.empik.com/wiedzmin-tom-5-chrzest-ognia-sapkowski-andrzej,p1103064227,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(43, '9788375781854', 'Wieża Jaskółki', '2019-12-01', 8.3, 31486, 3, 13, 1, 11, 'images/WieżaJaskółki.jpg', 'https://www.empik.com/wiedzmin-tom-6-wieza-jaskolki-sapkowski-andrzej,p1103074473,ksiazka-p?fromSearchQuery=wieza+jaskolki')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(44, '9788375781861', 'Pani Jeziora', '2019-12-01', 8.2, 31081, 3, 13, 1, 11, 'images/PaniJeziora.jpg', 'https://www.empik.com/wiedzmin-tom-7-pani-jeziora-sapkowski-andrzej,p1103074419,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(45, '9788375781793', 'Sezon burz', '2020-01-01', 7.4, 21236, 3, 13, 1, 11, 'images/Sezonburz.jpg', 'https://www.empik.com/sezon-burz-sapkowski-andrzej,p1083730592,ksiazka-p?qa=sezon%20burz&ac=true')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(46, '9788328715264', 'Pierwsza osoba liczby pojedynczej', '2020-11-12', 6.7, 1112, 14, 4, 12, 'images/Pierwszaosoba.webp', 'https://www.empik.com/pierwsza-osoba-liczby-pojedynczej-murakami-haruki,p1249469490,ksiazka-p?fromSearchQuery=pierwsza+osoba+liczby+pojedynczej')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(47, '9788328715387', 'Wszystkie boże dzieci tańczą', '2020-08-26', 6.7, 3021, 14, 4, 12, 'images/Wszystkieboże.webp', 'https://www.empik.com/wszystkie-boze-dzieci-tancza-murakami-haruki,2292624,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(48, '9788328700918', 'Mężczyźni bez kobiet', '2015-10-21', 7.0, 2702, 14, 4, 12, 'images/Mężczyźnibezkobiet.webp', 'https://www.empik.com/mezczyzni-bez-kobiet-murakami-haruki,p1242140736,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(49, '9788367034005', 'Podziemie pamięci', '2022-02-01', 6.9, 630, 15, 4, 13, 'images/Podziemiepamięci.webp', 'https://www.empik.com/podziemie-pamieci-ogawa-yoko,p1291774878,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(50, '9788395530081', 'Grobowa cisza, żałobny zgiełk', '2020-11-02', 7.5, 2403, 15, 4, 13, 'images/Grobowacisza.webp', 'https://www.empik.com/grobowa-cisza-zalobny-zgielk-ogawa-yoko,p1249489759,ksiazka-p?fromSearchQuery=grobowa+cisza+%C5%BCa%C5%82obny+zgie%C5%82k')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(51, '9788395243325', 'Ukochane równanie profesora', '2019-07-07', 7.6, 6000, 15, 4, 13, 'images/ukochane-rownanie-profesora-b-iext151551895.webp', 'https://www.empik.com/ukochane-rownanie-profesora-ogawa-yoko,p1225289232,ksiazka-p?fromSearchQuery=ukochane+r%C3%B3wnanie+profesora')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(52, '8324601112', 'Thinking in Java', '2006-09-01', 7.1, 88, 16, 6, 14, 'images/ThinkingInJava.jpg', 'https://www.empik.com/thinking-in-java-edycja-polska-eckel-bruce,p1136480168,ksiazka-p?fromSearchQuery=thinking+in+java')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(53, '9788368109375', 'Na dnie w Paryżu i w Londynie', '2024-05-24', 7.2, 1090, 17, 4, 5, 'images/nadniewparyzu.webp', 'https://www.empik.com/na-dnie-w-paryzu-i-w-londynie-orwell-george,p1474414779,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(54, '9788395243363', 'Gąsienica', '2019-12-09', 7.4, 797, 18, 2, 13, 'images/gasienica.jpg', 'https://www.empik.com/gasienica-edogawa-ranpo,p1236981637,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(55, '9788382152944', 'Demon i mroczna toń', '2021-03-24', 7.1, 808, 19, 3, 3, 'images/demonimroczna.jpg', 'https://www.empik.com/demon-i-mroczna-ton-turton-stuart,p1259638530,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(56, '9788382150964', 'Siedem śmierci Evelyn Hardcastle', '2020-06-22', 7.3, 4591, 19, 3, 3, 'images/siedemsmierci.jpg', 'https://www.empik.com/siedem-smierci-evelyn-hardcastle-turton-stuart,p1220774188,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(57, '9788380320413', 'Człowiek o 24 twarzach', '2015-09-23', 7.8, 3459, 20, 5, 15, 'images/czlowiek.jpg', 'https://www.empik.com/czlowiek-o-24-twarzach-keyes-daniel,p1282090543,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(58, '9788380622227', 'Kwiaty dla Algernona', '2019-04-23', 8.3, 5683, 20, 1, 6, 'images/kwiatydla.jpg', 'https://www.empik.com/kwiaty-dla-algernona-keyes-daniel,p1223076786,ksiazka-p?qa=kwiaty%20dla%20algernona&ac=true')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(59, '9788381164764', 'Krótkie odpowiedzi na wielkie pytania', '2018-11-12', 7.5, 2316, 21, 7, 4, 'images/Krótkieodpowiedzi.jpg', 'https://www.empik.com/krotkie-odpowiedzi-na-wielkie-pytania-hawking-stephen,p1307985764,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(60, '9788328390034', 'U mnie działa. Język branży IT', '2022-04-12', 5.7, 23, 22, 6, 14, 'images/umniedziala.jpg', 'https://www.empik.com/u-mnie-dziala-jezyk-branzy-it-baszuro-pawel,p1298104838,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(61, '9788328375222', 'Linux. Biblia', '2021-08-31', 7.4, 8, 23, 6, 14, 'images/linux.jpg', 'https://www.empik.com/linux-biblia-negus-christopher,p1276288855,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(62, '9788367034173', 'Ten, którego szukam', '2023-07-01', 5.7, 253, 24, 4, 13, 'images/tenktorego.jpg', 'https://www.empik.com/ten-ktorego-szukam-suah-bae,p1396496680,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(63, '9788381917124', 'Wszyscy tak jeżdżą', '2023-06-28', 7.5, 1339, 25, 5, 16, 'images/wszyscytak.jpg', 'https://www.empik.com/wszyscy-tak-jezdza-jozefiak-bartosz,p1386051859,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(64, '9788308074763', 'Kompleks Portnoya', '2022-01-19', 7.0, 2537, 26, 4, 1, 'images/kompleks.jpg', 'https://www.empik.com/kompleks-portnoya-roth-philip,p1292047762,ebooki-i-mp3-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(65, '9788367034142', 'Nikt nie odpisuje', '2022-12-12', 7.4, 842, 27, 4, 13, 'images/Niktnieodpisuje.jpg', 'https://www.empik.com/nikt-nie-odpisuje-eun-jin-jang,p1350468555,ksiazka-p?fromSearchQuery=nikt+nie+odpisuje')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(66, '9788381881548', 'Problem trzech ciał', '2017-03-14', 7.5, 5670, 4, 28, 1, 6, 'images/problemtrzech.jpg', 'https://www.empik.com/wspomnienie-o-przeszlosci-ziemi-tom-1-problem-trzech-cial-liu-cixin,p1137808972,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(67, '9788381884495', 'Ciemny las', '2022-01-01', 8.0, 3493, 4, 28, 1, 6, 'images/Ciemnylas.jpg', 'https://www.empik.com/wspomnienie-o-przeszlosci-ziemi-tom-2-ciemny-las-liu-cixin,p1144538956,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(68, '9788380622852', 'Koniec śmierci', '2021-01-01', 8.0, 2700, 4, 28, 1, 6, 'images/koniecsmierci.jpg', 'https://www.empik.com/koniec-smierci-wspomnienie-o-przeszlosci-ziemi-tom-3-cixin-liu,p1408270532,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(69, '9788377314296', 'Park Jurajski', '2022-06-15', 7.5, 2722, 5, 29, 1, 17, 'images/ParkJurajski.jpg', 'https://www.empik.com/jurassic-park-crichton-micheal,p1300993579,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(70, '9788377314630', 'Park Jurajski: Zaginiony Świat', '2023-08-21', 7.1, 1042, 5, 29, 1, 17, 'images/ParkJurajskizaginiony.jpg', 'https://www.empik.com/park-jurajski-2-zaginiony-swiat-crichton-michael,p1379326250,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(71, '9788383213484', 'Heaven', '2023-06-14', 7.3, 370, 30, 4, 18, 'images/heaven.jpg', 'https://www.empik.com/heaven-mieko-kawakami,p1379077345,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(72, '9788375282597', 'Śmierć jeździ audi', '2022-07-29', 6.1, 75, 31, 4, 19, 'images/Śmierćjeździaudi.jpg', 'https://www.empik.com/smierc-jezdzi-audi-kristian-bang-foss,p1332540624,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(73, '9788392151241', 'Fight Club', '2006-01-01', 7.8, 7719, 32, 4, 20, 'images/FightClub.webp', 'https://www.empik.com/fight-club-palahniuk-chuck,p1346571409,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(74, '9788395921629', 'Piercing', '2021-09-14', 6.9, 695, 33, 3, 13, 'images/Piercing.jpg', 'https://www.empik.com/piercing-murakami-ryu,p1280388806,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(75, '9788377313725', 'Dziecko Rosemary', '2021-03-31', 7.1, 3274, 34, 2, 17, 'images/DzieckoRosemary.jpg', 'https://www.empik.com/dziecko-rosemary-levin-ira,p1259910416,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(76, '9788373017238', 'Diuna', '2007-03-07', 8.2, 11056, 6, 35, 1, 6, 'images/Diuna.jpg', 'https://www.empik.com/diuna-tom-1-herbert-frank,2645430,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(77, '9788373017252', 'Mesjasz Diuny', '2007-05-15', 7.4, 8043, 6, 35, 1, 6, 'images/MesjaszDiuny.jpg', 'https://www.empik.com/mesjasz-diuny-herbert-frank,2841345,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(78, '9788381884792', 'Dzieci Diuny', '2022-01-01', 7.4, 5222, 6, 35, 1, 6, 'images/DzieciDiuny.jpg', 'https://www.empik.com/dzieci-diuny-herbert-frank,prod5200148,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(79, '9788381884785', 'Bóg Imperator Diuny', '2022-01-01', 7.4, 3781, 6, 35, 1, 6, 'images/BógImperatorDiuny.jpg', 'https://www.empik.com/bog-imperator-diuny-herbert-frank,prod8770238,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(80, '9788381880787', 'Heretycy Diuny', '2017-06-27', 7.3, 2718, 6, 35, 1, 6, 'images/HeretycyDiuny.jpg', 'https://www.empik.com/kroniki-diuny-tom-5-heretycy-diuny-herbert-frank,prod29020023,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(81, '9788373018488', 'Kapitularz Diuną', '2010-08-24', 7.2, 2202, 6, 35, 1, 6, 'images/KapitularzDiuną.jpg', 'https://www.empik.com/kapitularz-diuna-herbert-frank,prod58549357,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(82, '9788307034768', 'Zatracenie', '2020-06-02', 7.8, 1808, 36, 4, 21, 'images/zatracenie.jpg', 'https://www.empik.com/zatracenie-dazai-osamu,p1242563733,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(83, '9788307034898', 'Owoce wiśni', '2020-09-01', 7.3, 238, 36, 4, 21, 'images/Owocewiśni.jpg', 'https://www.empik.com/owoce-wisni-dazai-osamu,p1250304241,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(84, '9788366178984', 'Cyberpunk 2077: Bez przypadku', '2023-08-09', 6.6, 768, 37, 1, 22, 'images/cyber.jpg', 'https://www.empik.com/cyberpunk-2077-bez-przypadku-kosik-rafal,p1396972579,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(85, '9788308068687', 'Droga', '2019-05-08', 7.7, 11106, 38, 1, 1, 'images/droga.jpg', 'https://www.empik.com/droga-mccarthy-cormac,p1396509434,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(86, '9788308044766', 'Krwawy południk', '2010-06-30', 7.2, 1731, 38, 1, 1, 'images/krwawypol.jpg', 'https://www.empik.com/krwawy-poludnik-mccarthy-cormac,prod58220024,ksiazka-p?qa=krwawy%20po%C5%82udnik&ac=true')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(87, '9788377313527', 'W górach szaleństwa', '2020-05-15', 7.1, 401, 39, 2, 17, 'images/wgorach.jpg', 'https://www.empik.com/w-gorach-szalenstwa-lovecraft-howard-phillips,p1240043800,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(88, '9788377313237', 'Zew Cthulhu', '2019-04-17', 7.8, 1314, 39, 2, 17, 'images/zew.jpg', 'https://www.empik.com/zew-cthulhu-lovecraft-howard-phillips,p1223405845,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(89, '9788368053005', 'Psalm dla zbudowanych w dziczy', '2024-03-13', 6.9, 217, 7, 40, 1, 23, 'images/psalm.jpg', 'https://www.empik.com/psalm-dla-zbudowanych-w-dziczy-chambers-becky,p1452621094,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(90, '9788368053029', 'Modlitwa za nieśmiałe korony drzew', '2024-03-27', 7.4, 100, 7, 40, 1, 23, 'images/modlitwa.jpg', 'https://www.empik.com/modlitwa-za-niesmiale-korony-drzew-chambers-becky,p1452622516,ksiazka-p?fromSearchQuery=modlitwa+za+nie%C5%9Bmia%C5%82e+korony+drzew')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(91, '9788366409316', 'Droga Królów', '2019-11-13', 8.8, 10429, 8, 41, 1, 24, 'images/drogakrolow.jpg', 'https://empik.com/droga-krolow-sanderson-brandon,p1397146551,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(92, '9788366409507', 'Słowa światłości', '2020-02-26', 9.1, 7960, 8, 41, 1, 24, 'images/slowa.jpg', 'https://www.empik.com/slowa-swiatlosci-archiwum-burzowego-swiatla-tom-2-sanderson-brandon,p1237631775,ksiazka-p?fromSearchQuery=s%C5%82owa+%C5%9Bwiat%C5%82o%C5%9Bci')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(93, '9788366409538', 'Dawca Przysięgi. Część 1', '2020-06-17', 8.3, 5073, 8, 41, 1, 24, 'images/dawca1.jpg', 'https://www.empik.com/dawca-przysiegi-tom-1-tw-sanderson-brandon,p1239568260,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(94, '9788366409545', 'Dawca Przysięgi. Część 2', '2020-07-01', 8.5, 4436, 8, 41, 1, 24, 'images/dawca2.jpg', 'https://www.empik.com/dawca-przysiegi-2-tw-sanderson-brandon,p1241302296,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(95, '9788366712195', 'Rytm Wojny. Część 1', '2021-03-24', 8.1, 1987, 8, 41, 1, 24, 'images/rytm.jpg', 'https://www.empik.com/rytm-wojny-tom-1-4-sanderson-brandon,p1261933225,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Series_ID, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(96, '9788366712461', 'Rytm Wojny. Część 2', '2021-06-30', 8.4, 1795, 8, 41, 1, 24, 'images/rytm2.jpg', 'https://www.empik.com/rytm-wojny-tom-4-2-archiwum-burzowego-swiatla-sanderson-brandon,p1269187983,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(97, '9788374806817', 'Bezkres magii', '2017-01-11', 7.8, 1227, 41, 1, 24, 'images/bezkres.jpg', 'https://www.empik.com/bezkres-magii-sanderson-brandon,p1134404003,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(98, '9788383382227', 'Pielgrzym', '2024-05-07', 8.2, 6105, 42, 3, 6, 'images/pielgrzym.jpg', 'https://www.empik.com/pielgrzym-hayes-terry,p1473019735,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(99, '9788383381954', 'Rok szarańczy', '2024-05-14', 6.1, 119, 42, 3, 6, 'images/rokszaranczy.jpg', 'https://www.empik.com/rok-szaranczy-hayes-terry,p1468968288,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(100, '9788382250312', 'Jak człowiek staje się mordercą', '2021-04-14', 7.0, 915, 43, 5, 25, 'images/jakczlowiek.jpg', 'https://www.empik.com/jak-czlowiek-staje-sie-morderca-mroczne-opowiesci-psychiatry-sadowego-taylor-richard,p1259411580,ksiazka-p')");
                statement.executeUpdate("INSERT INTO Book(ID, ISBN, Title, Release_date, Rating, Num_ratings, Author_ID, Genre_ID, Publisher_ID, CoverImage, Link)" +
                        "VALUES(101, '9788375363135', 'Światu nie mamy czego zazdrościć', '2011-10-01', 8.4, 4154, 44, 5, 16, 'images/swiatu.jpg', 'https://www.empik.com/swiatu-nie-mamy-czego-zazdroscic-zwyczajne-losy-mieszkancow-korei-polnocnej-demick-barbara,p1144825870,ksiazka-p')");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getResultSet(String orderBy){
        ResultSet result = null;
        try {
            result = statement.executeQuery(
                    "SELECT * FROM Book " +
                            "JOIN Author ON Book.Author_ID = Author.ID " +
                            "LEFT JOIN Series ON Book.Series_ID = Series.ID " +
                            "JOIN Publisher ON Book.Publisher_ID = Publisher.ID " +
                            "JOIN Genre ON Book.Genre_ID = Genre.ID " +
                            "ORDER BY " + orderBy);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ResultSet getSearched(String orderBy, String title, String author, String genre, String publisher, String series, String minRating, String maxRating){
        ResultSet result = null;
        StringBuilder query = new StringBuilder("SELECT * FROM Book JOIN Author ON Book.Author_ID = Author.ID " +
                "LEFT JOIN Series ON Book.Series_ID = Series.ID JOIN Publisher ON Book.Publisher_ID = Publisher.ID " +
                "JOIN Genre ON Book.Genre_ID = Genre.ID " +
                "WHERE 1=1");

        if (title != null && !title.isEmpty()) {
            query.append(" AND LOWER(Title) LIKE '%" + title.toLowerCase() + "%'");
        }
        if (author != null && !author.isEmpty()) {
            String[] parts = author.split("\\s+");
            String surname = "";
            StringBuilder name = new StringBuilder();
            if (parts.length > 1) {
                surname = parts[parts.length - 1].toLowerCase();
                for (int i = 0; i < parts.length - 1; i++) {
                    name.append(parts[i]).append(" ");
                }
                query.append(" AND (LOWER(a_Name) LIKE '" + name.toString().trim() + "'");
                query.append(" AND LOWER(a_Surname) LIKE '" + surname + "')");
            } else {
                query.append(" AND (LOWER(a_Name) LIKE '%" + author.toLowerCase() + "%'");
                query.append(" OR LOWER(a_Surname) LIKE '%" + author.toLowerCase() + "%')");
            }
        }
        if (genre != null && !genre.isEmpty()) {
            query.append(" AND LOWER(g_Name) LIKE '%" + genre.toLowerCase() + "%'");
        }
        if (publisher != null && !publisher.isEmpty()) {
            query.append(" AND LOWER(p_Name) LIKE '%" + publisher.toLowerCase() + "%'");
        }
        if (series != null && !series.isEmpty()) {
            query.append(" AND LOWER(s_Name) LIKE '%" + series.toLowerCase() + "%'");
        }
        if (minRating != null && !minRating.isEmpty()){
            float min = Float.parseFloat(minRating);
            query.append(" AND Rating >= ").append(min);
        }
        if (maxRating != null && !maxRating.isEmpty()){
            float max = Float.parseFloat(maxRating);
            query.append(" AND Rating <= ").append(max);
        }

        if (orderBy != null && !orderBy.isEmpty()) {
            query.append(" ORDER BY ").append(orderBy);
        }

        try {
            result = statement.executeQuery(query.toString());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public static void disconnect(){
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
