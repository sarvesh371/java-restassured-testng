package endpoints;

public interface Endpoints {

    public static final String baseUrl = "https://petstore.swagger.io/v2";
    public static final String createUser = baseUrl + "/user";
    public static final String getUser = baseUrl + "/user/{username}";
    public static final String updateUser = baseUrl + "/user/{username}";
    public static final String priceApi = "https://api.coindesk.com/v1/bpi/currentprice.json";
}
