package com.mitrais.dkatalis.q1;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class StoreAndLoadTest {

    @Test
    public void test() {
        String text = "key1=value1;key2=value2\nkeyA=valueA\n";
        HashMap<String, String>[] load = StoreAndLoad.load(text);
        String store = StoreAndLoad.store(load);
        String result = "key1=value1;key2=value2\n" +
                "keyA=valueA";
        assertThat(store).isEqualTo(result);
    }

}