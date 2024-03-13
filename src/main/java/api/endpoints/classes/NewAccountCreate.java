package api.endpoints.classes;

import java.util.Random;

public class NewAccountCreate {

    public static String NewAccountCreate() {
        int length = 10;
        StringBuilder mobileNumber = new StringBuilder();
        mobileNumber.append((1 + new Random().nextInt(9)));

        for (int i = 1; i < length; i++) {
            mobileNumber.append(new Random().nextInt(10));
        }

        return mobileNumber.toString();
    }
}
