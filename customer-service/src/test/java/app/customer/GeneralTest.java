package app.customer;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author zoo
 */
public class GeneralTest {

    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<>();
        assertTrue(map.isEmpty());
        map.put("aaa", "bbb");
        assertEquals(1, map.size());
        map.clear();
        assertTrue(map.isEmpty());
    }
}
