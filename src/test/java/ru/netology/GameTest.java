package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Krosh", 100);
    Player player2 = new Player(2, "Yojik", 10);
    Player player3 = new Player(3, "Pin", 100);

    @Test
    public void shouldFirstStronger() {

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Krosh", "Yojik");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSecondStronger() {

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Yojik", "Krosh");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDrawnGame() {

        game.register(player1);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Pin", "Krosh");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFirstNotRegistered() {

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Krosh", "Yojik"));
    }

    @Test
    public void shouldSecondNotRegistered() {

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Krosh", "Yojik"));
    }

    @Test
    public void shouldBothNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Krosh", "Yojik"));
    }






}
