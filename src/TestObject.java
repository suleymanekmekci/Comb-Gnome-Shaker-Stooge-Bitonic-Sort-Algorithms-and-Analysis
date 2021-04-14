public class TestObject implements Comparable<TestObject> {
    String randomString;
    int randomInteger;

    public TestObject(String randomString, int randomInteger) {
        this.randomString = randomString;
        this.randomInteger = randomInteger;
    }

    public String getRandomString() {
        return randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }

    public int getRandomInteger() {
        return randomInteger;
    }

    public void setRandomInteger(int randomInteger) {
        this.randomInteger = randomInteger;
    }

    @Override
    public String toString() {
        return randomString + " " + randomInteger;
    }


    @Override
    public int compareTo(TestObject o) {
        if (this.randomInteger == o.randomInteger)
            return 0;
        else if (this.randomInteger > o.randomInteger) {
            return 1;
        }
        return -1;
    }
}
