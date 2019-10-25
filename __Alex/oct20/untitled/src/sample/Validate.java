package sample;

public  class Validate {
    public static String validateTextFieldNoRegexp(String tf, int minsize, int maxsize,String fieldName ) {
        String message= "";
        if ( tf.length() > maxsize
                || tf.length() < minsize) {
            // when it not matches the pattern and length isnot in the range

            message= fieldName + " ,";
        }
        return message;
    }
    public static String validateTextField(String tf, String regexp, int minsize, int maxsize,String fieldName ) {
        String message= "";
        if (!tf.matches(regexp) || tf.length() > maxsize
                || tf.length() < minsize) {
            // when it not matches the pattern and length isnot in the range

            message= fieldName + " ,";
        }
        return message;
    }

    public static String validateTextFieldNullValue( String tf, String regexp,  int maxsize,String fieldName ) {
        String message="";
        if (!tf.isEmpty()) {
            if (!tf.matches(regexp) || tf.length() > maxsize) {
                // when it not matches the pattern and length is not the range
                message = fieldName + " ,";
            }
        }
        return message;
    }

}
