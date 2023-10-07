package tests;

import models.Player;
import org.junit.jupiter.api.Test;
import services.AuthenticationService;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {

    @Test
    public void testLoginValidCredentials() {
        AuthenticationService authService = new AuthenticationService();

        String playerId = "123";
        String username = "testuser";
        String password = "testpassword";

        authService.registerPlayer(playerId, username, password);

        Player loggedInPlayer = authService.login(username, password);

        assertNotNull(loggedInPlayer);
        assertEquals(playerId, loggedInPlayer.getPlayerId());
    }

    @Test
    public void testLoginInvalidCredentials() {
        AuthenticationService authService = new AuthenticationService();

        String playerId = "123";
        String username = "testuser";
        String password = "testpassword";

        authService.registerPlayer(playerId, username, password);

        Player loggedInPlayer = authService.login(username, "wrongpassword");

        assertNull(loggedInPlayer);
    }
}