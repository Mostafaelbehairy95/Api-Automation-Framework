package Library.api;

import utils.Config;
import utils.Routes;

import java.util.HashMap;
import java.util.Map;

public class BookAPIs {
    private static String baseUrl;

    public BookAPIs(){
        baseUrl = Config.get("base.url");
    }

    public static String createBooksEndPoint(){
        String createBookPath = Routes.get("createBooks");
        return (baseUrl + createBookPath);
    }

    public static String getBookEndPoint(){
        String getBooksPath = Routes.get("getBooks");
        return (baseUrl + getBooksPath);
    }

    public static String updateBookEndPoint(int id){
        String updateBookPath = Routes.expand("updateBook", Map.of("id", id));
        return (baseUrl + updateBookPath);
    }

    public static String getBookEndPoint(int id){
        String getBookPath = Routes.expand("getBook",  Map.of("id",id));
        return (baseUrl + getBookPath);
    }

    public static String deleteBookEndPoint(int id){
        String deleteBookPath = Routes.expand("deleteBook", Map.of("id",id));
        return (baseUrl + deleteBookPath);
    }

}
