package com.brovada.document;

// need to create lifecycle stuff to handle this.  pre-save will inc/set version #.   (it will be null on first call).
@Deprecated 
public class VersionFoo {
    private int major;
    private int minor;
    private int patch;

    public VersionFoo() {
        setMajor(1);
    }

    public VersionFoo(int major) {
        setMajor(major);
    }

    public VersionFoo(int major, int minor) {
        setMajor(major);
    }

    public VersionFoo(int major, int minor, int patch) {
        setMajor(major);
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public int getPatch() {
        return patch;
    }

    public void setPatch(int patch) {
        this.patch = patch;
    }

    private String getVersionString() {
        return major+"."+minor+"."+patch;
    }
}
