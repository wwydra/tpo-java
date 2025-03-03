package pjatk.tpo.tpo6_ww;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "searchServlet", value = "/search-servlet")
public class SearchServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Wyszukaj</title>");
        out.println("<style>");
        out.println("body, html {");
        out.println("margin: 0;");
        out.println("padding: 0;");
        out.println("height: 100%;");
        out.println("display: flex;");
        out.println("flex-direction: column;");
        out.println("width: 100%;");
        out.println("justify-content: center;");
        out.println("align-items: center;");
        out.println("}");
        out.println(".container {");
        out.println("display: flex;");
        out.println("flex-direction: column;");
        out.println("align-items: center;");
        out.println("padding: 20px;");
        out.println("max-width: 800px;");
        out.println("width: 100%;");
        out.println("max-height: 900px;");
        out.println("height: 100%;");
        out.println("box-sizing: border-box;");
        out.println("}");
        out.println(".content-wrapper {");
        out.println("display: flex;");
        out.println("justify-content: center;");
        out.println("}");
        out.println(".content {");
        out.println("width: 800px;");
        out.println("height: 350px;");
        out.println("background-color: #DCDCDC;");
        out.println("border-radius: 10px;");
        out.println("padding: 20px;");
        out.println("display: grid;");
        out.println("grid-template-columns: repeat(2, 1fr);");
        out.println("row-gap: 0px;");
        out.println("column-gap: 30px;");
        out.println("}");
        out.println(".row {");
        out.println("display: flex;");
        out.println("flex-direction: column;");
        out.println("}");
        out.println(".row label, .row input {");
        out.println("margin-bottom: 10px;");
        out.println("}");
        out.println(".row:last-child {");
        out.println("margin-bottom: 0px;");
        out.println("}");
        out.println("h1 {");
        out.println("text-align: center;");
        out.println("margin-bottom: 10px;");
        out.println("text-transform: uppercase;");
        out.println("font-family: Century Gothic,CenturyGothic,AppleGothic,sans-serif;");
        out.println("font-weight: 200;");
        out.println("letter-spacing: 1px;");
        out.println("font-size: 30px;");
        out.println("}");
        out.println("label {");
        out.println("font-family: Century Gothic, CenturyGothic, AppleGothic, sans-serif;");
        out.println("font-size: 20px;");
        out.println("margin-bottom: 5px;");
        out.println("}");
        out.println("input {");
        out.println("padding: 10px;");
        out.println("border-radius: 16px;");
        out.println("border: 1px solid #ccc;");
        out.println("box-sizing: border-box;");
        out.println("width: 100%;");
        out.println("}");
        out.println(".small-input {");
        out.println("margin-top: 20px;");
        out.println("width: 45%;");
        out.println("}");
        out.println(".button-34 {");
        out.println("background: #808080;");
        out.println("border-radius: 999px;");
        out.println("box-shadow: #808080 0 10px 20px -10px;");
        out.println("box-sizing: border-box;");
        out.println("color: #FFFFFF;");
        out.println("cursor: pointer;");
        out.println("font-family: Inter, Helvetica, Apple Color Emoji, Segoe UI Emoji, NotoColorEmoji, " +
                "Noto Color Emoji, Segoe UI Symbol, Android Emoji, EmojiSymbols, -apple-system, system-ui, " +
                "Segoe UI, Roboto, Helvetica Neue, Noto Sans, sans-serif;");
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
        out.println(".gif-container {");
        out.println("width: 1000px; height: 500px;");
//        out.println("height: 200px;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<h1>Wyszukaj</h1>");
        out.println("<div class=\"content-wrapper\">");
        out.println("<form action=\"display-servlet\" method=\"GET\" class=\"content\">");
        out.println("<div class=\"row\">");
        out.println("<label for=\"search1\">Tytuł</label>");
        out.println("<input type=\"text\" id=\"search1\" name=\"search1\" placeholder=\"Wpisz tytuł książki...\">");
        out.println("<label for=\"search2\">Autor</label>");
        out.println("<input type=\"text\" id=\"search2\" name=\"search2\" placeholder=\"Wpisz autora...\">");
        out.println("</div>");
        out.println("<div class=\"row\">");
        out.println("<label for=\"search3\">Gatunek</label>");
        out.println("<input type=\"text\" id=\"search3\" name=\"search3\" placeholder=\"Wpisz nazwę gatunku...\">");;
        out.println("<label for=\"search4\">Wydawnictwo</label>");
        out.println("<input type=\"text\" id=\"search4\" name=\"search4\" placeholder=\"Wpisz nazwę wydawnictwa...\">");
        out.println("</div>");
        out.println("<div class=\"row\">");
        out.println("<label for=\"search5\">Seria</label>");
        out.println("<input type=\"text\" id=\"search5\" name=\"search5\" placeholder=\"Wpisz nazwę serii...\">");
        out.println("</div>");
        out.println("<div class=\"row\" style=\"flex-direction: row; align-items: center;" +
                " justify-content: space-between;\">");
        out.println("<label style=\"margin-bottom: 55px;\">Ocena:</label>");
        out.println("<label for=\"minRating\" style=\"width: auto; margin-top: 20px; margin-right: 10px;" +
                " margin-left: 10px; font-size: 15px;\">od</label>");
        out.println("<input type=\"number\" id=\"minRating\" name=\"minRating\" min=\"0\" max=\"10\" step=\"0.1\"" +
                " class=\"small-input\">");
        out.println("<label for=\"maxRating\" style=\"width: auto; margin-top: 20px; margin-right: 10px;" +
                " margin-left: 10px; font-size: 15px;\">do</label>");
        out.println("<input type=\"number\" id=\"maxRating\" name=\"maxRating\" min=\"0\" max=\"10\" step=\"0.1\"" +
                " class=\"small-input\">");
        out.println("</div>");
        out.println("<div class=\"row\">");
        out.println("<button type=\"submit\" class=\"button-34\" name=\"szukaj\">Szukaj</button>");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");
        out.println("<div class=\"gif-container\">");
        out.println("<img src=\"images/Pisanie.gif\" alt=\"Pisanie GIF\" style=\"width: 1000px; height: 500px;\">");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("search1");
        String author = request.getParameter("search2");
        String genre = request.getParameter("search3");
        String publisher = request.getParameter("search4");
        String series = request.getParameter("search5");
        String minRating = request.getParameter("minRating");
        String maxRating = request.getParameter("maxRating");

        String nextPage = "display-servlet?title="
                + URLEncoder.encode(title, StandardCharsets.UTF_8) +
                "&author=" + URLEncoder.encode(author, StandardCharsets.UTF_8) +
                "&genre=" + URLEncoder.encode(genre, StandardCharsets.UTF_8) +
                "&publisher=" + URLEncoder.encode(publisher, StandardCharsets.UTF_8) +
                "&series=" + URLEncoder.encode(series, StandardCharsets.UTF_8) +
                "&minRating=" + minRating +
                "&maxRating=" + maxRating;

        response.sendRedirect(nextPage);
    }

    public void destroy() {
        DataBaseInitializer.disconnect();
    }
}
