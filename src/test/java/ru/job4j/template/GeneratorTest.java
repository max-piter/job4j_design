package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;


class GeneratorTest {
    GeneratorClass template = new GeneratorClass();
    String phrase = "I am a ${name}, Who are ${subject}? ";
    String phraseWithMaultipleKeys = "Hello, ${sex}, I am a ${name}, Who are ${subject}? ";
    Map<String, String> keysValues = new HashMap<>();

    @Disabled
    @Test
    void whenGeneratorWorksGood() {
        keysValues.put("name", "Petr Arsentev");
        keysValues.put("subject", "you");
        assertThat(template.produce(phrase, keysValues)).isEqualTo("I am a Petr Arsentev, Who are you? ");
    }

    @Disabled
    @Test
    void whenInvalidKeys() {
        keysValues.put("name", "Petr Arsentev");
        keysValues.put("subject", "you");
        assertThatIllegalArgumentException().isThrownBy(() -> template.produce(phraseWithMaultipleKeys, keysValues));
    }

    @Disabled
    @Test
    void whenInvalidArgs() {
        keysValues.put("name", "Petr Arsentev");
        keysValues.put("subject", "you");
        keysValues.put("sex", "men");
        assertThatIllegalArgumentException().isThrownBy(() -> template.produce(phrase, keysValues));

    }

}