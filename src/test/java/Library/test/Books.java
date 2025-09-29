package Library.test;

import Library.Payloads;
import Library.api.BookAPIs;
import base.BaseApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Config;

import java.util.HashMap;
import java.util.Map;

import static utils.Restutils.performPost;

public class Books extends BaseApi{
    @Test
    public void createBooks(){
        BookAPIs book = new BookAPIs();
        Map<String, Object> RequestPayload = Payloads.getCreatingBooks("1", "testing","bench practice", "45", "test", "2025-09-28T11:18:49.072Z");
        Response res = performPost(book.createBooksEndPoint(), RequestPayload, new HashMap<>());
        Assert.assertEquals(res.statusCode(),200);
    }
}
