package com.object;

/**
 * @author 212331901
 * @date 2019/4/2
 */
public final class PhoneNumber {
    private final short areaCode, prefix, lineNum;
    private static int hashcode;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if ( o == this ) return true;
        if ( !(o instanceof PhoneNumber)) return false;

        PhoneNumber phoneNumber = (PhoneNumber) o;
        return phoneNumber.areaCode == areaCode && phoneNumber.prefix == prefix
                && phoneNumber.lineNum == lineNum;
    }

    @Override
    public int hashCode() {
        int result = hashcode;
        if (result == 0) {
            result = Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNum);
            hashcode = result;
        }
        return result;
    }
}
