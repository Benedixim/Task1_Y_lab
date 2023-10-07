package services;

import models.Account;
import models.Player;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private final Map<String, Player> players;

    public AuthenticationService() {
        this.players = new HashMap<>();
    }

    public void registerPlayer(String playerId, String username, String password) {
        Player player = new Player(playerId, username, password, new Account(playerId));
        players.put(playerId, player);
    }

    public Player login(String username, String password) {
        for (Player player : players.values()) {
            if (player.getUsername().equals(username) && player.getPassword().equals(password)) {
                return player;
            }
        }
        return null;
    }


}

