package ru.job4j.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.Calendar;
import java.util.List;
import static org.junit.Assert.*;

class CinemaTest {

    Cinema cinema = new Cinema3D();
    Calendar date = Calendar.getInstance();
    Account account = new AccountCinema();
    Ticket ticket =  new Ticket3D();

    @Disabled
    @Test
    public void whenBuy() {
        ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket).isEqualTo(new Ticket3D());
    }

    @Disabled
    @Test
    public void whenAddAndFindSomethingWorth() {
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions).isEqualTo(List.of(new Session3D()));
    }



    @Disabled
    @Test
    public void whenFindNoSessionThenNull() {
        List<Session> sessions = cinema.find(session -> false);
        assertThat(sessions).isNull();
    }



    @Disabled
    @Test()
    public void whenInvalidPlace() {
        assertThatIllegalArgumentException().isThrownBy(() -> cinema.buy(account, -1, 1, date));
    }

    @Disabled
    @Test()
    public void whenInvalidRow() {
        assertThatIllegalArgumentException().isThrownBy(() -> cinema.buy(account, 1, -1, date));
    }

    @Disabled
    @Test
    public void whenSoldOut() {
        ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket).isNull();
    }

    @Disabled
    @Test
    public void whenInvalidDate() {
        date.set(2012, Calendar.DECEMBER, 12);
        assertThatIllegalArgumentException().isThrownBy(() -> cinema.buy(account, 1, 1, date));
    }

    @Disabled
    @Test
    public void whenPlaceIsOccupied() {
        ticket = cinema.buy(account, 1, 1, date);
        assertThatIllegalArgumentException().isThrownBy(() -> cinema.buy(account, 1, 1, date));
    }
}