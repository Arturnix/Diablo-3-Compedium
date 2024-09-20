# Diablo-3-Compedium

Test Battletag: Ghall#2523

To gain access to API communication, please use this tutorial to get OAuth credentials:
https://develop.battle.net/documentation/guides/using-oauth

 Next thing to do is creating class named ClientCredentials in root location and name OAuth data with getters:
 
    public class ClientCredentials {

    private static final String clientId = ""; //provide your Client Id
    private static final String clientSecret = ""; //provide your Client Secret

    public static String getClientId() {
        return clientId;
    }

    public static String getClientSecret() {
        return clientSecret;
    }
}
 
