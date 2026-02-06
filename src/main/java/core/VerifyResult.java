package core;

import java.util.List;

public class VerifyResult {

    private final String expected;
    private final List<String> actualList;

    public VerifyResult(String expected, List<String> actualList) {
        this.expected = expected;
        this.actualList = actualList;
    }

    public String getExpected() {
        return expected;
    }

    public List<String> getActualList() {
        return actualList;
    }
}
