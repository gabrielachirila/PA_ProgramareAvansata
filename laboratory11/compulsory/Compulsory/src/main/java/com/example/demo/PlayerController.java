package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final List<Player> players = new ArrayList<>();
    public PlayerController() {
        players.add(new Player(1, "Player1"));
        players.add(new Player(2, "Player2"));
        players.add(new Player(3, "Player3"));
        players.add(new Player(4, "Player4"));
        players.add(new Player(5, "Player5"));

    }
    @GetMapping
    public List<Player> getPlayers() {
        return players;
    }

    @GetMapping("/count")
    public int countPlayers() {
        return players.size();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable("id") int id) {
        return players.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public int createPlayer(@RequestParam String name) {
        int id = 1 + players.size();
        players.add(new Player(id, name));
        return id;
    }
}