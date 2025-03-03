package pjatk.tpo.tpo6_ww;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {
        DataBaseInitializer.connect();
        DataBaseInitializer.create();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<meta name=viewport content=width=device-width, initial-scale=1.0>");
        out.println("<head>");
        out.println("<title>Przeglądaj książki</title>");
        out.println("<style>");
        out.println("body, html {");
        out.println("margin: 0;");
        out.println("padding: 0;");
        out.println("height: 100%;");
        out.println("display: flex;");
        out.println("flex-direction: column;");
        out.println("}");
        out.println(".container {");
        out.println("display: flex;");
        out.println("justify-content: center;");
        out.println("align-items: center;");
        out.println("width: 100%;");
        out.println("margin: 10px;");
        out.println("}");
        out.println(".top {");
        out.println("display: flex;");
        out.println("justify-content: space-between;");
        out.println("align-items: center;");
        out.println("width: 100%;");
        out.println("background-color: #DCDCDC;");
        out.println("border-radius: 15px;");
        out.println("padding: 20px 20px;");
        out.println("}");
        out.println(".left, .right {");
        out.println("flex-grow: 0;");
        out.println("}");
        out.println(".center {");
        out.println("display: flex;");
        out.println("justify-content: center;");
        out.println("flex-grow: 1;");
        out.println("}");
        out.println(".wyszukaj {");
        out.println("flex-grow: 0;");
        out.println("}");
        out.println(".left h1 {");
        out.println("text-transform: uppercase;");
        out.println("font-family: Century Gothic,CenturyGothic,AppleGothic,sans-serif;");
        out.println("font-weight: 200;");
        out.println("letter-spacing: 1px;");
        out.println("font-size: 35px;");
        out.println("color: #000000;");
        out.println("}");
        out.println(".right {");
        out.println("display: flex;");
        out.println("font-family: Century Gothic,CenturyGothic,AppleGothic,sans-serif;");
        out.println("align-items: center;");
        out.println("color: #555;");
        out.println("display: inherit;");
        out.println("}");
        out.println(".button-34 {");
        out.println("background: #808080;");
        out.println("border-radius: 999px;");
        out.println("box-shadow: #808080 0 10px 20px -10px;");
        out.println("box-sizing: border-box;");
        out.println("color: #FFFFFF;");
        out.println("cursor: pointer;");
        out.println("font-family: Inter, Helvetica, Apple Color Emoji, Segoe UI Emoji, NotoColorEmoji," +
                " Noto Color Emoji, Segoe UI Symbol, Android Emoji, EmojiSymbols, -apple-system, system-ui," +
                " Segoe UI, Roboto, Helvetica Neue, Noto Sans, sans-serif;");
        out.println("font-size: 20px;");
        out.println("font-weight: 700;");
        out.println("line-height: 28px;");
        out.println("opacity: 1;");
        out.println("outline: 0 solid transparent;");
        out.println("padding: 20px 40px;");
        out.println("user-select: none;");
        out.println("-webkit-user-select: none;");
        out.println("touch-action: manipulation;");
        out.println("width: fit-content;");
        out.println("word-break: break-word;");
        out.println("border: 0;");
        out.println("}");
        out.println(".sortuj {");
        out.println("font-size: 20px;");
        out.println("}");
        out.println(".styled-select {");
        out.println("width: 300px;");
        out.println("display: inline-block;");
        out.println("background-color: #fff;");
        out.println("transition: all .5s ease;");
        out.println("position: relative;");
        out.println("font-size: 17px;");
        out.println("color: #474747;");
        out.println("height: 100%;");
        out.println("text-align: left;");
        out.println("border: 1px solid #ccc;");
        out.println("border-radius: 25px;");
        out.println("padding: 10px 15px;");
        out.println("box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);");
        out.println("}");
        out.println(".styled-select:focus {");
        out.println("outline: none;");
        out.println("border-color: #808080;");
        out.println("border-width: 1px;");
        out.println("box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);");
        out.println("}");
        out.println(".styled-select option {");
        out.println("background: #FFFFFF;");
        out.println("color: #000000;");
        out.println("}");
        out.println(".main {");
        out.println("flex: 1;");
        out.println("padding: 20px;");
        out.println("box-sizing: border-box;");
        out.println("overflow-y: auto;");
        out.println("}");
        out.println(".book {");
        out.println("display: flex;");
        out.println("align-items: center;");
        out.println("background-color: #FFFFFF;");
        out.println("margin-bottom: 20px;");
        out.println("margin-right: 200px;");
        out.println("margin-left: 200px;");
        out.println("padding: 20px;");
        out.println("border-radius: 10px;");
        out.println("box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);");
        out.println("}");
        out.println(".book img {");
        out.println("width: 100px;");
        out.println("height: 150px;");
        out.println("margin-right: 20px;");
        out.println("border-radius: 5px;");
        out.println("}");
        out.println(".book-details {");
        out.println("display: flex;");
        out.println("justify-content: space-between;");
        out.println("flex-grow: 1;");
        out.println("}");
        out.println(".book-info {");
        out.println("display: flex;");
        out.println("flex-direction: column;");
        out.println("}");
        out.println(".book-info h3 {");
        out.println("margin: 0 0 10px 0;");
        out.println("font-size: 22px;");
        out.println("font-weight: bold;");
        out.println("font-family: Helvetica, Arial, sans-serif;");
        out.println("}");
        out.println(".book-info p {");
        out.println("margin: 0;");
        out.println("font-family: Helvetica, Arial, sans-serif;");
        out.println("}");
        out.println(".right-align {");
        out.println("text-align: right;");
        out.println("margin-right: 20px;");
        out.println("font-size: 20px;");
        out.println("}");
        out.println(".rating-value {");
        out.println("font-weight: bold;");
        out.println("font-family: Helvetica, Arial, sans-serif;");
        out.println("}");
        out.println(".star {");
        out.println("color: gold;");
        out.println("font-size: 20px;");
        out.println("}");
        out.println(".bold {");
        out.println("font-weight: bold;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<div class=\"top\">");
        out.println("<div class=\"left\">");
        out.println("<h1>Przeglądaj książki</h1>");
        out.println("</div>");
        out.println("<div class=\"center\">");
        out.println("<div class=\"wyszukaj\">");
        out.println("<form id=\"searchForm\" method=\"GET\" action=\"search-servlet\">");
        out.println("<button class=\"button-34\" name=\"wyszukaj\">Wyszukaj</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"right\">");
        out.println("<form id=\"sortForm\" method=\"GET\" action=\"http://localhost:8080/TPO6_WW_war_exploded/hello-servlet\">");
        out.println("<label for=\"sortuj\" class=\"sortuj\" style=\"margin-right: 15px;\">Sortuj</label>");
        out.println("<select name=\"sortuj\" id=\"sortuj\" class=\"styled-select\" onchange=\"this.form.submit()\">");
        String sortOption = request.getParameter("sortuj");
        if (sortOption == null) {
            sortOption = "Data wydania malejąco";
        }
        generateSortSelect(out, sortOption);
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");

        String sortOptionReq = request.getParameter("sortuj");
        String orderBy = "Release_date DESC";

        if (sortOptionReq != null) {
            switch (sortOptionReq) {
                case "Data wydania malejąco": {
                    orderBy = "Release_date DESC";
                    break;
                }
                case "Data wydania rosnąco": {
                    orderBy = "Release_date ASC";
                    break;
                }
                case "Liczba ocen malejąco": {
                    orderBy = "Num_ratings DESC";
                    break;
                }
                case "Liczba ocen rosnąco": {
                    orderBy = "Num_ratings ASC";
                    break;
                }
                case "Alfabetycznie": {
                    orderBy = "Title ASC";
                    break;
                }
            }
        }

        try {
            ResultSet resultSet = DataBaseInitializer.getResultSet(orderBy);
            out.println("<div class=\"main\">");
            int n = 1;
            while (resultSet.next()) {
                out.println("<div class=book>");
                String isbn = resultSet.getString("ISBN");
                String title = resultSet.getString("Title");
                String releaseDate = resultSet.getString("Release_date");
                float rating = resultSet.getFloat("Rating");
                int numRatings = resultSet.getInt("Num_ratings");
                String coverImage = resultSet.getString("CoverImage");
                String authorName = resultSet.getString("a_Name");
                String authorSurname = resultSet.getString("a_Surname");
                String genre = resultSet.getString("g_Name");
                String series = resultSet.getString("s_Name");
                String publisher = resultSet.getString("p_Name");
                String linkUrl = resultSet.getString("Link");

                out.println("<img src=\"" + coverImage + "\" alt='Okładka książki " + n + "'>");
                out.println("<div class=\"book-details\">");
                out.println("<div class=book-info>");
                out.println("<h3>" + title + "</h3>");
                out.println("<p><span class='bold'>" + authorName + " " + authorSurname + "</span></p>");
                if (series != null) {
                    out.println("<p>Seria: " + series + "</p>");
                }
                out.println("<p>--------------------------</p>");
                out.println("<p>Gatunek: " + genre + "</p>");
                out.println("<p>Wydawnictwo: " + publisher + "</p>");
                out.println("<p>Data wydania: " + releaseDate + "</p>");
                out.println("<p> </p>");
                out.println("<p>ISBN: " + isbn + "</p>");
                out.println("</div>");
                out.println("<div class=\"right-align\">");
                out.println("<p>Średnia ocena: <strong><span class=\"star\">⭐</span>" + rating + "/10</strong></p>");
                out.println("<p> | " + numRatings + " ocen |</p>");
                out.println("<a href=\"" + linkUrl + "\" target=\"_blank\"><img src=\"images/empiklogo.png\"" +
                        " alt=\"Link Image\" style=\"width: 80px; height: 60px;\"></a>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                n++;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    private void generateSortSelect(PrintWriter out, String selectedOption) {
        String[] options = {"Data wydania malejąco", "Data wydania rosnąco", "Liczba ocen malejąco",
                "Liczba ocen rosnąco", "Alfabetycznie"};
        out.println("<option value=\"" + selectedOption + "\" selected>" + selectedOption + "</option>");
        for (String option : options) {
            if (!option.equals(selectedOption)) {
                out.println("<option value=\"" + option + "\">" + option + "</option>");
            }
        }
        out.println("</select>");
    }

    public void destroy() {
        DataBaseInitializer.disconnect();
    }
}