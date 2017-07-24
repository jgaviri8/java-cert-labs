package gaviria_holguin.juan_camilo.test;

import java.io.Serializable;

public class TestSerializable implements Serializable {
    private byte _byte;
    private boolean _boolean;
    private char _char;
    private short _short;
    private int _int;
    private long _long;
    private float _float;
    private double _double;

    TestSerializable() {
        _float = Float.MIN_VALUE;
        _double = Double.MIN_VALUE;
        _long = Long.MIN_VALUE;
        _int = Integer.MIN_VALUE;
        _short = Short.MIN_VALUE;
        _char = Character.MIN_VALUE;
        _boolean = false;
        _byte = Byte.MIN_VALUE;
    }

    @Override
    public String toString() {
        return String.format("%s, byte: %d, boolean %b, char: %c, short: %d, int: %d, long: %d, float: %a, double: %a",
                super.toString(), _byte, _boolean, _char, _short, _int, _long, _float, _double);
    }
}
