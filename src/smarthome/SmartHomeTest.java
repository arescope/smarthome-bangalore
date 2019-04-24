package smarthome;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmartHomeTest {

    @Test
    public void turnOnBulb_whenSwitchIsOn() {
        SpyBulb spyBulb = new SpyBulb();
        AlwaysOnSwitch switchStub = new AlwaysOnSwitch();

        new SmartHome().run(spyBulb, switchStub);

        assertEquals(true, spyBulb.turnOn_wasCalled());
    }


    @Test
    public void turnOffBulb_whenSwitchIsOff() {
        SpyBulb spyBulb = new SpyBulb();
        AlwaysOffSwitch switchStub = new AlwaysOffSwitch();

        new SmartHome().run(spyBulb, switchStub);

        assertEquals(true, spyBulb.turnOff_wasCalled());
    }

    private class SpyBulb implements Switchable {
        @Override
        public void turnOn() {

        }

        @Override
        public void turnOff() {

        }

        public boolean turnOn_wasCalled() {
            return true;
        }

        public boolean turnOff_wasCalled() {
            return true;
        }
    }

    private class AlwaysOnSwitch implements Switch {
        @Override
        public boolean isOn() {
            return true;
        }
    }

    private class AlwaysOffSwitch implements Switch {
        @Override
        public boolean isOn() {
            return false;
        }
    }
}
