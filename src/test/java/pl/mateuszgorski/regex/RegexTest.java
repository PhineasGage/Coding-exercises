package pl.mateuszgorski.regex;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class RegexTest {

    String ipAdress;

    //After five hours of running the single test below i decided to quit. Not sure if i am doing
    //something time-consuming (String.format??), i compiled Pattern as a class field, not instance variable
    @Ignore
    @Test
    public void testEntireRegex() {
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                for (int k = 0; k < 256; k++) {
                    for (int l = 0; l < 256; l++) {
                        ipAdress = String.format("%d.%d.%d.%d", i, j, k, l);
                        assertTrue(Regex.isIpAddress(ipAdress));
                    }
                }
            }
        }
    }

    @Test
    @Parameters(method = "invalidIP")
    public void shouldReturnFalseIfIPisInvalid(String invalidIP) {
        assertFalse(Regex.isIpAddress(invalidIP));
    }

    private Object[] invalidIP() {
        return new String[]{"0.0.0.k", "0.0.0.256", ".12.13.23.23", "12..23.45.23", "IP0.23.23.24", "12.25.255", "255255255255"};
    }

    @Test
    public void testRegexPartially() {
        int[] ipAdressParts = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 256; j++) {
                ipAdressParts[i] = j;
                ipAdress = String.format("%d.%d.%d.%d", ipAdressParts[0], ipAdressParts[1], ipAdressParts[2], ipAdressParts[3]);
                assertTrue(Regex.isIpAddress(ipAdress));
            }
        }
    }
}