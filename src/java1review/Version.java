package java1review;

public class Version {
    private int major;
    private int minor;
    private int patch;

    public Version() {
        patch = 1;
    }

    public Version(String version) {
        String[] partedVersion = version.split("\\.");
        if(partedVersion.length == 1 && partedVersion[0] == "") {
            patch = 1;
            return;
        }
        try {
            switch(partedVersion.length) {
                case 0:
                    patch = 1;
                    break;
                case 1:
                    major = Integer.parseInt(partedVersion[0]);
                    break;
                case 2:
                    major = Integer.parseInt(partedVersion[0]);
                    minor = Integer.parseInt(partedVersion[1]);
                    break;
                default:
                    major = Integer.parseInt(partedVersion[0]);
                    minor = Integer.parseInt(partedVersion[1]);
                    patch = Integer.parseInt(partedVersion[2]);
            }
        } catch (NumberFormatException e) {
            // throw new Exception("Error occured while parsing version!");
            throw new IllegalArgumentException("Error occured while parsing version!");
        }
    }

    public Version(int major, int minor, int patch) {
        if((major < 0 || minor < 0 || patch < 0) ||
                (major == 0 && minor == 0 && patch == 0)
        ) {
            throw new IllegalArgumentException("Error occured while parsing version!");
        }
        this.major = major;
        this.minor = minor;
        this.patch = patch;
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

    @Override
    public String toString() {
        return String.format("%s.%s.%s", getMajor(), getMinor(), getPatch());
    }

}
