package com.brovada.document.config;


// follows classic semantic versioning guidelines.
public class Version {

    int major;
    int minor;
    int patch;
    // use this value when doing DB searching.  you can sort by this value to find newest.
    String text;

    public Version(int major) {
        withMajor(major).withMinor(0).withPatch(0);
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getPatch() {
        return patch;
    }

    public Version withMajor(int major) {
        // TODO : check that major doesn't exist.  if so, reject.
        // this is done at service layer.
        this.major = major;
        updateText();
        return this;
    }

    public Version withMinor(int minor) {
        this.minor = minor;
        updateText();
        return this;
    }

    public Version withPatch(int patch) {
        this.patch = patch;
        updateText();
        return this;
    }

    private void updateText() {
        this.text = String.format("%4d.%4d.%4d", major, minor, patch);
    }

    public int compareTo(Version v) {
        if (this.equals(this)) {
            return 0;
        }
        if (this.major>v.getMajor()) {
            return 1;
        } else if (this.minor>v.getMinor()) {
            return 1;
        }
        else if (this.patch>v.getPatch()) {
            return 1;
        }
        return -1;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Version version = (Version) o;

        if (major != version.major) return false;
        if (minor != version.minor) return false;
        if (patch != version.patch) return false;

        return true;
    }


    public Version incMajor() {
        withMajor(this.major++);
        return this;
    }

    public Version incMinor() {
        withMajor(this.minor++);
        return this;
    }

    public Version incPatch() {
        withMajor(this.patch++);
        return this;
    }

    @Override
    public int hashCode() {
        int result = major;
        result = 31 * result + minor;
        result = 31 * result + patch;
        return result;
    }

    @Override
    public String toString() {
        return "Version{" +
                "major=" + major +
                ", minor=" + minor +
                ", patch=" + patch +
                '}';
    }



}
