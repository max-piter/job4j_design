package ru.job4j.srp.wrong;


import java.util.List;

/**
 * The interface Alarm clock.
 * В интерфейсе Alarm clock помимо будильника находятся
 * 1) метод настройки громкости - это 1 нарушение srp,
 * необходимо метод setVolume выводить в отдельныйинерфейс
 *
 * 2) метод выбора мелодии для будильника - это 2 нарушение srp,
 * необходимо метод setTune выводить в отдельный интерфейс
 *
 */
public interface AlarmClock {
    void alarm();
    void setVolume();
    <T> T setTune(List<T> listOfTunes);
}
