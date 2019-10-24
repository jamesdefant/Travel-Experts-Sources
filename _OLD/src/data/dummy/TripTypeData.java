package data.dummy;

public class TripTypeData implements data.TripTypeData {
    @Override
    public String getTripType(String Id) {

        return "{\"triptypeId\":\"B\",\"ttName\":\"Business                 \"}";
    }

    @Override
    public String getTripTypes() {

        return "[{\"triptypeId\":\"B\",\"ttName\":\"Business                 \"},{\"triptypeId\":\"G\",\"ttName\":\"Group                    \"},{\"triptypeId\":\"L\",\"ttName\":\"Leisure                  \"}]";
    }
}
